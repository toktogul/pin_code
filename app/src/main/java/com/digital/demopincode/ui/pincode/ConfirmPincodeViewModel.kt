package com.digital.demopincode.ui.pincode

import androidx.lifecycle.ViewModel
import com.digital.demopincode.PinCodeScreens
import ru.terrakok.cicerone.Router

class ConfirmPinCodeViewModel(val router: Router, private val screen: PinCodeScreens) : ViewModel() {

    fun openSuccessScreen() {
        router.newRootChain(screen.openSuccessScreen())
    }
}