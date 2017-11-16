# LoadingStatus
总结一下rxjava2、retrofit2网络请求部分的加载状态的封装方式

# 这里列举了三种方式

# 1 onStart()显示进度框
  在 rxjava 2.0中，DisposableSubscriber<T>实现接口FlowableSubscriber<T>，
  意味着这种方式适用于被观察者Flowable<T>。
  在线程切换过程中，onStart()处于子线程还是主线程取法确定，由于View的控制职能
  在主线程中进行。所以，当onStart()处于子线程时，欲显示对话框，可以借助Handler。
  自定义Handler,封装对话框。
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

   显示与关闭：

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

# 2 onSubscribe(Disposable d) 中显示对话框
  自定义子类，实现Observer<T>接口，重写onSubscribe(Disposable d)。这种方式适用于
  被观察者Observable<T>。因为onSubscribe(Disposable d)的调用是在事件发送之前，
  而注册rxjava是在主线程，所以，onSubscribe(Disposable d)会在主线程执行。

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

# 3 在ObservableTransformer<T, T>或者ObservableTransformer<T, T>上面封装

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

   这种方式利用率两个方法，分别是doOnSubscribe()和doAfterTerminate()。

   根据需求选择不同的方式吧！