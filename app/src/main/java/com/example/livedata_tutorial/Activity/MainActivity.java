package com.example.livedata_tutorial.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.livedata_tutorial.Adapter.ItemListAdapter;
import com.example.livedata_tutorial.Database.AppDatabase;
import com.example.livedata_tutorial.Database.User;
import com.example.livedata_tutorial.R;
import com.example.livedata_tutorial.ViewModel.ListDataViewModel;
import com.example.livedata_tutorial.ViewModel.TestViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = MainActivity.class.getName();
    private ListDataViewModel viewModel;
    private ItemListAdapter listAdapter;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstance();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContentActivity.class);
                startActivity(intent);
            }
        });

//        btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                model.getText().setValue("HEllo eifjdsfdks;f");
//            }
//        });


    }

    private void initInstance() {
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        listAdapter = new ItemListAdapter(new ArrayList<User>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

        viewModel = ViewModelProviders.of(this).get(ListDataViewModel.class);
        viewModel.getUserList().observe(MainActivity.this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                listAdapter.addItems(users);
                Log.d(TAG,"---- user from onChnage: "+users);
            }
        });


//        tvHello = (TextView) findViewById(R.id.tvHello);
//        btnClick = (Button) findViewById(R.id.btnClick);

//        model = ViewModelProviders.of(this).get(TestViewModel.class);
//
//        final Observer<String> nameObserver = new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                tvHello.setText(s);
//            }
//        };
//
//        model.getText().observe(this, nameObserver);
    }

    @Override
    public void onClick(View v) {

    }
}
