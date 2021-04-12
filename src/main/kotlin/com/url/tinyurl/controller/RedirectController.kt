package com.url.tinyurl.controller

import com.url.tinyurl.entity.Redirect
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid
import com.url.tinyurl.request.RecirectCreation
import com.url.tinyurl.service.RedirectService
import org.springframework.beans.factory.annotation.Autowired
import java.net.URISyntaxException
import kotlin.jvm.Throws

@RestController
class RedirectController @Autowired
constructor(redirectService:RedirectService) {
    private val redirectService: RedirectService = redirectService

    @GetMapping("/{alias}")
    @Throws(URISyntaxException::class)
    fun handleRedirect(@PathVariable alias: String?): ResponseEntity<*>? {
        val redirect = alias?.let { redirectService.getRedirect(it) }
        println("We're redirecting here!" + redirect)
        val uri = URI(redirect?.getUrl())
        val httpHeaders = HttpHeaders()
        httpHeaders.setLocation(uri)
        return ResponseEntity<Any>(
            httpHeaders, HttpStatus.MOVED_PERMANENTLY
        )
    }

    @PostMapping("/")
    fun createRedirect(@Valid @RequestBody redirectCreation: RecirectCreation): ResponseEntity<*> {
        return ResponseEntity.ok(redirectService.createRedirect(redirectCreation))
    }

}