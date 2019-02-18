package com.example.livedata_tutorial.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.livedata_tutorial.Database.User;
import com.example.livedata_tutorial.R;
import com.example.livedata_tutorial.ViewModel.AddDataViewModel;

public class AddContentActivity extends AppCompatActivity {

    private static final String TAG = AddContentActivity.class.getName();
    private EditText edtFirstName, edtLastName, edtEmail;
    private Button btnAdd;
    private AddDataViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        initInstance();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtFirstName.getText() == null || edtLastName.getText() == null || edtEmail.getText() == null) {
                    Toast.makeText(AddContentActivity.this,"Missing Field", Toast.LENGTH_LONG).show();
                } else {
                    viewModel.addData(new User(
                            edtFirstName.getText().toString(),
                            edtLastName.getText().toString(),
                            edtEmail.getText().toString()
                    ));
                    Log.d(TAG, "---- User from activity: "+edtFirstName.getText().toString());
                    finish();
                }
            }
        });
    }

    private void initInstance() {
        edtFirstName = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        viewModel = ViewModelProviders.of(this).get(AddDataViewModel.class);
    }
}
