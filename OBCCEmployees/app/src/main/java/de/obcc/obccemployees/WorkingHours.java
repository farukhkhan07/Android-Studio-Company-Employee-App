package de.obcc.obccemployees;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;



public class WorkingHours extends AppCompatActivity {


    DatabaseHelper mdb;
    EditText w_name, w_date, starttime, endtime;
    Button save_button, view_button, back;

    //private static final int REQUEST_EXTERNAL_STORAGE = 1;
    //private static String[] PERMISSION_STORAGE = (Manifest.permission.WRITE_EXTERNAL_STORAGE);
    //private SignaturePad mSignaturePad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_hours);
        w_name = (EditText) findViewById(R.id.w_name);
       //w_date = (EditText) findViewById(R.id.w_date);
        //starttime = (EditText) findViewById(R.id.w_startTime);
        //endtime = (EditText) findViewById(R.id.w_endTime);
        save_button = (Button) findViewById(R.id.workinghours_saveButton);
        view_button = (Button) findViewById(R.id.workinghours_view);
        back = (Button) findViewById(R.id.back);
        mdb = new DatabaseHelper(WorkingHours.this);
        insertEntry();
        //signatureActivity();
    }



    public void insertEntry(){

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = w_name.getText().toString();
                if(w_name.length() != 0){
                    AddData(newName);
                    w_name.setText("");
                }else {

                    toastMessage("Cannot Save Empty");
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkingHours.this, MainActivity.class);
                startActivity(intent);
            }
        });

        view_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkingHours.this, WorkingHoursView.class);
                startActivity(intent);
            }
        });

    }

    public void AddData(String newName){
        //boolean isInserted = mdb.addData(w_name.getText().toString()); //, w_date.getText().toString(),starttime.getText().toString(),endtime.getText().toString());

        boolean isInserted = mdb.addData(newName);

        if(isInserted == true){
            //Toast.makeText(WorkingHours.this, "DATA IS INSERTED", Toast.LENGTH_LONG);
            toastMessage("DATA INSERTED SUCCESSFULLY");
        }
        else
        {
            //Toast.makeText(WorkingHours.this, "DATA IS NOT INSERTED", Toast.LENGTH_LONG);
            toastMessage("DATA IS NOT INSERTED");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }
}
