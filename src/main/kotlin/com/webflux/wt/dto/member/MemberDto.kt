package com.webflux.wt.dto.member

import com.webflux.wt.domain.member.Member
import java.time.LocalDateTime

data class MemberDto(
        private val id: Long,
        private val name: String,
        private val age: Int,
        private val createdAt: LocalDateTime
) {
    data class Res(
            val id: Long,
            val name: String
    ) {
        companion object {
            fun of(member: Member): Res {
                return Res(
                        id = member.id,
                        name = member.name
                )
            }
        }
    }
}