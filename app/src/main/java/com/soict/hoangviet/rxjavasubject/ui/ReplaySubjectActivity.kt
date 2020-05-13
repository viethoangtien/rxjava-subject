package com.soict.hoangviet.rxjavasubject.ui

import com.soict.hoangviet.rxjavasubject.BaseActivity
import io.reactivex.rxjava3.subjects.ReplaySubject

class ReplaySubjectActivity : BaseActivity() {
    override fun initView() {
        doSomeWork()
    }

    private fun doSomeWork() {
        val source = ReplaySubject.create<Int>()
        //First Observer subscribes to Observable
        source.subscribe(getFirstObserver())
        source.onNext(1)
        source.onNext(2)
        source.onNext(3)
        source.onNext(4)

        //Second Observer subscribes to Observable
        source.subscribe(getSecondObserver())
        source.onComplete()
    }

    override fun initListener() {

    }
}