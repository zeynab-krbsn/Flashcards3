package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        TextView textViewHeader=findViewById(R.id.TextViewHeader);
        TextView textViewDescription=findViewById(R.id.TextViewDescription);

        String D = new String() ;
        String  H = new String() ;
        //


        Bundle bundle=getIntent().getExtras();
        if(bundle != null){
            H=bundle.getString("Header");
            D = bundle.getString("Description");
        }
        textViewHeader.setText(H);
        textViewDescription.setText(D);
    }
}