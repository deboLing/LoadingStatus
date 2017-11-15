package com.loading.lb.loadinglibrary.subscribe;

import android.content.Context;

import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created Time: 2017/11/15.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：activity 结合LoadingObserver/LoadingSubscribe使用
 */

public class RxActTransformerHelper<T> {
    public   <T> ObservableTransformer<T, T> apply(final Context context) {
        return new ObservableTransformer<T, T>() {
            @Override
            public Observable<T> apply(Observable<T> upstream) {
                return (Observable<T>)upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(RxLifecycle.bindUntilEvent(((RxFragmentActivity)context).lifecycle(), ActivityEvent.DESTROY));
            }
        };
    }

    public   <T> FlowableTransformer<T, T> applys(final Context context) {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return (Publisher<T>)upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(RxLifecycle.bindUntilEvent(((RxFragmentActivity)context).lifecycle(), ActivityEvent.DESTROY));
            }
        };
    }
}
