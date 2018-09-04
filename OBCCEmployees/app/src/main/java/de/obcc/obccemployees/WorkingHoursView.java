package de.obcc.obccemployees;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

public class WorkingHoursView extends AppCompatActivity {

    private static final String TAG = "SavedDataActivity";

    DatabaseHelper mdb ;

    private ListView lstv;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_hours_view);
        lstv = (ListView) findViewById(R.id.list_view);
        mdb = new DatabaseHelper(this);
        back = (Button) findViewById(R.id.goback);

        populateListView();
        goback();

    }



    private void populateListView(){
        Log.d(TAG, "Displaying Data In List View");

        Cursor data = mdb.getData();
        ArrayList<String> listData = new ArrayList<>();

        while(data.moveToNext()){

            listData.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        lstv.setAdapter(adapter);


    }

    private void goback(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkingHoursView.this, WorkingHours.class);
                startActivity(intent);
            }
        });
    }

}
