package com.digital.demopincode.ui.pincode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.digital.demopincode.R
import com.digital.demopincode.ui.BaseFragment
import kotlinx.android.synthetic.main.buttons.*
import kotlinx.android.synthetic.main.pin_code_fragment.*

abstract class BasePinCodeFragment : BaseFragment(), View.OnClickListener {

    protected var count: Int = 0
    protected val pinValues: Array<String?> = arrayOfNulls(4)
    protected lateinit var dots: Array<TextView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.pin_code_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initKeyboardButtonsListener()
        dots = arrayOf(first, second, third, fourth)
        first.setBackgroundResource(R.drawable.code_active_bg)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun initKeyboardButtonsListener() {
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        zero.setOnClickListener(this)
        delete.setOnClickListener(this)
    }

    protected fun updateDots(setNumber: Boolean = false) {
        val view = dots[count]
        if (setNumber) {
            view.text = pinValues[count]
        } else {
            view.text = ""
        }
    }

    protected fun refreshFirstCodeItem() {
        if (count == 0) {
            first.setBackgroundResource(R.drawable.code_active_bg)
        } else {
            first.setBackgroundResource(R.drawable.code_inactive_bg)
        }
    }
}