package com.example.witsoverflow;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher; //Abelwe Code
import java.util.regex.Pattern; //Abelwe Code

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText name;
    EditText surname;
    EditText email;
    EditText address;
    EditText cell_num;
    EditText password;
    EditText re_password;
    EditText stu_num;
    //Switch Admin;
    TextView Log_In;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.Name);
        surname = findViewById(R.id.Surname);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        cell_num = findViewById(R.id.cell_num);
        password = findViewById(R.id.password);
        re_password = findViewById(R.id.password1);
        stu_num = findViewById(R.id.stud_num);
        Log_In = findViewById(R.id.R_log_in);
        register = findViewById(R.id.register1);

        Log_In.setOnClickListener(View ->signIN());
        register.setOnClickListener(View -> checkUserData());
    }
    public void checkUserData(){
        boolean isValid = true;

        //checks if the password matches the re-enter
      if (!password.getText().toString().equals(re_password.getText().toString())) {

                password.setError("Password and Re-enter Password must match!");
                isValid = false;
        }
        if(isValid && checkDataEntered()){
                Toast.makeText(getApplicationContext(),
                        "Redirecting...",Toast.LENGTH_SHORT).show();
                Intent switchActivityIntent = new Intent(SignUp.this,SignIn.class);
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

    void signIN(){
        Intent switchActivityIntent = new Intent(SignUp.this,SignIn.class);
        startActivity(switchActivityIntent);
    }

    boolean checkDataEntered() {
        Pattern UpperCasePattern = Pattern.compile("[A-Z]");  // Abelwe Code
        if (isEmpty(name)) { //checks if name is entered
            name.setError("First name is required!");
            return false;
        }
        else if (isEmpty(address)) {  //checks if address is entered
            address.setError("Address is required!");
            return false;
        }
        else if (isEmpty(cell_num)) {  //checks if cell number is entered
            cell_num.setError("Cellphone number is required!");
            return false;
        }
        else if (isEmpty(stu_num)) {  //checks if student number is entered
            surname.setError("Student number is required!");
            return false;
        }
        else if (isEmpty(password)) {  //checks if password is entered
            password.setError("Password is required!");
            return false;
        }
        else if (isEmpty(re_password)) {  //checks if re-entere password is entered
            re_password.setError("Re-enter is required!");
            return false;
        }
        else if (isEmpty(surname)) {  //checks if surname is entered
            surname.setError("Last name is required!");
            return false;
        }
        else if (!isEmail(email)) {  //checks if email is entered
            email.setError("Enter valid email!");
            return false;
        }
        else if (password.getText().toString().length()<8 || re_password.getText().toString().length()<8) {
            password.setError("Password must be at least 8 chars long!");
            return false;
        }
        else if (!UpperCasePattern.matcher(password.getText().toString()).find())
        {
            //Trying to make sure the passwords have a number and special character 
            password.setError("Enter a special character");
            return false;

        }
        else if(!password.getText().toString().matches(".*[0-9].*")){
            password.setError("Password must have a number!");
            return false;
        }                                             
        
        //String pass = password.getText().toString();
        // for special characters
        else if (!(password.getText().toString().contains("@") || password.getText().toString().contains("#")
              || password.getText().toString().contains("!") || password.getText().toString().contains("~")
              || password.getText().toString().contains("$") || password.getText().toString().contains("%")
              || password.getText().toString().contains("^") || password.getText().toString().contains("&")
              || password.getText().toString().contains("*") || password.getText().toString().contains("(")
              || password.getText().toString().contains(")") || password.getText().toString().contains("-")
              || password.getText().toString().contains("+") || password.getText().toString().contains("/")
              || password.getText().toString().contains(":") || password.getText().toString().contains(".")
              || password.getText().toString().contains(", ") || password.getText().toString().contains("<")
              || password.getText().toString().contains(">") || password.getText().toString().contains("?")
              || password.getText().toString().contains("|"))) 
        {
            
            //Shows error 
            password.setError("Enter a special character");
            return false;
        }

        
        
          //checking whether a number is present in the password entered
         else if(!password.getText().toString().matches(".*[0-9].*"){
            password.setError("Password must have a number!");
             return false;
         }
                 
        else{
            return true;
        }
    }
}
