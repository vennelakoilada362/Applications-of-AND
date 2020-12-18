package com.example.sharedprefernceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText et_name,et_password,et_email;
   Button register,login;
   SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.et_name);
        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);
        preferences=getSharedPreferences("apssdc",MODE_PRIVATE);


    }





    public void register(View view) {

        String uname=et_name.getText().toString();
        String uemail=et_email.getText().toString();
        String upassword=et_password.getText().toString();
        SharedPreferences.Editor editor=preferences.edit();
        if(uname.equals("")){
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
        }
        else if(uemail.equals("")){
            Toast.makeText(this, "Enter useremail", Toast.LENGTH_SHORT).show();
        }
        else if(upassword.equals("")){
            Toast.makeText(this, "Enter userpasword", Toast.LENGTH_SHORT).show();
        }
        else {
            editor.putString("name", uname);
            editor.putString("password", upassword);
            editor.apply();
            Toast.makeText(this, "USER  REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        }
    }
    public void login(View view) {
    Intent i = new Intent(MainActivity.this,LoginActivity.class);
    startActivity(i);
    }
}