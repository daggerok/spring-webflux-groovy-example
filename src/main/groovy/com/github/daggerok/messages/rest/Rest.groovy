package com.github.daggerok.messages.rest

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunctions

import static org.springframework.web.reactive.function.server.RequestPredicates.path

@Configuration
class Rest {

    //@org.springframework.beans.factory.annotation.Autowired
    Handlers handlers

    Rest(Handlers h) {
        handlers = h
    }

    @Bean
    def routes() {
        RouterFunctions.route()
                .GET("/api/v1/messages/info", { handlers.showInfo(it) })
                .GET("/api/v1/messages/{id}", { handlers.readMessage(it) })
                .POST("/api/v1/messages", { handlers.addMessage(it) })
                .GET("/api/v1/messages", { handlers.allMessages(it) })
                .build()
                .andRoute(path("/**"), { handlers.showInfo(it) })
    }
}
