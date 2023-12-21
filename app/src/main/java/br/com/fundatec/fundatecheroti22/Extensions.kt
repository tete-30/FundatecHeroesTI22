package br.com.fundatec.fundatecheroti22

import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun Context.showSnackBar(
    view: View,
    @StringRes snackbarMessage: Int,
    @ColorRes colorBackground: Int,
    duration: Int = Snackbar.LENGTH_SHORT
) {
    val snackBar = Snackbar.make(
        view,
        snackbarMessage,
        duration
    ).setBackgroundTint(ContextCompat.getColor(this, colorBackground)).show()
}