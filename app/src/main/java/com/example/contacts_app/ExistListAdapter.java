package com.example.contacts_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contacts_app.db.Exist_User;

import java.util.List;

public class ExistListAdapter extends RecyclerView.Adapter<ExistListAdapter.MYViewHolder>{

    private Context context;
    private List<Exist_User> exist_users;
    public ExistListAdapter(Context context)
    {
        this.context=context;
    }
    public void setExist_users(List<Exist_User> exist_users1){
        this.exist_users=exist_users1;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ExistListAdapter.MYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.row_recycler,parent,false);
        return new MYViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull ExistListAdapter.MYViewHolder holder, int position) {
        holder.tv_name.setText(this.exist_users.get(position).name);
        holder.tv_phone.setText(this.exist_users.get(position).phone);
        holder.tv_group.setText(this.exist_users.get(position).group);
        holder.tv_city.setText(this.exist_users.get(position).city);
        holder.tv_country.setText(this.exist_users.get(position).country);


    }
    @Override
    public int getItemCount() {
        return this.exist_users.size();
    }
    public class MYViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name,tv_phone,tv_group,tv_city,tv_country;
        public MYViewHolder(View view)
        {
            super(view);
            tv_name= view.findViewById(R.id.tvname);
            tv_phone=view.findViewById(R.id.tvphone);
            tv_group=view.findViewById(R.id.tvgroup);
            tv_city=view.findViewById(R.id.tvcity);
            tv_country=view.findViewById(R.id.tvcountry);


        }

    }

}


