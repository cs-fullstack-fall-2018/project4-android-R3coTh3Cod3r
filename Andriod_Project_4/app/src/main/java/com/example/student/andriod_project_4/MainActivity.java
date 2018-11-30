package com.example.student.andriod_project_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


Toolbar mToolbar;
ListView mListView;

String[] menuNames= {"BreakFast","Lunch","Dinner"};
int[] menuOptions ={R.drawable.breakfast,R.drawable.lunch,R.drawable.dinner};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        mListView = findViewById(R.id.listview);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        ActivityAdapter activityAdapter = new ActivityAdapter(MainActivity.this,menuNames,menuOptions);
        mListView.setAdapter(activityAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent mIntent = new Intent(MainActivity.this,DetailActivity.class);
                mIntent.putExtra("menuName",menuNames[i]);
                mIntent.putExtra("menuOption",menuNames[i]);
                startActivity(mIntent);
            }


        });



        }



    }








