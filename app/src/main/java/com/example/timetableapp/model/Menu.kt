package com.example.timetableapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Menu (
    @StringRes val title: Int,
    @StringRes val description: Int,
    @StringRes val click: Int,
    @DrawableRes val image: Int
        )