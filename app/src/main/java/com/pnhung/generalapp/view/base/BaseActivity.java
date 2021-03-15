package com.pnhung.generalapp.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.pnhung.generalapp.presenter.BasePresenter;

import java.lang.reflect.Constructor;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter = getPresenter();
        initView();
    }

    protected abstract T getPresenter();

    protected abstract void initView();

    protected abstract int getLayoutId();

    public <G extends View> G findViewById(int idView, View.OnClickListener event) {
        G view = findViewById(idView);
        if (view instanceof TextView && event != null) {
            view.setOnClickListener(event);
        }
        return view;
    }

    public void showFragment(String tag) {
        try {
            Class<?> clazz = Class.forName(tag);
            Constructor<?> constructor = clazz.getConstructor();
            BaseFragment frg = (BaseFragment) constructor.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .replace(getContentId(), frg).commit();
        } catch (Exception e) {
        }
    }

    public void showFragment(BaseFragment frg) {
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(getContentId(), frg).commit();
        } catch (Exception e) {
        }
    }

    protected abstract int getContentId();
}
