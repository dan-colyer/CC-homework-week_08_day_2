package com.codeclan.example.wordcounter.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.codeclan.example.wordcounter.R;

public class WordCounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_counter);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        String wordCount = extras.getString("count");

        TextView wordCountTextView = findViewById(R.id.text_result);

        wordCountTextView.setText(wordCount);
    }
}