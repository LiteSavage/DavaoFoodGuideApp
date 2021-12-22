package com.example.davaofoodguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderViewAdapter;



public class SliderAdapter extends SliderViewAdapter<SliderAdapter.Holder> {

    int[] images;


    public SliderAdapter(int[] images){
        this.images = images;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slider_item,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {

        viewHolder.imageview.setImageResource(images[position]);



    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder{

        ImageView imageview;

        public Holder(View itemView){
            super(itemView);

            imageview = itemView.findViewById(R.id.first);
        }


    }


}
