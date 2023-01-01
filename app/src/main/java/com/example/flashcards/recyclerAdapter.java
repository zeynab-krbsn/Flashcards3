package com.example.flashcards;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Flashcards> flashcardsList;
    private RecyclerViewClickListener listener;

    public recyclerAdapter(ArrayList<Flashcards> flashcardsList, RecyclerViewClickListener listener){
        this.flashcardsList=flashcardsList;
        this.listener=listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView TextViewFlashcards;

        public MyViewHolder(final View view){
            super(view);
            view.setClickable(true);
            TextViewFlashcards=view.findViewById(R.id.textView_recyclerview);
            TextViewFlashcards.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v,getAdapterPosition());
                }
            });

        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String flashcard=flashcardsList.get(position).getHeader();
        holder.TextViewFlashcards.setText(flashcard);
    }

    @Override
    public int getItemCount() {
        return flashcardsList.size();
    }

        public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }
}
