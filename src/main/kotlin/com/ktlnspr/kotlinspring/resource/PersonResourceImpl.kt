package com.ktlnspr.kotlinspring.resource

import com.ktlnspr.kotlinspring.dto.AddPersonRequest
import com.ktlnspr.kotlinspring.dto.PersonRespose
import com.ktlnspr.kotlinspring.dto.UpdatePersonRequest
import com.ktlnspr.kotlinspring.resource.PersonResourceImpl.Companion.BASE_PERSON_URL
import com.ktlnspr.kotlinspring.service.PersonManagementService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class PersonResourceImpl(private val personManagementService: PersonManagementService) : PersonResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<PersonRespose?> {
        val personRespose: PersonRespose? = this.personManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(personRespose)
    }

    @GetMapping
    override fun findALl(): ResponseEntity<List<PersonRespose>> = ResponseEntity.ok(this.personManagementService.findALl())

    @PostMapping
    override fun save(@RequestBody addPersonRequest: AddPersonRequest): ResponseEntity<PersonRespose> {
        val personRespose = this.personManagementService.save(addPersonRequest)
        return ResponseEntity
            .created(URI.create(BASE_PERSON_URL.plus("/${personRespose.id}")))
            .body(personRespose)
    }

    @PutMapping
    override fun update(@RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonRespose> {
        return ResponseEntity.ok(this.personManagementService.update(updatePersonRequest))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.personManagementService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object{
        const val BASE_PERSON_URL: String = "/api/v1/person"
    }
}