package com.msignoretto.coffeemachine

interface Grinder {

    /**
     * The beans tank has beans inside
     */
    fun hasCoffee(): Boolean

    /**
     * grind X grams of coffee beans
     * @param grams: grams of coffee beans to grind
     */
    fun grind(grams: Int)
}