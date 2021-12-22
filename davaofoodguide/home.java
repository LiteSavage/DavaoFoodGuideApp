package com.example.davaofoodguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class home extends AppCompatActivity {

    private ImageButton youtube, instagram, giveaways, blogs, newshop, popular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        youtube = (ImageButton) findViewById(R.id.youtube);
        instagram = (ImageButton) findViewById(R.id.instagram);
        giveaways = (ImageButton) findViewById(R.id.giveaways);
        newshop = (ImageButton) findViewById(R.id.newshop);
        blogs = (ImageButton) findViewById(R.id.blogs);
        popular = (ImageButton) findViewById(R.id.popular);



        //FOR YOUTUBE IMAGE BUTTON REDIRECTION HUEHUE
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.youtube.com/c/DavaoFoodGuide?fbclid=IwAR2vBihRBplKKPQfdnRZixkbGjg4VdyNJxLkpbCM1XD1PovmRrSU6BTFIZs"));
                startActivity(viewIntent);
            }
        });

        //FOR INSTSAGRAM IMAGE BUTTON REDIRECTION HEHE
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.instagram.com/davaofoodguide/?hl=en"));
                startActivity(viewIntent);
            }
        });

        //FOR BLOGS IMAGE BUTTON REDIRECTION HUEHUE
        blogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.facebook.com/DavaoFoodGuidePH"));
                startActivity(viewIntent);
            }
        });

        //NEW SHOP DIRIA GUYS NA AREA NEW SHOP IMAGE BUTTON
        newshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newshoppy();

            }
        });

        //FOR POPULAR IMAGE BUTTON REDIRECTION HUEHUE
        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.tripadvisor.com.ph/Restaurants-g298459-Davao_City_Davao_del_Sur_Province_Mindanao.html"));
                startActivity(viewIntent);
            }
        });


        //FOR GIVEAWAWYS IMAGE BUTTON REDIRECTION HUEHUE
        giveaways.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.facebook.com/DavaoFoodGuidePH"));
                startActivity(viewIntent);
            }
        });



    }
    public void newshoppy() {
        Intent intent  = new Intent(this, newfoods.class);
        startActivity(intent);
    }
}