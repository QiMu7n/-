package com.example.afalse.base;

public interface BaseCallback<D>{
    void onSuccess(D data);

    void onFailure(String message);

}
