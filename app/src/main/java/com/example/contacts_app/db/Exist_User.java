package com.example.contacts_app.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Exist_User {
    @PrimaryKey()
    @NonNull
    public String uid;
    @ColumnInfo(name="Name")//City
    public String name;
    @ColumnInfo(name="Phone_Number")//City
    public String phone;
    @ColumnInfo(name="Group")//Friends,family,colleagues etc
    public String group;
    @ColumnInfo(name="City")//City
    public String city;
    @ColumnInfo(name="Country")//Country
    public String country;

}
