package com.example.livedata_tutorial.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {
    private MutableLiveData<String> text;


    public MutableLiveData<String> getText() {
        if (text == null) {
            text = new MutableLiveData<String>();
        }

        return text;
    }

}
