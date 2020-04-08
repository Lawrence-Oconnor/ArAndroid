package com.example.grocerystore.Dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    //shift 1
    TextView S1A;
    TextView S1B;
    TextView S1C;
    TextView S1D;
    TextView S1E;

    int S1Produce =0;
    int S1Dry =0;
    int S1Frozen =0;
    int S1Registers =0;
    int s1Total = 0;

    ImageButton S1M1;
    ImageButton S1P1;
    ImageButton S1M2;
    ImageButton S1P2;
    ImageButton S1M3;
    ImageButton S1P3;
    ImageButton S1M4;
    ImageButton S1P4;

    //shift 2
    TextView S2A;
    TextView S2B;
    TextView S2C;
    TextView S2D;
    TextView S2E;

    int S2Produce =0;
    int S2Dry =0;
    int S2Frozen =0;
    int S2Registers =0;
    int s2Total = 0;

    ImageButton S2M1;
    ImageButton S2P1;
    ImageButton S2M2;
    ImageButton S2P2;
    ImageButton S2M3;
    ImageButton S2P3;
    ImageButton S2M4;
    ImageButton S2P4;



    //shift 3

    TextView S3A;
    TextView S3B;
    TextView S3C;
    TextView S3D;
    TextView S3E;

    int S3Produce =0;
    int S3Dry =0;
    int S3Frozen =0;
    int S3Registers =0;
    int s3Total = 0;

    ImageButton S3M1;
    ImageButton S3P1;
    ImageButton S3M2;
    ImageButton S3P2;
    ImageButton S3M3;
    ImageButton S3P3;
    ImageButton S3M4;
    ImageButton S3P4;


    Button btnFinal;
    ArrayList departments,employees,items;
    Store day;
    int minteger1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_inputs);
        setupView();

        btnFinal = (Button) findViewById(R.id.btnFinal);

        Bundle b = this.getIntent().getExtras();
        if (b == null);
        {
           // Toast.makeText(getApplicationContext(), "Store Object Error", Toast.LENGTH_SHORT).show();
            //this means we are on the first day


        }

        if (b != null)
        {
            day = b.getParcelable("DayObj");
            //Toast.makeText(getApplicationContext(),"B is not NULL", Toast.LENGTH_SHORT).show();
        }



        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Store passDay = day;
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("DayObj", day);
                i.putExtras(b);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setClass(getApplicationContext(), DailyReport.class);
                startActivity(i);

            }
        });
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


        S1A = findViewById(R.id.s1N2);
        S1B = findViewById(R.id.S1N1);
        S1C = findViewById(R.id.s1N3);
        S1D = findViewById(R.id.s1N4);
        S1E = findViewById(R.id.s1N5);



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

        S2A = findViewById(R.id.s2N2);
        S2B = findViewById(R.id.S2N1);
        S2C = findViewById(R.id.s2N3);
        S2D = findViewById(R.id.s2N4);
        S2E = findViewById(R.id.s2N5);


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

        S3A = findViewById(R.id.s3N2);
        S3B = findViewById(R.id.S3N1);
        S3C = findViewById(R.id.s3N3);
        S3D = findViewById(R.id.s3N4);
        S3E = findViewById(R.id.s3N5);
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
                if (S1Dry != 0) {
                    S1Dry -= 1;
                    s1Total -= 1;
                    S1B.setText("" + S1Dry);
                    S1E.setText("" + s1Total);
                }
                break;
            case R.id.s1P:
                if (s1Total < 10)
                {
                    S1Dry += 1;
                    s1Total += 1;
                    S1B.setText("" + S1Dry);
                    S1E.setText("" + s1Total);
                }
                break;
            case R.id.s1M2:
                if (S1Frozen != 0) {
                    S1Frozen -= 1;
                    s1Total -= 1;
                    S1C.setText("" + S1Frozen);
                    S1E.setText("" + s1Total);
                }
                break;
            case R.id.s1P2:
                if (s1Total < 10)
                {
                    S1Frozen += 1;
                    s1Total += 1;
                    S1C.setText("" + S1Frozen);
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
                if (s1Total < 10)
                {
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
                if (S2Dry != 0) {
                    S2Dry -= 1;
                    s2Total -= 1;
                    S2B.setText("" + S2Dry);
                    S2E.setText("" + s2Total);
                }
                break;
            case R.id.s2P:
                if (s2Total < 10)
                {
                    S2Dry += 1;
                    s2Total += 1;
                    S2B.setText("" + S2Dry);
                    S2E.setText("" + s2Total);
                }
                break;

            case R.id.s2M2:
                if (S2Frozen != 0) {
                    S2Frozen -= 1;
                    s2Total -= 1;
                    S2C.setText("" + S2Frozen);
                    S2E.setText("" + s2Total);
                }
                break;
            case R.id.s2P2:
                if (s2Total < 10)
                {
                    S2Frozen += 1;
                    s2Total += 1;
                    S2C.setText("" + S2Frozen);
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
                if (s2Total < 10)
                {
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
                if (S3Dry != 0) {
                    S3Dry -= 1;
                    s3Total -= 1;
                    S3B.setText("" + S3Dry);
                    S3E.setText("" + s3Total);
                }
                break;
            case R.id.s3P:
                if (s3Total < 10)
                {
                    S3Dry += 1;
                    s3Total += 1;
                    S3B.setText("" + S3Dry);
                    S3E.setText("" + s3Total);
                }
                break;
            case R.id.s3M2:
                if (S3Frozen != 0) {
                    S3Frozen -= 1;
                    s3Total -= 1;
                    S3C.setText("" + S3Frozen);
                    S3E.setText("" + s3Total);
                }
                break;
            case R.id.s3P2:
                if (s3Total < 10)
                {
                    S3Frozen += 1;
                    s3Total += 1;
                    S3C.setText("" + S3Frozen);
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
                if (s3Total < 10)
                {
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
        if (s2Total <10)
            S2E.setTextColor(getResources().getColor(R.color.secondary));
        if (s3Total < 10)
            S3E.setTextColor(getResources().getColor(R.color.secondary));

    }
}
