package com.loading.lb.loadinglibrary.subscribe;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created Time: 2017/11/14.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：在onSubscribe调用
 */

public abstract class LoadingObserver<T> implements Observer<T>{


    private ProgressDialog progressDialog;

    private Context context;


    public LoadingObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        //只有当上游和下游建立连接之后, 上游才会开始发送事件. 也就是调用了subscribe() 方法之后才开始发送事件.
        showDialog(d);
    }

    @Override
    public void onNext(T o) {
        success(o);
    }

    @Override
    public void onError(Throwable e) {
        dismissDialog();
        fail(e.getMessage());
    }

    @Override
    public void onComplete() {
        dismissDialog();
    }

    private void showDialog(final Disposable d){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("正在加载...");
        progressDialog.show();
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                if (d != null && !d.isDisposed()) {
                    d.dispose();
                }
            }
        });
    }

    private void dismissDialog(){
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
    protected abstract void success(T t);

    protected abstract void fail(String msg);

}
