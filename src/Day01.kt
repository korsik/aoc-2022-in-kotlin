fun main() {
    fun part1(input: List<String>): Int {
        val data = mutableListOf<Int>()
        var point = 0
        data.add(0)
        for (num in input) {
            if (num == "") {
                point++
                data.add(0)
            }
            else {
                data[point] += num.toInt()
            }
        }
        return data.max()
    }

    fun part2(input: List<String>): Int {
        val data = mutableListOf<Int>()
        var point = 0
        data.add(0)
        for (num in input) {
            if (num == "") {
                point++
                data.add(0)
            }
            else {
                data[point] += num.toInt()
            }
        }
        return data.sorted().reversed().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_default")
    println(part2(testInput))
//    check(part1(testInput) == 1)

    val input = readInput("Day01_test")
    println(part1(input))
    println(part2(input))
}
