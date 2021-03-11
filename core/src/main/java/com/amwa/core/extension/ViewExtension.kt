package com.amwa.core.extension

import android.view.View

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.setGone(isGone: Boolean) {
    this.visibility = if (isGone) View.GONE else View.VISIBLE
}