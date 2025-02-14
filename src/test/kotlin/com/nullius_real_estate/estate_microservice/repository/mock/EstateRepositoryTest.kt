package com.nullius_real_estate.estate_microservice.repository.mock

import com.nullius_real_estate.estate_microservice.entity.EstateEntity
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.*

class EstateRepositoryTest {
    private val mockEstateRepository = MockEstateRepository()

    @Test
    fun `should create an Estate`() {
        val estate = EstateEntity(UUID.randomUUID(), "depto 3 amb", 3000.0)
        val savedEstate = mockEstateRepository.save(estate)
        assertNotNull(savedEstate)
        assertEquals(estate, savedEstate)
    }

    @Test
    fun `should provide a collection of estates`() {
        val estateList = mockEstateRepository.findAll()
        assertNotNull(estateList)
        assertTrue(estateList.isEmpty())
    }

    @Test
    fun `should find all estates ordered by price asc`() {
        val estate1 = EstateEntity(UUID.randomUUID(), "depto 3 amb", 3000.0)
        val estate2 = EstateEntity(UUID.randomUUID(), "depto 2 amb", 2000.0)
        val estate3 = EstateEntity(UUID.randomUUID(), "depto 4 amb", 4000.0)

        // Assume mockEstateRepository is already populated with estate1, estate2, estate3
        mockEstateRepository.save(estate1)
        mockEstateRepository.save(estate2)
        mockEstateRepository.save(estate3)

        val sort = Sort.by(Sort.Order.asc("price"))
        val matchingEstates = mockEstateRepository.findAll(sort)

        assertNotNull(matchingEstates)
        assertEquals(3, matchingEstates.size)
        assertEquals(2000.0, matchingEstates[0].price)
        assertEquals(3000.0, matchingEstates[1].price)
        assertEquals(4000.0, matchingEstates[2].price)
    }

    @Test
    fun `should find all estates with pagination`() {
        val estate1 = EstateEntity(UUID.randomUUID(), "depto 3 amb", 3000.0)
        val estate2 = EstateEntity(UUID.randomUUID(), "depto 2 amb", 2000.0)
        val estate3 = EstateEntity(UUID.randomUUID(), "depto 4 amb", 4000.0)

        // Assume mockEstateRepository is already populated with estate1, estate2, estate3
        mockEstateRepository.save(estate1)
        mockEstateRepository.save(estate2)
        mockEstateRepository.save(estate3)

        val pageable = PageRequest.of(0, 2)
        val page = mockEstateRepository.findAll(pageable)

        assertNotNull(page)
        assertEquals(2, page.content.size)
        assertEquals(3, page.totalElements)
        assertTrue(page.content.containsAll(listOf(estate1, estate2)))
    }


    @Test
    fun `should find all estates that match a given example`() {
        val estate1 = EstateEntity(UUID.randomUUID(), "depto 3 amb", 3000.0)
        val estate2 = EstateEntity(UUID.randomUUID(), "depto 2 amb", 2000.0)
        val estate3 = EstateEntity(UUID.randomUUID(), "depto 4 amb", 4000.0)

        // Assume mockEstateRepository is already populated with estate1, estate2, estate3
        mockEstateRepository.save(estate1)
        mockEstateRepository.save(estate2)
        mockEstateRepository.save(estate3)

        val example = Example.of(estate1)
        val matchingEstates = mockEstateRepository.findAll(example)

        assertNotNull(matchingEstates)
        assertEquals(1, matchingEstates.size)
        assertEquals("depto 3 amb", matchingEstates[0].name)
        assertEquals(3000.0, matchingEstates[0].price)
    }

    @Test
    fun `should find all estates that match a given example and are sorted by price`() {
        val estate1 = EstateEntity(UUID.randomUUID(), "depto 3 amb", 3000.0)
        val estate2 = EstateEntity(UUID.randomUUID(), "depto 2 amb", 2000.0)
        val estate3 = EstateEntity(UUID.randomUUID(), "depto 4 amb", 4000.0)

        // Assume mockEstateRepository is already populated with estate1, estate2, estate3
        mockEstateRepository.save(estate1)
        mockEstateRepository.save(estate2)
        mockEstateRepository.save(estate3)

        val example = Example.of(estate1)
        val sort = Sort.by(Sort.Order.asc("price"))
        val matchingEstates = mockEstateRepository.findAll(example, sort)

        assertNotNull(matchingEstates)
        assertEquals(1, matchingEstates.size)
        assertEquals("depto 3 amb", matchingEstates[0].name)
        assertEquals(3000.0, matchingEstates[0].price)
    }

    @Test
    fun `should find all estates that match a given example with pagination`() {
        val estate1 = EstateEntity(UUID.randomUUID(), "depto 3 amb", 3000.0)
        val estate2 = EstateEntity(UUID.randomUUID(), "depto 2 amb", 2000.0)
        val estate3 = EstateEntity(UUID.randomUUID(), "depto 4 amb", 3000.0)

        // Assume mockEstateRepository is already populated with estate1, estate2, estate3
        mockEstateRepository.save(estate1)
        mockEstateRepository.save(estate2)
        mockEstateRepository.save(estate3)

        val example = Example.of(estate1)
        val pageable = PageRequest.of(0, 1)
        val page = mockEstateRepository.findAll(example, pageable)

        assertNotNull(page)
        assertEquals(1, page.content.size)
        assertEquals(1, page.totalElements)
        assertTrue(page.content.contains(estate1))
    }
}