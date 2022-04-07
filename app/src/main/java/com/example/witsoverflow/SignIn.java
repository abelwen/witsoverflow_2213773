package com.example.witsoverflow;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {
    Button Sign_IN;
    EditText email;
    EditText password;
    TextView signup,reset_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        reset_password = findViewById(R.id.resetPassword);
        signup = findViewById(R.id.Text_signup);
        password = findViewById(R.id.rp_password);
        email = findViewById(R.id.rp_email);
        Sign_IN = findViewById(R.id.rp_Reset);
        reset_password.setOnClickListener(View -> Reset_password());
        Sign_IN.setOnClickListener(View -> checkUserData());
        signup.setOnClickListener(view -> Register());
    }
    public void Reset_password(){
        //Enter code for resetting password
        Intent switchActivityIntent = new Intent(SignIn.this,Reset_Password.class);
        startActivity(switchActivityIntent);
    }
    public void checkUserData(){
        boolean isValid = true;
        if(isEmpty(email)){
            email.setError("Enter your email to log in!");
            isValid = false;
        }
        else if (!isEmail(email)) {
                email.setError("Enter valid email!");
                isValid = false;
        }
        else if(isEmpty(password)){
            password.setError("Enter your password to log in!");
            isValid = false;
        }
        else if (password.getText().toString().length()<4) {
                password.setError("Password must be at least 4 chars long!");
                isValid = false;
        }
        if(isValid){
            String Email = email.getText().toString();
            String Password = password.getText().toString();
            if(Email.equals("tristan@gmail.com")&& Password.equals("9Baker")){
                Toast.makeText(getApplicationContext(),
                        "Redirecting...",Toast.LENGTH_SHORT).show();
                Intent switchActivityIntent = new Intent(getApplicationContext(),ProfileUI.class);
                startActivity(switchActivityIntent);
            }
            else {
                Toast.makeText(getApplicationContext(),
                        "Wrong password or email address",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    public void Register(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}