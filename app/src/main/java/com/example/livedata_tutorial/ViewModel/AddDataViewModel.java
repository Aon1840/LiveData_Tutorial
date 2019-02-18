package com.example.livedata_tutorial.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.util.Log;

import com.example.livedata_tutorial.Database.AppDatabase;
import com.example.livedata_tutorial.Model.User;

public class AddDataViewModel extends AndroidViewModel {

    private final static String TAG = AddDataViewModel.class.getName();
    private AppDatabase appDatabase;

    public AddDataViewModel(Application application){
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());
    }

    public void addData(final User user){
        new addAsyncTask(appDatabase).execute(user);
    }

    private static class addAsyncTask extends AsyncTask<User, Void, Void>{

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase){
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(User... users) {
            db.userDao().addUser(users[0]);
            Log.d(TAG,"----- User: "+users[0]);
            return null;
        }
    }

//    private void addAsyncTask(final User user){
//
//        new AsyncTask<User, Void, Void>(){
//            @Override
//            protected Void doInBackground(User... users) {
//                appDatabase.userDao().addUser(users[0]);
//                return null;
//            }
//        }.execute();
//    }

}
