package com.example.grocerystore.Dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grocerystore.Activities.DailyReport;
import com.example.grocerystore.Activities.Historical;
import com.example.grocerystore.Models.Employee;
import com.example.grocerystore.Models.FoodItem;
import com.example.grocerystore.Models.Store;
import com.example.grocerystore.R;

import android.view.View;

import java.util.ArrayList;

public class UserInputs extends Activity implements View.OnClickListener {


    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    EditText et6;
    EditText et7;
    EditText et8;

    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;
    CheckBox ch4;
    CheckBox ch5;
    CheckBox ch6;
    CheckBox ch7;
    CheckBox ch8;

    //shift 1
    TextView S1A;
    TextView S1B;
    TextView S1C;
    TextView S1D;
    TextView S1E;
    TextView S1F;

    int S1Produce = 0;
    int S1Dairy = 0;
    int S1Dry = 0;
    int S1Frozen = 0;

    int S1Registers = 0;
    int s1Total = 0;

    ImageButton S1M1;
    ImageButton S1P1;
    ImageButton S1M2;
    ImageButton S1P2;
    ImageButton S1M3;
    ImageButton S1P3;
    ImageButton S1M4;
    ImageButton S1P4;

    ImageButton S1M5;
    ImageButton S1P5;


    //shift 2
    TextView S2A;
    TextView S2B;
    TextView S2C;
    TextView S2D;
    TextView S2E;
    TextView S2F;


    int S2Produce = 0;
    int S2Dairy = 0;
    int S2Dry = 0;
    int S2Frozen = 0;

    int S2Registers = 0;
    int s2Total = 0;

    ImageButton S2M1;
    ImageButton S2P1;
    ImageButton S2M2;
    ImageButton S2P2;
    ImageButton S2M3;
    ImageButton S2P3;
    ImageButton S2M4;
    ImageButton S2P4;
    ImageButton S2M5;
    ImageButton S2P5;


    //shift 3

    TextView S3A;
    TextView S3B;
    TextView S3C;
    TextView S3D;
    TextView S3E;
    TextView S3F;

    int S3Produce = 0;
    int S3Dairy = 0;
    int S3Dry = 0;
    int S3Frozen = 0;

    int S3Registers = 0;
    int s3Total = 0;

    float[] S1 = {0, 0, 0, 0, 0, 0};
    float[] S2 = {0, 0, 0, 0, 0, 0};
    float[] S3 = {0, 0, 0, 0, 0, 0};

    float[] quantities = {0, 0, 0, 0, 0, 0, 0, 0};
    float[] shipping = {0, 0, 0, 0, 0, 0, 0, 0};

    ImageButton S3M1;
    ImageButton S3P1;
    ImageButton S3M2;
    ImageButton S3P2;
    ImageButton S3M3;
    ImageButton S3P3;
    ImageButton S3M4;
    ImageButton S3P4;
    ImageButton S3M5;
    ImageButton S3P5;


