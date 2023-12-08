package no.finntech.aoc2023

import kotlin.math.max
import kotlin.math.min

class Day3 {
    fun getAnswer1(): Int {
        return sumOfAdjacentParts(fileLinesAsList("aoc2023/day3.txt"))
    }

    fun getAnswer2(): Int {
        return sumGearRatios(fileLinesAsList("aoc2023/day3.txt"))
    }

    fun sumOfAdjacentParts(testInput: List<String>): Int {
        return testInput.mapIndexed { index, currentRow -> findNumbers(currentRow, testInput.getOrNull(index - 1), testInput.getOrNull(index + 1)) }
            .flatten()
            .sum()
    }

    private fun findNumbers(currentRow: String, nextRow: String?, lastRow: String?): List<Int> {
        return numberRegex.findAll(currentRow).filter {
            containsSymbolInRange(it.range, currentRow) ||
                containsSymbolInRange(it.range, nextRow) ||
                containsSymbolInRange(it.range, lastRow)
        }.map { it.value.toInt() }.toList()
    }

    private fun containsSymbolInRange(range: IntRange, row: String?): Boolean {
        val increasedRange = max(range.first - 1, 0)..min(range.last + 1, (row?.length ?: 0) - 1)
        return row?.let { symbolRegex.containsMatchIn(it.substring(increasedRange)) } ?: false
    }

    fun sumGearRatios(testInput: List<String>): Int {
        return testInput.mapIndexed { index, currentRow -> findGearRatios(currentRow, testInput.getOrNull(index - 1), testInput.getOrNull(index + 1)) }
            .flatten()
            .sum()
    }

    private fun findGearRatios(currentRow: String, nextRow: String?, lastRow: String?): List<Int> {
        return gearRegex.findAll(currentRow).map {
            val neighbours = getNumbersInRange(it.range, currentRow) + getNumbersInRange(it.range, nextRow) + getNumbersInRange(it.range, lastRow)
            if (neighbours.size == 2) neighbours[0] * neighbours[1] else 0
        }.toList()
    }

    private fun getNumbersInRange(range: IntRange, row: String?): List<Int> {
        if (row == null) return emptyList()
        val increasedRange = max(range.first - 1, 0)..min(range.last + 1, (row?.length ?: 0) - 1)

        return numberRegex.findAll(row)
            .filter { it.range.last in increasedRange || it.range.first in increasedRange || it.range.first + 1 in increasedRange }
            .map { it.value.toInt() }
            .toList()
    }

    companion object {
        private val numberRegex = Regex("\\d+")
        private val symbolRegex = Regex("[^\\d.]")
        private val gearRegex = Regex("[*]")
    }
}

fun main() {
    println("Answer1: ${Day3().getAnswer1()}")
    println("Answer2: ${Day3().getAnswer2()}")
}