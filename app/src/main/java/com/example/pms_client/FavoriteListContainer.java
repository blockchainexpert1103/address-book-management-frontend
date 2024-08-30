package com.example.pms_client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FavoriteListContainer extends AppCompatActivity {

    ListView favoriteContainer;

//    boolean isFavoriteView = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_container);

        TextView addContactTextView = findViewById(R.id.favorite_add);
        addContactTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FavoriteListContainer.this, FavoriteAdd.class);
                startActivity(intent);
            }
        });

        favoriteContainer = (ListView) findViewById(R.id.container_favorite_list);
        FavoriteListItem[] favoriteItems = new FavoriteListItem[] {
                new FavoriteListItem("田崎 幸治", "0761-55-3487", "090-4275-0206", R.drawable.avatar_background),
                new FavoriteListItem("谷口 日野自動車", "", "090-4275-0203", R.drawable.avatar_background),
        };

        FavoriteAdapter adapter = new FavoriteAdapter(this, R.layout.favorite_list_item, favoriteItems);
        favoriteContainer.setAdapter(adapter);
    }

}
