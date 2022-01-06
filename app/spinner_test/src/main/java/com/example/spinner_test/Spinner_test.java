package com.example.spinner_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Spinner_test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_test);

        Spinner spinner01 = findViewById(R.id.spinner01);
        Spinner spinner02 = findViewById(R.id.spinner02);
        ListView listView01 = findViewById(R.id.listView01);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(Spinner_test.this, R.array.spinner02, android.R.layout.simple_dropdown_item_1line);
        spinner02.setAdapter(spinnerAdapter);

        spinner01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Spinner_test.this, "证件类型：" + spinner01.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> listViewAdapter = ArrayAdapter.createFromResource(Spinner_test.this, R.array.listView01, android.R.layout.simple_list_item_checked);
        listView01.setAdapter(listViewAdapter);
        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Spinner_test.this, listView01.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}