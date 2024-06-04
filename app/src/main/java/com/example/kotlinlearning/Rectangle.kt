package com.example.kotlinlearning

import kotlinx.serialization.Serializable

@Serializable
data class Rectangle(val color: String, val heading: String, val content: String)
