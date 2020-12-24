package com.benjaminsproule.kofuapi

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.Micronaut.*


@Controller
class SampleController {

    @Get("/")
    fun packagesWithLowLevelClient() = "Hello, world!"
}

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("com.benjaminsproule.kofuapi")
        .start()
}
