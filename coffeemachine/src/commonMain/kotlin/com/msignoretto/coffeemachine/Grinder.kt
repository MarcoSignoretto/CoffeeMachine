package com.msignoretto.coffeemachine

interface Grinder {

    /**
     * The beans tank has beans inside
     */
    fun hasCoffee(): Boolean

    /**
     * grind beans for the coffee
     */
    fun grind()
}