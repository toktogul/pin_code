package com.digital.demopincode.ui.pincode

import androidx.lifecycle.ViewModel
import com.digital.demopincode.PinCodeScreens
import ru.terrakok.cicerone.Router

class CreatePinCodeViewModel(
    val router: Router,
    private val screen: PinCodeScreens
) : ViewModel() {

    fun openConfirmScreen(code: String) {
        router.navigateTo(screen.openConfirmPinCodeScreen(code))
    }
}