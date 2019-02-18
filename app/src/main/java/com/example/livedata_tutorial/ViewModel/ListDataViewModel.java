package com.example.livedata_tutorial.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.livedata_tutorial.Database.AppDatabase;
import com.example.livedata_tutorial.Database.User;

import java.util.List;

public class ListDataViewModel extends AndroidViewModel {

    private final static String TAG = ListDataViewModel.class.getName();
    private final LiveData<List<User>> userList;
    private AppDatabase appDatabase;

    public ListDataViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());
        userList = appDatabase.userDao().getAll();
        Log.d(TAG,"----- userList: "+userList);
    }

    public LiveData<List<User>> getUserList(){
        return userList;
    }

}
