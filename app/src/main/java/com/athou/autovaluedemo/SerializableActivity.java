package com.athou.autovaluedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.athou.autovaluedemo.bean.NullableStory;

import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class SerializableActivity extends AppCompatActivity {

    @Extra
    NullableStory story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        SerializableActivityIntentBuilder.inject(getIntent(), this);

        TextView tv_parcelable = (TextView) findViewById(R.id.tv_parcelable);
        tv_parcelable.setText(story.toString());
    }
}
