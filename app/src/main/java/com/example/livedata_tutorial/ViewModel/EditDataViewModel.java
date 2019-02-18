package com.example.livedata_tutorial.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import com.example.livedata_tutorial.Database.AppDatabase;
import com.example.livedata_tutorial.Model.User;

public class EditDataViewModel extends AndroidViewModel {

    private final User userLiveData;
    private AppDatabase appDatabase;

    public EditDataViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
        userLiveData = appDatabase.userDao().getUserById(1);
    }


    public void updateUser(User user){
        new updateAsyncTask(appDatabase).execute(user);
    }

    private static class updateAsyncTask extends AsyncTask<User, Void, Void>{
        private AppDatabase db;

        updateAsyncTask(AppDatabase appDatabase){
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(User... users) {
            db.userDao().updateUser(users[0]);
            return null;
        }
    }

    public void deleteUser(User user){
        new deleteAsyncTask(appDatabase).execute(user);
    }

    private static class deleteAsyncTask extends AsyncTask<User, Void, Void>{

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase){
            db = appDatabase;
        }
        @Override
        protected Void doInBackground(User... users) {
            db.userDao().deleteUser(users[0]);
            return null;
        }
    }
}
