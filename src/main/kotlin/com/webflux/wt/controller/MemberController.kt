package com.webflux.wt.controller

import com.webflux.wt.dto.member.MemberDto
import com.webflux.wt.service.member.MemberService
import jakarta.validation.Valid
import mu.KotlinLogging
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Suppress("unused")
val log = KotlinLogging.logger { }

@RestController
class MemberController(
    private val memberService: MemberService,
) {

    @GetMapping("/members/{memberName}")
    fun findMemberByName(@PathVariable memberName: String): Mono<MemberDto.Res> {
        return memberService.findMemberByName(memberName)
    }

    @GetMapping("/members")
    fun findMembers(): Flux<MemberDto.Res> {
        return memberService.findMembers()
    }

    @PostMapping("/members")
    fun saveMember(@Valid @RequestBody request: MemberDto.Req): Mono<MemberDto.Res> {
        return memberService.saveMember(request)
    }
}