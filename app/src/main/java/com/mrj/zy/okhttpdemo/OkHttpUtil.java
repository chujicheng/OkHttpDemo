package com.mrj.zy.okhttpdemo;


import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ZY on 2017/6/1.
 */

public class OkHttpUtil {

    public OkHttpUtil(){
    }

    /**
     * 通过get来获取网络数据
     * @param file 缓存区文件
     * @param url 链接地址
     * @param callback 请求后的回调
     */
    public static void getOkHttp(File file, String url, Callback callback){

        int cacheSize=10*1024*1024;//设置缓存区大小

        OkHttpClient.Builder clientBuilder=new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)//连接超时时间设置
                .readTimeout(5,TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(5,TimeUnit.SECONDS)//设置写入超时时间
                .cache(new Cache(file.getAbsoluteFile(),cacheSize));//设置缓存大小

        OkHttpClient okHttpClient=clientBuilder.build();//通过builder来创建客户端实例

        Request.Builder builder=new Request.Builder()//初始化Request的Builder实例
                .url(url);//设置url

        builder.method("GET",null);//设置请求方法为 GET（默认为 GET）

        Request request=builder.build();//通过builder得到Request实例

        Call call=okHttpClient.newCall(request);//通过客户端得到call实例

        call.enqueue(callback);//发起网络请求并且通过callback来操作返回的结果
    }

    /**
     *
     */
    public static void postOkHttp(){

    }

}
