package com.thejerryuc.wordsmith

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WordsmithApplication

fun main(args: Array<String>) {
	runApplication<WordsmithApplication>(*args)
}
