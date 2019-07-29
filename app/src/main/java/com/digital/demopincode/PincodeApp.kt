package com.digital.demopincode

import android.app.Application
import com.digital.demopincode.ui.pincode.ConfirmPinCodeViewModel
import com.digital.demopincode.ui.pincode.CreatePinCodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone

class PincodeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val cicerone = Cicerone.create()
        startKoin {
            modules(module {
                single { cicerone.router!! }
                single { cicerone.navigatorHolder!! }
                single { PinCodeScreens() }
                viewModel { CreatePinCodeViewModel(get(), get()) }
                viewModel { ConfirmPinCodeViewModel(get(), get()) }
            })
        }
    }
}