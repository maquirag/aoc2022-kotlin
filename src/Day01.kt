fun main() {
    val day = "01"

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

    val testInput = readInput("Day${day}_Test")
    val input = readInput("Day${day}")
    val test1 = part1(testInput)
    check(test1 == 24000)
    println("Part 1 => ${part1(input)}")
    val test2 = part2(testInput)
    check(test2 == 45000)
    println("Part 2 => ${part2(input)}")
}
