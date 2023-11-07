package com.ktlnspr.kotlinspring.transformer

import com.ktlnspr.kotlinspring.domain.Person
import com.ktlnspr.kotlinspring.dto.PersonRespose

fun Person?.toPersonResponse(): PersonRespose {
    return PersonRespose(
        id = this?.id ?: 1L,
        fullName = "${this?.lastName}, ${this?.name}"
    )
}