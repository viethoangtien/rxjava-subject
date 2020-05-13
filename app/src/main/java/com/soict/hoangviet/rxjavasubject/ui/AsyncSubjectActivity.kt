package com.soict.hoangviet.rxjavasubject.ui

import com.soict.hoangviet.rxjavasubject.BaseActivity
import io.reactivex.rxjava3.subjects.AsyncSubject

class AsyncSubjectActivity : BaseActivity() {
    override fun initView() {
        doSomeWork()
    }

    private fun doSomeWork() {
        val source = AsyncSubject.create<Int>()
        //First Observer subscribes to Observable
        source.subscribe(getFirstObserver())
        source.onNext(1)
        source.onNext(2)
        source.onNext(3)

        //Second Observer subscribes to Observable
        source.subscribe(getSecondObserver())
        source.onNext(4)
        source.onComplete()
    }

    override fun initListener() {

    }
}