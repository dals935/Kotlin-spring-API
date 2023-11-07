package com.ktlnspr.kotlinspring.dto

data class AddPersonRequest(
    val name: String,
    val lastName: String? = null
)