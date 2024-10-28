package com.example.demo.controller.company

import com.example.demo.service.company.CompanyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/company")
internal class CompanyController(private val companyService: CompanyService) {

    @GetMapping("/{inn}/{region}/{capital}")
    fun getCompanyName(
        @PathVariable inn: String,
        @PathVariable region: Int,
        @PathVariable capital: Int
    ): Boolean {
        return companyService.isCompanyValid(inn, region, capital)
    }
}