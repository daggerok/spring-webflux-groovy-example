# Spring Webflux Groovy Sample [![Build Status](https://travis-ci.org/daggerok/spring-webflux-groovy-example.svg?branch=master)](https://travis-ci.org/daggerok/spring-webflux-groovy-example)
spring-boot, spring-webflux using dynamic groovy

```bash
./gradlew bootRun

http :8080/api/v1/messages message=hello
http :8080/api/v1/messages message=world
http :8080/api/v1/messages
http :8080
```

[NOTE]

For better developer experience during testing, use idea cURL integration tests from `rest-client*` files. Read more: https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html

