package com.pabi.splitsmart

import org.junit.Assert.assertEquals
import org.junit.Test

/*
 * These tests ARE the grader. You don't edit them (except once, on purpose,
 * to see what a failure looks like). Each `assertEquals(expected, actual, delta)`
 * means: "the two numbers must be equal (within a tiny tolerance)".
 */
class CalculatorTest {

    @Test
    fun tip_of_10_percent_on_500_is_50() {
        assertEquals(50.0, Calculator.tipAmount(500.0, 10), 0.001)
    }
    fun tipAmount(billAmount: Double, tipPercent: Int): Double {
    return billAmount * tipPercent / 100
    }

    @Test
    fun tip_of_0_percent_is_0() {
        assertEquals(0.0, Calculator.tipAmount(500.0, 0), 0.001)
    }
   

    @Test
    fun bill_300_tip_10_percent_split_3_ways_is_110_each() {
        assertEquals(110.0, Calculator.totalPerPerson(300.0, 10, 3), 0.001)
    }
     fun totalPerPerson(billAmount: Double, tipPercent: Int, people: Int): Double {
         val tip=tipAmount(billAmount, tipPercent)
         val safePeople=kotlin.math.max(1, people)
         return (billAmount + tipAmount)/safePeople 
        }

    @Test
    fun zero_people_is_treated_as_one_person() {
        assertEquals(330.0, Calculator.totalPerPerson(300.0, 10, 0), 0.001)
    }

    @Test
    fun round_up_110_point_2_is_111() {
        assertEquals(111.0, Calculator.roundUp(110.2), 0.001)
    }

    @Test
    fun round_up_whole_number_stays_the_same() {
        assertEquals(111.0, Calculator.roundUp(111.0), 0.001)
    }
}
