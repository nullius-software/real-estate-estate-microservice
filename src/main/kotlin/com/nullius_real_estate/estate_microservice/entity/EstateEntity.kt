package com.nullius_real_estate.estate_microservice.entity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class EstateEntity (
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val price: Double,
)