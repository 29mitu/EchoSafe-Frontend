package com.example.echosafefrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainFeaturesActivity extends AppCompatActivity {

    private CardView buttonSiren, buttonSOS, buttonViewContacts, buttonRecordAudio;
    private CardView buttonSelfDefence, buttonHelpLines, buttonFakeCall;
    private ImageView profileIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfeatures);

        // Initialize the CardView buttons
        buttonSiren = findViewById(R.id.button_siren);
        buttonSOS = findViewById(R.id.button_sos);
        buttonViewContacts = findViewById(R.id.button_view_contacts);
        buttonRecordAudio = findViewById(R.id.button_record_audio);
        buttonSelfDefence = findViewById(R.id.button_self_defence);
        buttonHelpLines = findViewById(R.id.button_help_lines);
        buttonFakeCall = findViewById(R.id.button_fake_call);

        // Initialize the profile icon
        profileIcon = findViewById(R.id.profile_icon);

        // Set click listener for the profile icon
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to ProfileActivity
                Intent intent = new Intent(MainFeaturesActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        // Set click listeners for each button
        buttonSiren.setOnClickListener(v -> Toast.makeText(MainFeaturesActivity.this, "Siren Activated", Toast.LENGTH_SHORT).show());

        buttonSOS.setOnClickListener(v -> Toast.makeText(MainFeaturesActivity.this, "SOS Activated", Toast.LENGTH_SHORT).show());

        buttonViewContacts.setOnClickListener(v -> {
            Intent intent = new Intent(MainFeaturesActivity.this, Contacts.class);
            startActivity(intent);
        });

        buttonRecordAudio.setOnClickListener(v -> {
            Intent intent = new Intent(MainFeaturesActivity.this, RecordAudioActivity.class);
            startActivity(intent);
        });

        buttonSelfDefence.setOnClickListener(v -> Toast.makeText(MainFeaturesActivity.this, "Self Defence Mode", Toast.LENGTH_SHORT).show());

        buttonHelpLines.setOnClickListener(v -> {
            Intent intent = new Intent(MainFeaturesActivity.this, HelpLinesActivity.class);
            startActivity(intent);
        });

        buttonFakeCall.setOnClickListener(v -> Toast.makeText(MainFeaturesActivity.this, "Fake Call Activated", Toast.LENGTH_SHORT).show());
    }
}
