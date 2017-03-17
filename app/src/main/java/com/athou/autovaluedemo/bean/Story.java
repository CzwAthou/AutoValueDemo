package com.athou.autovaluedemo.bean;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by athou on 2017/3/17.
 */

@AutoValue
public abstract class Story implements Parcelable {
    public abstract int id();

    public abstract String title();

    public static Story create(int id, String title) {
        return new AutoValue_Story(id, title);
    }

    public static TypeAdapter<Story> typeAdapter(Gson gson) {
        return new AutoValue_Story.GsonTypeAdapter(gson);
    }
}
