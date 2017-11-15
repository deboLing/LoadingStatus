package com.loading.lb.loadinglibrary.subscribe;

import com.loading.lb.loadinglibrary.handler.ProgressHandler;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.subscribers.DisposableSubscriber;
import mehdi.sakout.dynamicbox.DynamicBox;
import retrofit2.HttpException;

/**
 * Created Time: 2017/11/14.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：使用Handler方式发送通知给主线程   Flowable
 */

public abstract class LoadingSubscribe<T> extends DisposableSubscriber<T> {

    private ProgressHandler progressHandler;

    public LoadingSubscribe(DynamicBox box) {
        this.progressHandler = new ProgressHandler(box);
    }


    @Override
    protected void onStart() {
        super.onStart();
        progressHandler.showByTag(ProgressHandler.LOADLING);
    }

    @Override
    public void onNext(T o) {
        if(o == null){
            progressHandler.showByTag(ProgressHandler.ERROR);
        }else{
            progressHandler.showByTag(ProgressHandler.NORMAL);
        }
        success(o);
    }

    @Override
    public void onError(Throwable t) {
        //UnknownHostException -> SocketException -> SocketTimeoutException -> IOException
        if(t instanceof UnknownHostException || t instanceof SocketTimeoutException || t instanceof SocketException
                ||t instanceof ConnectException || t instanceof HttpException){
            progressHandler.showByTag(ProgressHandler.NETWORK_EXCEPTION);
        }else{
            progressHandler.showByTag(ProgressHandler.ERROR);
        }
        fail(t.getMessage());
    }

    @Override
    public void onComplete() {

    }
    protected abstract void success(T t);

    protected abstract void fail(String msg);

}
