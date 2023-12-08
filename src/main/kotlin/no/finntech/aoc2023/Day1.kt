package no.finntech.aoc2023

class Day1 {

    fun getAnswer1(): Int {
        return fileLinesAsList("aoc2023/day1.txt").sumOf { calibrationValue(it) }
    }

    fun getAnswer2(): Int {
        return fileLinesAsList("aoc2023/day1.txt").sumOf { calibrationValueWithNumberStrings(it) }
    }

    fun calibrationValue(line: String): Int {
        val allNumbers = numberRegex.findAll(line)
        val firstValue = allNumbers.first().value
        val lastValue = allNumbers.last().value
        return "$firstValue$lastValue".toInt()
    }

    fun calibrationValueWithNumberStrings(line: String): Int {
        val allNumbers =( 0..line.length).mapNotNull { numberAndStringValueRegex.find(line, it) }
        val firstValue = allNumbers.first().value.toNumber()
        val lastValue = allNumbers.last().value.toNumber()
        return "$firstValue$lastValue".toInt()
    }

    companion object {
        private val textToNumber = listOf(
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9,
        )
        private val numberTextString = textToNumber.joinToString("|") { it.first }
        private val numberRegex = Regex("\\d")

        private val numberAndStringValueRegex = Regex("\\d|$numberTextString")

        private fun String.toNumber(): Int {
            return textToNumber.firstOrNull { it.first == this }?.second ?: this.toInt()
        }
    }
}

fun main() {
    println("Answer1: ${Day1().getAnswer1()}")
    println("Answer2: ${Day1().getAnswer2()}")
}