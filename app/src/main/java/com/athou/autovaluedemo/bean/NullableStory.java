package com.athou.autovaluedemo.bean;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.Serializable;

/**
 * Created by athou on 2017/3/17.
 */

@AutoValue
public abstract class NullableStory implements Serializable{

    public abstract int id();

    @Nullable
    public abstract String title();

    public static NullableStory create(int id, String title) {
        return new AutoValue_NullableStory(id, title);
    }

    public static TypeAdapter<NullableStory> typeAdapter(Gson gson) {
        return new AutoValue_NullableStory.GsonTypeAdapter(gson);
    }
}
