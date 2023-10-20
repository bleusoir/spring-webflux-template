package com.webflux.wt.service.member

import com.webflux.wt.domain.member.MemberRepository
import com.webflux.wt.dto.member.MemberDto
import mu.KotlinLogging
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Suppress("unused")
val log = KotlinLogging.logger { }

@Service
@Transactional(rollbackFor = [Exception::class], readOnly = true)
class MemberService(private val memberRepo: MemberRepository) {

    @Transactional(rollbackFor = [Exception::class], readOnly = true)
    fun findMemberByName(name: String): Mono<MemberDto.Res> {

        return memberRepo.findTopByName(name).map(MemberDto.Res::of)
            .switchIfEmpty(
                Mono.error(
                    ResponseStatusException(
                        HttpStatusCode.valueOf(404),
                        "NOT FOUND MEMBER BY NAME :: $name"
                    )
                )
            )
    }

    @Transactional(rollbackFor = [Exception::class], readOnly = true)
    fun findMembers(): Flux<MemberDto.Res> {
        return memberRepo.findAll().map(MemberDto.Res::of)
            .switchIfEmpty(Flux.error(ResponseStatusException(HttpStatusCode.valueOf(404), "NOT FOUND MEMBERS")))
    }
}