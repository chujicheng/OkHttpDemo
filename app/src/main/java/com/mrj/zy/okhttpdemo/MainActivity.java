package com.mrj.zy.okhttpdemo;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_get_image_btn)
    Button mainGetImageBtn;
    @BindView(R.id.show_photo_iv)
    ImageView showPhotoIv;

    private String url;//声明地址url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_get_image_btn)
    public void onClick() {

        url = "https://www.baidu.com";//url百度地址

        File cache = getExternalCacheDir();//缓存文件

        OkHttpUtil.getOkHttp(cache, url, new Callback() {//请求回调
            @Override
            public void onFailure(Call call, IOException e) {//请求失败
                Log.d("rongjie", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {//请求成功
                Log.d("rongjie", "onResponse: " + response.networkResponse());
            }
        });


    }
}
