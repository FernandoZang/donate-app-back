package com.sanem.donation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DonationApplication

fun main(args: Array<String>) {
	runApplication<DonationApplication>(*args)
}
