package no.finntech.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day11Test {
    val testInput = listOf(
        "...#......",
        ".......#..",
        "#.........",
        "..........",
        "......#...",
        ".#........",
        ".........#",
        "..........",
        ".......#..",
        "#...#.....",
    )

    @Test
    fun part1LenghtBetween() {
        val universe = Day11().expandUniverse(testInput)

        assertEquals(9, Day11().distanceBetween(universe.galaxies[4], universe.galaxies[8], universe, 1))
        assertEquals(15, Day11().distanceBetween(universe.galaxies[0], universe.galaxies[6], universe, 1))
        assertEquals(17, Day11().distanceBetween(universe.galaxies[2], universe.galaxies[5], universe, 1))
        assertEquals(5, Day11().distanceBetween(universe.galaxies[7], universe.galaxies[8], universe, 1))
    }

    @Test
    fun part1Example() {
        assertEquals(374L, Day11().sumOfDistances(testInput))
    }

    @Test
    fun part2Example() {
        assertEquals(1030L, Day11().sumOfDistances(testInput, 9))
        assertEquals(8410L, Day11().sumOfDistances(testInput, 99))
    }

}