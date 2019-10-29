package com.lesniak.resumeapp.util

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBindings {

    @JvmStatic
    @BindingAdapter("hide")
    fun hide(view: View, hide: Boolean) {
        view.visibility = if (hide) View.GONE else View.VISIBLE
    }
}