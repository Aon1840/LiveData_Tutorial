package com.example.livedata_tutorial.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.livedata_tutorial.Model.User;
import com.example.livedata_tutorial.R;
import com.example.livedata_tutorial.ViewModel.EditDataViewModel;

public class EditContentActivity extends AppCompatActivity {

    private final static String TAG = EditContentActivity.class.getName();
    private EditText edtFirstName, edtLastName, edtEmail;
    private Button btnEdit, btnDelete;
    private EditDataViewModel editDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_content);
        initInstance();
        final User user=(User) getIntent().getExtras().getSerializable("data");

        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();

        edtFirstName.setText(firstName);
        edtLastName.setText(lastName);
        edtEmail.setText(email);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtFirstName.getText().toString() == null || edtLastName.getText().toString()  == null || edtEmail.getText().toString()  == null) {
                    Toast.makeText(EditContentActivity.this,"Missing Field", Toast.LENGTH_LONG).show();
                } else {
                    editDataViewModel.updateUser(user);
                    finish();
                }
            }
        });
    }

    private void initInstance() {
        edtFirstName = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        editDataViewModel = ViewModelProviders.of(this).get(EditDataViewModel.class);
    }
}
