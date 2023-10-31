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

@RequestMapping("/members")
@RestController
class MemberController(
    private val memberService: MemberService,
) {

    @GetMapping("/{memberName}")
    fun findMemberByName(@PathVariable memberName: String): Mono<MemberDto.Res> {
        return memberService.findMemberByName(memberName)
    }

    @GetMapping
    fun findMembers(): Flux<MemberDto.Res> {
        return memberService.findMembers()
    }

    @PostMapping
    fun saveMember(@Valid @RequestBody request: MemberDto.Req): Mono<MemberDto.Res> {
        return memberService.saveMember(request)
    }

    @PutMapping("/{memberId}")
    fun updateMemberById(
        @Valid @RequestBody request: MemberDto.Req,
        @PathVariable memberId: Long
    ): Mono<MemberDto.Res> {
        return memberService.updateMember(memberId, request)
    }
}