package com.example.myapplication2.model;

public abstract class Result<T> {
    private Result(){

    }

    public static final class Success<T> extends Result<T>{
        public T mData;

        public Success(T data){
            this.mData = data;
        }
    }

    public static final class Error<T> extends Result<T>{
        public Throwable mException;

        public Error(Throwable exception){
            this.mException = exception;
        }
    }

    public static final class Progress<T> extends Result<T>{
        public T mProgress;

        public Progress(T progress){
            this.mProgress = progress;
        }
    }

    public interface ICallbacck<T> {
        void complete(Result<T> result);
    }
}
