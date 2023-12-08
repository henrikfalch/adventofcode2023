package no.finntech.aoc2023

import kotlin.math.pow

class Day2 {
    fun sumOfValidIds(testInput: List<String>): Int {
        val bag = mapOf(
            Color.RED to 12,
            Color.GREEN to 13,
            Color.BLUE to 14,
        )

        return testInput.map { toGame(it) }
            .filter { game ->
                game.rounds.all { round ->
                    round.picks.all { (color, count) ->
                        bag[color]!! >= count
                    }
                }
            }
            .sumOf { it.number }

    }

    private fun toGame(input: String): Game {
        val split = input.split(":")
        val gameNumber = split.first().split(" ").last().toInt()
        val rounds = split.last()
            .split(";")
            .map { it.trim() }
            .map { toRound(it) }
        return Game(gameNumber, rounds)
    }

    private fun toRound(roundInput: String): Round {
        val picks = roundInput.split(", ")
            .map { it.trim() }
            .associate { toPick(it) }
        return Round(picks)
    }

    private fun toPick(pickInput: String) : Pair<Color, Int> {
        val split = pickInput.split(" ")
        val color = Color.valueOf(split[1].uppercase())
        val count = split.first().toInt()
        return color to count
    }

    private class Game(val number: Int, val rounds: List<Round>)

    private data class Round(val picks: Map<Color, Int>)

    private enum class Color {
        RED, GREEN, BLUE
    }

    fun getAnswer1(): Int {
        return sumOfValidIds(fileLinesAsList("aoc2023/day2.txt"))
    }

    fun sumOfPowerMinimumCounts(testInput: List<String>): Long {
        return testInput.sumOf { powerOfMinimum(it) }
    }

    fun powerOfMinimum(input: String): Long {
        val game = toGame(input)

        return game.rounds
            .flatMap { it.picks.entries }
            .groupBy { it.key }
            .map { it.value.maxOfOrNull { v -> v.value } ?: 0 }
            .map { it.toLong() }
            .reduce(Long::times)
    }


    fun getAnswer2(): Long {
        return sumOfPowerMinimumCounts(fileLinesAsList("aoc2023/day2.txt"))
    }
}

fun main() {
    println("Answer1: ${Day2().getAnswer1()}")
    println("Answer2: ${Day2().getAnswer2()}")
}