package com.example.livedata_tutorial.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.livedata_tutorial.Model.User;
import com.example.livedata_tutorial.R;

public class EditContentActivity extends AppCompatActivity {

    private final static String TAG = EditContentActivity.class.getName();
    private EditText edtFirstName, edtLastName, edtEmail;
    private Button btnAdd, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_content);
        initInstance();
        User user=(User) getIntent().getExtras().getSerializable("data");

        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();

        edtFirstName.setText(firstName);
        edtLastName.setText(lastName);
        edtEmail.setText(email);
    }

    private void initInstance() {
        edtFirstName = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
    }
}
