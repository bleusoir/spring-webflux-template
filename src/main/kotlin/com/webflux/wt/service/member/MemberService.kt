package com.webflux.wt.service.member

import com.webflux.wt.domain.member.Member
import com.webflux.wt.domain.member.MemberRepository
import com.webflux.wt.dto.member.MemberDto
import mu.KotlinLogging
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.NOT_FOUND
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

    fun findMemberByName(name: String): Mono<MemberDto.Res> {
        return memberRepo.findTopByName(name).map(MemberDto.Res::of)
            .switchIfEmpty(Mono.error(ResponseStatusException(NOT_FOUND, "NOT FOUND MEMBER BY NAME :: $name")))
    }

    fun findMembers(): Flux<MemberDto.Res> {
        return memberRepo.findAll().map(MemberDto.Res::of)
            .switchIfEmpty(Flux.error(ResponseStatusException(NOT_FOUND, "NOT FOUND MEMBERS")))
    }

    @Transactional(rollbackFor = [Exception::class])
    fun saveMember(request: MemberDto.Req): Mono<MemberDto.Res> {
        val newMember = Member(request.name, request.age)
        return memberRepo.save(newMember).map(MemberDto.Res::of)
    }

    @Transactional(rollbackFor = [Exception::class])
    fun updateMember(memberId: Long, request: MemberDto.Req): Mono<MemberDto.Res> {
        return memberRepo.findById(memberId)
            .flatMap { m -> memberRepo.save(Member(id = m.id, name = request.name, age = request.age)) }
            .map(MemberDto.Res::of)
            .switchIfEmpty(Mono.error(ResponseStatusException(BAD_REQUEST, "BAD MEMBER ID :: $memberId")))
    }

    @Transactional(rollbackFor = [Exception::class])
    fun removeMember(memberId: Long): Mono<Void> {
        return memberRepo.findById(memberId)
            .switchIfEmpty(Mono.error(ResponseStatusException(NOT_FOUND, "NOT FOUND MEMBER ID :: $memberId")))
            .flatMap { memberRepo.deleteById(it.id!!) }
    }
}