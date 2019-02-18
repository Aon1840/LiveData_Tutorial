package com.example.livedata_tutorial.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.livedata_tutorial.R;
import com.example.livedata_tutorial.ViewModel.TestViewModel;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getName();
    private TextView tvHello;
    private Button btnClick;
    private TestViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstance();

//        btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                model.getText().setValue("HEllo eifjdsfdks;f");
//            }
//        });


    }

    private void initInstance() {
//        tvHello = (TextView) findViewById(R.id.tvHello);
//        btnClick = (Button) findViewById(R.id.btnClick);

        model = ViewModelProviders.of(this).get(TestViewModel.class);

        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvHello.setText(s);
            }
        };

        model.getText().observe(this, nameObserver);
    }
}
