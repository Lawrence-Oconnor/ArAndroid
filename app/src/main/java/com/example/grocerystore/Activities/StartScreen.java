package com.example.grocerystore.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.grocerystore.Dialogs.popupMenu;
import com.example.grocerystore.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartScreen extends AppCompatActivity {

    Button historical;
    Button realtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        //Toolbar toolbar = findViewById(R.id.toolbar);

        historical = findViewById(R.id.btn_Historical);
        realtime = findViewById(R.id.btn_Realtime);

        historical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Historical Treatment", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Historical.class);
                startActivity(intent);
            }
        });

        realtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Realtime Treatment",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Realtime.class);
                startActivity(intent);
            }
        });
    }


}
