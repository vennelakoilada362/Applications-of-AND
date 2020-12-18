package com.example.sharedprefernceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et_name,et_password;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_name=findViewById(R.id.name);
        et_password=findViewById(R.id.password);
        preferences=getSharedPreferences("apssdc",MODE_PRIVATE);
    }

    public void ok(View view) {
        String user_name=et_name.getText().toString();
        String user_password=et_password.getText().toString();
        String reg_user=preferences.getString("name","");
        String reg_pass=preferences.getString("password","");
        if(user_name.equals(reg_user)&& user_password.equals(reg_pass))
        {
            Toast.makeText(this, "Login details are correct", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Wrong details entered", Toast.LENGTH_SHORT).show();
        }


    }
}