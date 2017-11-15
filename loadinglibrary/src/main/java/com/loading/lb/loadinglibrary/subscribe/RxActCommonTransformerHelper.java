package com.loading.lb.loadinglibrary.subscribe;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created Time: 2017/11/14.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：结合CommonSubscribe使用  将进度框封装在这里
 */

public class RxActCommonTransformerHelper<T> {

    private Context context;
    private MaterialDialog materialDialog;



    public   ObservableTransformer<T, T> apply(final Context context) {

        this.context = context;

        return new ObservableTransformer<T, T>() {
            @Override
            public Observable<T> apply(Observable<T> upstream) {
                return (Observable<T>) upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                showProgressDialog();
                            }
                        })
                        .doAfterTerminate(new Action() {
                            @Override
                            public void run() throws Exception {
                                dismissProgressDialog();
                            }
                        })
                        .compose(RxLifecycle.bindUntilEvent(((RxFragmentActivity) context).lifecycle(), ActivityEvent.DESTROY));
            }
        };
    }

    private void showProgressDialog() {
        materialDialog = new MaterialDialog.Builder(context)
                .progress(true,100)
                .content("稍后....")
                .build();
        materialDialog.show();
    }

    private void dismissProgressDialog() {
        if (materialDialog != null && materialDialog.isShowing()) {
            materialDialog.dismiss();
        }
    }
}
