package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication2.model.Result;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mResponseTv;
    private APIService mAPIService;
    private PostRepository apk;

    @Inject
    private ExecutorService executorService = Executors.newFixedThreadPool(10);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText titleEt = (EditText) findViewById(R.id.et_title);
        final EditText bodyEt = (EditText) findViewById(R.id.et_body);
        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        Button getBtn = (Button) findViewById(R.id.btn_get);
        mResponseTv = (TextView) findViewById(R.id.tv_response);

        mAPIService = ApiUtils.getAPIService();
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPost("1");
            }
        });

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPost("2");
            }
        });
    }

    public void getPost(String type) {
//        try {
//
//        }catch (Exception e){
//            Log.d("getPost",e.toString());
//        }
        MutableLiveData<Result<Post>> handle;
        if(type.equals("1")){
            handle = handlePost();
        }else{
            handle = handlePost2();
        }

        handle.observe(this,result ->{
            try {
                Post post = ((Result.Success<Post>) result).mData;
                Log.d("getPost", String.valueOf(post.getId()) +  post.getTitle());
            }catch (Exception exc){
                Log.d("getPost",exc.toString());
            }
        });
    }

    public MutableLiveData<Result<Post>> handlePost() {
        apk = new PostRepository(executorService);

        MutableLiveData<Result<Post>> observalbleResult = new MutableLiveData<>();
        apk.GetPost(result -> {
           if(result instanceof Result.Success){
                observalbleResult.postValue(result);
           }
        });
        return observalbleResult;
    }

    public MutableLiveData<Result<Post>> handlePost2() {
        apk = new PostRepository(executorService);

        MutableLiveData<Result<Post>> observalbleResult = new MutableLiveData<>();
        apk.GetPost2(result -> {
            if(result instanceof Result.Success){
                observalbleResult.postValue(result);
            }
        });
        return observalbleResult;
    }
}