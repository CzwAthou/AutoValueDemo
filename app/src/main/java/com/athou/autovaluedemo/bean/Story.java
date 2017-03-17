package com.athou.autovaluedemo.bean;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by athou on 2017/3/17.
 */

@AutoValue
public abstract class Story{
    @SerializedName("id")
    public abstract int id();
    @SerializedName("title")
    public abstract String title();

    public static Story create(int id, String title){
        return new AutoValue_Story(id, title);
    }

    public static TypeAdapter<Story> typeAdapter(Gson gson) {
        return new AutoValue_Story.GsonTypeAdapter(gson);
    }
}
