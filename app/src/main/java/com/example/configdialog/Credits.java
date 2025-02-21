package com.example.configdialog;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * The credits activity of the application.
 */
public class Credits extends AppCompatActivity {

    /**
     * @param savedInstanceState The saved instance state of the activity.
     * The function creates the activity and sets the layout.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     * @param view The button that was clicked.
     * The function closes the activity
     */
    public void goBack(View view) {
        finish();
    }
}