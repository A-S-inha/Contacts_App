package com.example.contacts_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.contacts_app.db.AppData;
import com.example.contacts_app.db.Exist_User;
import com.example.contacts_app.db.User;

import java.util.List;

public class SearchDB extends AppCompatActivity {
   private ExistListAdapter existListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_db);
        initRecyclerView();
        loadUserList();
    }


    void loadUserList()
    {
        AppData dbb=AppData.getDbInstance(this.getApplicationContext());
        List<Exist_User> userList= dbb.Exist_DAO().getAllUser();
        existListAdapter.setExist_users(userList);

    }
    void initRecyclerView()
    {
        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        existListAdapter=new ExistListAdapter(this);
        recyclerView.setAdapter(existListAdapter);
    }
}