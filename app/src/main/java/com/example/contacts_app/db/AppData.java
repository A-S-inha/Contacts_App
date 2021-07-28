package com.example.contacts_app.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class,Exist_User.class},version = 3)
public abstract class AppData extends RoomDatabase {


 public abstract DAO_App DAO_App();
 public abstract Exist_DAO Exist_DAO();
 private static AppData INSTANCE;
 public static  AppData getDbInstance(Context context)
 {
     if(INSTANCE==null)
     {
         INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppData.class,"DB.NAME").allowMainThreadQueries().build();

     }
     return INSTANCE;
 }
}
