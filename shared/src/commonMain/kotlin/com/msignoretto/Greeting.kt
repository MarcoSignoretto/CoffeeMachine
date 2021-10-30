package com.msignoretto

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}