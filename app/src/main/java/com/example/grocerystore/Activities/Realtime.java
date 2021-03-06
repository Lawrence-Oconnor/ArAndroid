package com.example.grocerystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.grocerystore.Models.Employee;
import com.example.grocerystore.Models.FoodItem;
import com.example.grocerystore.Models.Store;
import com.example.grocerystore.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Realtime extends AppCompatActivity implements View.OnClickListener {

    Thread sample;


    //Buttons
    Button restock;
    Button delivery;
    Button release;
    Button callIn;
    Button reassign;

    TextView tvDay;

    //charts
    PieChart pieChart1;
    BarChart barChart;
    LineChart lineChart;

    Store day;

    private int dayCount;
    private Timer clock = new Timer();


    ArrayList<Employee> employees;
    ArrayList<String> departments;
    ArrayList<String> foods;
    ArrayList<FoodItem> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime);
       // setupView();

        //Testing initialization of multiple chart types
//        pieChartTest();
       // barChartTest();
       // lineChartTest();


      //  initializeDay();

        //for later use/ set up default charts
     //   initializeCharts();

        //update chart method updates on hour of game time
     //   refreshCharts();

    }

    private void initializeDay() {

        //fills Array with Employees
        initializeEmployees();
        //fills array of with current stock of food
        initializeStock();


        //TODO
        //need to increment the day on refresh
        //initializing a day with the default values, starter array of employees, departments and foods
        day = new Store(1, 1, 100, 12, 10, 20, 100, 250, departments, employees, items, 0);

        tvDay.setText("DAY :" + day.getStoreDay());


    }
