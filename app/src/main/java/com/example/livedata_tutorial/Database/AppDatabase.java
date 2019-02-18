package com.example.livedata_tutorial.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    private static AppDatabase instnace;

    public static AppDatabase getDatabase(Context context){
        if (instnace == null){
            instnace = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user_db").build();
        }

        return instnace;
    }
}
