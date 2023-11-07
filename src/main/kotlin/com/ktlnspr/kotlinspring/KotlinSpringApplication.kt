package com.ktlnspr.kotlinspring

import com.ktlnspr.kotlinspring.domain.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class KotlinSpringApplication{

	@GetMapping
	fun hi(): Person {
		return Person(lastName = "Bryant", name = "Kobe")
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinSpringApplication>(*args)
}
