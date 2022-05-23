package com.example.witsoverflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class opened_post extends AppCompatActivity {
    TextView un,pt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opened_post);
         un = findViewById(R.id.userName2);
        pt = findViewById(R.id.post2);
       

        String pos = getIntent().getStringExtra("post");
        String user = getIntent().getStringExtra("Stud_Num");
        

        pt.setText(pos);
        un.setText(user);
        
    }


}
