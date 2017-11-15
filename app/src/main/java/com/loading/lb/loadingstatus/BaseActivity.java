package com.loading.lb.loadingstatus;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.loading.lb.loadinglibrary.net.NetworkApi;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

/**
 * Created Time: 2017/11/14.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：
 */

public abstract class BaseActivity extends RxFragmentActivity {

    NetworkApi.FromNetwork fromNetwork;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fromNetwork = NetworkApi.getRetrofit().create(NetworkApi.FromNetwork.class);
        initView();
    }

    public abstract void initView();
}
