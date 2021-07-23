package com.example.contacts_app.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DAO_App {
    @Query("SELECT * FROM user ")
    List<User> getAllUser();
    @Insert
    void insertUser(User... users);
    @Delete
    void delete(User user);
}
