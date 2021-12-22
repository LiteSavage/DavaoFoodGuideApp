package com.example.davaofoodguide;

import static com.example.davaofoodguide.DBmain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class newfoods extends AppCompatActivity {

DBmain dBmain;
SQLiteDatabase sqLiteDatabase;
RecyclerView recyclerView;
MyAdapter myAdapter;


    SliderView sliderview;
    int[] images = {R.drawable.malaska,
    R.drawable.nawong, R.drawable.first};

    Button add,exit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newfoods);




        dBmain = new DBmain(this);
        findId();
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));







        sliderview = findViewById(R.id.slide);
        add = findViewById(R.id.add);
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });
        //add button ni diri na part
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodadd();
            }
        });


      /*  ListView main_listview = findViewById(R.id.main_listview);


        ArrayList<CustomList> placeList = new ArrayList<>();
        placeList.add(new CustomList(R.drawable.first, "TEST 1", "description chuchu yey123"));
        placeList.add(new CustomList(R.drawable.first, "TEST 2 ", "pan is bread yey 123"));
        placeList.add(new CustomList(R.drawable.first, "TEST 3", "description 123121"));

        CustomArrayAdapter arrayAdapter = new CustomArrayAdapter(this, 0, placeList);
        main_listview.setAdapter(arrayAdapter); */


       /* SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderview.setSliderAdapter(sliderAdapter);
        sliderview.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderview.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderview.startAutoCycle(); */




    }

    private void displayData() {
        sqLiteDatabase = dBmain.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLENAME + "",null);
        ArrayList<Model>models = new ArrayList<>();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            byte[]avatar = cursor.getBlob(1);
            String name = cursor.getString(2);
            String dessy = cursor.getString(3);
            String linkz = cursor.getString(4);


            models.add(new Model(id,avatar,name,dessy,linkz));

        }
        cursor.close();
        myAdapter = new MyAdapter(this, R.layout.singledata,models,sqLiteDatabase);
        recyclerView.setAdapter(myAdapter);
    }

    private void findId() {
        recyclerView = findViewById(R.id.rv);
    }

    public void foodadd(){
        Intent intent  = new Intent(this, foodadd.class);
        startActivity(intent);
    }


    public void exit() {
        Intent intent  = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}