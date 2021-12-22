package com.example.davaofoodguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class foodinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodinfo);




        Intent intent =getIntent();
        String name = intent.getStringExtra("name");
        String dessy = intent.getStringExtra("dessy");
        String linkz = intent.getStringExtra("linkz");

        byte[]image = intent.getByteArrayExtra("avatar");
        Bitmap bitmap = BitmapFactory.decodeByteArray(image,0, image.length);

    //    Toast.makeText(this, "name: " + name, Toast.LENGTH_SHORT).show();
     //   Toast.makeText(this, "name: " + dessy, Toast.LENGTH_SHORT).show();

        
        TextView namechange = findViewById(R.id.namechange);
        TextView descdisplay = findViewById(R.id.descdisplay);
        TextView linky = findViewById(R.id.linky);
        EditText displi = findViewById(R.id.displi);
        ImageView imgz = findViewById(R.id.imgz);

        linky.setMovementMethod(LinkMovementMethod.getInstance());

        namechange.setText(name);
        descdisplay.setText(dessy);
        linky.setText(linkz);
        displi.setText(dessy);
        imgz.setImageBitmap(bitmap);

        displi.setMovementMethod(new ScrollingMovementMethod());

        displi.setFocusableInTouchMode(false);
        displi.clearFocus();



    }
}