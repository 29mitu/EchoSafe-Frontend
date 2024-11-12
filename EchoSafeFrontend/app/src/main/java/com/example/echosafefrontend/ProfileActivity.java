package com.example.echosafefrontend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int CAMERA_REQUEST = 2;

    private ImageView profileImage, editName, editMobile, editEmail, editAge, editOccupation, editLocation;
    private TextView nameText, mobileText, emailText, ageText, occupationText, locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        profileImage = findViewById(R.id.profile_image);
        editName = findViewById(R.id.edit_name);
        editMobile = findViewById(R.id.edit_mobile);
        editEmail = findViewById(R.id.edit_email);
        editAge = findViewById(R.id.edit_age);
        editOccupation = findViewById(R.id.edit_occupation);
        editLocation = findViewById(R.id.edit_location);

        // Initialize TextViews to update their values
        nameText = findViewById(R.id.name_text);
        mobileText = findViewById(R.id.mobile_text);
        emailText = findViewById(R.id.email_text);
        ageText = findViewById(R.id.age_text);
        occupationText = findViewById(R.id.occupation_text);
        locationText = findViewById(R.id.location_text);

        // Click listener for profile image update
        profileImage.setOnClickListener(v -> showImagePickerDialog());

        // Click listeners for edit icons
        editName.setOnClickListener(v -> showEditDialog("Name", nameText));
        editMobile.setOnClickListener(v -> showEditDialog("Mobile Number", mobileText));
        editEmail.setOnClickListener(v -> showEditDialog("Email Address", emailText));
        editAge.setOnClickListener(v -> showEditDialog("Age", ageText));
        editOccupation.setOnClickListener(v -> showEditDialog("Occupation", occupationText));
        editLocation.setOnClickListener(v -> showEditDialog("Location", locationText));
    }

    // Method to show edit dialog and update the TextView
    private void showEditDialog(String field, TextView textViewToUpdate) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit " + field);

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Save", (dialog, which) -> {
            String newValue = input.getText().toString();
            if (!newValue.isEmpty()) {
                textViewToUpdate.setText(newValue);
                Toast.makeText(ProfileActivity.this, field + " updated to: " + newValue, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ProfileActivity.this, "Please enter a valid " + field, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    // Method to show a dialog for choosing image source (Gallery or Camera)
    private void showImagePickerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Profile Picture Source");
        builder.setItems(new CharSequence[]{"Gallery", "Camera", "Cancel"}, (dialog, which) -> {
            switch (which) {
                case 0: // Gallery
                    openGallery();
                    break;
                case 1: // Camera
                    openCamera();
                    break;
                case 2: // Cancel
                    dialog.dismiss();
                    break;
            }
        });
        builder.show();
    }

    // Method to open the gallery
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    // Method to open the camera
    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    // Handle the result of image picking or camera capturing
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PICK_IMAGE_REQUEST && data != null && data.getData() != null) {
                Uri selectedImageUri = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                    profileImage.setImageBitmap(bitmap); // Update the profile image
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (requestCode == CAMERA_REQUEST && data != null && data.getExtras() != null) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                profileImage.setImageBitmap(photo); // Update the profile image
            }
        }
    }
}
