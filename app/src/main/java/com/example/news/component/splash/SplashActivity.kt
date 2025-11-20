package com.example.news.component.splash

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.news.MainActivity
import com.example.news.R
import com.example.news.activity.BaseLogicActivity

/*
    启动界面
 */


class SplashActivity : BaseLogicActivity() {
//    private lateinit var supportFragmentManage: FragmentManager

    private lateinit var welcomeView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun initViews() {
        super.initViews()
        // 设置界面
        welcomeView = findViewById<Button>(R.id.welcome)
    }

    override fun initDatum() {
        super.initDatum()
        // 设置数据

        showTermsServiceAgreementDialog()
    }

    override fun initListeners() {
        super.initListeners()
        welcomeView.setOnClickListener{
            startActivityAfterFinishThis(MainActivity::class.java)
        }
    }

    private fun showTermsServiceAgreementDialog() {
        TermsServiceDialogFragment.show(supportFragmentManager, object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d(TAG,"primary onClick")
            }
        })
    }

    companion object{
        const val TAG = "SplashActivity"
    }

}