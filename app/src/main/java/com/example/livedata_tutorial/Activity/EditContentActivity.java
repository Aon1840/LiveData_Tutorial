package com.example.livedata_tutorial.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
                Log.d(TAG,"before --- user id from update: "+user.getUid()+" "+user.getFirstName());
                user.setFirstName(edtFirstName.getText().toString());
                user.setLastName(edtLastName.getText().toString());
                user.setEmail(edtEmail.getText().toString());
                editDataViewModel.updateUser(user);
                Log.d(TAG,"after --- user id from update: "+user.getUid()+" "+user.getFirstName());

                Intent intent = new Intent(EditContentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"User user id from delete: "+user.getUid()+" "+user.getFirstName());
                editDataViewModel.deleteUser(user);

                Intent intent = new Intent(EditContentActivity.this, MainActivity.class);
                startActivity(intent);
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
