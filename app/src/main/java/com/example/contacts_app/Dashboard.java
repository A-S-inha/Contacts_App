package com.example.contacts_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void view_All(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void view_Added(View view)
    {
        Intent intent = new Intent(this, View_All_Added.class);
        startActivity(intent);
        startActivityForResult(intent, 100);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data)
    {
        if(requestCode==100)
        {

        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}