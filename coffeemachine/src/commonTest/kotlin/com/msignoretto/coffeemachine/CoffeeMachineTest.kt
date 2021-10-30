package com.msignoretto.coffeemachine

import com.careem.mockingbird.test.every
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CoffeeMachineTest {

    private val grinderMock = GrinderMock()
    private val waterHeater = WaterHeaterMock()
    private val waterPump = WaterPumpMock()

    private lateinit var coffeeMachine: CoffeeMachine

    @BeforeTest
    fun setUp(){
        coffeeMachine = CoffeeMachine(
            grinder = grinderMock,
            waterHeater = waterHeater,
            waterPump = waterPump
        )
    }

    @Test
    fun testTwoPlusTwoIsFour(){
        assertEquals(4, 2+2)
    }

    @Test
    fun givenColdWaterWhenMakeCoffeeThenResultWarming(){

    }

    @Test
    fun givenWarmWaterButNoBeansWhenMakeCoffeeThenResultNoBeans(){

    }

    @Test
    fun givenWarmWaterAndBeansWhenMakeCoffeeThenResultSuccess(){

    }

    @Test
    fun givenWarmWaterAndBeansWhenMakeCoffeeThenGrindAndPump(){

    }
}