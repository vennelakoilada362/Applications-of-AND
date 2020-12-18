package com.muneiah.example.studentdirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.muneiah.example.studentdirectory.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {
ActivityUpdateBinding binding;
StudentEntity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding= DataBindingUtil.setContentView(this,R.layout.activity_update);
    Intent i=getIntent();
    String nn=i.getStringExtra("name");
    String ii=i.getStringExtra("id");
    binding.updateName.setText(nn);
    binding.updateRollnumber.setText(ii);
    binding.updateRollnumber.setKeyListener(null);
    }

    public void updateData(View view) {
        entity=new StudentEntity();
        entity.setName(binding.updateName.getText().toString());
        entity.setId(binding.updateRollnumber.getText().toString());
       // MainActivity.dataBase.studentDAO().updateData(entity);
        MainActivity.viewModel.update(entity);
        Toast.makeText(this,binding.updateName.getText().toString() +" is Updated", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}