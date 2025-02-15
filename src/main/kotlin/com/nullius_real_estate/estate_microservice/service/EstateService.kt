package com.nullius_real_estate.estate_microservice.service

import com.nullius_real_estate.estate_microservice.entity.EstateEntity
import com.nullius_real_estate.estate_microservice.repository.EstateRepository
import org.springframework.stereotype.Service

@Service
class EstateService(val estateRepository: EstateRepository) {

    fun getAll(): List<EstateEntity> {
        return estateRepository.findAll()
    }

    fun create(estateEntity: EstateEntity): EstateEntity {
        return estateRepository.save(estateEntity)
    }
}