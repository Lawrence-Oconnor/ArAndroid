package com.example.grocerystore.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grocerystore.Dialogs.PrevReport;
import com.example.grocerystore.Dialogs.UserInputs;
import com.example.grocerystore.Dialogs.referencePopup;
import com.example.grocerystore.HelperClasses.Charts;
import com.example.grocerystore.Models.Employee;
import com.example.grocerystore.Models.FoodItem;
import com.example.grocerystore.Models.Store;
import com.example.grocerystore.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Historical extends AppCompatActivity implements View.OnClickListener {

    Button userInput;
    TextView tvDay;
    TextView tvCash;
    ImageButton btnInfo;
    ImageButton btnReport;



    //Quadrant 1
    PieChart pieChartQ1A;
    PieChart pieChartQ1B;
    PieChart pieChartQ1C;
    PieChart pieChartQ1D;
    PieChart pieChartQ1E;
    PieChart pieChartQ1F;

    //Quadrant 2
    PieChart pieChart1;
    BarChart barChartQ2A;
    BarChart barChartQ2B;



    //Quadrant 3
    PieChart pieChartQ3A;
    PieChart pieChartQ3B;
    TextView tv_Rev;
    TextView tv_Cost;
    TextView tv_Profit;


    //Quadrant 4
    HorizontalBarChart barChartQ4;
    PieChart pieChartQ4A;
    PieChart pieChartQ4B;
    PieChart pieChartQ4C;

    TextView cv1;
    TextView cv2;
    TextView cv3;
    TextView cv4;
    TextView cv5;
    TextView cv6;



    ArrayList<String> departments;
    ArrayList<String> foods;
    ArrayList<String> stockLabels;
    ArrayList<String> costLabels;
    ArrayList<String> statusLabels;
     ArrayList<String> shifts;

    ArrayList<Integer> deptColors;
    ArrayList<Integer> foodColors;
    ArrayList<Integer> foodColorsStack;
    ArrayList<Integer> stockColors;
    ArrayList<Integer> costColors;
    ArrayList<Integer> statusColors;



    ArrayList<Employee> employees;
    ArrayList<FoodItem> items;

    Store day;
    Store dayCopy;

    float[] prevVals = {0,0,0,0,0,0,0,0,0,0};

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


        Bundle b = this.getIntent().getExtras();
         if (b == null);
        {
            //this means we are on the first day
            initializeDay();


        }

        if (b != null)
        {
            day = b.getParcelable("DayObj");
            prevVals = b.getFloatArray("prev");


        }
        dayCopy = new Store(day);
        DecimalFormat formatter = new DecimalFormat("#,###.00");

        int cash = day.getCash();

        //tv9.setText(getString(R.string.cashtx, cash));
        tvDay.setText("Day "+ day.getStoreDay());
        tvCash.setText("" + formatter.format(day.getCash()));



    }


    private void initializeDay() {

        //fills Array with Employees
        initializeEmployees();
        //fills array of with current stock of food
        initializeStock();


        //TODO
        //need to increment the day on refresh
        //initializing a day with the default values, starter array of employees, departments and foods
        day = new Store(1,10000,12,12,10,0,100, 250, departments,employees,items, 0);



    }
    private void quadrant1() {

        pieChartQ1A = (PieChart) findViewById(R.id.pcQ1A);
        pieChartQ1A = Charts.pieChart(pieChartQ1A , statusLabels, statusColors);

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
        pieChartQ1B = Charts.pieChart(pieChartQ1B, statusLabels, statusColors);
        pieChartQ1B.getData().getDataSet().setValueFormatter(new PercentFormatter(pieChartQ1B));


        pieChartQ1C = (PieChart) findViewById(R.id.pcQ1C);
        pieChartQ1C = Charts.pieChart(pieChartQ1C, statusLabels, statusColors);
        pieChartQ1C.getData().getDataSet().setValueFormatter(new PercentFormatter(pieChartQ1C));

        //top charts above

        pieChartQ1D = (PieChart) findViewById(R.id.pcQ1D);
        pieChartQ1D = Charts.pieChart(pieChartQ1D, departments, deptColors);
        pieChartQ1D.getData().getDataSet().setValueFormatter(new PercentFormatter(pieChartQ1D));

        pieChartQ1E = (PieChart) findViewById(R.id.pcQ1E);
        pieChartQ1E = Charts.pieChart(pieChartQ1E, departments, deptColors);
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
        pieChartQ1F = Charts.pieChart(pieChartQ1F, departments, deptColors);
        pieChartQ1F.getData().getDataSet().setValueFormatter(new PercentFormatter(pieChartQ1F));
    }

    public void quadrant2() {

        pieChart1 = (PieChart) findViewById(R.id.chart1Pie);
        pieChart1 = Charts.pieChart(pieChart1, stockLabels, stockColors);
        pieChart1.getLegend().setEnabled(true);


//TODO replace with values pulled from excel file for each day

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, new float[]{30f, 15f,22f}));
        entries.add(new BarEntry(1f, new float[]{30f, 15f,22f}));
        entries.add(new BarEntry(2f, new float[]{30f, 15f,22f}));
        entries.add(new BarEntry(3f, new float[]{30f, 15f,22f}));
        entries.add(new BarEntry(4f, new float[]{30f, 15f,22f}));
        entries.add(new BarEntry(5f, new float[]{30f, 15f,22f}));
        entries.add(new BarEntry(6f, new float[]{30f, 15f,22f}));
        entries.add(new BarEntry(7f, new float[]{30f, 15f,22f}));




        ArrayList<BarEntry> foodEntries = new ArrayList<>();
       foodEntries.add(new BarEntry(0f, 30f));
       foodEntries.add(new BarEntry(1f, 10f));
       foodEntries.add(new BarEntry(2f, 15f));
       foodEntries.add(new BarEntry(3f, 35f));
       foodEntries.add(new BarEntry(4f, 33f));
       foodEntries.add(new BarEntry(5f, 24f));
       foodEntries.add(new BarEntry(6f, 5f));
       foodEntries.add(new BarEntry(7f, 9f));

        barChartQ2A = (BarChart)findViewById(R.id.bcQ2A);
        barChartQ2A = Charts.barChart(barChartQ2A, foods, foodColorsStack, entries);
        barChartQ2A.getDescription().setEnabled(false);

        barChartQ2B = (BarChart)findViewById(R.id.bcQ2B);
        barChartQ2B = Charts.barChart(barChartQ2B, foods, foodColors, foodEntries);
        barChartQ2B.getLegend().setEnabled(false);
        barChartQ2B.getDescription().setEnabled(false);
    }



    private void quadrant3() {

        pieChartQ3A = (PieChart) findViewById(R.id.pcQ3A);
        pieChartQ3A = Charts.pieChart(pieChartQ3A, foods, foodColors);
        pieChartQ3A.getLegend().setEnabled(true);
        pieChartQ3A.getLegend().setWordWrapEnabled(true);

        pieChartQ3B = (PieChart) findViewById(R.id.pcQ3B);
        pieChartQ3B = Charts.pieChart(pieChartQ3B, costLabels, foodColors);
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
        pieChartQ4A = Charts.pieChart(pieChartQ4A, foods, foodColors);
        pieChartQ4A.getLegend().setEnabled(true);
        pieChartQ4A.getLegend().setWordWrapEnabled(true);
        pieChartQ4A.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        pieChartQ4A.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        pieChartQ4A.getLegend().setOrientation(Legend.LegendOrientation.VERTICAL);
        pieChartQ4A.setExtraOffsets(16, 0, 0, 0);

        pieChartQ4B = (PieChart) findViewById(R.id.pcQ4B);
        pieChartQ4B = Charts.pieChart(pieChartQ4B, foods, foodColors);



        pieChartQ4C = (PieChart) findViewById(R.id.pcQ4C);
        pieChartQ4C = Charts.pieChart(pieChartQ4C, foods, foodColors);

        //TODO change to real values when data balanced by changing y coord
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 280f));
        entries.add(new BarEntry(2f, 360f));

        ArrayList green = new ArrayList<Integer>();
        green.add(ContextCompat.getColor(this, R.color.green));
        barChartQ4 = (HorizontalBarChart) findViewById(R.id.bcQ4);
        barChartQ4 = Charts.barChartH(barChartQ4, shifts, green, entries);
        barChartQ4.getLegend().setEnabled(false);
        barChartQ4.getDescription().setEnabled(false);



        cv1 = findViewById(R.id.cv1);
        cv2 = findViewById(R.id.cv2);
        cv3 = findViewById(R.id.cv3);
        cv4 = findViewById(R.id.cv4);
        cv5 = findViewById(R.id.cv5);
        cv6 = findViewById(R.id.cv6);

        //TODO change to real amount when excel sheet balanced.
        cv1.setText("0");
        cv2.setText("0");
        cv3.setText("0");
        cv4.setText("0");
        cv5.setText("0");
        cv6.setText("0");
    }



    private void initlalValues() {
        foods = new ArrayList<>();
        departments = new ArrayList<>();
        stockLabels = new ArrayList<>();
        costLabels = new ArrayList<>();
        statusLabels = new ArrayList<>();
        shifts = new ArrayList<>();

        deptColors  =new ArrayList<>();
        foodColors = new ArrayList<>();
        foodColorsStack = new ArrayList<>();
        stockColors = new ArrayList<>();
        costColors  = new ArrayList<>();
        statusColors = new ArrayList<>();

        tvDay = findViewById(R.id.tvDay);
        tvCash = findViewById(R.id.tvCash2);
        btnInfo = findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(this);

        btnReport = findViewById(R.id.btnReport);
        btnReport.setOnClickListener(this);

        stockLabels.add("FOH");
        stockLabels.add("BOH");
        stockLabels.add("EMPTY");


        statusLabels.add("Active");
        statusLabels.add("OffSite");
        statusLabels.add("Idle");



        costLabels.add("Delivery");
        costLabels.add("Expiration Penalty");
        costLabels.add("Employee Wayes");
        costLabels.add("Product Costs");
        costLabels.add("Inventory Penalty");


        foods.add("Cheese");
        foods.add("Milk");
        foods.add("Cereal");
        foods.add("Cookies");
        foods.add("Pizza");
        foods.add("Dessert");
        foods.add("Apples");
        foods.add("Bananas");

        departments.add("Produce");
        departments.add( "Dairy" );
        departments.add( "Dry Goods");
        departments.add( "Frozen");
        departments.add( "Registers");


        shifts.add("8 AM - 12 PM");
        shifts.add("12 PM - 4 PM ");
        shifts.add("4 PM - 8 PM ");

         statusColors.add(ContextCompat.getColor(this,R.color.active));
         statusColors.add(ContextCompat.getColor(this,R.color.offsite));
         statusColors.add(ContextCompat.getColor(this,R.color.idle));

         deptColors .add(ContextCompat.getColor(this,R.color.produce));
         deptColors.add(ContextCompat.getColor(this,R.color.dairy));
         deptColors.add(ContextCompat.getColor(this,R.color.dryGoods));
         deptColors.add(ContextCompat.getColor(this,R.color.frozen));
         deptColors.add(ContextCompat.getColor(this,R.color.registers));



         foodColors.add(ContextCompat.getColor(this,R.color.eggs));
         foodColors.add(ContextCompat.getColor(this,R.color.milk));

        foodColors.add(ContextCompat.getColor(this,R.color.cereal));
        foodColors.add(ContextCompat.getColor(this,R.color.cookies));
        foodColors.add(ContextCompat.getColor(this,R.color.pizza));
        foodColors.add(ContextCompat.getColor(this,R.color.desert));
        foodColors.add(ContextCompat.getColor(this,R.color.apples));
        foodColors.add(ContextCompat.getColor(this,R.color.banana));

         stockColors.add(ContextCompat.getColor(this,R.color.FOH2));
         stockColors.add(ContextCompat.getColor(this,R.color.BOH2));
         stockColors.add(ContextCompat.getColor(this, R.color.EMPTY2));

         costColors.add(ContextCompat.getColor(this,R.color.delivery));
         costColors.add(ContextCompat.getColor(this,R.color.expiration));
         costColors.add(ContextCompat.getColor(this,R.color.wages));
         costColors.add(ContextCompat.getColor(this,R.color.productCost));
         costColors.add(ContextCompat.getColor(this,R.color.inventoryPenalty));




        foodColorsStack.add(ContextCompat.getColor(this,R.color.apples));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.FOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.BOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.banana));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.FOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.BOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.eggs));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.FOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.BOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.milk));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.FOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.BOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.pizza));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.FOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.BOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.cookies));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.FOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.BOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.cereal));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.FOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.BOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.desert));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.FOH));
        foodColorsStack.add(ContextCompat.getColor(this,R.color.BOH));



        //  new int[] { R.color., R.color.red2, R.color.red3, R.color.red4 }

    }


    private void initializeEmployees() {

        employees = new ArrayList<>();

        for(int i=0; i< 10; i++)
        {
            employees.add(new Employee("Employee",i+1,true,45.0,1,false, false));
            //use String temp = new String(departments.get(1)); to access emplyee dept string
        }
    }
    private void initializeStock() {
        items = new ArrayList<>();

        int sampleInitial =150;
        float priceCustomer =5.00f, priceFarmer= 0.50f, totalPrice = 7.0f;

        items.add(new FoodItem(1, "Cheese", totalPrice, priceCustomer, priceFarmer, 100,100, 100, 100, 200));
        items.add(new FoodItem(1, "Milk" , totalPrice, priceCustomer, priceFarmer, 100,100, 100, 100, 200));
        items.add(new FoodItem(2, "Cereal", totalPrice, priceCustomer, priceFarmer, 100,100, 100, 100, 200));
        items.add(new FoodItem(2, "Cookies", totalPrice, priceCustomer, priceFarmer, 100,100, 100, 100, 200));
        items.add(new FoodItem(3, "Pizza", totalPrice, priceCustomer, priceFarmer, 100,100, 100, 100, 200));
        items.add(new FoodItem(3, "Dessert", totalPrice, priceCustomer, priceFarmer, 100,100, 100, 100, 200));
        items.add(new FoodItem(4, "Apples", totalPrice, priceCustomer, priceFarmer, 100,100, 100, 100, 200));
        items.add(new FoodItem(4, "Bananas", totalPrice, priceCustomer, priceFarmer, 100,100, 100, 100, 200));

    }


    private void setupView() {
        userInput = findViewById(R.id.btnInputs);
        userInput.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
          //Toast.makeText(getApplicationContext(),"Testing Button", Toast.LENGTH_SHORT).show();

        switch (v.getId()) {

            case R.id.btnInputs:
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("DayObj", day);
                i.putExtras(b);
                i.setClass(getApplicationContext(), UserInputs.class);
                startActivity(i);

                break;

            case R.id.btnInfo:
                Intent c = new Intent();
                c.setClass(getApplicationContext(), referencePopup.class);
                startActivity(c);
                break;

            case R.id.btnReport:
                Intent x = new Intent();
                Bundle y = new Bundle();
                y.putParcelable("DayObj", dayCopy);
                y.putFloatArray("prev", prevVals);
                x.putExtras(y);
                x.setClass(getApplicationContext(), PrevReport.class);// replace with new class
                startActivity(x);

                break;


            default:
                break;
        }
    }
}
