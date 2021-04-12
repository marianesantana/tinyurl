package com.url.tinyurl.request

import javax.validation.constraints.NotNull

class RecirectCreation(alias:String, url:String)  {

    @NotNull
    private var url: String = ""

    @NotNull
    private var alias: String = ""

    init {
        this.alias = alias
        this.url = url
    }

    fun getAlias():String {
        return alias
    }
    fun getUrl():String {
        return url
    }

    override fun toString():String {
        return ("RedirectCreation{" +
                "alias='" + alias + '\''.toString() +
                ", url='" + url + '\''.toString() +
                '}'.toString())
    }

}