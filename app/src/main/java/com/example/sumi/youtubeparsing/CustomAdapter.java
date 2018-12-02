package com.example.sumi.youtubeparsing;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sumi.youtubeparsing.entities.Item;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context c;
    List<Item> list;


    public CustomAdapter(MainActivity mainActivity, List<Item> mydata) {
        c=mainActivity;
        list=mydata;

    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView= LayoutInflater.from(c).inflate(R.layout.singleitem,null);


        return new MyViewHolder(convertView) ;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, final int position) {
holder.title.setText(list.get(position).getSnippet().getTitle());
holder.date.setText(list.get(position).getSnippet().getPublishedAt());
        Glide.with(c)
                .load(list.get(position).getSnippet().getThumbnails().getDefault().getUrl().toString())
                .into(holder.imv);

        holder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(c,PlayerActivity.class);
                i.putExtra("id",list.get(position).getSnippet().getResourceId().getVideoId());
                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{
        ImageView imv;
        TextView title,date;
       //2
        View convertView;


        public MyViewHolder(View itemView) {
            super(itemView);
            imv=itemView.findViewById(R.id.image);
            title=itemView.findViewById(R.id.title);
            date=itemView.findViewById(R.id.date);
           //2
            convertView=itemView;

        }
    }
}
