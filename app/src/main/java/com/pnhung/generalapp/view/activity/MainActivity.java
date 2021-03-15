package com.pnhung.generalapp.view.activity;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.pnhung.generalapp.R;
import com.pnhung.generalapp.presenter.MainPresenter;
import com.pnhung.generalapp.view.base.BaseActivity;
import com.pnhung.generalapp.view.event.OnHomeCallBack;

public class MainActivity extends BaseActivity<MainPresenter> implements OnHomeCallBack {
    private static final int DOWNLOAD_PERMISSON = 1001;
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void initView() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.INTERNET
                        , Manifest.permission.WRITE_EXTERNAL_STORAGE},
                DOWNLOAD_PERMISSON);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Log.i(TAG, "request Code : KEY = " + requestCode);

        if (grantResults[0] == getPackageManager().PERMISSION_GRANTED) {
            Toast.makeText(this, "Ngoan lắm", Toast.LENGTH_LONG).show();
        } else {
            Log.e(TAG, "Permission denied");
            Toast.makeText(this, "Không đồng ý hả mậy", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_home;
    }

    @Override
    protected int getContentId() {
        return R.id.ln_content;
    }
}
