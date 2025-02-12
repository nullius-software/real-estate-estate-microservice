package com.nullius_real_estate.estate_microservice.controller

import com.nullius_real_estate.estate_microservice.entity.EstateEntity
import com.nullius_real_estate.estate_microservice.repository.EstateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/estate")
class EstateController {

    @Autowired
    lateinit var estateRepository: EstateRepository

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<EstateEntity> {
        return estateRepository.findAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createEstate(@RequestBody estateEntity: EstateEntity): EstateEntity {
        return estateRepository.save(estateEntity)
    }
}