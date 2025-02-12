package com.nullius_real_estate.estate_microservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EstateMicroserviceApplication

fun main(args: Array<String>) {
	runApplication<EstateMicroserviceApplication>(*args)
}
