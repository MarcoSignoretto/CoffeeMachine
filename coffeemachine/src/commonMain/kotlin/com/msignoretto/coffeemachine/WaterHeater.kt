package com.msignoretto.coffeemachine

interface WaterHeater {
    /**
     * This function will return true if the water is hot enough for the coffee
     */
    fun isWaterHot(): Boolean
}