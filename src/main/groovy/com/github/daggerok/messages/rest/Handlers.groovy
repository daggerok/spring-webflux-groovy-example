package com.github.daggerok.messages.rest

import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Service
class Handlers {

    def messages = [:]

    def showInfo(def _) {
        def API = [
                info: "GET /api/v1/messages/info",
                add : "POST /api/v1/messages message={message}",
                read: "GET /api/v1/messages/{id}",
                all : "GET /api/v1/messages}",
        ]
        ServerResponse.ok().body(Mono.just(API), Map)
    }

    def addMessage(ServerRequest serverRequest) {
        def id = UUID.randomUUID()
        def url = serverRequest.uri().with { "$scheme//$authority/api/v1/messages/$id" }
        def response = serverRequest
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {})
                .map { it["message"] ?: "Hello!" }
                .doOnNext { messages[id] = it }
                .map {
                    [
                            id     : id,
                            message: messages[id],
                    ]
                }

        ServerResponse.created(URI.create(url)).body(response, Map)
    }

    def readMessage(ServerRequest serverRequest) {
        def uuid = serverRequest.pathVariable("id")
        def id = UUID.fromString(uuid)
        String message = messages[id]
        ServerResponse.ok().body(Mono.justOrEmpty(message), String)
    }

    def allMessages(def _) {
        //ServerResponse.ok().body(Flux.fromIterable(messages.entrySet()), Map.Entry)
        ServerResponse.ok().body(Mono.justOrEmpty(messages), Map)
    }
}
