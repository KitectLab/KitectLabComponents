package io.github.kitectlab.components

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform