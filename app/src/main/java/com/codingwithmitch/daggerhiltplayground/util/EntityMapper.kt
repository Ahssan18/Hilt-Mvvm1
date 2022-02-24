package com.codingwithmitch.daggerhiltplayground.util

interface EntityMapper<Entity,DomainModel> {
    fun mapTOEntity(domainModel: DomainModel):Entity
    fun mapFromEntity(entity: Entity):DomainModel

}