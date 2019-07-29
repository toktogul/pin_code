package com.digital.demopincode.ui.pincode

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.digital.demopincode.R
import kotlinx.android.synthetic.main.buttons.*
import kotlinx.android.synthetic.main.pin_code_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ConfirmPinCodeFragment : BasePinCodeFragment() {
    private val viewModel: ConfirmPinCodeViewModel by viewModel()

    private var isErrorViewsActive = false
    override fun onBackPressed() = viewModel.router.exit()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title.text = getString(R.string.repeat_pin_code)
        Log.e("ConfirmPinCodeFragment", "onViewCreated: ${arguments!!.getString("pin_сode")}")
    }

    override fun onClick(view: View?) {
        when {
            view?.id == delete.id -> {
                if (isErrorViewsActive) {
                    isErrorViewsActive = false
                    dots.forEach {
                        it.setBackgroundResource(R.drawable.code_inactive_bg)
                    }
                    error_message.visibility = View.INVISIBLE
                }
                if (count == 0) return
                count--
                pinValues[count] = null
                updateDots(false)
                refreshFirstCodeItem()
            }

            else -> {
                val button = view as TextView
                pinValues[count] = button.text.toString()
                updateDots(true)
                count++

                if (count == 4) {
                    val pin = StringBuilder()
                    pinValues.forEach { item ->
                        pin.append(item)
                    }

                    if (pin.toString() == arguments!!.getString("pin_сode")) {
                        viewModel.openSuccessScreen()
                    } else {
                        isErrorViewsActive = true
                        dots.forEach {
                            it.setBackgroundResource(R.drawable.code_error_bg)
                        }
                        error_message.visibility = View.VISIBLE
                    }
                } else refreshFirstCodeItem()
            }
        }
    }
}


class ConfirmPinCodeScreen(private val pinCode: String) : SupportAppScreen() {

    override fun getFragment(): Fragment {
        return ConfirmPinCodeFragment().apply {
            arguments = bundleOf("pin_сode" to pinCode)
        }
    }
}