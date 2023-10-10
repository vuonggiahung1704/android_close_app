package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.editTextText1);
        edt2 = findViewById(R.id.editTextText2);

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.example.myapplication3");
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("edt",edt1.getText().toString());
//                startActivity(intent);
                Intent intent = new Intent("com.example.LOGOUT");
                intent.putExtra("key", "value");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

//        try {
//            Intent intent = getIntent();
//            String text = intent.getStringExtra("text");
//
//        }catch (Exception ignore){
//            Log.d("error - message" ,"error");
//        }

        // Lấy dữ liệu từ intent mới
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String data = extras.getString("text");
            edt2.setText(data);
            // Xử lý dữ liệu nhận được
        }
    }
}