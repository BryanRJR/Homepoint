package com.synrgy.homepoint.ui.payment

import android.opengl.Visibility

data class Order (
    var totalOrder: String = "",
    var productOrder: String = "",
    var priceOrder: String = "",
    var visibility: Boolean = false
)