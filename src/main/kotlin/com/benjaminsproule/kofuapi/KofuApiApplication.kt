package com.benjaminsproule.kofuapi

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.Micronaut.build


@Controller
class SampleController {

    @Get("/", produces = [MediaType.TEXT_PLAIN])
    fun packagesWithLowLevelClient() = "Hello, world!"
}

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("com.benjaminsproule.kofuapi")
        .start()
}
