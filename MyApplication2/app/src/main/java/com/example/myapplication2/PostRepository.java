package com.example.myapplication2;

import com.example.myapplication2.model.Result;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import retrofit2.HttpException;
import retrofit2.Response;

public class PostRepository {

    private APIService mAPIService;
    private Executor executor;

    @Inject
    PostRepository(ExecutorService executor){
        this.executor = executor;
    }

    public void GetPost(final Result.ICallbacck<Post> callbacck){
        executor.execute(() ->{
            mAPIService = ApiUtils.getAPIService();
            Response<Post> response = null;

            try {
                response = mAPIService.getPost().execute();
            }catch (IOException exception){
                callbacck.complete(new Result.Error<>(exception));
            }

            if(response.code() != 200){
                callbacck.complete(new Result.Error<>(new HttpException(response)));
                return;
            }

            callbacck.complete(new Result.Success<>(response.body()));
        });
    }

    public void GetPost2(final Result.ICallbacck<Post> callbacck){
        executor.execute(() ->{
            mAPIService = ApiUtils.getAPIService();
            Response<Post> response = null;

            try {
                response = mAPIService.getPost2().execute();
            }catch (IOException exception){
                callbacck.complete(new Result.Error<>(exception));
            }

            if(response.code() != 200){
                callbacck.complete(new Result.Error<>(new HttpException(response)));
                return;
            }

            callbacck.complete(new Result.Success<>(response.body()));
        });
    }

}
