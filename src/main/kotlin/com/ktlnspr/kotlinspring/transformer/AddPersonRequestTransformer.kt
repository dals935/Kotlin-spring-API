package com.ktlnspr.kotlinspring.transformer

import com.ktlnspr.kotlinspring.domain.Person
import com.ktlnspr.kotlinspring.dto.AddPersonRequest
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer: Transformer<AddPersonRequest, Person> {
    override fun transform(source: AddPersonRequest): Person {
        return Person(
            name = source.name,
            lastName = source.lastName
        )
    }
}