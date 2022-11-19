package com.dimas.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        TextView title = findViewById(R.id.tvTitile);
        TextView desk = findViewById(R.id.tvBodi);

        Intent intent = getIntent();
        if(intent != null){
            title.setText(intent.getStringExtra("tvTitle"));
            desk.setText(intent.getStringExtra("tvDesc"));
        }
    }

}