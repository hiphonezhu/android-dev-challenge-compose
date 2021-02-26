package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes

/**
 * @author hyvenzhu
 * @version 2021-02-25
 */
data class Dog(
    val name: String,
    @DrawableRes val avatar: Int,
    val desc: String
)