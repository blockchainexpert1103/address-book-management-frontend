package com.example.pms_client;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.provider.OpenableColumns;

public class SMSSend extends AppCompatActivity {

    TextView textView;
    private ActivityResultLauncher<Intent> filePickerLauncher;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_send);

        // Initialize ActivityResultLauncher
        filePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri uri = result.getData().getData();
                        if (uri != null) {
                            displaySelectedFile(uri);
                        }
                    }
                }
        );

        // Retrieve the contact details passed from the ContactAdapter
        String contactName = getIntent().getStringExtra("contact_name");
        String mobilePhone = getIntent().getStringExtra("mobile_phone");

        // Set the contact details to views if needed
        // For example, set the contact name on a TextView in sms_send.xml
        TextView titleTextView = findViewById(R.id.selected_username);
        titleTextView.setText(contactName);

        // Set up the back button
        ImageView backButton = findViewById(R.id.sms_send_back);
        backButton.setOnClickListener(v -> finish());

        // Upload function
        ImageView attachFile = findViewById(R.id.attach_file);
        ImageView attachImage = findViewById(R.id.attach_image);

        attachFile.setOnClickListener(v -> openFileChooser("file/*"));
        attachImage.setOnClickListener(v -> openFileChooser("image/*"));

    }

    private void openFileChooser(String mimeType) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType(mimeType);
        filePickerLauncher.launch(intent);
    }

    private void displaySelectedFile(Uri uri) {
        // For example, if you are loading an image, use an ImageView:
        ImageView imageView = findViewById(R.id.attach_image);
        imageView.setImageURI(uri);

        // For other files, you might want to show the file name or path:
        String fileName = getFileNameFromUri(uri);
        if (textView != null) {
            textView.setText(fileName);
        }
    }

    public String getFileNameFromUri(Uri uri) {
        String displayName = null;

        if (uri != null) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                        if (nameIndex != -1) {
                            displayName = cursor.getString(nameIndex);
                        }
                    }
                } finally {
                    cursor.close();
                }
            }
        }

        return displayName;
    }
}


