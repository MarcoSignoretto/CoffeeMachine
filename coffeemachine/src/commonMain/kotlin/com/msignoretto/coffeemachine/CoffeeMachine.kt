package com.msignoretto.coffeemachine

class CoffeeMachine(
    private val waterHeater: WaterHeater,
    private val waterPump: WaterPump,
    private val grinder: Grinder
) {

    /**
     * Make coffee if water is hot and grinder has beans
     */
    fun makeCoffee(): Result {
        if(!waterHeater.isWaterHot()) return Result.HEATING
        if(!grinder.hasCoffee()) return Result.NO_BEANS
        grinder.grind(5)
        waterPump.pump()
        return Result.SUCCESS
    }

    enum class Result{
        SUCCESS,
        HEATING,
        NO_BEANS
    }
}