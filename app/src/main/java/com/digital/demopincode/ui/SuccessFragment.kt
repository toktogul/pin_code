package com.digital.demopincode.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.digital.demopincode.R
import kotlinx.android.synthetic.main.success_fragment.*
import org.koin.android.ext.android.get
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SuccessFragment : BaseFragment() {
    private val router = get<Router>()

    override fun onBackPressed() = router.exit()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.success_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ok.setOnClickListener {
            router.exit()
        }
    }
}


class SuccessScreen : SupportAppScreen() {
    override fun getFragment() = SuccessFragment()
}