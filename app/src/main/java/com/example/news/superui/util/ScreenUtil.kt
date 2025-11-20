package com.example.news.superui.util

import android.annotation.SuppressLint
import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

object ScreenUtil {

    fun getScreenWith(context: Context): Int {
    //获取window管理器
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    //创建显示对象
        val outDisplayMetrics = DisplayMetrics()
    //获取默认显示对象
        wm.defaultDisplay.getMetrics(outDisplayMetrics)
    //返回屏幕宽度
        return outDisplayMetrics.widthPixels
    }
}