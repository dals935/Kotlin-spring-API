package com.ktlnspr.kotlinspring.service

import com.ktlnspr.kotlinspring.dto.AddPersonRequest
import com.ktlnspr.kotlinspring.dto.PersonRespose
import com.ktlnspr.kotlinspring.dto.UpdatePersonRequest

interface PersonManagementService {

    fun findById(id:Long): PersonRespose?
    fun findALl(): List<PersonRespose>
    fun save(addPersonRequest: AddPersonRequest): PersonRespose
    fun update(updatePersonRequest: UpdatePersonRequest): PersonRespose
    fun deleteById(id:Long)
}