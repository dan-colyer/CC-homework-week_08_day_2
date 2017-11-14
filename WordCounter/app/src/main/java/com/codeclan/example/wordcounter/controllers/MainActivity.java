package com.codeclan.example.wordcounter.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codeclan.example.wordcounter.R;
import com.codeclan.example.wordcounter.WordCounter;
import com.codeclan.example.wordcounter.WordCounterExtended;

/**
 * Created by sandy on 26/10/2016.
 */
public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button buttonWordCount;
    Button buttonConcordance;
    WordCounter wordCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.text_to_scan);
        buttonWordCount = (Button)findViewById(R.id.button_scan);
        buttonConcordance = (Button)findViewById(R.id.button_concordance);
        textView = (TextView)findViewById(R.id.text_result);

        wordCounter = new WordCounter();
    }

    public void onWordCountButtonClick(View view) {
        String textToScan = editText.getText().toString();
        Log.d("WordCounter", "Counting words in : '" + textToScan + "'");

        int numberOfWords = WordCounter.getCount(textToScan);

        Intent intent = new Intent(this, WordCounterActivity.class);

        int newCount = WordCounter.getCount(textToScan);

        intent.putExtra("count", Integer.toString(newCount));

        startActivity(intent);
    }


    public void onConcordanceButtonClick(View view) {
        String textToScan = editText.getText().toString();
        Log.d("WordCounter", "Creating concordance for : '" + textToScan + "'");

        WordCounterExtended wordCounter = new WordCounterExtended(textToScan);
        textView.setText(wordCounter.toString());
    }

}
