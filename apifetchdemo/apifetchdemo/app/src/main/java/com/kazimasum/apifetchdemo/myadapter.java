package com.kazimasum.apifetchdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    model data[];

    public myadapter(model[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
         return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
      holder.t1.setText(data[position].getName());
      holder.t2.setText(data[position].getDesig());
      Glide.with(holder.t1.getContext()).load("http://10.0.2.2/api/images/"+data[position].getImage()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView t1,t2;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            img=itemView.findViewById(R.id.img);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
        }
    }

}
