package com.example.afalse.base;



public class BasePresenter<V extends BaseView>{
    protected  V view;

    public V getView() {
        return view;
    }

    /**
     * 绑定Activity与View对象
     */
    //依赖
    public void attachView(V view){
        this.view=view;
    }
    //分离
    public void detachView(){
        this.view=null;
    }
    public boolean isAttach(){
        return view != null;
    }
}
