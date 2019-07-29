package com.digital.demopincode.ui

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract fun onBackPressed()
}