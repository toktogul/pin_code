package com.digital.demopincode.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digital.demopincode.PinCodeScreens
import com.digital.demopincode.R
import org.koin.android.ext.android.get
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

    private val holder = get<NavigatorHolder>()
    private val router = get<Router>()
    private val screens = get<PinCodeScreens>()
    private val navigator by lazy { SupportAppNavigator(this, R.id.root) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router.replaceScreen(screens.openCreatePinCodeScreen())
    }

    override fun onResume() {
        super.onResume()
        holder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        holder.removeNavigator()
    }
}
