package com.example.emicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Extra Imports
import android.widget.Button;
import android.widget.EditText;


public class HomePage extends AppCompatActivity {

    // Declaring inputs from the layout fields
    private EditText LoanAmountInput;
    private EditText AnnualInterestInput;
    private EditText LoanTenureYearsInput;
    private Button CalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        // Assign layout IDs to variables
        LoanAmountInput = findViewById(R.id.LoanAmountInput);
        AnnualInterestInput = findViewById(R.id.AnnualInterestInput);
        LoanTenureYearsInput = findViewById(R.id.LoanTenureYearsInput);
        CalculateButton = findViewById(R.id.CalculateButton);

        // Set OnClickListener for the Calculate button
        CalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input values from the EditText fields
                double LoanAmount = Double.parseDouble(LoanAmountInput.getText().toString());
                double AnnualInterestRate = Double.parseDouble(AnnualInterestInput.getText().toString());
                int TenureYears = Integer.parseInt(LoanTenureYearsInput.getText().toString());

                // Call the result of the EMIcalculation function
                double EMI = EMIcalculation(LoanAmount, AnnualInterestRate, TenureYears);

                // Create an Intent to send the EMI to ResultPage and navigate to it upon click
                Intent i = new Intent(HomePage.this, ResultPage.class);
                i.putExtra("Your EMI:", EMI);
                startActivity(i);
            }
        });
    }

    // EMI calculation function here
    private double EMIcalculation(double LoanAmount, double AnnualInterestRate, int TenureYears)
    {
        //Convert yearly inputs to monthly inputs
        double MonthlyInterestRate = (AnnualInterestRate / 100) / 12;
        int TenureMonths = TenureYears * 12;

        return (LoanAmount * MonthlyInterestRate * Math.pow(1 + MonthlyInterestRate, TenureMonths)) /
                (Math.pow(1 + MonthlyInterestRate, TenureMonths) - 1);
    }
}