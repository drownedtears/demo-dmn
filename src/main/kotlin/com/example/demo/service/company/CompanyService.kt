package com.example.demo.service.company

import com.example.demo.dao.company.model.CompanyValidCheckDb
import com.example.demo.dao.company.repository.CompanyValidCheckRepository
import org.camunda.bpm.dmn.engine.DmnEngine
import org.camunda.bpm.engine.variable.Variables.putValue
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import java.io.InputStream
import java.math.BigDecimal


internal interface CompanyService {
    fun isCompanyValid(inn: String, region: Int, capital: Int): Boolean
}

@Service
internal class CompanyServiceImpl(private val dmnEngine: DmnEngine, private val companyValidCheckRepository: CompanyValidCheckRepository): CompanyService {

    @Value("classpath:dmn/company.dmn11.xml")
    lateinit var dmnResource: Resource

    override fun isCompanyValid(
        inn: String,
        region: Int,
        capital: Int
    ): Boolean {
        val dmnModel: InputStream = dmnResource.inputStream
        val decision = dmnEngine.parseDecision("companyDecision", dmnModel)
        val decisionVariables = putValue("region", region)
            .putValue("capital", capital)
            .putValue("inn", inn)
            .putValue("innSuffix", inn.takeLast(4))
        val result = dmnEngine.evaluateDecision(decision, decisionVariables).singleResult?.getSingleEntry() ?: false
        saveResult(result, inn, region, capital)
        return result
    }

    private fun saveResult(result: Boolean, inn: String, region: Int, capital: Int) {
        companyValidCheckRepository.save(
            CompanyValidCheckDb(
                checkResult = result,
                inn = inn,
                region = region,
                capital = capital
            )
        )
    }
}