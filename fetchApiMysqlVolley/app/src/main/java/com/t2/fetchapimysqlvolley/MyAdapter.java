package com.t2.fetchapimysqlvolley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter<DataClass> {

    Context context;
    List<DataClass> dataClassList;

    public MyAdapter(@NonNull Context context, List<DataClass>dataClasses) {
        super(context, R.layout.data_item,dataClasses);

        this.context = context;
        this.dataClassList = dataClasses;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item,null,true);

        TextView nametv = view.findViewById(R.id.nameTv);
        TextView agetv = view.findViewById(R.id.ageTv);
        TextView gendertv = view.findViewById(R.id.genderTv);

        nametv.setText(dataClassList.get(position).getName());
        agetv.setText(dataClassList.get(position).getAge());
        gendertv.setText(dataClassList.get(position).getGender());

        return view;
    }
}
