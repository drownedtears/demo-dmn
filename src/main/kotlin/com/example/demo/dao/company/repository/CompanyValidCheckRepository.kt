package com.example.demo.dao.company.repository

import com.example.demo.dao.company.model.CompanyValidCheckDb
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyValidCheckRepository: JpaRepository<CompanyValidCheckDb, Long> {

}