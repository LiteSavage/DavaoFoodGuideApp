package com.example.davaofoodguide;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<CustomList> {
    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CustomList> customLists) {
        super(context, resource, customLists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent ,false);

        }

        CustomList currentItem = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.img);
        imageView.setImageResource(currentItem.getmImgResId());
        TextView textView1 = listItemView.findViewById(R.id.placename);
        textView1.setText(currentItem.getPname());

        TextView textView2 = listItemView.findViewById(R.id.descz);
        textView2.setText(currentItem.getPdescription());

        return listItemView;


    }
}
