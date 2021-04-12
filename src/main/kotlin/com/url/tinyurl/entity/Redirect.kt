package com.url.tinyurl.entity

import org.hibernate.annotations.NaturalId
import javax.persistence.Column
import javax.persistence.Entity;
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotNull


@Entity
class Redirect(alias:String, url:String) {

    @Id
    @GeneratedValue
    private var id:Long = 0

    @NaturalId
    @Column(unique = true, nullable = false)
    @NotNull
    private var alias:String = ""

    @Column(nullable = false)
    @NotNull
    private var url: String = "";

    init {
        this.alias = alias
        this.url = url
    }

    fun getId():Long {
        return id
    }
    fun setId(id:Long) {
        this.id = id
    }
    fun getAlias():String {
        return alias
    }
    fun setAlias(alias:String) {
        this.alias = alias
    }
    fun getUrl():String {
        return url
    }
    fun setUrl(url:String) {
        this.url = url
    }

    override fun toString():String {
        return ("RedirectCreation{" +
                "alias='" + alias + '\''.toString() +
                ", url='" + url + '\''.toString() +
                '}'.toString())
    }


}