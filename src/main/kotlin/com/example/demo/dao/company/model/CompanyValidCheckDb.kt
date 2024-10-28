package com.example.demo.dao.company.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "company_valid_check")
data class CompanyValidCheckDb(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    @Column(name = "check_result")
    private val checkResult: Boolean = false,

    @Column(name = "check_time", nullable = false)
    private val checkTime: LocalDateTime = LocalDateTime.now(),

    @Column(name = "inn", nullable = false)
    private val inn: String = "",

    @Column(name = "capital", nullable = false)
    private val capital: Int = 0,

    @Column(name = "region", nullable = false)
    private val region: Int = 0
)