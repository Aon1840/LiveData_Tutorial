package com.example.livedata_tutorial.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.livedata_tutorial.Adapter.ItemListAdapter;
import com.example.livedata_tutorial.Model.User;
import com.example.livedata_tutorial.R;
import com.example.livedata_tutorial.ViewModel.ListDataViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

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


    }

    private void initInstance() {
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        listAdapter = new ItemListAdapter(new ArrayList<User>());
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

    }

}
