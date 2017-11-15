package com.loading.lb.loadinglibrary.net;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created Time: 2016/9/4
 * <p/>
 * Author:Melvin
 * <p/>
 * 功能：Token拦截器
 */
public class TokenInterceptor implements Interceptor {
    private final MyHttpLoggingInterceptor.Logger logger;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (loadAuthorization() != null) {
            request = request.newBuilder().addHeader("token", loadAuthorization()).build();
            logger.log("Token:" + loadAuthorization());
        }
        if (getVersioncode() != null) {
            request = request.newBuilder().addHeader("appAndroidVersion", getVersioncode()).build();
            logger.log("Version:" + getVersioncode());
        }
        Response response = chain.proceed(request);
        return response;
    }

    public TokenInterceptor() {
        this.logger = MyHttpLoggingInterceptor.Logger.DEFAULT;
    }

    private String loadAuthorization() {

        return "token";

    }

    private String getVersioncode() {

        return "versioncode";

    }


}
