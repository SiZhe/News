package com.example.news.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/*
    所有activity的父类
 */
open class BaseActivity : AppCompatActivity() {
    //
    protected open fun initViews(){}
    // 数据
    protected open fun initDatum(){}
    // 监听器
    protected open fun initListeners(){}

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initViews ()
        initDatum ()
        initListeners ()
    }
}