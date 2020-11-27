package com.example.architecture_module.utils

import android.content.res.Resources
import android.util.TypedValue


val <T> T.exhaustive: T
    get() = this

val Int.dp: Int get() =
    TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()