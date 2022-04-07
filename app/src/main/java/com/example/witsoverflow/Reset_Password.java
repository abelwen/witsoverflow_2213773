package com.example.witsoverflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reset_Password extends AppCompatActivity {
    EditText password,email;
    EditText re_password;
    Button reset_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        email = findViewById(R.id.rp_email);
        password = findViewById(R.id.rp_password);
        re_password = findViewById(R.id.rp_New_password);
        reset_password = findViewById(R.id.rp_Reset);
        reset_password.setOnClickListener(View -> CheckUserData());
    }
    public void CheckUserData(){
        boolean isValid = true;
        if (password.getText().toString().equals(re_password.getText().toString())) {
            password.setError("Password and Re-enter Password must match!");
            isValid = false;
        }
        if(isValid && CheckDataEntered()){
            Toast.makeText(getApplicationContext(),
                    "Redirecting...",Toast.LENGTH_SHORT).show();
            Intent switchActivityIntent = new Intent(Reset_Password.this,SignIn.class);
            startActivity(switchActivityIntent);
        }
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean CheckDataEntered() {
        if (isEmpty(password)) {
            password.setError("Password is required!");
            return false;
        }
        else if (isEmpty(re_password)) {
            re_password.setError("Re-enter is required!");
            return false;
        }
        else if (!isEmail(email)) {
            email.setError("Enter valid email!");
            return false;
        }
        else if (password.getText().toString().length()<4 || re_password.getText().toString().length()<4) {
            password.setError("Password must be at least 4 chars long!");
            return false;
        }
        else{
            return true;
        }
    }

}