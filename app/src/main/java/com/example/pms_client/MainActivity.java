package com.example.pms_client;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.TextView;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton radio1, radio2;
    Button positiveButton;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button defaultButton = findViewById(R.id.defaultButton);

        defaultButton.setOnClickListener(v -> {
            showSetDefaultDialog();
        });
    }

    private void showSetDefaultDialog() {
        // Inflate the custom dialog layout
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.dialog_set_default, null);

        // Set up the RadioButtons
        radio1 = dialogView.findViewById(R.id.radio1);
        radio2 = dialogView.findViewById(R.id.radio2);
        text2 = dialogView.findViewById(R.id.text2);

        // Initially hide text2
        text2.setVisibility(View.GONE);

        // Set radio2 as the default selection
        radio2.setChecked(true);

        // Create and display an AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCustomTitle(dialogView);

        // Set up the dialog with a positive and negative button
        builder.setPositiveButton("デフォルトに設定", null);
        builder.setNegativeButton("キャンセル", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();

        // Reference to the positive button
        positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

        // Initially disable the positive button and set its text color to gray
        positiveButton.setEnabled(false);
        positiveButton.setTextColor(Color.GRAY);

        // Handle RadioButton clicks manually to ensure single selection
        radio1.setOnClickListener(v -> {
            radio1.setChecked(true);
            radio2.setChecked(false);
            positiveButton.setEnabled(true);  // Enable the positive button
            positiveButton.setTextColor(Color.rgb(72,37,138));  // Change the text color to blue

            // Show text2 when radio1 is selected
            text2.setVisibility(View.VISIBLE);
        });

        radio2.setOnClickListener(v -> {
            radio1.setChecked(false);
            radio2.setChecked(true);
            positiveButton.setEnabled(false);  // Disable the positive button
            positiveButton.setTextColor(Color.GRAY);  // Change the text color back to gray

            text2.setVisibility(View.GONE);
        });

        // Set an onClickListener for the positive button after it is shown
        positiveButton.setOnClickListener(v -> {
            if (radio1.isChecked()) {
                Toast.makeText(MainActivity.this, "電話 現在のデフォルトが選択されました", Toast.LENGTH_SHORT).show();
            } else if (radio2.isChecked()) {
                Toast.makeText(MainActivity.this, "電話が選択されました", Toast.LENGTH_SHORT).show();
            }

            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            startActivity(intent);

            dialog.dismiss();  // Close the dialog after the positive action
        });
    }
}
