package com.url.tinyurl.service

import com.url.tinyurl.entity.Redirect
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.url.tinyurl.repository.RedirectRepository
import java.util.*
import com.url.tinyurl.request.RecirectCreation
import javassist.NotFoundException

@Service
class RedirectService @Autowired
constructor(redirectRepository:RedirectRepository) {
    private val redirectRepository:RedirectRepository
    init {
        this.redirectRepository = redirectRepository
    }

     fun createRedirect(redirectCreation: RecirectCreation): Optional<Redirect>{
        if(redirectRepository.existsByAlias(redirectCreation.getAlias()))
            throw RuntimeException("Alias already exists")
        println("Redirection Request" + redirectCreation.toString())
        var redirect = redirectRepository.save(Redirect(redirectCreation.getAlias(), redirectCreation.getUrl()))
        println("Redirected to" + redirect)

        return Optional.ofNullable(redirect)
    }

    fun getRedirect(alias:String):Redirect {
        val redirect = redirectRepository.findByAlias(alias)
            .orElseThrow({ NotFoundException("Hey we don't have that alias ! Try making it") })
        return redirect
    }

}