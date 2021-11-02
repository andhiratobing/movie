package com.andhiratobing.movieapp.domain.mapper

interface Mapper<E, D> {

    fun mapFromEntityToDomain(type: E): D

    fun mapFromDomainToEntity(type: D): E

}