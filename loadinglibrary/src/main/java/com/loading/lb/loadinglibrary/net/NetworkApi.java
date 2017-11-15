package com.loading.lb.loadinglibrary.net;

import com.loading.lb.loadinglibrary.model.Weather;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created Time: 2017/11/15.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：
 */

public class NetworkApi {
    private static Retrofit sRetrofit;
    public static final String API_URL = "http://apis.haoservice.com";


    public static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            OkHttpClient httpClient  = new OkHttpClient().newBuilder().connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS).writeTimeout(0, TimeUnit.SECONDS).hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    })
                    .addInterceptor(new MyHttpLoggingInterceptor().setLevel(MyHttpLoggingInterceptor.Level.BODY))
                    .addNetworkInterceptor(new TokenInterceptor()).build();

            sRetrofit = new Retrofit.Builder()
                    .client(httpClient)
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    public interface FromNetwork {
        //查看代收款领取人详情修改日志接口

        @GET("/weather")
        Observable<Weather> getWeather(@Query("cityname") String cityname,
                                       @Query("dtype") String dtype,
                                       @Query("key") String key);

        @GET("/weather")
        Flowable<Weather> getWeathers(@Query("cityname") String cityname,
                                     @Query("dtype") String dtype,
                                     @Query("key") String key);
    }
}
