package com.athou.autovaluedemo.bean;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

/**
 * Created by athou on 2017/3/17.
 */

@AutoValue
public abstract class NullableStory{

    public abstract int id();

    @Nullable
    public abstract String title();

    public static NullableStory create(int id, String title){
        return new AutoValue_NullableStory(id, title);
    }
}
