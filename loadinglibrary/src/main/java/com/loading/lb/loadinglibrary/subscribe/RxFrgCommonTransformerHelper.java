package com.loading.lb.loadinglibrary.subscribe;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.RxFragment;

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
 * 功能：结合CommonSubscribe使用   将进度框封装在这里
 */

public class RxFrgCommonTransformerHelper<T> {

    private Context context;
    private MaterialDialog materialDialog;



    public <T> ObservableTransformer<T, T> apply(final RxFragment context) {

        this.context = context.getActivity();

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
                        .compose(RxLifecycle.bindUntilEvent(context.lifecycle(), FragmentEvent.DESTROY));
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
