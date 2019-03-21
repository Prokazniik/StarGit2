package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = findViewById(R.id.main_textview);
        mainTextView.setText("Set in Java!");

        mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        mainEditText = (EditText) findViewById(R.id.main_edittext);




    }
    @Override
    public void onClick(View v) {
        mainTextView.setText(mainEditText.getText().toString()
            + " is learning Android development!");
        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        mainListView.setAdapter(mArrayAdapter);
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
        mainListView.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText(mNameList.get(position).toString()
                + " is learning Android development!");
    }





}
