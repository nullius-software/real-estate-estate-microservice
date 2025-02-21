package com.nullius_real_estate.estate_microservice.service

import com.nullius_real_estate.estate_microservice.entity.EstateEntity
import com.nullius_real_estate.estate_microservice.repository.EstateRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.UUID


class EstateServiceTest {
    @Mock
    private lateinit var dataSource: EstateRepository
    private lateinit var estateService: EstateService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        estateService = EstateService(dataSource)
    }

    @Test
    fun getAll() {
        val estate1 = EstateEntity(UUID.randomUUID(), "depto 3 amb", 3000.0)
        val estate2 = EstateEntity(UUID.randomUUID(), "depto 2 amb", 2000.0)

        Mockito.`when`(dataSource.findAll()).thenReturn(listOf(estate1, estate2))

        val result = estateService.getAll()
        kotlin.test.assertEquals(2, result.size)
        kotlin.test.assertTrue(result.contains(estate1))
        kotlin.test.assertTrue(result.contains(estate2))
    }

    @Test
    fun create() {
        val estate = EstateEntity(UUID.randomUUID(), "depto 3 amb", 3000.0)

        Mockito.`when`(dataSource.save(estate)).thenReturn(estate)

        val result = estateService.create(estate)
        kotlin.test.assertEquals(estate, result)
    }
}