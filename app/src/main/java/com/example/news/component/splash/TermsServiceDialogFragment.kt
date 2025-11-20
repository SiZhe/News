package com.example.news.component.splash

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.news.R
import com.example.news.fragment.BaseCommonFragment
import com.example.news.superui.util.ScreenUtil
import javax.crypto.KeyAgreement

class TermsServiceDialogFragment : BaseCommonFragment(){

    private lateinit var contentView: TextView
    private lateinit var primaryView: Button

    private lateinit var onAgreementClickListener: View.OnClickListener

    override fun initViews() {
        super.initViews()
        // 点击外部不关闭
        isCancelable = false
        contentView = findViewById<TextView>(R.id.content)

        primaryView = findViewById<Button>(R.id.primary)
    }

    override fun initDatum() {
        super.initDatum()
        val content = Html.fromHtml(getString(R.string.term_service_privacy_content))
       contentView.text=content
    }

    override fun initListeners() {
        super.initListeners()
        primaryView.setOnClickListener{
            dismiss()
            onAgreementClickListener.onClick(it)
        }
    }

    override fun onResume() {
        super.onResume()

        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ((ScreenUtil.getScreenWith(requireContext()) * 0.9).toInt())
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }

    override fun getLayoutView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_term_service,container,false)
    }

    companion object{
        fun show(fragmentManager: FragmentManager, onAgreementClickListener:View.OnClickListener){
            val dialogFragment = TermsServiceDialogFragment()

            dialogFragment.onAgreementClickListener = onAgreementClickListener

            dialogFragment.show(fragmentManager,"TermsServiceDialogFragment")
        }
    }

}