/*
    private void dayThread()
    {
        //code to be moved to a thread to run every hour

        //updating the day with methods in Update day
        day = updateDay.expireInventory(day);
        day = updateDay.checkoutFood(day);
        day = updateDay.foodToRegister(day);
        day = updateDay.returnFoodToShelves(day);



        //thread end of day
        day = updateDay.pullItemsOffShelves(day);
        day = updateDay.payEmployees(day);
        day = updateDay.expireInventory(day);


            checkForDelivery();



       //copy the logic for these
            registers.checkoutFoods();
            // if theres any at the end of the day, return the foods to shelves
            registers.returnFoodsToShelves();



        // thread for END OF EACH HOUR
        day = updateDay.pullItemsOffShelves(day);
        day = updateDay.payEmployees(day);



            registers.checkoutFoods();
        }

        */

    private void initializeStock() {
        departments = new ArrayList<>();
        foods = new ArrayList<>();
        items = new ArrayList<>();

        int sampleInitial = 150;
        float priceCustomer = 0.99f, priceFarmer = 0.50f, totalPrice = 148.50f;
/*
        items.add(new FoodItem("Produce", "PR", "Apples", "A2", "PR-A2", sampleInitial, priceCustomer, priceFarmer, totalPrice));
        items.add(new FoodItem("Produce", "PR", "Bananas", "A2", "PR-A2", sampleInitial, priceCustomer, priceFarmer, totalPrice));
        items.add(new FoodItem("DryGoods", "PR", "Cereal", "A2", "PR-A2", sampleInitial, priceCustomer, priceFarmer, totalPrice));
        items.add(new FoodItem("DryGoods", "PR", "Cookies", "A2", "PR-A2", sampleInitial, priceCustomer, priceFarmer, totalPrice));
        items.add(new FoodItem("Frozen", "PR", "Pizza", "A2", "PR-A2", sampleInitial, priceCustomer, priceFarmer, totalPrice));
        items.add(new FoodItem("Frozen", "PR", "Dessert", "A2", "PR-A2", sampleInitial, priceCustomer, priceFarmer, totalPrice));
        items.add(new FoodItem("Dairy", "PR", "Milk", "A2", "PR-A2", sampleInitial, priceCustomer, priceFarmer, totalPrice));
        items.add(new FoodItem("Dairy", "PR", "Eggs", "A2", "PR-A2", sampleInitial, priceCustomer, priceFarmer, totalPrice));
*/
        foods.add("Apples");
        foods.add("Bananas");
        foods.add("Cereal");
        foods.add("Cookies");
        foods.add("Pizza");
        foods.add("Dessert");
        foods.add("Milk");
        foods.add("Eggs");

        departments.add("Registers");
        departments.add("Produce");
        departments.add("Dry Goods");
        departments.add("Frozen");
        departments.add("Dairy");
    }


    private void initializeEmployees() {

        employees = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            employees.add(new Employee("Employee", i + 1, true, 45.0, 1, false, false));
            //use String temp = new String(departments.get(1)); to access emplyee dept string
        }
    }


    private void refreshCharts() {

    }

    private void initializeCharts() {


    }

    private void lineChartTest() {

       // lineChart = (LineChart) findViewById(R.id.Q2LineChart);

        List<Entry> entries1 = new ArrayList<>();
        entries1.add(new Entry(0f, 34f));
        entries1.add(new Entry(1f, 75f));
        entries1.add(new Entry(2f, 900f));
        entries1.add(new Entry(3f, 22f));

        LineDataSet dataset1 = new LineDataSet(entries1, "Test Set");
        dataset1.setAxisDependency(YAxis.AxisDependency.LEFT);


        List<ILineDataSet> datasets = new ArrayList<ILineDataSet>();
        datasets.add(dataset1);

        LineData data = new LineData(datasets);
        lineChart.setData(data);
        lineChart.invalidate();
        //lineChart.animateXY(22,22);
    }

    private void barChartTest() {
        barChart = (BarChart) findViewById(R.id.bcQ2A);


        BarDataSet barDataSet = new BarDataSet(getData(), "TestData");
        barDataSet.setBarBorderWidth(0.9f);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData = new BarData(barDataSet);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        final String[] testData = new String[]{"Test1", "Test2", "Test3", "Test4", "Test5", "Test6"};
        IndexAxisValueFormatter formatter = new IndexAxisValueFormatter(testData);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);
        barChart.setData(barData);
        barChart.setFitBars(true);
        //barChart.animateXY(5000, 5000);
        barChart.invalidate();

    }

    private ArrayList getData() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        entries.add(new BarEntry(4f, 70f));
        entries.add(new BarEntry(5f, 60f));
        return entries;
    }


    private void pieChartTest() {
        //import into a new class
        pieChart1 = (PieChart) findViewById(R.id.chart1Pie);
        pieChart1.setUsePercentValues(true);
        pieChart1.getDescription().setEnabled(false);
        pieChart1.setExtraOffsets(0, 0, 0, 0);

        pieChart1.setDragDecelerationFrictionCoef(0.95f);

        pieChart1.setDrawHoleEnabled(false);
        // pieChart1.setHoleColor(Color.WHITE);
        // pieChart1.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> values = new ArrayList<>();

        values.add(new PieEntry(60f, "1"));
        values.add(new PieEntry(10, "2"));
        values.add(new PieEntry(5f, "3"));
        values.add(new PieEntry(7f, "4"));
        values.add(new PieEntry(18f, "5"));

        PieDataSet dataset = new PieDataSet(values, "TEST VALUES");
        dataset.setSliceSpace(3f);
        dataset.setSelectionShift(5f);
        dataset.setColors(ColorTemplate.PASTEL_COLORS);

        PieData data = new PieData(dataset);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.WHITE);


        pieChart1.getLegend().setEnabled(false);
        pieChart1.setData(data);


    }


    private void setupView() {
        //buttons = find view by id
        restock = findViewById(R.id.btnRestock);
        delivery = findViewById(R.id.btnMakeNewDeliv);
        release = findViewById(R.id.btnReleaseEmployee);
        callIn = findViewById(R.id.btnCallEmployee);
        reassign = findViewById(R.id.btnReasEmployee);
        tvDay = findViewById(R.id.tvDay);

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
        switch (v.getId()) {
/*
            case R.id.btnRestock:
                Toast.makeText(getApplicationContext(),"Testing Button", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, popupMenu.class);
                startActivity(intent1);
                break;

            case R.id.btnMakeNewDeliv:
                Toast.makeText(getApplicationContext(),"Testing Button", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, popupMenu.class);
                startActivity(intent2);
                break;

            case R.id.btnReasEmployee:
                Toast.makeText(getApplicationContext(),"Testing Button", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, popupMenu.class);
                startActivity(intent3);
                break;

            case R.id.btnCallEmployee:
                Toast.makeText(getApplicationContext(),"Testing Button", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, popupMenu.class);
                startActivity(intent4);
                break;

            case R.id.btnReleaseEmployee:
                Toast.makeText(getApplicationContext(),"Testing Button", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(this, popupMenu.class);
                startActivity(intent5);
                break;


*/

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

//

    }
}
