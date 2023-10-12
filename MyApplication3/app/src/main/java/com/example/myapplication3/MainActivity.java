package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EditText edt1 = findViewById(R.id.editTextText1);
//        EditText edt2 = findViewById(R.id.editTextText2);

        IntentFilter intentFilter = new IntentFilter("com.example.LOGOUT");
        registerReceiver(new BroadCast(), intentFilter);


//        try {
//            Intent intent = getIntent();
//            String edt = intent.getStringExtra("edt");
//            edt2.setText(edt);
//        }catch (Exception ignore){
//            Log.d("error - message" ,"error");
//        }

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.example.myapplication2");
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("text",edt1.getText().toString());
                Intent intent = new Intent(MainActivity.this, DemoActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }
}