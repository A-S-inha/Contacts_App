package com.example.contacts_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contacts_app.db.User;

import java.text.BreakIterator;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder>{

    private Context context;
    private List<User> userList;
    public UserListAdapter(Context context)
    {
        this.context=context;
    }

    public void setUserList(List<User> userList)
    {
        this.userList=userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.tv_name.setText(this.userList.get(position).names);
      holder.tv_phone.setText(this.userList.get(position).phone);
    }

    @Override
    public int getItemCount() {
        return this.userList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name,tv_phone;
        public MyViewHolder(View view)
        {
           super(view);
          tv_name= view.findViewById(R.id.tvname);
          tv_phone=view.findViewById(R.id.tvphone);

        }

    }
}

