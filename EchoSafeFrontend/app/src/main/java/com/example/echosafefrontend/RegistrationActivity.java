package com.example.echosafefrontend; // Removed the extra period at the end

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    // Declare UI elements
    private EditText nameInput, addressInput, occupationInput, phoneNumberInput;
    private Button continueButton;
    private TextView alreadyHaveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration); // Ensure this matches your layout file name

        // Initialize UI elements
        nameInput = findViewById(R.id.name_input);
        addressInput = findViewById(R.id.address_input);
        occupationInput = findViewById(R.id.occupation_input);
        phoneNumberInput = findViewById(R.id.phone_number_input);
        continueButton = findViewById(R.id.continue_button);
        alreadyHaveAccount = findViewById(R.id.already_have_account); // Ensure this ID matches

        // Set click listener for the Continue button (Placeholder for future logic)
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder for future logic (e.g., form submission)
            }
        });

        // Set click listener for the already have an account prompt
        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Login Activity
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
