package no.finntech.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day2Test {
    val testInput = listOf(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
    )

    @Test
    fun part1Example() {
        assertEquals(8, Day2().sumOfValidIds(testInput))
    }

    @Test
    fun part2Example() {
        assertEquals(2286L, Day2().sumOfPowerMinimumCounts(testInput))
    }

    @Test
    fun part2Lines() {
        assertEquals(48, Day2().powerOfMinimum(testInput[0]))
        assertEquals(12, Day2().powerOfMinimum(testInput[1]))
        assertEquals(1560, Day2().powerOfMinimum(testInput[2]))
        assertEquals(630, Day2().powerOfMinimum(testInput[3]))
        assertEquals(36, Day2().powerOfMinimum(testInput[4]))
    }

}