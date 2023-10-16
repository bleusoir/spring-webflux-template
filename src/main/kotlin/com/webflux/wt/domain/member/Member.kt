package com.webflux.wt.domain.member

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime


@Table("member")
class Member(
        @Id val id: Long,
         val name: String,
         val age: Int,
         val createdAt: LocalDateTime,
         val updatedAt: LocalDateTime? = null,
) {
    override fun toString(): String {
        return "id: $id, name: $name, age: $age, createdAt: $createdAt, updatedAt: $updatedAt"
    }
}