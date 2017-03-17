package com.athou.autovaluedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.athou.autovaluedemo.bean.Story;

public class ParacableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        TextView tv_parcelable = (TextView) findViewById(R.id.tv_parcelable);
        tv_parcelable.setText(((Story) getIntent().getParcelableExtra("story")).toString());
    }
}
