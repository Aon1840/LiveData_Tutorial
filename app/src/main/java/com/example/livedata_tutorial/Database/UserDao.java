package com.example.livedata_tutorial.Database;

import android.arch.persistence.room.Query;
import android.widget.ListView;

import java.util.List;

public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid ")
    User getUserById(int uid);

//    @Query("DELETE ")
}
