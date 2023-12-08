package no.finntech.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day1Test {
    val testInput = listOf(
        "1abc2",
        "pqr3stu8vwx",
        "a1b2c3d4e5f",
        "treb7uchet",
    )
    val testInput2 = listOf(
        "two1nine",
        "eightwothree",
        "abcone2threexyz",
        "xtwone3four",
        "4nineeightseven2",
        "zoneight234",
        "7pqrstsixteen",
    )

    @Test
    fun calibrationValues() {
        assertEquals(12, Day1().calibrationValue("1abc2"))
        assertEquals(38, Day1().calibrationValue("pqr3stu8vwx"))
        assertEquals(15, Day1().calibrationValue("a1b2c3d4e5f"))
        assertEquals(77, Day1().calibrationValue("treb7uchet"))
    }

    @Test
    fun part1Example() {
        assertEquals(142, testInput.sumOf { Day1().calibrationValue(it) })
    }

    @Test
    fun calibrationValuesPart2() {
        assertEquals(24, Day1().calibrationValueWithNumberStrings("xtwone3four"))
        assertEquals(42, Day1().calibrationValueWithNumberStrings("4nineeightseven2"))
        assertEquals(14, Day1().calibrationValueWithNumberStrings("zoneight234"))
        assertEquals(76, Day1().calibrationValueWithNumberStrings("7pqrstsixteen"))
    }

    @Test
    fun part2Example() {
        assertEquals(281, testInput2.sumOf { Day1().calibrationValueWithNumberStrings(it) })
    }

    @Test
    fun part2Exampldsdae() {
        val list = listOf(
            "23krgjlpone",
            "kfxone67bzb2",
            "8jjpseven",
            "236twoknbxlczgd",
            "sevensrncljm5zmvvrtthreejjd85twonepvj",
            "1dgzljrtcndqqrqkgxseventhreessnthree",
            "s2eight6bhshvmsevensix",
            "5tpbsrf",
            "two35kxjtnbhxrmdhbgzeight",
            "khgdlljfjxt6sevenfour35pxone",
            "qvztdsix2",
            "6lsgzmjtjrseven8cnbnpgd",
            "three1sk4hnine",
            "sixmqhg5tvbvlhtzxgpfqlzone9",
            "fljgbjmccvpz67one",
            "5six3four9nine8",
        )


        val value = 21+12+87+22+71+13+26+55+28+61+62+68+39+69+61+58
        println("value = ${value}, listCount = ${list.count()}")
        assertEquals(value, list.sumOf { Day1().calibrationValueWithNumberStrings(it) })
    }

    @Test
    fun part2JustNumbers() {
        assertEquals(53, Day1().calibrationValueWithNumberStrings("5694356943"))
    }

    @Test
    fun part2JustNumbers2() {
        assertEquals(71, Day1().calibrationValueWithNumberStrings("sevensrncljm5zmvvrtthreejjd85twonepvj"))
    }
}