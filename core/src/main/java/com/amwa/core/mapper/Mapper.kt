package com.amwa.core.mapper

interface DomainMapper<E, D> {
    fun mapToDomain(type: E): D
}

interface EntityMapper<E, D> {
    fun mapToEntity(type: E): D
}