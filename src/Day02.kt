fun main() {
    fun part1(input: List<String>): Int {
        fun calculateOutcome(line: String): Int {
            return when(line) {
                "A Z", "B X", "C Y" -> 0
                "A X", "B Y", "C Z" -> 3
                "C X", "A Y", "B Z" -> 6
                else -> error("Wrong Input!")
            }
        }

        fun calculateSymbolScore(shape: Char): Int {
            return when(shape) {
                'A', 'X' -> 1
                'B', 'Y' -> 2
                'C', 'Z' -> 3
                else -> error("Wrong Input!")
            }
        }
        return input.sumOf {
            calculateOutcome(it) + calculateSymbolScore(it[2])
        }
    }

    fun part2(input: List<String>): Int {
        fun calculateOutcome(outcome: Char): Int {
            return when(outcome) {
                'X' -> 0
                'Y' -> 3
                'Z' -> 6
                else -> error("Wrong Input!")
            }
        }

        //                  Loses to  Wins to
        // A -> Rock         Paper(B)  Scissors(C)
        // B -> Paper       Scissors(C) Rock(A)
        // C -> Scissor     Rock(A)    Paper(B)
        // X -> Lose
        // Y -> Draw
        // Z -> Win
        fun calculateSymbolScore(line: String): Int {
            return when(line) {
                "A Y", "B X", "C Z"  -> 1
                "A Z", "B Y", "C X" -> 2
                "A X", "B Z", "C Y" -> 3
                else -> error("Wrong Input!")
            }
        }
        return input.sumOf {
            calculateOutcome(it[2]) + calculateSymbolScore(it)
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_default")
    println(part2(testInput))
//    check(part1(testInput) == 1)

    val input = readInput("Day02_test")
    println(part1(input))
    println(part2(input))
}
