package com.example.afalse.base;

public interface BaseView<D>{
    void onSuccess(D data);

    void onFailure(String message);
}

