package com.athou.autovaluedemo.bean;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by athou on 2017/3/20.
 */
@AutoValue
public abstract class Test1 {
    abstract String title();

    public static Test1 create(String title) {
        return new AutoValue_Test1(title);
    }

    public static TypeAdapter<Test1> typeAdapter(Gson gson) {
        return new AutoValue_Test1.GsonTypeAdapter(gson);
    }
}
