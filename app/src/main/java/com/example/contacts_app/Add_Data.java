package com.example.contacts_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.contacts_app.db.AppData;
import com.example.contacts_app.db.Exist_User;
import com.example.contacts_app.db.User;

public class Add_Data extends AppCompatActivity {
    private EditText groupEdt, cityEdt, countryEdt;
    private TextView names,phones;
    private String n="",nn="",i="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        names=findViewById(R.id.name_view);
        phones=findViewById(R.id.phone_view);
        n=getIntent().getStringExtra("name");
        nn=getIntent().getStringExtra("contact");
        i=getIntent().getStringExtra("id");
        names.setText(n);
        phones.setText(nn);


    }
    public void adding_data(View view)
    {
        groupEdt= findViewById(R.id.addGroup);
        cityEdt = findViewById(R.id.addCity);
        countryEdt = findViewById(R.id.addCountry);
        String grp = groupEdt.getText().toString();
        String city = cityEdt.getText().toString();
        String country = countryEdt.getText().toString();
        AppData db= AppData.getDbInstance(this.getApplicationContext());
        Exist_User exist_user= new Exist_User();
        exist_user.uid=i;
        exist_user.name=n;
        exist_user.phone=nn;
        exist_user.group=grp;
        exist_user.city=city;
        exist_user.country=country;
        db.Exist_DAO().insertUser(exist_user);
        Intent i = new Intent(this, ViewIndividual.class);
        i.putExtra("id",i);

        finish();
    }
}