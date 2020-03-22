package com.example.grocerystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grocerystore.Dialogs.UserInputs;
import com.example.grocerystore.Dialogs.popupMenu;
import com.example.grocerystore.HelperClasses.Charts;
import com.example.grocerystore.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
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
    TextView tv_Rev;
    TextView tv_Cost;
    TextView tv_Profit;


    //Quadrant 4
    BarChart barChartQ4;
    PieChart pieChartQ4A;
    PieChart pieChartQ4B;
    PieChart pieChartQ4C;


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

        Legend l = pieChartQ1A.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        l.setEnabled(true);
        pieChartQ1A.setExtraOffsets(4,0,0,0);
        pieChartQ1A.getData().getDataSet().setValueFormatter(new PercentFormatter(pieChartQ1A));


        pieChartQ1B = (PieChart) findViewById(R.id.pcQ1B);
        pieChartQ1B = Charts.pieChart(pieChartQ1B, statusLabels);
        pieChartQ1B.getData().getDataSet().setValueFormatter(new PercentFormatter(pieChartQ1B));


        pieChartQ1C = (PieChart) findViewById(R.id.pcQ1C);
        pieChartQ1C = Charts.pieChart(pieChartQ1C, statusLabels);
        pieChartQ1C.getData().getDataSet().setValueFormatter(new PercentFormatter(pieChartQ1C));

        //top charts above

        pieChartQ1D = (PieChart) findViewById(R.id.pcQ1D);
        pieChartQ1D = Charts.pieChart(pieChartQ1D, departments);
        pieChartQ1D.getData().getDataSet().setValueFormatter(new PercentFormatter(pieChartQ1D));

        pieChartQ1E = (PieChart) findViewById(R.id.pcQ1E);
        pieChartQ1E = Charts.pieChart(pieChartQ1E, departments);
        pieChartQ1E.getData().getDataSet().setValueFormatter(new PercentFormatter(pieChartQ1E));

        Legend le = pieChartQ1E.getLegend();
        le.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        le.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        le.setOrientation(Legend.LegendOrientation.VERTICAL);
        le.setDrawInside(false);
        le.setXEntrySpace(7f);
        le.setYEntrySpace(0f);
        le.setYOffset(0f);
        le.setEnabled(true);
        pieChartQ1E.setExtraOffsets(16,0,0,0);


        pieChartQ1F = (PieChart) findViewById(R.id.pcQ1F);
        pieChartQ1F = Charts.pieChart(pieChartQ1F, departments);
        pieChartQ1F.getData().getDataSet().setValueFormatter(new PercentFormatter(pieChartQ1F));
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
        pieChartQ3A.getLegend().setEnabled(true);
        pieChartQ3A.getLegend().setWordWrapEnabled(true);

        pieChartQ3B = (PieChart) findViewById(R.id.pcQ3B);
        pieChartQ3B = Charts.pieChart(pieChartQ3B, costLabels);
        pieChartQ3B.getLegend().setEnabled(true);
        pieChartQ3B.getLegend().setWordWrapEnabled(true);

        tv_Cost = findViewById(R.id.textView13);
        tv_Rev = findViewById(R.id.textView5);
        tv_Profit = findViewById(R.id.textView6);

        //TODO change to the value from that specific day
        tv_Cost.setText("$0.00");
        tv_Rev.setText("$0.00");
        tv_Profit.setText("$0.00");
    }

    private void quadrant4() {
      //  lineChartQ4 = (LineChart)findViewById(R.id.Q4LineChart);
        //lineChartQ4 = Charts.lineChart(lineChartQ4);

        pieChartQ4A = (PieChart) findViewById(R.id.pcQ4A);
        pieChartQ4A = Charts.pieChart(pieChartQ3A, foods);
        pieChartQ4A.getLegend().setEnabled(true);
        pieChartQ4A.getLegend().setWordWrapEnabled(true);
        pieChartQ4A.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        pieChartQ4A.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);

        pieChartQ4B = (PieChart) findViewById(R.id.pcQ4B);
        pieChartQ4B = Charts.pieChart(pieChartQ4B, foods);



        pieChartQ4C = (PieChart) findViewById(R.id.pcQ4C);
        pieChartQ4C = Charts.pieChart(pieChartQ4C, foods);


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
