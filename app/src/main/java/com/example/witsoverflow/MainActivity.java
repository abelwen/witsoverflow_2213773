package com.example.witsoverflow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button Sign_in;
    Button Sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sign_in = findViewById(R.id.signin);
        Sign_up = findViewById(R.id.signup);
        Sign_in.setOnClickListener(view -> Login());
        Sign_up.setOnClickListener(view -> Register());
    }
    public void Login(){
        Toast.makeText(getApplicationContext(),
                "Redirecting...",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);

    }
    public void Register(){
        Toast.makeText(getApplicationContext(),
                "Redirecting...",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SignUp.class);
        
        startActivity(intent);
    }
}
