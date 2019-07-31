package com.github.daggerok.messages

import org.junit.jupiter.api.Test
import com.github.daggerok.messages.rest.Handlers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class SpringWebfluxGroovyApplicationTests extends Specification {

	@Autowired(required = false)
	Handlers handlers

	def "when context is loaded then all expected beans are created"() {
		expect: "Handlers bean is created"
			handlers
	}

	def "ololo trololo"() {
		given:
			int a = 1
		and:
			int b = 2
		when:
			int c = a + b
		then:
			c == 3
	}
	
	@Test
	void "troololo ololo"() {
		println 'this should be executed only with junit runnet...'
	}
}
