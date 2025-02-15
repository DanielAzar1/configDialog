package com.example.configdialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    Button btn1, btn2, btn3, btn4;
    AlertDialog.Builder adb1;
    AlertDialog.Builder adb2;
    AlertDialog.Builder adb3;
    AlertDialog.Builder adb4;
    final String[] colors = {"Red", "Green", "Blue"};
    int[] color = {0, 0, 0};
    LinearLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        myLayout = findViewById(R.id.main);
        myLayout.setBackgroundColor(Color.rgb(255,250,250));

        adb1 = new AlertDialog.Builder(this);
        adb2 = new AlertDialog.Builder(this);
        adb3 = new AlertDialog.Builder(this);
        adb4 = new AlertDialog.Builder(this);


    }

    public void toast(View view) {

    }

    public void reset(View view) {
        adb2.setTitle("Reset background");
        adb2.setCancelable(false);

        adb2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        adb2.setNegativeButton("Reset Background", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myLayout.setBackgroundColor(Color.rgb(255,250,250));
            }
        });

        adb2.show();
    }

    public void merge(View view) {
        adb3.setTitle("Set background to a merge of primary colors");
        adb3.setCancelable(false);

        adb3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myLayout.setBackgroundColor(Color.rgb(255,255,255));
            }
        });

        adb3.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                if (isChecked) color[which] = 255;
                else if (color[which] == 255) color[which] = 0;
                myLayout.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });

        adb3.show();
    }

    public void primary(View view) {
        adb4.setTitle("Set background to a primary color");
        adb4.setCancelable(false);

        adb4.setPositiveButton("DISMISS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        adb4.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                color[which] = 255;
                myLayout.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
                color[0] = 0;
                color[1] = 0;
                color[2] = 0;
            }
        });

        adb4.show();
    }
}