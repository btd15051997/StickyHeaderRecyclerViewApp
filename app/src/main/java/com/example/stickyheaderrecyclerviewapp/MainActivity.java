package com.example.stickyheaderrecyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_person);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,layoutManager.getOrientation()));

        createPersonList();
        PersonAdapter adapter = new PersonAdapter(this, people);
        recyclerView.setAdapter(adapter);
    }

    //Becausse in PersonAdapter

    private void createPersonList() {
        people = Common.genPeopleGroup();
        people = Common.sortList(people); // Sort
        people = Common.addAlphabets(people); // Add alphabet header
    }
}