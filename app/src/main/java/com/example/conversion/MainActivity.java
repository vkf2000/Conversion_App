package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ImageView image = (ImageView)findViewById(R.id.imageView);
        TextView tx=(TextView)findViewById(R.id.textView4);
        int secondsDelayed = 3000;

        Animation animation1 =
                AnimationUtils.loadAnimation(this,
                        R.anim.fade);
        image.setAnimation(animation1);

        Animation animation2 =
                AnimationUtils.loadAnimation(this,
                        R.anim.fade);
        tx.setAnimation(animation2);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {




            /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainActivity.this,list.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }
        }, secondsDelayed);
    }






}