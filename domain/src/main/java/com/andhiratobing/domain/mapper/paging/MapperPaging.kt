package com.andhiratobing.domain.mapper.paging

interface MapperPaging<E, D> {

    fun mapFromEntityToDomain(type: E): D

    fun mapFromDomainToEntity(type: D): E
}