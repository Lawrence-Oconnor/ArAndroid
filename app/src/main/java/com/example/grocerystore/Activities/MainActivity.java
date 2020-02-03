package com.example.grocerystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.grocerystore.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Timer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//TODO
    /*
    *Game Timer - implement the timer in a thread then do specifics later
    *Toasts on buttons
    *Cards setup for all charts
    *setup pie charts - fake Data
    *Bar graph charts
    *Other charts
    *Refresh method to manage charts
    *
    * */
   //deciare 5 buttons
    Button restock;
    Button delivery;
    Button release;
    Button callIn;
    Button reassign;

    PieChart pieChart1;


    private int day;
    private Timer clock = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        setupChartsView();
        initializeCharts();
        refreshCharts();


    }

    private void refreshCharts(){
int y;
int x;
    }

    private void initializeCharts() {
    }

    private void setupChartsView() {
    }


    private void setupView() {
        //buttons = find view by id
        restock = findViewById(R.id.btnRestock);
        delivery = findViewById(R.id.btnMakeNewDeliv);
        release = findViewById(R.id.btnReleaseEmployee);
        callIn = findViewById(R.id.btnCallEmployee);
        reassign = findViewById(R.id.btnReasEmployee);

        delivery.setOnClickListener(this);
        restock.setOnClickListener(this);
        release.setOnClickListener(this);
        callIn.setOnClickListener(this);
        reassign.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //implement switch for buttons
        //Launches fragment in screen
        Toast.makeText(getApplicationContext(),"Testing Button", Toast.LENGTH_SHORT).show();
    }
}
