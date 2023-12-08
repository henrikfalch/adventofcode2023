package no.finntech.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day7Test {
    val testInput = listOf(
        "32T3K 765",
        "T55J5 684",
        "KK677 28",
        "KTJJT 220",
        "QQQJA 483",
    )
    val testInputTask1 = testInput.map { Day7.Hand(it, false) }
    val testInputTask2 = testInput.map { Day7.Hand(it, true) }

    @Test
    fun orderByHandStrengthPart1() {
        assertEquals(listOf(testInputTask1[0], testInputTask1[3], testInputTask1[2], testInputTask1[1], testInputTask1[4]), testInputTask1.sorted())
    }

    @Test
    fun testHandTypePart1() {
        assertEquals(Day7.HandType.ONE_PAIR, Day7.HandType.findType("32T3K", false))
        assertEquals(Day7.HandType.THREE_OF_A_KIND, Day7.HandType.findType("T55J5", false))
        assertEquals(Day7.HandType.TWO_PAIR, Day7.HandType.findType("KK677", false))
        assertEquals(Day7.HandType.TWO_PAIR, Day7.HandType.findType("KTJJT", false))
        assertEquals(Day7.HandType.THREE_OF_A_KIND, Day7.HandType.findType("QQQJA", false))
    }

    @Test
    fun part1Example() {
        assertEquals(6440, Day7().totalWinnings(testInputTask1))
    }


    @Test
    fun orderByHandStrengthPart2() {
        assertEquals(listOf(testInputTask2[0], testInputTask2[2], testInputTask2[1], testInputTask2[4], testInputTask2[3]), testInputTask2.sorted())
    }

    @Test
    fun testHandTypePart2() {
        assertEquals(Day7.HandType.ONE_PAIR, Day7.HandType.findType("32T3K", true))
        assertEquals(Day7.HandType.FOUR_OF_A_KIND, Day7.HandType.findType("T55J5", true))
        assertEquals(Day7.HandType.TWO_PAIR, Day7.HandType.findType("KK677", true))
        assertEquals(Day7.HandType.FOUR_OF_A_KIND, Day7.HandType.findType("KTJJT", true))
        assertEquals(Day7.HandType.FOUR_OF_A_KIND, Day7.HandType.findType("QQQJA", true))
    }

    @Test
    fun part2Example() {
        assertEquals(5905, Day7().totalWinnings(testInputTask2))
    }
}