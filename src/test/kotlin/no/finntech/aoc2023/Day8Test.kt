package no.finntech.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day8Test {

    @Test
    fun part1ExampleInput1() {
        val testInput = listOf(
            "RL",
            "",
            "AAA = (BBB, CCC)",
            "BBB = (DDD, EEE)",
            "CCC = (ZZZ, GGG)",
            "DDD = (DDD, DDD)",
            "EEE = (EEE, EEE)",
            "GGG = (GGG, GGG)",
            "ZZZ = (ZZZ, ZZZ)",
        )
        assertEquals(
            2, Day8.findNumSteps(
                testInput
            )
        )
    }

    @Test
    fun part1ExampleInput2() {
        val testInput = listOf(
            "LLR",
            "",
            "AAA = (BBB, BBB)",
            "BBB = (AAA, ZZZ)",
            "ZZZ = (ZZZ, ZZZ)",
        )
        assertEquals(
            6, Day8.findNumSteps(
                testInput
            )
        )
    }

    @Test
    fun part2ExampleInput() {
        val testInput = listOf(
            "LR",
            "",
            "11A = (11B, XXX)",
            "11B = (XXX, 11Z)",
            "11Z = (11B, XXX)",
            "22A = (22B, XXX)",
            "22B = (22C, 22C)",
            "22C = (22Z, 22Z)",
            "22Z = (22B, 22B)",
            "XXX = (XXX, XXX)",
        )
        assertEquals(
            6, Day8.findNumSteps(testInput, "A", "Z")
        )
    }
}