package com.example.grocerystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.grocerystore.Dialogs.UserInputs;
import com.example.grocerystore.Dialogs.popupMenu;
import com.example.grocerystore.HelperClasses.Charts;
import com.example.grocerystore.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Historical extends AppCompatActivity implements View.OnClickListener {

    Button userInput;

    //Quadrant 1
    PieChart pieChartQ1A;
    PieChart pieChartQ1B;
    PieChart pieChartQ1C;
    PieChart pieChartQ1D;
    PieChart pieChartQ1E;
    PieChart pieChartQ1F;

    //Quadrant 2
    PieChart pieChart1;
    BarChart barChart;
    LineChart lineChart;


    //Quadrant 3
    PieChart pieChartQ3A;
    PieChart pieChartQ3B;


    //Quadrant 4
    BarChart barChartQ4;
    LineChart lineChartQ4;



    ArrayList<String> departments;
    ArrayList<String> foods;
    ArrayList<String> stockLabels;
    ArrayList<String> costLabels;
    ArrayList<String> statusLabels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical);


        setupView();
        initlalValues();


        quadrant1();
        quadrant2();
        quadrant3();
        quadrant4();



        //unwrap bundle that had the day

        //get data with the day
    }
    private void quadrant1() {

        pieChartQ1A = (PieChart) findViewById(R.id.pcQ1A);
        pieChartQ1A = Charts.pieChart(pieChartQ1A , statusLabels);

        pieChartQ1B = (PieChart) findViewById(R.id.pcQ1B);
        pieChartQ1B = Charts.pieChart(pieChartQ1B, statusLabels);

        pieChartQ1C = (PieChart) findViewById(R.id.pcQ1C);
        pieChartQ1C = Charts.pieChart(pieChartQ1C, statusLabels);

        //top charts above

        pieChartQ1D = (PieChart) findViewById(R.id.pcQ1D);
        pieChartQ1D = Charts.pieChart(pieChartQ1D, departments);

        pieChartQ1E = (PieChart) findViewById(R.id.pcQ1E);
        pieChartQ1E = Charts.pieChart(pieChartQ1E, departments);

        pieChartQ1F = (PieChart) findViewById(R.id.pcQ1F);
        pieChartQ1F = Charts.pieChart(pieChartQ1F, departments);
    }

    public void quadrant2() {

        pieChart1 = (PieChart) findViewById(R.id.chart1Pie);
        pieChart1 = Charts.pieChart(pieChart1, stockLabels);

        lineChart = (LineChart)findViewById(R.id.Q2LineChart);
        lineChart = Charts.lineChart(lineChart);

        barChart = (BarChart)findViewById(R.id.chartBarTest);
        barChart = Charts.barChart(barChart);


    }

    //Line ch

    private void quadrant3() {

        pieChartQ3A = (PieChart) findViewById(R.id.pcQ3A);
        pieChartQ3A = Charts.pieChart(pieChartQ3A, foods);

        pieChartQ3B = (PieChart) findViewById(R.id.pcQ3B);
        pieChartQ3B = Charts.pieChart(pieChartQ3B, costLabels);
    }

    private void quadrant4() {
        lineChartQ4 = (LineChart)findViewById(R.id.Q4LineChart);
        lineChartQ4 = Charts.lineChart(lineChartQ4);

        barChartQ4 = (BarChart)findViewById(R.id.Q4BarChart);
        barChartQ4 = Charts.barChart(barChartQ4);
    }



    private void initlalValues() {
        foods = new ArrayList<>();
        departments = new ArrayList<>();
        stockLabels = new ArrayList<>();
        costLabels = new ArrayList<>();
        statusLabels = new ArrayList<>();


        stockLabels.add("FOH");
        stockLabels.add("BOH");
        stockLabels.add("EMPTY");

        statusLabels.add("OffSite");
        statusLabels.add("Idle");
        statusLabels.add("Active");


        costLabels.add("Delivery");
        costLabels.add("Expiration Penalty");
        costLabels.add("Employee Wayes");
        costLabels.add("Product Costs");
        costLabels.add("Inventory Penalty");

        foods.add("Apples");
        foods.add("Bananas");
        foods.add("Cereal");
        foods.add("Cookies");
        foods.add("Pizza");
        foods.add("Dessert");
        foods.add("Milk");
        foods.add("Eggs");

        departments.add( "Registers");
        departments.add("Produce");
        departments.add( "Dry Goods");
        departments.add( "Frozen");
        departments.add( "Dairy" );

    }


    private void setupView() {
        userInput = findViewById(R.id.btnInputs);
        userInput.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(getApplicationContext(),"Testing Button", Toast.LENGTH_SHORT).show();
        Intent intent5 = new Intent(this, UserInputs.class);
        startActivity(intent5);
    }
}
