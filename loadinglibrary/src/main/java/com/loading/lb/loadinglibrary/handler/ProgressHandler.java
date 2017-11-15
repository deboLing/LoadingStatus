package com.loading.lb.loadinglibrary.handler;

import android.os.Handler;
import android.os.Message;

import mehdi.sakout.dynamicbox.DynamicBox;

/**
 * Created Time: 2017/11/14.
 * <p>
 * Author:Melvin
 * <p>
 * 功能：
 */

public class ProgressHandler extends Handler {

    private DynamicBox dynamicBox;

    public static final int LOADLING = 0x0001;
    public static final int EMPTY = 0x0002;
    public static final int ERROR = 0x0003;
    public static final int NETWORK_EXCEPTION = 0x0004;
    public static final int NORMAL = 0x0005;

    public ProgressHandler(DynamicBox dynamicBox) {

        this.dynamicBox=dynamicBox;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        switch (msg.what){
            case LOADLING:
                dynamicBox.showLoadingLayout();
                break;
            case EMPTY:
                dynamicBox.showCustomView("");
                break;
            case ERROR:
                dynamicBox.showExceptionLayout();
                break;
            case NETWORK_EXCEPTION:
                dynamicBox.showInternetOffLayout();
                break;
            case NORMAL:
                dynamicBox.hideAll();
                break;
        }
    }

    public void showByTag(int tag){
        sendEmptyMessage(tag);
    }
}
