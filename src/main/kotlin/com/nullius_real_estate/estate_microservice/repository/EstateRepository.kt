package com.nullius_real_estate.estate_microservice.repository
import com.nullius_real_estate.estate_microservice.entity.EstateEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface EstateRepository : JpaRepository<EstateEntity, UUID> {}