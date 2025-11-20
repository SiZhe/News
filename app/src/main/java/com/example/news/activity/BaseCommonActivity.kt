package com.example.news.activity

import android.content.Intent

// 通用界面逻辑
open class BaseCommonActivity : BaseActivity() {

    protected fun startActivity(clazz: Class<*>?){
        val intent = Intent(this,clazz)
        startActivity(intent)
    }

    fun startActivityAfterFinishThis(clazz: Class<*>?){
        startActivity(clazz)
        finish()
    }
}