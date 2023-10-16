package com.webflux.wt.domain.member

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface MemberRepository : R2dbcRepository<Member, Long> {

    fun findTopByName(memberName: String): Mono<Member>?
}