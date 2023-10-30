package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText edt3;
    ProgressBar pg;

    int count = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EditText edt1 = findViewById(R.id.editTextText1);
//        EditText edt2 = findViewById(R.id.editTextText2);
//        edt3 = findViewById(R.id.editTextText3);
        pg = findViewById(R.id.progressBar);

//        IntentFilter intentFilter = new IntentFilter("com.example.LOGOUT");
//        registerReceiver(new BroadCast(), intentFilter);


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
//                Intent intent = new Intent(MainActivity.this, DemoActivity.class);
//                startActivityForResult(intent,1);
//                Intent intent = new Intent();
//                intent.setClassName("com.example.myapplication2","com.example.myapplication2.MainActivity");
//                startActivityForResult(intent,1);
                count += + 5;
                pg.setProgress(count + 5);
            }
        });


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if(extras != null){
            String output = extras.getString("KEY");
            Log.d("KEY",output);

            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(output);
                String title = jsonObject.getString("title");
                String body = jsonObject.getString("body");
                int value1 = jsonObject.getInt("id");
                int value2 = jsonObject.getInt("userId");
                List<String> sp2 = parseStringArray(jsonObject.getJSONArray("sp2"));

                Post post = new Post(title,body,value1,value2,sp2);

//                Gson gson = new Gson();
                Gson gson = new GsonBuilder()
                        .serializeNulls()
                        .setPrettyPrinting()
                        .create();
                String json = gson.toJson(post);
//                json = json.replace("[\\n\\s+", "[").replace("\\s+\\n]", "]");
                Log.d("json",json);
                json = json.replaceAll("\\[\\n\\s+", " ");
//                json = json.replace("\\s+\\n\\]", "]");
                Log.d("json",json);
                edt3.setText(json);


            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static List<String> parseStringArray(JSONArray jsonArray) throws JSONException {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            String item = jsonArray.getString(i);
            stringList.add(item);
        }
        return stringList;
    }
}