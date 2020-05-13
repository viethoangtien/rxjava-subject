package com.soict.hoangviet.rxjavasubject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver

abstract class BaseActivity : AppCompatActivity() {
    protected val compositeDisposable = CompositeDisposable()
    companion object {
        val TAG = BaseActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }

    abstract fun initListener()

    abstract fun initView()

    protected fun getFirstObserver() : DisposableObserver<Int>{
        return object : DisposableObserver<Int>(){
            override fun onComplete() {
                Log.d(TAG, " First onComplete");
            }

            override fun onNext(item: Int?) {
                Log.d(TAG, " First onNext value : $item");
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, " First onError : " + e?.message);
            }

        }
    }

    protected fun getSecondObserver() : DisposableObserver<Int>{
        return object : DisposableObserver<Int>(){
            override fun onComplete() {
                Log.d(TAG, " Second onComplete");
            }

            override fun onNext(item: Int?) {
                Log.d(TAG, " Second onNext value : $item");
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, " Second onError : " + e?.message);
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}