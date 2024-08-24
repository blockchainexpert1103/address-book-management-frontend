package com.example.pms_client;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Favorite extends AppCompatActivity {
    boolean isFavoriteView = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);

        TextView addContactTextView = findViewById(R.id.add_contact);
        addContactTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favorite.this, com.example.pms_client.FavoriteAdd.class);
                startActivity(intent);
            }
        });

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView_for_favorite);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set up adapter with dummy data
        ContactAdapter adapter = new ContactAdapter(getDummyContacts(), isFavoriteView);
        recyclerView.setAdapter(adapter);
    }

    // Dummy contacts data
    private List<Contact> getDummyContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("田崎 幸治", "0761-55-3487", "090-4275-0206",  R.drawable.ic_contact_default)); // Use your own drawable
        contacts.add(new Contact("谷口 日野自動車", "", "090-4275-0203",  R.drawable.ic_contact_default));

        return contacts;
    }
}
