package com.example.demo.configuration.dmn

import org.camunda.bpm.dmn.engine.DmnEngine
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DmnConfiguration {
    @Bean
    fun dmnEngine(): DmnEngine {
        return DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine()
    }
}