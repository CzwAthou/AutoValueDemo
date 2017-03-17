package com.athou.autovaluedemo.bean;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by athou on 2017/3/17.
 */

@GsonTypeAdapterFactory
public abstract class MyAdapterFactory implements TypeAdapterFactory {

    public static TypeAdapterFactory create(){
        return new AutoValueGson_MyAdapterFactory();
    }
}
