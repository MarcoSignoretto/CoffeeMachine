package com.msignoretto.coffeemachine

import com.careem.mockingbird.test.any
import com.careem.mockingbird.test.every
import com.careem.mockingbird.test.verify
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CoffeeMachineTest {

    private val grinderMock = GrinderMock()
    private val waterHeaterMock = WaterHeaterMock()
    private val waterPumpMock = WaterPumpMock()

    private lateinit var coffeeMachine: CoffeeMachine

    @BeforeTest
    fun setUp(){
        coffeeMachine = CoffeeMachine(
            grinder = grinderMock,
            waterHeater = waterHeaterMock,
            waterPump = waterPumpMock
        )
    }

    @Test
    fun testTwoPlusTwoIsFour(){
        assertEquals(4, 2+2)
    }

    @Test
    fun givenColdWaterWhenMakeCoffeeThenResultWarming(){
        waterHeaterMock.every(
            methodName = WaterHeaterMock.Method.isWaterHot
        ){ false }

        val result = coffeeMachine.makeCoffee()

        assertEquals(CoffeeMachine.Result.HEATING, result)
    }

    @Test
    fun givenColdWaterWhenMakeCoffeeThenGrinderAndPumpNotActivated(){
        waterHeaterMock.every(
            methodName = WaterHeaterMock.Method.isWaterHot
        ){ false }

        coffeeMachine.makeCoffee()

        grinderMock.verify(
            exactly = 0,
            methodName = GrinderMock.Method.grind,
            arguments = mapOf(
                GrinderMock.Arg.grams to any()
            )
        )
        waterPumpMock.verify(
            exactly = 0,
            methodName = WaterPumpMock.Method.pump
        )
    }

    @Test
    fun givenWarmWaterButNoBeansWhenMakeCoffeeThenResultNoBeans(){

    }

    @Test
    fun givenWarmWaterAndBeansWhenMakeCoffeeThenResultSuccess(){

    }

    @Test
    fun givenWarmWaterAndBeansWhenMakeCoffeeThenGrindAndPump(){
        waterHeaterMock.every(
            methodName = WaterHeaterMock.Method.isWaterHot
        ){ true }

        grinderMock.every(
            methodName = GrinderMock.Method.hasCoffee
        ){ true }

        coffeeMachine.makeCoffee()

        grinderMock.verify(
            methodName = GrinderMock.Method.grind,
            arguments = mapOf(
                GrinderMock.Arg.grams to 5
            )
        )
        waterPumpMock.verify(
            methodName = WaterPumpMock.Method.pump
        )
    }
}