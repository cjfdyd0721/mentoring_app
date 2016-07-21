package com.android.mentoring_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private void editText() {

        EditText mTitle = (EditText) findViewById(R.id.editText_id);

        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        imm.showSoftInput(mTitle, 0);

    }




    public void b1 (View v) {

        EditText editText_id = (EditText) findViewById(R.id.editText_id);
        EditText editText_pwd = (EditText) findViewById(R.id.editText_pwd);


        if(TextUtils.isEmpty(editText_id.getText())||TextUtils.isEmpty(editText_pwd.getText())) {

            return;
    }
        Intent intent = new Intent(MainActivity.this, management.class);
        startActivity(intent);

    }
}
