package com.athou.autovaluedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.athou.autovaluedemo.bean.CustomStory;
import com.athou.autovaluedemo.bean.NullableStory;
import com.athou.autovaluedemo.bean.ParentStoy;
import com.athou.autovaluedemo.bean.Story;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickBean2Gson(View v) {
        Story story = Story.create(100, "hahaha");

        String json = new Gson().toJson(story);
        System.out.println(json);
    }

    public void OnClickGson2Bean(View v) {
        String json = "{\"id\":100,\"title\":\"test\"}";

        // 自定义的Gson对象，需要配置 MyAdapterFactory
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(MyAdapterFactory.create()).create();

        Story story = gson.fromJson(json, Story.class);
        System.out.println(story);

        NullableStory nullableStory = gson.fromJson(json, NullableStory.class);
        System.out.println(nullableStory);

        CustomStory customStory = gson.fromJson(json, CustomStory.class);
        System.out.println(customStory.toString());
    }

    public void OnParentWithChild(View v) {
        parse(new Callback<ParentStoy<Story>>() {
            @Override
            void onParse(ParentStoy<Story> result) {

            }
        });
    }

    abstract class Callback<T> {
        abstract void onParse(T result);
    }

    private <T> void parse(Callback<T> callback) {
        Type type = findNeedType(callback.getClass());
        
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(MyAdapterFactory.create()).create();
        String json = "{\n" +
                "\"code\":0,\n" +
                "\"result\":{\n" +
                "\"id\":100,\n" +
                "\"title\":\"test\"\n" +
                "},\n" +
                "\"error\":\"\"\n" +
                "}";
        
        ParentStoy story = gson.fromJson(json, type);
        System.out.println(story.getResult().toString());
        System.out.println(story.toString());
        if (callback != null) {
            callback.onParse((T)story);
        }
    }

    public void OnClickParcelable(View v) {
        Story story = Story.create(101, "哈哈哈");
        startActivity(new ParacableActivityIntentBuilder(story).build(this));
    }

    public void OnClickSerializable(View v) {
        NullableStory story = NullableStory.create(102, "哈哈哈哈哈哈");
        startActivity(new SerializableActivityIntentBuilder(story).build(this));
    }

    /**
     * find the type by interfaces
     *
     * @param cls
     * @param <R>
     * @return
     */
    public static <R> Type findNeedType(Class<R> cls) {
        List<Type> typeList = getMethodTypes(cls);
        if (typeList == null || typeList.isEmpty()) {
            return String.class;
        }
        return typeList.get(0);
    }

    /**
     * MethodHandler
     */
    public static <T> List<Type> getMethodTypes(Class<T> cls) {
        Type typeOri = cls.getGenericSuperclass();
        List<Type> needtypes = null;
        // if Type is T
        if (typeOri instanceof ParameterizedType) {
            needtypes = new ArrayList<>();
            Type[] parentypes = ((ParameterizedType) typeOri).getActualTypeArguments();
            for (Type childtype : parentypes) {
                needtypes.add(childtype);
                if (childtype instanceof ParameterizedType) {
                    Type[] childtypes = ((ParameterizedType) childtype).getActualTypeArguments();
                    for (Type type : childtypes) {
                        needtypes.add(type);
                    }
                }
            }
        }
        return needtypes;
    }
}
