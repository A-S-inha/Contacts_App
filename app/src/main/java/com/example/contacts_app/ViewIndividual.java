package com.example.contacts_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contacts_app.db.AppData;
import com.example.contacts_app.db.Exist_User;

import java.util.List;

public class ViewIndividual extends AppCompatActivity {
TextView name,phone,city,country,group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_individual);
        name=findViewById(R.id.Name);
        phone=findViewById(R.id.Phone);
        city=findViewById(R.id.City);
        country=findViewById(R.id.Country);
        group=findViewById(R.id.Group);
        loadData();
    }
    public void loadData()
    {
        AppData dbb=AppData.getDbInstance(this.getApplicationContext());
        String ii= getIntent().getStringExtra("id");
        List<Exist_User> list=dbb.Exist_DAO().findContact(ii);
        System.out.println(ii);
        if(list.size()==0)
        {

            System.exit(0);
        }
        for(int i=0;i<list.size();i++)
        {
           name.setText(list.get(i).name);
           phone.setText(list.get(i).phone);
           city.setText(list.get(i).city);
           country.setText(list.get(i).country);
           group.setText(list.get(i).group);
        }



    }

}