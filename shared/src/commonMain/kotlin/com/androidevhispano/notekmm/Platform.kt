package com.androidevhispano.notekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform