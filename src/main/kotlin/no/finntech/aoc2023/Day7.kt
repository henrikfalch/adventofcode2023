package no.finntech.aoc2023

class Day7 {

    fun getAnswer1(): Int {
        return totalWinnings(fileLinesAsList("aoc2023/day7.txt").toHands())
    }

    private fun List<String>.toHands(hasJokers: Boolean = false): List<Hand> = this.map { Hand(it, hasJokers) }

    fun getAnswer2(): Int {
        return totalWinnings(fileLinesAsList("aoc2023/day7.txt").toHands(true))
    }

    fun totalWinnings(hands: List<Hand>): Int {
        return hands.sorted()
            .mapIndexed { index, hand -> (index + 1) * hand.bet }
            .sum()
    }

    class Hand(val input: String, hasJokers: Boolean) : Comparable<Hand> {
        private val cardStrengthOrder = listOf('A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2').filterNot { hasJokers && it == 'J' } + listOf('J')

        private val rawInput = input.split(" ")

        val cards = rawInput[0]
        val type = HandType.findType(cards, hasJokers)

        val bet = rawInput[1].toInt()

        override fun compareTo(other: Hand): Int {

            return when {
                HandType.strengthOrder.indexOf(type) < HandType.strengthOrder.indexOf(other.type) -> 1
                HandType.strengthOrder.indexOf(type) > HandType.strengthOrder.indexOf(other.type) -> -1
                else -> compare(cards, other.cards)
            }
        }

        private fun compare(a: String, b:String): Int {
            return when {
                a == b -> 0
                cardStrengthOrder.indexOf(a.first()) < cardStrengthOrder.indexOf(b.first()) -> 1
                cardStrengthOrder.indexOf(a.first()) > cardStrengthOrder.indexOf(b.first()) -> -1
                else -> compare(a.drop(1), b.drop(1))
            }
        }
    }

    enum class HandType : Comparable<HandType> {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        FIVE_OF_A_KIND;



        companion object {
            val strengthOrder = listOf(FIVE_OF_A_KIND, FOUR_OF_A_KIND, FULL_HOUSE, THREE_OF_A_KIND, TWO_PAIR, ONE_PAIR, HIGH_CARD)

            fun findType(cards: String, hasJokers: Boolean): HandType {
                val grouped = cards.groupBy { it }
                val sorted = grouped.values.sortedByDescending { it.size }.filterNot { hasJokers && it.first() == 'J' }
                val jokers = if (hasJokers) grouped['J']?.size ?: 0 else 0

                return when {
                    jokers == 5 -> FIVE_OF_A_KIND
                    jokers + sorted[0].size == 5 -> FIVE_OF_A_KIND
                    jokers + sorted[0].size == 4 -> FOUR_OF_A_KIND
                    jokers + sorted[0].size == 3 && sorted[1].size == 2 -> FULL_HOUSE
                    jokers + sorted[0].size == 3 -> THREE_OF_A_KIND
                    sorted[0].size == 2 && sorted[1].size == 2 -> TWO_PAIR
                    jokers + sorted[0].size == 2 -> ONE_PAIR
                    sorted[0].size == 1 -> HIGH_CARD
                    else -> throw IllegalStateException()
                }
            }

        }
    }

}

fun main() {
    println("Answer1: ${Day7().getAnswer1()}")
    println("Answer2: ${Day7().getAnswer2()}")
}