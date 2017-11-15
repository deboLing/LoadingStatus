package com.loading.lb.loadinglibrary.subscribe;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created Time: 2017/11/14.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：结合RxActCommonTransformerHelper使用
 */

public abstract class CommonObserver<T>  implements Observer<T>{
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T o) {
        success(o);
    }

    @Override
    public void onError(Throwable e) {
        fail(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
    protected abstract void success(T t);

    protected abstract void fail(String msg);

}
