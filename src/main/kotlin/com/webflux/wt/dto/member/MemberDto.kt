package com.webflux.wt.dto.member

import com.webflux.wt.domain.member.Member
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class MemberDto(
    private val id: Long,
    private val name: String,
    private val age: Int,
    private val createdAt: LocalDateTime
) {
    data class Res(
        val id: Long?,
        val age: Int,
        val name: String,
    ) {
        companion object {
            fun of(member: Member): Res {
                return Res(
                    id = member.id,
                    name = member.name,
                    age = member.age
                )
            }
        }
    }

    data class Req(
        @get:Size(min = 3, max = 20)
        val name: String,
        @get:DecimalMin("6", message = "age can not be lower then 6")
        val age: Int
    )
}