package no.finntech.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day3Test {
    val testInput = listOf(
        "467..114..",
        "...*......",
        "..35..633.",
        "......#...",
        "617*......",
        ".....+.58.",
        "..592.....",
        "......755.",
        "...$.*....",
        ".664.598..",
    )

    @Test
    fun part1Example() {
        assertEquals(4361, Day3().sumOfAdjacentParts(testInput))
    }

    @Test
    fun part2Example() {
        assertEquals(467835, Day3().sumGearRatios(testInput))
    }

}