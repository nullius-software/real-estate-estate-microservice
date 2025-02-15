package com.nullius_real_estate.estate_microservice.controller

import com.nullius_real_estate.estate_microservice.entity.EstateEntity
import com.nullius_real_estate.estate_microservice.repository.EstateRepository
import com.nullius_real_estate.estate_microservice.service.EstateService
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
    lateinit var estateService: EstateService

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<EstateEntity> {
        return estateService.getAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody estateEntity: EstateEntity): EstateEntity {
        return estateService.create(estateEntity)
    }
}