package com.nullius_real_estate.estate_microservice.repository.mock

import com.nullius_real_estate.estate_microservice.entity.EstateEntity
import com.nullius_real_estate.estate_microservice.repository.EstateRepository
import org.apache.tomcat.util.file.Matcher
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import org.springframework.stereotype.Repository
import java.util.*
import java.util.function.Function

@Repository
class MockEstateRepository: EstateRepository {

    private val estatesList = mutableListOf<EstateEntity>()

    override fun <S : EstateEntity?> save(entity: S & Any): S & Any {
        estatesList.add(entity as EstateEntity)
        return entity
    }

    override fun <S : EstateEntity?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Optional<EstateEntity> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<EstateEntity> {
        return estatesList
    }

    override fun findAll(sort: Sort): MutableList<EstateEntity> {
        val comparator = sort.map { order ->
            val property = order.property
            val direction = if (order.isAscending) 1 else -1
            Comparator<EstateEntity> { a, b ->
                when (property) {
                    "price" -> direction * a.price.compareTo(b.price)
                    else -> 0
                }
            }
        }.reduce { acc, comparator -> acc.thenComparing(comparator) }

        return estatesList.sortedWith(comparator).toMutableList()
    }

    override fun findAll(pageable: Pageable): Page<EstateEntity> {
        val start = pageable.offset.toInt()
        val end = (start + pageable.pageSize).coerceAtMost(estatesList.size)
        val pageContent = estatesList.subList(start, end)
        return PageImpl(pageContent, pageable, estatesList.size.toLong())
    }

    override fun <S : EstateEntity> findAll(example: Example<S>): MutableList<S> {
        val results = estatesList.filter {
            it == example.probe
        }.toMutableList() as MutableList<S>
        return results
    }

    override fun <S : EstateEntity?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        val comparator = sort.map { order ->
            val property = order.property
            val direction = if (order.isAscending) 1 else -1
            Comparator<EstateEntity> { a, b ->
                when (property) {
                    "price" -> direction * a.price.compareTo(b.price)
                    else -> 0
                }
            }
        }.reduce { acc, comparator -> acc.thenComparing(comparator) }

        val results = estatesList.filter {
            it == example.probe
        }.sortedWith(comparator).toMutableList() as MutableList<S>
        return results
    }

    override fun <S : EstateEntity?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        val filteredList = estatesList.filter { it == example.probe } as MutableList<S>
        val start = pageable.offset.toInt()
        val end = (start + pageable.pageSize).coerceAtMost(estatesList.size)
        val pageContent = filteredList.subList(start, end)
        return PageImpl(pageContent, pageable, filteredList.size.toLong())
    }

    override fun findAllById(ids: MutableIterable<UUID>): MutableList<EstateEntity> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : EstateEntity?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: EstateEntity) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<UUID>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<EstateEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : EstateEntity?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : EstateEntity?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : EstateEntity?, R : Any?> findBy(
        example: Example<S>,
        queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>
    ): R & Any {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun <S : EstateEntity?> saveAndFlush(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : EstateEntity?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch(entities: MutableIterable<EstateEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun deleteAllByIdInBatch(ids: MutableIterable<UUID>) {
        TODO("Not yet implemented")
    }

    @Deprecated("Deprecated in Java")
    override fun getOne(id: UUID): EstateEntity {
        TODO("Not yet implemented")
    }

    @Deprecated("Deprecated in Java")
    override fun getById(id: UUID): EstateEntity {
        TODO("Not yet implemented")
    }

    override fun getReferenceById(id: UUID): EstateEntity {
        TODO("Not yet implemented")
    }
}