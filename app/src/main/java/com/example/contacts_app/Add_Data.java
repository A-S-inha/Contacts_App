package com.example.contacts_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.contacts_app.db.AppData;
import com.example.contacts_app.db.User;

public class Add_Data extends AppCompatActivity {
    private EditText nameEdt, phoneEdt, emailEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

    }
    public void adding_data(View view)
    {
        nameEdt = findViewById(R.id.addName);
        phoneEdt = findViewById(R.id.addPhoneNumber);
        emailEdt = findViewById(R.id.addEmail);
        String name = nameEdt.getText().toString();
        String phone = phoneEdt.getText().toString();
        String email = emailEdt.getText().toString();
        AppData db= AppData.getDbInstance(this.getApplicationContext());
        User user= new User();
        user.names=name;
        user.email=email;
        user.phone=phone;
        db.DAO_App().insertUser(user);

        finish();
    }
}