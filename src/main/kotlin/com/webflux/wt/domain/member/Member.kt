package com.webflux.wt.domain.member

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.time.LocalDateTime.now


@Table("member")
class Member(
    val name: String,
    val age: Int,
    @CreatedDate var createdAt: LocalDateTime = now(),
    @LastModifiedDate var updatedAt: LocalDateTime? = null,
    @Id var id: Long? = null,
) {

    override fun toString(): String {
        return "id: $id, name: $name, age: $age, createdAt: $createdAt, updatedAt: $updatedAt"
    }
}