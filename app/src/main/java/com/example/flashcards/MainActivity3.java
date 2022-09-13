package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private ArrayList<Flashcards> flashcardsArrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView=findViewById(R.id.recyclerview);
        flashcardsArrayList=new ArrayList<>();

        setFlashcardsInfo();
        setAdapter();
    }

    private void setAdapter() {
        RecyclerAdapter adapter=new RecyclerAdapter(flashcardsArrayList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setFlashcardsInfo() {
        flashcardsArrayList.add(new Flashcards("شبکه"));
        flashcardsArrayList.add(new Flashcards("پایگاه"));
        flashcardsArrayList.add(new Flashcards("نود"));
    }
}