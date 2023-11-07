package com.ktlnspr.kotlinspring.service

import com.ktlnspr.kotlinspring.dao.PersonDao
import com.ktlnspr.kotlinspring.domain.Person
import com.ktlnspr.kotlinspring.dto.AddPersonRequest
import com.ktlnspr.kotlinspring.dto.PersonRespose
import com.ktlnspr.kotlinspring.dto.UpdatePersonRequest
import com.ktlnspr.kotlinspring.transformer.AddPersonRequestTransformer
import com.ktlnspr.kotlinspring.transformer.toPersonResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonManagementServiceImpl(
    private val personDao: PersonDao,
    private val addPersonRequestTransformer: AddPersonRequestTransformer) : PersonManagementService {

    override fun findById(id: Long): PersonRespose? = this.findPersonById(id).toPersonResponse()

    override fun findALl(): List<PersonRespose>  = this.personDao.findAll().map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonRespose {
        return this.saveOrUpdate(
            addPersonRequestTransformer.transform(addPersonRequest)
        )
    }
    override fun update(updatePersonRequest: UpdatePersonRequest): PersonRespose {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalAccessException("${updatePersonRequest.id} not found")

        return this.saveOrUpdate(person.apply {
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteById(id: Long) {
        this.personDao.deleteById(id)
    }

    private fun findPersonById(id: Long): Person? = this.personDao.findByIdOrNull(id)

    private fun saveOrUpdate(person: Person): PersonRespose = this.personDao.save(person).toPersonResponse()
}