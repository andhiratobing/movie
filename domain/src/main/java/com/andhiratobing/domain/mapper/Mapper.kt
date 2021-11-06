package com.andhiratobing.domain.mapper

interface Mapper<E, D> {

    fun mapFromEntityToDomain(type: E): D

    fun mapFromDomainToEntity(type: D): E

}