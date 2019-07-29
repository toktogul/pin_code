package com.digital.demopincode.ui.pincode

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.buttons.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.terrakok.cicerone.android.support.SupportAppScreen

class CreatePinCodeFragment : BasePinCodeFragment() {

    private val viewModel: CreatePinCodeViewModel by viewModel()

    override fun onBackPressed() = viewModel.router.exit()

    override fun onClick(view: View?) {
        when {
            view?.id == delete.id -> {
                if (count > 0) {
                    pinValues[count] = null
                    count--
                    updateDots(false)
                }
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
                    viewModel.openConfirmScreen(pin.toString())

                    dots.forEach {
                        it.text = ""
                    }
                    count = 0
                }
            }
        }
        refreshFirstCodeItem()
    }
}


class CreatePinCodeScreen : SupportAppScreen() {

    override fun getFragment(): Fragment {
        return CreatePinCodeFragment()
    }
}