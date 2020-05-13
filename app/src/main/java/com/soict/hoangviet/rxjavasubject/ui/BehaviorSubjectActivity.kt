package com.soict.hoangviet.rxjavasubject.ui

import com.soict.hoangviet.rxjavasubject.BaseActivity
import io.reactivex.rxjava3.subjects.BehaviorSubject

class BehaviorSubjectActivity : BaseActivity() {
    override fun initView() {
        doSomeWork()
    }

    private fun doSomeWork() {
        val source = BehaviorSubject.create<Int>()

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