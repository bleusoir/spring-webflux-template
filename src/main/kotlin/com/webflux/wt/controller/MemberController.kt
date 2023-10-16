package com.webflux.wt.controller

import com.webflux.wt.dto.member.MemberDto
import com.webflux.wt.service.member.MemberService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

val log = KotlinLogging.logger { }

@RestController
class MemberController(
        private val memberService: MemberService,
) {

    @GetMapping("/members/{memberName}")
    fun findMemberByName(@PathVariable memberName: String): Mono<MemberDto.Res> {
        log.info { "encountered /members/$memberName" }
        return memberService.findMemberByName(memberName)
    }

    @GetMapping("/members")
    fun findMembers(): Flux<MemberDto.Res> {
        log.info { "encountered /members" }
        return memberService.findMembers()
    }
}