package com.sanem.donation.jobs

import com.sanem.donation.domain.repository.CidadeRepository
import mu.KotlinLogging
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Scheduler(
    var cidadeRepository: CidadeRepository
) {

    private val logger = KotlinLogging.logger {}

    @Scheduled(cron = "\${schedule.keep-app-running.cron}")
    fun keepAlive() {
        logger.info { "m=keepAlive - Start: Keeping App Alive" }
        try {
            cidadeRepository.findById(1)
        } catch (e: Exception) {
            logger.error { "m=keepAlive - ERROR: Keeping App Alive ${e.message}" }
        }

        logger.info { "m=keepAlive - End: Keeping App Alive" }
    }
}
