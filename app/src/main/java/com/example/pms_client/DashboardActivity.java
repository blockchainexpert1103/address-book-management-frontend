package com.example.pms_client;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set up adapter with dummy data
        ContactAdapter adapter = new ContactAdapter(getDummyContacts());
        recyclerView.setAdapter(adapter);
    }

    // Dummy contacts data
    private List<Contact> getDummyContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("田崎 幸治", "090-4275-0207", R.drawable.ic_contact_phone)); // Use your own drawable
        contacts.add(new Contact("谷口 日野自動車", "0761-55-3488", R.drawable.ic_contact_work));
        return contacts;
    }
}
