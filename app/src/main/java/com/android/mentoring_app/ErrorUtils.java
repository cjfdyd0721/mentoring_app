package com.android.mentoring_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by user on 2016-08-04.
 */
public class ErrorUtils {

    public static void ProntLog(String tag, Exception e){
        e.printStackTrace();
    }

    public static void AlertException(Activity atvt, String expMessage, Exception e) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(atvt);
        dialog.setTitle(atvt.getString(R.string.common_text_error));
        dialog.setMessage(expMessage);
        dialog.setNeutralButton(R.string.common_text_confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
        e.printStackTrace();
    }
}

