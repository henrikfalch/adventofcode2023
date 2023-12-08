package no.finntech.aoc2023

import org.apache.commons.math3.util.ArithmeticUtils

class Day8 {

    fun getAnswer1(): Long {
        return findNumSteps(fileLinesAsList("aoc2023/day8.txt"))
    }

    fun getAnswer2(): Long {
        return findNumSteps(fileLinesAsList("aoc2023/day8.txt"), "A", "Z")
    }


    companion object {
        private fun getMap(input: List<String>): Map<String, Pair<String, String>> {
            return input.drop(2)
                .map { it.split(" = ") }
                .map { it.first().trim() to it.last().split(", ").map { w -> w.trim().replace("(", "").replace(")", "") } }
                .associate { it.first to (it.second[0] to it.second[1]) }
        }

        fun findNumSteps(input: List<String>, startingPositionsEndLetters: String = "AAA", goalPostionsEndLetters: String = "ZZZ"): Long {
            val map = getMap(input)
            val directions = input.first()

            return map.keys.filter { it.endsWith(startingPositionsEndLetters) }
                .map { numStepsForNode(it, goalPostionsEndLetters, map, directions) }
                .fold(1L) { acc, i -> ArithmeticUtils.lcm(acc, i.toLong()) }
        }

        private fun numStepsForNode(startingPosition: String, goalPostionsEndLetters: String, map: Map<String, Pair<String, String>>, directions: String): Int {
            var counter = 0
            var currentPosition = startingPosition
            while (!currentPosition.endsWith(goalPostionsEndLetters)) {
                val nextPosition = map[currentPosition]!!

                currentPosition = if (directions[counter % directions.length] == 'R') {
                    nextPosition.second
                } else {
                    nextPosition.first
                }
                counter++
            }
            return counter
        }
    }

}


fun main() {
    println("Answer1: ${Day8().getAnswer1()}")
    println("Answer2: ${Day8().getAnswer2()}")
}