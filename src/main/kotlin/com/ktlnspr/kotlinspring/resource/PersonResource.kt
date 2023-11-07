package com.ktlnspr.kotlinspring.resource

import com.ktlnspr.kotlinspring.dto.AddPersonRequest
import com.ktlnspr.kotlinspring.dto.PersonRespose
import com.ktlnspr.kotlinspring.dto.UpdatePersonRequest
import org.springframework.http.ResponseEntity

interface PersonResource {
    fun findById(id:Long): ResponseEntity<PersonRespose?>
    fun findALl(): ResponseEntity<List<PersonRespose>>
    fun save(addPersonRequest: AddPersonRequest): ResponseEntity<PersonRespose>
    fun update(updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonRespose>
    fun deleteById(id:Long): ResponseEntity<Unit>
}