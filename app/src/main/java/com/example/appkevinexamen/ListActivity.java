package com.example.appkevinexamen;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private
    ListView futbolistasListView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        futbolistasListView = findViewById(R.id.futbolistasListView);
        databaseHelper = new DatabaseHelper(this);

        List<Futbolista> futbolistas = databaseHelper.getAllFutbolistas();

        ArrayAdapter<Futbolista> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, futbolistas);
        futbolistasListView.setAdapter(adapter);
    }
}


