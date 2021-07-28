package com.example.contacts_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;

import com.example.contacts_app.db.AppData;
import com.example.contacts_app.db.Exist_User;


import java.util.ArrayList;
import java.util.List;

public class SearchDB extends AppCompatActivity {
   private ExistListAdapter existListAdapter;
    List<Exist_User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_db);
        AppData dbb=AppData.getDbInstance(this.getApplicationContext());
        userList= dbb.Exist_DAO().getAllUser();
        initRecyclerView();
        loadUserList();
    }


    void loadUserList()
    {


        existListAdapter.setExist_users(userList);

    }
    void initRecyclerView()
    {
        RecyclerView recyclerView =findViewById(R.id.recyclerViews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        existListAdapter=new ExistListAdapter(this);
        recyclerView.setAdapter(existListAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.exist_menu,menu);

        MenuItem searchViewItem = menu.findItem(R.id.exist_search);
        SearchView searchView = (SearchView) searchViewItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // on query submit we are clearing the focus for our search view.
              //  searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // on changing the text in our search view we are calling
                // a filter method to filter our array list.
                System.out.println(newText);
                filter(newText.toLowerCase());
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void filter(String text) {
        // in this method we are filtering our array list.
        // on below line we are creating a new filtered array list.
        ArrayList<Exist_User> filteredlist = new ArrayList<>();
        // on below line we are running a loop for checking if the item is present in array list.
        for (int i=0;i<userList.size();i++) {
            System.out.println(userList.get(i));
            if (userList.get(i).city.contains(text.toLowerCase())) {
                // on below line we are adding item to our filtered array list.
                filteredlist.add(userList.get(i));
            }
        }
        // on below line we are checking if the filtered list is empty or not.
        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "No Contact Found", Toast.LENGTH_SHORT).show();
        } else {
            // passing this filtered list to our adapter with filter list method.
            ExistListAdapter obj=new ExistListAdapter(this);
            obj.setExist_users(filteredlist);
        }
    }



}