package com.example.grocerystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grocerystore.HelperClasses.Register;
import com.example.grocerystore.HelperClasses.updateDay;
import com.example.grocerystore.Models.Employee;
import com.example.grocerystore.Models.Store;
import com.example.grocerystore.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

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
    TextView btn10;
    TextView btn11;

    int expiredTotal = 0;
    int pay = 0;
    int netChange = 0;
    int soldS1 = 0, soldS2 = 0, soldS3 = 0;
    int leftS1 = 0, leftS2 = 0, leftS3 = 0;
    boolean end;

    float[] S1 = {0, 0, 0, 0, 0, 0};
    float[] S2 = {0, 0, 0, 0, 0, 0};
    float[] S3 = {0, 0, 0, 0, 0, 0};
    float[] S1b = {0, 0, 0, 0, 0, 0};
    float[] S2b = {0, 0, 0, 0, 0, 0};
    float[] S3b = {0, 0, 0, 0, 0, 0};
    float[] prevVals = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    float[] quantities = {0, 0, 0, 0, 0, 0, 0, 0};
    float[] shipping = {0, 0, 0, 0, 0, 0, 0, 0};


    ArrayList<Employee> S1Employees;
    ArrayList<Employee> S2Employees;
    ArrayList<Employee> S3Employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_report);


        Bundle b = this.getIntent().getExtras();
        if (b == null) ;
        {
            //Toast.makeText(getApplicationContext(), "Store Object Error", Toast.LENGTH_SHORT).show();
            // //this means we are on the first day
        }

        if (b != null) {
            day = b.getParcelable("DayObj");
            //Toast.makeText(getApplicationContext(),"B is not NULL", Toast.LENGTH_SHORT).show();
            S1 = b.getFloatArray("S1");
            S2 = b.getFloatArray("S2");
            S3 = b.getFloatArray("S3");
            S1b = Arrays.copyOf(S1, 6);
            S2b = Arrays.copyOf(S2, 6);
            S3b = Arrays.copyOf(S3, 6);
            quantities = b.getFloatArray("quant");
            shipping = b.getFloatArray("ship");
            newDay = new Store(day);
        }

        initializeEmployees();
        end = false;

        setupView();
        runCalculations();
        setTextViews();


        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newDay.setStoreDay(newDay.getStoreDay() + 1);
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("DayObj", newDay);
                b.putFloatArray("prev", prevVals);
                i.putExtras(b);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                if (end) {
                    i.setClass(getApplicationContext(), StartScreen.class);
                }
                if (!end) {
                    i.setClass(getApplicationContext(), Historical.class);
                }
                startActivity(i);
            }
        });
    }

    private void initializeEmployees() {

        S1Employees = new ArrayList<>();
        S2Employees = new ArrayList<>();
        S3Employees = new ArrayList<>();
        int a = 1, b = 1, c = 1, x = 6;

        for (int i = a; i < x; i++) {
            if (a == x)
                break;

            while (S1[a] != 0) {
                S1Employees.add(new Employee("Employee", i + 1, true, 45.0, a, false, false));
                S1[a] -= 1;
            }
            if (S1[a] == 0) {
                a++;
            }

        }

        for (int i = b; i < x; i++) {
            if (b == x)
                break;

            while (S2[b] != 0) {
                S2Employees.add(new Employee("Employee", i + 1, true, 45.0, b, false, false));
                S2[b] -= 1;
            }
            if (S2[b] == 0) {
                b++;
            }

        }

        for (int i = c; i < x; i++) {
            if (c == x)
                break;

            while (S3[c] != 0) {
                S3Employees.add(new Employee("Employee", i + 1, true, 45.0, c, false, false));
                S3[c] -= 1;
            }
            if (S3[c] == 0) {
                c++;
            }

        }

    }

    private void setTextViews() {
        DecimalFormat formatter = new DecimalFormat("#,###.00");

        btn1.setText("You completed Day " + newDay.getStoreDay());
        btn2.setText("You have $" + formatter.format(newDay.getCash()) + "\n Net Change: " + formatter.format(netChange));
        btn3.setText("Total Front of House Stock: " + newDay.getFOHStock());
        btn4.setText("Total Back of House Stock: " + newDay.getBOHStock());
        int solttot = soldS1 + soldS2 + soldS3;
        btn5.setText("You sold " + solttot + " items" + "\n Shift 1:\t" + soldS1 + "\t Shift 2: " + soldS2 + "\t Shift 3: " + soldS3);
        btn6.setText("Items left at register \n Shift 1:" + leftS1 + "\t Shift 2: " + leftS2 + "\t Shift 3: " + leftS3);
        btn7.setText(expiredTotal + " foods expired");
        btn8.setText("$ " + formatter.format(pay) + " Spent on Employee Salaries");

        prevVals[0] = solttot;
        prevVals[1] = soldS1;
        prevVals[2] = soldS2;
        prevVals[3] = soldS3;
        prevVals[4] = leftS1;
        prevVals[5] = leftS2;
        prevVals[6] = leftS3;
        prevVals[7] = expiredTotal;
        prevVals[8] = netChange;
        prevVals[9] = pay;
    }

    private void setupView() {

        btnContinue = findViewById(R.id.btnNextDay);
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
        btn10 = findViewById(R.id.tvDP10);
        btn11 = findViewById(R.id.tvDP11);


    }

    private void runCalculations() {
        //run calculatuons on newDay - that way we can compare to previous day

        //3 for loops that run 4 times - represents each hour in 12 hour day
        int cash = 0;
        int pay2 = 0;
        pay = 0;

        newDay.setEmployees(S1Employees);
        //Toast.makeText(getApplicationContext(),"Register Employees: size " + newDay.getEmployeesRegisters(), Toast.LENGTH_SHORT).show();
        for (int i = 0; i < 4; i++) {
            //restock
            newDay = updateDay.restock(newDay, S1b);
            //pay employees
            pay2 = updateDay.payEmployees(newDay);
            pay += pay2;
            cash = newDay.getCash();
            cash -= pay2;
            newDay.setCash(cash);

            if (newDay.getEmployeesRegisters() > 0)
                newDay = Register.pullItemsOffShelves(newDay);
        }
        soldS1 = (int) newDay.getRegUT();
        leftS1 = (newDay.getShift() / 4);
        newDay.setShift(0);
        newDay.setRegUT(0);

        //shift 2 calculations
        newDay.setEmployees(S2Employees);
        for (int i = 0; i < 4; i++) {

            newDay = updateDay.restock(newDay, S2b);
            pay2 = updateDay.payEmployees(newDay);
            pay += pay2;
            cash = newDay.getCash();
            cash -= pay2;
            newDay.setCash(cash);

            if (i == 1)
                newDay = updateDay.makeDeliveries(newDay, quantities, shipping);

            if (newDay.getEmployeesRegisters() > 0)
                newDay = Register.pullItemsOffShelves(newDay);

        }

        soldS2 = (int) newDay.getRegUT();
        leftS2 = (newDay.getShift() / 4);
        newDay.setShift(0);
        newDay.setRegUT(0);

        //shift 3 calculations
        newDay.setEmployees(S3Employees);
        for (int i = 0; i < 4; i++) {

            newDay = updateDay.restock(newDay, S3b);

            pay2 = updateDay.payEmployees(newDay);
            pay += pay2;
            cash = newDay.getCash();
            cash -= pay2;
            newDay.setCash(cash);


            if (newDay.getEmployeesRegisters() > 0)
                newDay = Register.pullItemsOffShelves(newDay);
        }

        soldS3 = (int) newDay.getRegUT();
        leftS3 = (newDay.getShift() / 4);
        newDay.setShift(0);
        newDay.setRegUT(0);

        //end of day
        int initialBOH = newDay.getBOHStock();
        int initialFOH = newDay.getFOHStock();
        int afterBOH = 0;
        int afterFOH = 0;
        expiredTotal = 0;
        newDay = updateDay.expireInventory(newDay);
        afterBOH = newDay.getBOHStock();
        afterFOH = newDay.getFOHStock();
        expiredTotal = initialBOH + initialFOH - afterBOH - afterFOH;
        netChange = newDay.getCash() - day.getCash();

    }


}
