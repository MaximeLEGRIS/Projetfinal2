package com.vogella.projetfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {


    public TextView txtHeader2;
    public TextView txtFooter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtHeader2 = findViewById(R.id.name);
        txtFooter2 = findViewById(R.id.URL);

        Intent intent = getIntent();

        String url = intent.getStringExtra("URL");
        String name = intent.getStringExtra("nom");

        txtHeader2.setText(name);
        txtFooter2.setText(url);


    }
}
