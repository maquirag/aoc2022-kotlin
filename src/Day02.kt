fun main() {
    val day = "02"

    fun moveScore(move: Char): Int =
        mapOf('A' to 1, 'B' to 2, 'C' to 3)[move]!!

    fun gameScore(p1: Char, p2: Char) = when (p2 - p1) {
        0 -> 3
        1, -2 -> 6
        else -> 0
    }

    fun determineMove(p1: Char, strategy: Char): Char = when (strategy) {
        'X' -> mapOf('A' to 'C', 'B' to 'A', 'C' to 'B')[p1]!!
        'Z' -> mapOf('A' to 'B', 'B' to 'C', 'C' to 'A')[p1]!!
        else -> p1
    }

    fun part1(input: List<String>): Int =
        input.map { it.split(" ")}
            .map { (p1, p2) ->
                val move1 = p1.first()
                val move2 = p2.first() - ('X' - 'A')
                moveScore(move2) + gameScore(move1, move2) }
            .sum()

    fun part2(input: List<String>): Int  =
        input.map { it.split(" ")}
            .map { (p1, p2) ->
                val move1 = p1.first()
                val move2 = p2.first().let { determineMove(move1, it) }
                moveScore(move2) + gameScore(move1, move2) }
            .sum()

    val testInput = readInput("Day${day}_Test")
    val input = readInput("Day${day}")
    val test1 = part1(testInput)
    check(test1 == 15)
    println("Part 1 => ${part1(input)}")
    val test2 = part2(testInput)
    check(test2 == 12)
    println("Part 2 => ${part2(input)}")
}