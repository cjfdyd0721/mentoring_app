package com.android.mentoring_app;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;



public class application extends AppCompatActivity implements onNetworkResponseListener{

    private EditText et;
    private int day;
    private int month;
    private int year;
    private Calendar cal;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application);

        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);
        et.setOnClickListener((View.OnClickListener) this);

        //getAccountList();

        StrictMode.enableDefaults();

        super.onCreate();

        StrictMode.enableDefaults();


    }


    public void onClick(View v) {
        showDialog(0);
    }
    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,int selectedMonth, int selectedDay) {
            et.setText(selectedYear +" / " + selectedDay + " / "+   (selectedMonth + 1));
        }
    };




    public void getAccountList(View view){

        AccountTitleSpinnerList spinnerList;
        Spinner spinner;

        JSONObject red_data = new JSONObject();
        try {
            red_data.put("USER_ID", "test_user1");


            JSONArray array = response.getJSONArray("REC");

            spinnerList = new AccountTitleSpinnerList(array);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(application.this, android.R.layout.simple_spinner_item, spinnerList.getArrayList());
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner = (Spinner) findViewById(R.id.spinner);
            spinner.setAdapter(adapter);


//            CommNetwork commNetwork = new CommNetwork(this, this);
//            commNetwork.requestToServer("ACCOUNT_L001", red_data);

        } catch (Exception e) {
            ErrorUtils.AlertException(this, "오류가 발생하였습니다", e);
        }


    }


    @Override
    public void onSuccess(String api_key, JSONObject response) {
        //성공
        Toast.makeText(this,"요청 성공",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onFailure(String api_key, String error_cd, String error_msg) {
        //실패/
        Toast.makeText(this,"요청 실패",Toast.LENGTH_SHORT).show();


    }
}
