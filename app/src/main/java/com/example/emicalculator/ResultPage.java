package com.example.emicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
//additional imports
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultPage extends AppCompatActivity {

    //Declare variable for
    private TextView EMIresult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_page);

        //Assign layout element ID to result variable
        EMIresult = findViewById(R.id.EMIresult);

        //Getting EMI value from the intent in HomePage activity and displaying output
        double EMIfinal = getIntent().getDoubleExtra("Your EMI:", 0);
        EMIresult.setText("Your EMI: " + String.format("%.2f", EMIfinal));
    }
    //Code for navigation
    public void ReturnButton(View v)
    {
        Intent i = new Intent (this, HomePage.class);
        startActivity(i);
    }
}