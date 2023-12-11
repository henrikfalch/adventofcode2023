package no.finntech.aoc2023

import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class Day11 {
    fun getAnswer1(): Long {
        return sumOfDistances(fileLinesAsList("aoc2023/day11.txt"))
    }

    fun getAnswer2(): Long {
        return sumOfDistances(fileLinesAsList("aoc2023/day11.txt"), (1000000-1))
    }

    fun distanceBetween(galaxy1: Galaxy, galaxy2: Galaxy, universe: Universe, emptyDistanceSize: Long): Long {
        val columns = (galaxy1.x - galaxy2.x).absoluteValue + (universe.emptyColumns.filter { it in min(galaxy1.x, galaxy2.x)..max(galaxy1.x, galaxy2.x) }.size * emptyDistanceSize)
        val rows = (galaxy1.y - galaxy2.y).absoluteValue + (universe.emptyRows.filter { it in min(galaxy1.y, galaxy2.y)..max(galaxy1.y, galaxy2.y) }.size * emptyDistanceSize)
        return columns + rows
    }

    fun expandUniverse(testInput: List<String>): Universe {
        val galaxies = getGalaxy(testInput)
        val emptyRows = (0..testInput.size).filter { rowNum ->
            galaxies.none { it.y == rowNum }
        }
        val emptyColumns = (0..testInput.first().length).filter { columnNum ->
            galaxies.none { it.x == columnNum }
        }
        return Universe(galaxies, emptyRows, emptyColumns)
    }

    private fun getGalaxy(testInput: List<String>) = testInput.flatMapIndexed { rowNum, row ->
        row.mapIndexedNotNull { columnNum, char ->
            if (char == '#') {
                Galaxy(columnNum, rowNum)
            } else {
                null
            }
        }
    }

    fun sumOfDistances(testInput: List<String>, emptyDistanceSize: Long = 1): Long {
        val universe = expandUniverse(testInput)
        val flatMapIndexed = universe.galaxies.flatMapIndexed { galIdx, galaxy1 ->
            universe.galaxies.drop(galIdx + 1).map { galaxy2 ->
                distanceBetween(galaxy1, galaxy2, universe, emptyDistanceSize)
            }
        }
        return flatMapIndexed.sum()
    }

    companion object {
        var counter = 0
    }

    data class Galaxy(val x: Int, val y: Int) {
        val id = counter++
    }

    data class Universe(val galaxies: List<Galaxy>, val emptyRows: List<Int>, val emptyColumns: List<Int>)
}

fun main() {
    println("Answer1: ${Day11().getAnswer1()}")
    println("Answer2: ${Day11().getAnswer2()}")
}