package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvtraicay;
    ArrayList<Contactclass> arraytraicay;
    ContactAdapter adapter;
    Button btnadd;
    private int requestCode;
    private int resultCode;
    private Intent data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvtraicay = (ListView) findViewById(R.id.listview);
        btnadd = (Button) findViewById(R.id.btn_add);
        arraytraicay = new ArrayList<Contactclass>();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyen();

            }

        });
        adapter = new ContactAdapter(this, R.layout.contact, arraytraicay);
        lvtraicay.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        CheckPermission();
        lvtraicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowDialog(position);
            }
        });

    }



    public void chuyen() {
        Intent intent = new Intent(this, Activity2.class);
        startActivityForResult(intent,1);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                addtraicay(data);

            }
        }
    }
    public void addtraicay(Intent intent1)
    {
        Bundle bundle = intent1.getExtras();
        int hinh1 = 0;
        if (bundle != null) {
            String tentraicay = bundle.getString("key_ten", "");
            String motatraicay = bundle.getString("key_numberPhone", "");
            hinh1 = R.drawable.icon_cute;
            arraytraicay.add(new Contactclass(tentraicay, motatraicay, hinh1));
            adapter.notifyDataSetChanged();
        }


    }


    public void ShowDialog(final int position){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        Button btncall = (Button) dialog.findViewById(R.id.btncall);
        Button btnsend = (Button) dialog.findViewById(R.id.btnsend);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "call", Toast.LENGTH_SHORT).show();
                Call(position);
            }
        });
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendSMS(position);
            }
        });
        dialog.show();
    }

    private void SendSMS(int position) {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("sms:"+ arraytraicay.get(position).getPhoneNumber()));
        startActivity(intent);
    }

    private void Call(int position) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+ arraytraicay.get(position).getPhoneNumber()));
        startActivity(intent);
    }

    private void CheckPermission(){
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS
        };
        List<String> ListPermissionNeed = new ArrayList<>();
        for(String permission : permissions) {
            if(ContextCompat.checkSelfPermission(this,permission)!= PackageManager.PERMISSION_GRANTED){
                ListPermissionNeed.add(permission);
            }
        }
        if(!ListPermissionNeed.isEmpty()){
            ActivityCompat.requestPermissions(this,ListPermissionNeed.toArray(new String[ListPermissionNeed.size()]),1);
        }

    }
}
