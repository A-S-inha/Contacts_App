package com.example.contacts_app.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Exist_DAO {
    @Query("SELECT * FROM Exist_User ORDER BY name")
    List<Exist_User> getAllUser();
    @Query("SELECT * from Exist_User where uid=:given")
    public List<Exist_User> findContact(String given);
    @Insert
    void insertUser(Exist_User... exist_users);
    @Delete
    void delete(Exist_User exist_user);
    @Query("UPDATE Exist_User SET Calls=:price WHERE uid = :id")
    void update(int price, String id);
    @Query("SELECT * FROM Exist_User WHERE uid=:giv")
    Exist_User getUser(String giv);


}
