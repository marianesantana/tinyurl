package com.url.tinyurl.repository

import com.url.tinyurl.entity.Redirect
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional


@Repository
 interface RedirectRepository: JpaRepository<Redirect, Long>{
    fun findByAlias(alias: String): Optional<Redirect>
    fun existsByAlias(alias: String): Boolean
}