package com.example.freeforlife.models

data class BlockRule(
    val appName: String,        //app,that will be blocked
    val packageName: String,    //packagename(ex. com.google.android.youtube) why needed?
    val startHour: Int,
    val startMinute: Int,
    val endHour: Int,
    val endMinute: Int
)
