package com.athou.autovaluedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.athou.autovaluedemo.bean.MyAdapterFactory;
import com.athou.autovaluedemo.bean.NullableStory;
import com.athou.autovaluedemo.bean.Story;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try { //避免出现java.lang. NoClassDefFoundError: android.os.AsyncTask
            Class.forName("com.google.gson.Gson");
        } catch (Throwable ignore) {
            // ignored
            ignore.printStackTrace();
        }
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
    }

    public void OnClickParcelable(View v) {
        Story story = Story.create(100, "hahaha");

        Intent intent = new Intent(this, ParacableActivity.class);
//        intent.putExtra("story", story);
        startActivity(intent);
    }

    public void OnClickSerializable(View v) {

    }
}
