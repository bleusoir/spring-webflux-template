package com.webflux.wt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebfluxTemplateApp

fun main(args: Array<String>) {
    runApplication<WebfluxTemplateApp>(*args)
}