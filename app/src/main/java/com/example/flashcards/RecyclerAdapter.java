package com.example.flashcards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<Flashcards> flashcardsList;

    public RecyclerAdapter(ArrayList<Flashcards> flashcardsList){
        this.flashcardsList=flashcardsList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView TextViewFlashcards;

        public MyViewHolder(final View view){
            super(view);
            TextViewFlashcards=view.findViewById(R.id.textView_recyclerview);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String flashcard=flashcardsList.get(position).getFlashcards();
        holder.TextViewFlashcards.setText(flashcard);
    }

    @Override
    public int getItemCount() {
        return flashcardsList.size();
    }
}
