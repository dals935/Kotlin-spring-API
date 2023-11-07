package com.ktlnspr.kotlinspring.transformer

interface Transformer<A, B> {
    fun transform(source: A): B
}