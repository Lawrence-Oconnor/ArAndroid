package com.example.grocerystore.Dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.grocerystore.Models.Store;
import com.example.grocerystore.R;

import java.text.DecimalFormat;

public class PrevReport extends Activity {

    TextView title;
    Store newDay;
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

    float[] prevVals = {0,0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev_report);


        title = findViewById(R.id.textView36);



        Bundle b = this.getIntent().getExtras();

        newDay = b.getParcelable("DayObj");
        prevVals = b.getFloatArray("prev");


        if (newDay.getStoreDay() == 1);
        {

            title.setText("No Previous Report Available");

        }
        if (newDay.getStoreDay() >1) {
            title.setText("Previous End of Day Report");

            setupView();
            setTextViews();
        }
    }

    private void setupView() {


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

    private void setTextViews() {
        DecimalFormat formatter = new DecimalFormat("#,###.00");

        btn1.setText("You completed Day " + newDay.getStoreDay());
        btn2.setText("You have $" + formatter.format(newDay.getCash()) + "\n Net Change: " + formatter.format(prevVals[8]));
        btn3.setText("Total Front of House Stock: " + newDay.getFOHStock());
        btn4.setText("Total Back of House Stock: " + newDay.getBOHStock());
        float solttot = prevVals[1]+prevVals[2]+prevVals[3];
        btn5.setText("You sold " + solttot +" items" + "\n Shift 1:\t" + (int)prevVals[1] +"\t Shift 2: " + (int)prevVals[2] + "\t Shift 3: " + (int)prevVals[3]);
        btn6.setText("Items left at register \n Shift 1:" + (int)prevVals[4] + "\t Shift 2: " + (int)prevVals[5] + "\t Shift 3: " + (int)prevVals[6]);
        btn7.setText((int)prevVals[7] + " foods expired");
        btn8.setText("$ " + formatter.format((int)prevVals[9]) +" Spent on Employee Salaries");

    }

}
