package com.webflux.wt.domain.member

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime


@Table("member")
class Member(
         val name: String,
         val age: Int? = null,
         val createdAt: LocalDateTime = LocalDateTime.now(),
         val updatedAt: LocalDateTime? = null,
         @Id var id: Long? = null,
) {
    override fun toString(): String {
        return "id: $id, name: $name, age: $age, createdAt: $createdAt, updatedAt: $updatedAt"
    }
}