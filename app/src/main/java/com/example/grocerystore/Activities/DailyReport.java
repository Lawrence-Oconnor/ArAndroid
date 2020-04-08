package com.example.grocerystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grocerystore.HelperClasses.updateDay;
import com.example.grocerystore.Models.Store;
import com.example.grocerystore.R;

import java.text.DecimalFormat;

public class DailyReport extends AppCompatActivity {

    Store day;
    Store newDay;
    TextView btnContinue;
    TextView btn1;
    TextView btn2;
    TextView btn3;
    TextView btn4;
    TextView btn5;
    TextView btn6;
    TextView btn7;
    TextView btn8;
    TextView btn9;
    int expiredTotal = 0;
    int pay = 0;

    boolean end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_report);




        Bundle b = this.getIntent().getExtras();
        if (b == null);
        {
            //Toast.makeText(getApplicationContext(), "Store Object Error", Toast.LENGTH_SHORT).show();
           // //this means we are on the first day
        }

        if (b != null)
        {
            day = b.getParcelable("DayObj");
            //Toast.makeText(getApplicationContext(),"B is not NULL", Toast.LENGTH_SHORT).show();

            newDay = new Store(day);
        }


        end = false;


        setupView();
        runCalculations();
        setTextViews();




        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                newDay.setStoreDay(newDay.getStoreDay()+1);

                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("DayObj", newDay);
                i.putExtras(b);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                if (end) {
                    i.setClass(getApplicationContext(), StartScreen.class);
                }
                if (!end)
                {
                    i.setClass(getApplicationContext(), Historical.class);
                }
                startActivity(i);
            }
        });
    }

    private void setTextViews() {
        DecimalFormat formatter = new DecimalFormat("#,###.00");

        btn1.setText("You completed Day " + newDay.getStoreDay());
        btn2.setText("You have $" + formatter.format(newDay.getCash()));
        btn3.setText("Total Front of House Stock: " + newDay.getFOHStock());
        btn4.setText("Total Back of House Stock: " + newDay.getBOHStock());
        btn5.setText("You sold " + " items");
        btn6.setText(expiredTotal + " foods expired");
        btn7.setText("$ " + formatter.format(pay) +" Spent on Employee Salaries");
        btn8.setText("Blanl" + " deliveries will arrive tomorrow");
        btn9.setText("Reister Utilization");//calculations
    }

    private void setupView() {

        btnContinue= findViewById(R.id.btnNextDay);
        if (day.getStoreDay() == 7) {
            btnContinue.setText(getResources().getString(R.string.btn_End));
            end = true;
        }

        if (day.getStoreDay() < 7) {
            btnContinue.setText(getResources().getString(R.string.btn_Continue));
            end = false;
        }

         btn1 = findViewById(R.id.tvDP1);
         btn2 = findViewById(R.id.tvDP2);
         btn3 = findViewById(R.id.tvDP3);
         btn4 = findViewById(R.id.tvDP4);
         btn5 = findViewById(R.id.tvDP5);
         btn6 = findViewById(R.id.tvDP6);
         btn7 = findViewById(R.id.tvDP7);
         btn8 = findViewById(R.id.tvDP8);
         btn9 = findViewById(R.id.tvDP9);




    }

    private void runCalculations()
    {
        //run calculatuons on newDay - that way we can compare to previous day

        //3 for loops that run 4 times - represents each hour
 int cash =0;
 int pay2 = 0;

        for(int i=0; i<4;i++)
        {
            //shift 1 calculations
            //pull items off shelf

            //pay employees

        pay2 = updateDay.payEmployees(newDay);
        pay+= pay2;
        cash = newDay.getCash();
        cash -= pay2;
        newDay.setCash(cash);
        }
//set the number of employees and departments based on the data bassed pn finalize
//create 3 employee arrays so we can just set the employees in between shifts
        for(int i=0; i<4;i++)
        {

            //shift 1 calculations
            pay2 = updateDay.payEmployees(newDay);
            pay+= pay2;
            cash = newDay.getCash();
            cash -= pay2;
            newDay.setCash(cash);

            //pull items off shelf
            //
        }

        for(int i=0; i<4;i++)
        {

            //shift 1 calculations
            pay2 = updateDay.payEmployees(newDay);
            pay+= pay2;
            cash = newDay.getCash();
            cash -= pay2;
            newDay.setCash(cash);
        }

        //end of day
        int initialBOH = newDay.getBOHStock();
        int initialFOH = newDay.getFOHStock();
        int afterBOH = 0;
        int afterFOH = 0;
        expiredTotal = 0;
        newDay = updateDay.expireInventory(newDay);
        afterBOH = newDay.getBOHStock();
        afterFOH = newDay.getFOHStock();

        expiredTotal = initialBOH+initialFOH-afterBOH-afterFOH;
    }


}
