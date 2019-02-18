package com.example.livedata_tutorial.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.livedata_tutorial.R;
import com.example.livedata_tutorial.ViewModel.AddDataViewModel;

public class AddContentActivity extends AppCompatActivity {

    private static final String TAG = AddContentActivity.class.getName();
    private EditText edtFirstname, edtLastName, edtEmail;
    private Button btnAdd;
    private AddDataViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        initInstance();

//        Observer<String> firstNameObserver = new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                edt
//            }
//        };
//        model.getFirstName().observe(this, );
    }

    private void initInstance() {
        edtFirstname = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        model = ViewModelProviders.of(this).get(AddDataViewModel.class);
    }
}