    Button btnFinal;
    ArrayList departments, employees, items;
    Store day;
    int minteger1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_inputs);
        setupView();

        btnFinal = (Button) findViewById(R.id.btnFinal);

        Bundle b = this.getIntent().getExtras();
        if (b == null) ;
        {
            // Toast.makeText(getApplicationContext(), "Store Object Error", Toast.LENGTH_SHORT).show();
            //this means we are on the first day


        }

        if (b != null) {
            day = b.getParcelable("DayObj");
            //Toast.makeText(getApplicationContext(),"B is not NULL", Toast.LENGTH_SHORT).show();
        }


        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setArrays();

                Store passDay = day;
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("DayObj", day);
                b.putFloatArray("S1", S1);
                b.putFloatArray("S2", S2);
                b.putFloatArray("S3", S3);
                b.putFloatArray("quant", quantities);
                b.putFloatArray("ship", shipping);
                i.putExtras(b);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setClass(getApplicationContext(), DailyReport.class);
                startActivity(i);

            }
        });
    }

    private void setArrays() {
        S1[0] = s1Total;
        S1[1] = S1Produce;
        S1[2] = S1Dairy;
        S1[3] = S1Dry;
        S1[4] = S1Frozen;
        S1[5] = S1Registers;

        S2[0] = s2Total;
        S2[1] = S2Produce;
        S2[2] = S2Dairy;
        S2[3] = S2Dry;
        S2[4] = S2Frozen;
        S2[5] = S2Registers;


        S3[0] = s3Total;
        S3[1] = S3Produce;
        S3[2] = S3Dairy;
        S3[3] = S3Dry;
        S3[4] = S3Frozen;
        S3[5] = S3Registers;

        int a = 0;
        if (et1.getText().toString().length() > 0)
            quantities[0] = a + Integer.parseInt(et1.getText().toString());
        if (et2.getText().toString().length() > 0)
            quantities[1] = a + Integer.parseInt(et2.getText().toString());
        if (et3.getText().toString().length() > 0)
            quantities[2] = a + Integer.parseInt(et3.getText().toString());
        if (et4.getText().toString().length() > 0)
            quantities[3] = a + Integer.parseInt(et4.getText().toString());
        if (et5.getText().toString().length() > 0)
            quantities[4] = a + Integer.parseInt(et5.getText().toString());
        if (et6.getText().toString().length() > 0)
            quantities[5] = a + Integer.parseInt(et6.getText().toString());
        if (et7.getText().toString().length() > 0)
            quantities[6] = a + Integer.parseInt(et7.getText().toString());
        if (et8.getText().toString().length() > 0)
            quantities[7] = a + Integer.parseInt(et8.getText().toString());

        if (ch1.isChecked())
            shipping[0] = 1;

        if (ch2.isChecked())
            shipping[1] = 1;
        if (ch3.isChecked())
            shipping[2] = 1;
        if (ch4.isChecked())
            shipping[3] = 1;
        if (ch5.isChecked())
            shipping[4] = 1;
        if (ch6.isChecked())
            shipping[5] = 1;
        if (ch7.isChecked())
            shipping[6] = 1;
        if (ch8.isChecked())
            shipping[7] = 1;
        // Toast.makeText(getApplicationContext(), "quantities" + quantities[7], Toast.LENGTH_SHORT).show();
        //   shipping =


    }

    private void setupView() {

        S1M1 = findViewById(R.id.S1M1);
        S1M1.setOnClickListener(this);
        S1P1 = findViewById(R.id.S1P1);
        S1P1.setOnClickListener(this);
        S1M2 = findViewById(R.id.s1M);
        S1M2.setOnClickListener(this);
        S1P2 = findViewById(R.id.s1P);
        S1P2.setOnClickListener(this);
        S1M3 = findViewById(R.id.s1M2);
        S1M3.setOnClickListener(this);
        S1P3 = findViewById(R.id.s1P2);
        S1P3.setOnClickListener(this);
        S1M4 = findViewById(R.id.s1M3);
        S1M4.setOnClickListener(this);
        S1P4 = findViewById(R.id.s1P3);
        S1P4.setOnClickListener(this);

        S1M5 = findViewById(R.id.s1M4);
        S1M5.setOnClickListener(this);
        S1P5 = findViewById(R.id.s1P5);
        S1P5.setOnClickListener(this);


        S1A = findViewById(R.id.s1N2);
        S1B = findViewById(R.id.S1N1);
        S1C = findViewById(R.id.s1N3);
        S1D = findViewById(R.id.s1N4);
        S1E = findViewById(R.id.s1N5);
        S1F = findViewById(R.id.s1N6);


        S2M1 = findViewById(R.id.S2M1);
        S2M1.setOnClickListener(this);
        S2P1 = findViewById(R.id.S2P1);
        S2P1.setOnClickListener(this);
        S2M2 = findViewById(R.id.s2M);
        S2M2.setOnClickListener(this);
        S2P2 = findViewById(R.id.s2P);
        S2P2.setOnClickListener(this);
        S2M3 = findViewById(R.id.s2M2);
        S2M3.setOnClickListener(this);
        S2P3 = findViewById(R.id.s2P2);
        S2P3.setOnClickListener(this);
        S2M4 = findViewById(R.id.s2M3);
        S2M4.setOnClickListener(this);
        S2P4 = findViewById(R.id.s2P3);
        S2P4.setOnClickListener(this);

        S2M5 = findViewById(R.id.s2M4);
        S2M5.setOnClickListener(this);
        S2P5 = findViewById(R.id.s2P5);
        S2P5.setOnClickListener(this);

        S2A = findViewById(R.id.s2N2);
        S2B = findViewById(R.id.S2N1);
        S2C = findViewById(R.id.s2N3);
        S2D = findViewById(R.id.s2N4);
        S2E = findViewById(R.id.s2N5);
        S2F = findViewById(R.id.s2N);


        S3M1 = findViewById(R.id.S3M1);
        S3M1.setOnClickListener(this);
        S3P1 = findViewById(R.id.S3P1);
        S3P1.setOnClickListener(this);
        S3M2 = findViewById(R.id.s3M);
        S3M2.setOnClickListener(this);
        S3P2 = findViewById(R.id.s3P);
        S3P2.setOnClickListener(this);
        S3M3 = findViewById(R.id.s3M2);
        S3M3.setOnClickListener(this);
        S3P3 = findViewById(R.id.s3P2);
        S3P3.setOnClickListener(this);
        S3M4 = findViewById(R.id.s3M3);
        S3M4.setOnClickListener(this);
        S3P4 = findViewById(R.id.s3P3);
        S3P4.setOnClickListener(this);

        S3M5 = findViewById(R.id.s3M4);
        S3M5.setOnClickListener(this);
        S3P5 = findViewById(R.id.s3P4);
        S3P5.setOnClickListener(this);

        S3A = findViewById(R.id.s3N2);
        S3B = findViewById(R.id.S3N1);
        S3C = findViewById(R.id.s3N3);
        S3D = findViewById(R.id.s3N4);
        S3E = findViewById(R.id.s3N5);
        S3F = findViewById(R.id.s3N);


        et1 = findViewById(R.id.etApples);
        et2 = findViewById(R.id.etBananas);
        et3 = findViewById(R.id.etEggs);
        et4 = findViewById(R.id.etMilk);
        et5 = findViewById(R.id.etCereal);
        et6 = findViewById(R.id.etCookies);
        et7 = findViewById(R.id.etPizza);
        et8 = findViewById(R.id.etDessert);

        ch1 = findViewById(R.id.checkBox1);
        ch2 = findViewById(R.id.checkBox2);
        ch3 = findViewById(R.id.checkBox3);
        ch4 = findViewById(R.id.checkBox4);
        ch5 = findViewById(R.id.checkBox5);
        ch6 = findViewById(R.id.checkBox6);
        ch7 = findViewById(R.id.checkBox7);
        ch8 = findViewById(R.id.checkBox8);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.S1M1:
                if (S1Produce != 0) {
                    S1Produce -= 1;
                    s1Total -= 1;
                    S1A.setText("" + S1Produce);
                    S1E.setText("" + s1Total);
                }
                break;
            case R.id.S1P1:
                if (s1Total < 10) {
                    S1Produce += 1;
                    s1Total += 1;
                    S1A.setText("" + S1Produce);
                    S1E.setText("" + s1Total);

                }
                break;
            case R.id.s1M:
                if (S1Dairy != 0) {
                    S1Dairy -= 1;
                    s1Total -= 1;
                    S1B.setText("" + S1Dairy);
                    S1E.setText("" + s1Total);
                }
                break;
            case R.id.s1P:
                if (s1Total < 10) {
                    S1Dairy += 1;
                    s1Total += 1;
                    S1B.setText("" + S1Dairy);
                    S1E.setText("" + s1Total);
                }
                break;
            case R.id.s1M2:
                if (S1Dry != 0) {
                    S1Dry -= 1;
                    s1Total -= 1;
                    S1C.setText("" + S1Dry);
                    S1E.setText("" + s1Total);
                }
                break;
            case R.id.s1P2:
                if (s1Total < 10) {
                    S1Dry += 1;
                    s1Total += 1;
                    S1C.setText("" + S1Dry);
                    S1E.setText("" + s1Total);
                }
                break;
            case R.id.s1M4:
                if (S1Frozen != 0) {
                    S1Frozen -= 1;
                    s1Total -= 1;
                    S1F.setText("" + S1Frozen);
                    S1E.setText("" + s1Total);
                }
                break;
            case R.id.s1P5:
                if (s1Total < 10) {
                    S1Frozen += 1;
                    s1Total += 1;
                    S1F.setText("" + S1Frozen);
                    S1E.setText("" + s1Total);
                }
                break;

            case R.id.s1M3:
                if (S1Registers != 0) {
                    S1Registers -= 1;
                    s1Total -= 1;
                    S1D.setText("" + S1Registers);
                    S1E.setText("" + s1Total);
                }
                break;
            case R.id.s1P3:
                if ((s1Total < 10) && (S1Registers < 3)) {
                    S1Registers += 1;
                    s1Total += 1;
                    S1D.setText("" + S1Registers);
                    S1E.setText("" + s1Total);

                }

            case R.id.S2M1:
                if (S2Produce != 0) {
                    S2Produce -= 1;
                    s2Total -= 1;
                    S2A.setText("" + S2Produce);
                    S2E.setText("" + s2Total);
                }
                break;
            case R.id.S2P1:
                if (s2Total < 10) {
                    S2Produce += 1;
                    s2Total += 1;
                    S2A.setText("" + S2Produce);
                    S2E.setText("" + s2Total);

                }
                break;
            case R.id.s2M:
                if (S2Dairy != 0) {
                    S2Dairy -= 1;
                    s2Total -= 1;
                    S2B.setText("" + S2Dairy);
                    S2E.setText("" + s2Total);
                }
                break;
            case R.id.s2P:
                if (s2Total < 10) {
                    S2Dairy += 1;
                    s2Total += 1;
                    S2B.setText("" + S2Dairy);
                    S2E.setText("" + s2Total);
                }
                break;

            case R.id.s2M2:
                if (S2Dry != 0) {
                    S2Dry -= 1;
                    s2Total -= 1;
                    S2C.setText("" + S2Dry);
                    S2E.setText("" + s2Total);
                }
                break;
            case R.id.s2P2:
                if (s2Total < 10) {
                    S2Dry += 1;
                    s2Total += 1;
                    S2C.setText("" + S2Dry);
                    S2E.setText("" + s2Total);
                }
                break;
            case R.id.s2M4:
                if (S2Frozen != 0) {
                    S2Frozen -= 1;
                    s2Total -= 1;
                    S2F.setText("" + S2Frozen);
                    S2E.setText("" + s2Total);
                }
                break;
            case R.id.s2P5:
                if (s1Total < 10) {
                    S2Frozen += 1;
                    s2Total += 1;
                    S2F.setText("" + S2Frozen);
                    S2E.setText("" + s2Total);
                }
                break;
            case R.id.s2M3:
                if (S2Registers != 0) {
                    S2Registers -= 1;
                    s2Total -= 1;
                    S2D.setText("" + S2Registers);
                    S2E.setText("" + s2Total);
                }
                break;
            case R.id.s2P3:
                if ((s2Total < 10) && (S2Registers < 3)) {
                    S2Registers += 1;
                    s2Total += 1;
                    S2D.setText("" + S2Registers);
                    S2E.setText("" + s2Total);

                }
                break;

            case R.id.S3M1:
                if (S3Produce != 0) {
                    S3Produce -= 1;
                    s3Total -= 1;
                    S3A.setText("" + S3Produce);
                    S3E.setText("" + s3Total);
                }
                break;
            case R.id.S3P1:
                if (s3Total < 10) {
                    S3Produce += 1;
                    s3Total += 1;
                    S3A.setText("" + S3Produce);
                    S3E.setText("" + s3Total);

                }
                break;
            case R.id.s3M:
                if (S3Dairy != 0) {
                    S3Dairy -= 1;
                    s3Total -= 1;
                    S3B.setText("" + S3Dairy);
                    S3E.setText("" + s3Total);
                }
                break;
            case R.id.s3P:
                if (s3Total < 10) {
                    S3Dairy += 1;
                    s3Total += 1;
                    S3B.setText("" + S3Dairy);
                    S3E.setText("" + s3Total);
                }
                break;
            case R.id.s3M2:
                if (S3Dry != 0) {
                    S3Dry -= 1;
                    s3Total -= 1;
                    S3C.setText("" + S3Dry);
                    S3E.setText("" + s3Total);
                }
                break;
            case R.id.s3P2:
                if (s3Total < 10) {
                    S3Dry += 1;
                    s3Total += 1;
                    S3C.setText("" + S3Dry);
                    S3E.setText("" + s3Total);
                }
                break;
            case R.id.s3M4:
                if (S3Frozen != 0) {
                    S3Frozen -= 1;
                    s3Total -= 1;
                    S3F.setText("" + S3Frozen);
                    S3E.setText("" + s3Total);
                }
                break;
            case R.id.s3P4:
                if (s3Total < 10) {
                    S3Frozen += 1;
                    s3Total += 1;
                    S3F.setText("" + S3Frozen);
                    S3E.setText("" + s3Total);
                }
                break;

            case R.id.s3M3:
                if (S3Registers != 0) {
                    S3Registers -= 1;
                    s3Total -= 1;
                    S3D.setText("" + S3Registers);
                    S3E.setText("" + s3Total);
                }
                break;
            case R.id.s3P3:
                if ((s3Total < 10) && (S3Registers < 3)) {
                    S3Registers += 1;
                    s3Total += 1;
                    S3D.setText("" + S3Registers);
                    S3E.setText("" + s3Total);

                }


            default:
                break;

        }

        if (s1Total == 10)
            S1E.setTextColor(getResources().getColor(R.color.redA));
        if (s2Total == 10)
            S2E.setTextColor(getResources().getColor(R.color.redA));
        if (s3Total == 10)
            S3E.setTextColor(getResources().getColor(R.color.redA));


        if (s1Total < 10)
            S1E.setTextColor(getResources().getColor(R.color.secondary));
        if (s2Total < 10)
            S2E.setTextColor(getResources().getColor(R.color.secondary));
        if (s3Total < 10)
            S3E.setTextColor(getResources().getColor(R.color.secondary));


        if (S1Registers == 3) S1D.setTextColor(getResources().getColor(R.color.redA));
        if (S1Registers < 3) S1D.setTextColor(getResources().getColor(R.color.secondary));

        if (S2Registers == 3) S2D.setTextColor(getResources().getColor(R.color.redA));
        if (S2Registers < 3) S2D.setTextColor(getResources().getColor(R.color.secondary));

        if (S3Registers == 3) S3D.setTextColor(getResources().getColor(R.color.redA));
        if (S3Registers < 3) S3D.setTextColor(getResources().getColor(R.color.secondary));


    }
}
