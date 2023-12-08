package no.finntech.aoc2023

class DayO {
    fun getAnswer1(): Int {
        return fileLinesAsList("aoc2023/dayO.txt").size
    }

    fun getAnswer2(): Int {
        return fileLinesAsList("aoc2023/dayO.txt").size
    }
}

fun main() {
    println("Answer1: ${DayO().getAnswer1()}")
    println("Answer2: ${DayO().getAnswer2()}")
}