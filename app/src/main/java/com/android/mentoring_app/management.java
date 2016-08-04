package com.android.mentoring_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by user on 2016-07-21.
 */
public class management extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management);
    }

    public void but (View v){
        Intent intent = new Intent(management.this,application.class);
        startActivity(intent);

    }
}