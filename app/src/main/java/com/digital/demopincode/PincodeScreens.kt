package com.digital.demopincode

import com.digital.demopincode.ui.SuccessScreen
import com.digital.demopincode.ui.pincode.ConfirmPinCodeScreen
import com.digital.demopincode.ui.pincode.CreatePinCodeScreen

class PinCodeScreens {
    fun openCreatePinCodeScreen() = CreatePinCodeScreen()
    fun openConfirmPinCodeScreen(code: String) = ConfirmPinCodeScreen(code)
    fun openSuccessScreen() = SuccessScreen()
}