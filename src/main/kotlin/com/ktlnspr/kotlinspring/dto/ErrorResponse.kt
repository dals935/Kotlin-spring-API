package com.ktlnspr.kotlinspring.dto

import java.time.LocalDateTime

data class ErrorResponse (
    val title: String = "Bad Request",
    val message: String,
    val dateTime: LocalDateTime = LocalDateTime.now()
)