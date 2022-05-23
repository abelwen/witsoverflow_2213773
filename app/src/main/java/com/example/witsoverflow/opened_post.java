package com.example.witsoverflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class opened_post extends AppCompatActivity {
    TextView pt,un;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opened_post);
        pt = findViewById(R.id.post2);
        un = findViewById(R.id.userName2);

        String user = getIntent().getStringExtra("Stud_Num");
        String pos = getIntent().getStringExtra("post");

        un.setText(user);
        pt.setText(pos);
    }


}