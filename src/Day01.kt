fun main() {
    fun countBags(input: List<String>): List<Int> = sequence {
        var total = 0
        input.forEach {
            if (it.isBlank()) {
                yield(total)
                total = 0
            } else {
                total += it.toInt()
            }
        }
        yield(total)
    }.toList()

    fun part1(input: List<String>): Int {
        val bags = countBags(input)
        return bags.max()
    }

    fun part2(input: List<String>): Int {
        val bags = countBags(input)
        return bags.sortedDescending().take(3).sum()
    }

    val testInput = readInput("Day01_Test")
    val test1 = part1(testInput)
    check(test1 == 24000)
    val test2 = part2(testInput)
    check(test2 == 45000)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
