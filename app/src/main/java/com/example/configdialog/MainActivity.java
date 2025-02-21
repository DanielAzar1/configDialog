package com.example.configdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * The main activity of the application.
 */
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

    /**
     * @param savedInstanceState The saved instance state of the activity.
     * The function creates the activity and sets the layout.
     */
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

    }

    /**
     * @param view The button that was clicked.
     * The function creates a toast with the user's input
     */
    public void toast(View view) {
        adb1 = new AlertDialog.Builder(this);
        adb1.setTitle("Toast");
        adb1.setCancelable(false);

        final EditText eT = new EditText(this);
        eT.setHint("Type toast content here");
        adb1.setView(eT);
        adb1.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = eT.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

        adb1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb1.show();
    }

    /**
     * @param view The button that was clicked.
     * The function resets the background color to white
     */
    public void reset(View view) {
        adb2 = new AlertDialog.Builder(this);
        adb2.setTitle("Reset background");
        adb2.setCancelable(false);

        adb2.setPositiveButton("DISMISS", new DialogInterface.OnClickListener() {
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

    /**
     * @param view the button that was clicked.
     * The function sets the background color to a merge of primary colors based on the user choice
     */
    public void merge(View view) {
        adb3 = new AlertDialog.Builder(this);
        adb3.setTitle("Set background to a merge of primary colors ");
        adb3.setCancelable(false);
        color[0] = 0;
        color[1] = 0;
        color[2] = 0;

        adb3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myLayout.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });

        adb3.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                if (isChecked) color[which] = 255;
                else if (color[which] == 255) color[which] = 0;

            }
        });

        adb3.setNegativeButton("DISMISS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        adb3.show();
    }

    /**
     * @param view The button that was clicked.
     *  The function sets the background color to a primary color based on the user choice
     */
    public void primary(View view) {
        adb4 = new AlertDialog.Builder(this);
        adb4.setTitle("Set background to a primary color");
        adb4.setCancelable(false);
        color[0] = 0;
        color[1] = 0;
        color[2] = 0;

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

    /**
     * @param menu The menu in the action bar.
     * @return true if the menu was created, false otherwise.
     * The function creates the menu in the action bar.
     */
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * @param item The menu item that was selected.
     * @return true if the action was handled, false otherwise.
     * The function opens the credits activity when the menu item is selected.
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        Intent ti = new Intent(this, Credits.class);
        startActivity(ti);
        return true;
    }
}