import kotlin.properties.Delegates

fun main() {
    fun part1(input: List<String>): Int {
        fun Char.toScore(): Int {
            return if(this.isLowerCase()) {
                this.code - 'a'.code + 1
            } else {
                this.code - 'A'.code + 27
            }
        }

        return input.sumOf {
            val compartments = listOf(
                    it.substring(0, it.length / 2).toCharArray().sorted(),
                    it.substring(it.length / 2, it.length).toCharArray().sorted())
            var repeated by Delegates.notNull<Char>()
            for (i in 0 until compartments[0].size) {
                if (compartments[1].contains(compartments[0][i])) {
                    repeated = compartments[0][i]
                    break
                }
            }
            repeated.toScore()
        }

    }

    fun part2(input: List<String>): Int {
        fun Char.toScore(): Int {
            return if(this.isLowerCase()) {
                this.code - 'a'.code + 1
            } else {
                this.code - 'A'.code + 27
            }
        }

        return input.chunked(3) {
            it[0].toSet()
                    .intersect(it[1].toSet())
                    .intersect(it[2].toSet())
                    .first().toScore()
        }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_default")
    println(part2(testInput))
//    check(part1(testInput) == 1)

    val input = readInput("Day03_test")
    println(part1(input))
    println(part2(input))
}
