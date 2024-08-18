package com.example.pms_client;

import android.os.Bundle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button defaultButton = findViewById(R.id.defaultButton);

        defaultButton.setOnClickListener(v -> {
            showSetDefaultDialog();
        });
    }

    private void showSetDefaultDialog () {
        // Create and display an AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("電話 をデフォルトの電話アプリとして設定しますか?");

        // Set up the single-choice items
        

    }
}