package com.athou.autovaluedemo.bean;

import android.os.Parcel;

import com.athou.autovaluedemo.bean.Story;
import com.ryanharter.auto.value.parcel.TypeAdapter;


/**
 * Created by athou on 2017/3/17.
 */

public class StoryTypeAdapter implements TypeAdapter<Story> {

    @Override
    public Story fromParcel(Parcel in) {
        return new AutoValue_Story(
                in.readInt(),
                in.readString()
        );
    }

    @Override
    public void toParcel(Story value, Parcel dest) {
        dest.writeInt(value.id());
        dest.writeString(value.title());
    }
}
