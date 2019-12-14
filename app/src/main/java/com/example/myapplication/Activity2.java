package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    EditText edtten,edtsodt;
    Button btnadd2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        
        btnadd2 = (Button) findViewById(R.id.btn_add2);
        edtten = (EditText) findViewById(R.id.edt_ten);
        edtsodt = (EditText) findViewById(R.id.edt_sodt);
        btnadd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ChuyenactivityMain();
            }
        });
        
        
    }

    public void ChuyenactivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        if(edtten.getText().toString().length()>0&&edtsodt.getText().toString().length()>0){
            String ten = edtten.getText().toString();
            String numberphone = edtsodt.getText().toString();
            Bundle bd = new Bundle();
            bd.putString("key_ten", ten);
            bd.putString("key_numberPhone", numberphone);
            intent.putExtras(bd);
            setResult(RESULT_OK, intent);
            finish();
            //startActivity(intent);
        }
        else {
            Toast.makeText(this, "Chưa nhập Họ tên hoặc Số đt", Toast.LENGTH_SHORT).show();
        }
    }
}
