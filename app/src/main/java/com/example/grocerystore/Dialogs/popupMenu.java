package com.example.grocerystore.Dialogs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.grocerystore.R;

public class popupMenu extends Activity {

   RecyclerView foodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

       // foodList= findViewById(R.id.list);

    }
}
