package com.chenfengweiqing.chat.entity

class AppInfo {
    var title: String? = null
    var artist: String? = null
    var appName: String? = null
    var dataUrl: String? = null

    constructor(title: String?, artist: String?, appName: String?, dataUrl: String?) {
        this.title = title
        this.artist = artist
        this.appName = appName
        this.dataUrl = dataUrl
    }
}