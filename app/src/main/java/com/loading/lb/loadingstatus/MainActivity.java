package com.loading.lb.loadingstatus;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.View;

import com.loading.lb.loadinglibrary.model.Weather;
import com.loading.lb.loadinglibrary.subscribe.CommonObserver;
import com.loading.lb.loadinglibrary.subscribe.LoadingObserver;
import com.loading.lb.loadinglibrary.subscribe.LoadingSubscribe;
import com.loading.lb.loadinglibrary.subscribe.RxActCommonTransformerHelper;
import com.loading.lb.loadinglibrary.subscribe.RxActTransformerHelper;
import com.loading.lb.loadingstatus.databinding.ActivityMainBinding;

import mehdi.sakout.dynamicbox.DynamicBox;

public class MainActivity extends BaseActivity {

    private final String key="3c93eca92a034a7f9808221f56801062";
    private final String dtType="json";
    private final String city = "成都";
    private ActivityMainBinding binding;

    private Context context;

    @Override
    public void initView() {
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        context = this;
    }

    //方式一
    public void transformerHelper(View v) {

        fromNetwork.getWeather(city,dtType,key)
                .compose(new RxActCommonTransformerHelper<Weather>().apply(this))
                .subscribe(new CommonObserver<Weather>() {
                    @Override
                    protected void success(Weather weather) {
                        Log.i("","");
                        binding.resultTv.setText(weather.getReason());
                    }

                    @Override
                    protected void fail(String msg) {
                        binding.resultTv.setText(msg);
                    }
                });

    }

    //方式二
    public void observer(View v) {

        fromNetwork.getWeather(city, dtType, key)
                .compose(new RxActTransformerHelper().apply(this))
                .subscribe(new LoadingObserver<Weather>(this) {
                    @Override
                    protected void success(Weather weather) {
                        binding.resultTv.setText(weather.getReason());
                    }

                    @Override
                    protected void fail(String msg) {

                    }
                });
    }


    //方式三
    public void disposeSubscribe(View v) {
        DynamicBox box = new DynamicBox(this,binding.resultLayout);

        fromNetwork.getWeathers(city, dtType, key)
                .compose(new RxActTransformerHelper().applys(this))
                .subscribe(new LoadingSubscribe<Weather>(box) {
                    @Override
                    protected void success(Weather weather) {
                        binding.resultTv.setText(weather.getReason());
                    }

                    @Override
                    protected void fail(String msg) {

                    }
                });
    }


}
