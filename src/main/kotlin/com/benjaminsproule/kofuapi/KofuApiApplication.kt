package com.benjaminsproule.kofuapi

import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.boot.logging.LogLevel
import org.springframework.fu.kofu.reactiveWebApplication
import org.springframework.fu.kofu.webflux.webFlux

val app = reactiveWebApplication {
    logging {
        level = LogLevel.DEBUG
    }
    beans {
        bean<SampleService>()
    }
    webFlux {
        port = if (profiles.contains("test")) 8181 else 8080
        coRouter {
            val service = ref<SampleService>()
            GET("/") {
                ok().bodyValue(service.generateMessage()).awaitFirst()!!
            }
        }
        codecs {
            string()
            jackson {
                indentOutput = true
            }
        }
    }
}

class SampleService {
    fun generateMessage() = "Hello, world!"
}

fun main() {
    app.run()
}
