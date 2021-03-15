package com.pnhung.generalapp.presenter;

import com.pnhung.generalapp.view.event.OnCallBackToView;

public abstract class BasePresenter<T extends OnCallBackToView> {
    protected T mCallBack;

    public BasePresenter(T mCallBack) {
        this.mCallBack = mCallBack;
    }


}
