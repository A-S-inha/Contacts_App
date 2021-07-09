package com.example.contacts_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.contacts_app.db.AppData;
import com.example.contacts_app.db.User;

import java.util.List;

public class View_All_Added extends AppCompatActivity {
    private UserListAdapter userListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_added);


        initRecyclerView();
        loadUserList();
    }
    void loadUserList()
    {
        AppData dbb=AppData.getDbInstance(this.getApplicationContext());
        List<User> userList= dbb.DAO_App().getAllUser();
        userListAdapter.setUserList(userList);

    }
    void initRecyclerView()
    {
        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter=new UserListAdapter(this);
        recyclerView.setAdapter(userListAdapter);
    }

}