package com.example.grocerystore.HelperClasses;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GlobalClass extends Application{


    private ArrayList<String> globalLogHist;


    public ArrayList<String> getGlobalArrayList() {
        return globalLogHist;
    }

    public void setGlobalArrayList(ArrayList<String> globalArrayList) {
        this.globalLogHist = globalArrayList;
    }
}
