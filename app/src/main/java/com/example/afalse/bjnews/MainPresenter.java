package com.example.afalse.bjnews;

import com.example.afalse.base.BasePresenter;
import com.example.afalse.base.ModelManager;

public class MainPresenter extends BasePresenter<MainView> {
    public void translate(String doctype,String type,String i){
        MainModel model= ModelManager.getInstance().getModel(MainModel.class);
        model.translate(doctype, type, i, new MainCallback() {
            @Override
            public void onSuccess(WordBean data) {
                if(isAttach()){
                    view.onSuccess(data);
                }
            }

            @Override
            public void onFailure(String message) {
                    if(isAttach()){
                        view.onFailure(message);
                    }
            }
        });
    }
}
