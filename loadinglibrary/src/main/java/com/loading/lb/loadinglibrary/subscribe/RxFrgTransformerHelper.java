package com.loading.lb.loadinglibrary.subscribe;

import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.RxFragment;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created Time: 2017/11/15.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：fragment 结合LoadingObserver/LoadingSubscribe使用
 */

public class RxFrgTransformerHelper<T> {
    public   <T> ObservableTransformer<T, T> apply(final RxFragment context) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return (Observable<T>)upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(RxLifecycle.bindUntilEvent(context.lifecycle(), FragmentEvent.DESTROY));
            }
        };
    }
}
