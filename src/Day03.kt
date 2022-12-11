fun main() {
    val day = "03"

    fun priority(c: Char): Int = when(c) {
        in 'a'..'z' -> (c - 'a') + 1
        else -> (c - 'A') + 27
    }

    fun part1(input: List<String>): Int =
        input.map {
            val misplaced = (it.take(it.length/2).toSet() intersect it.drop(it.length/2).toSet()).first()
            priority(misplaced)
        }.sum()

    fun part2(input: List<String>): Int  =
        input.chunked(3).map {(a, b, c) ->
            val badge = (a.toSet() intersect b.toSet() intersect c.toSet()).first()
            priority(badge)
        }.sum()

    val testInput = readInput("Day${day}_Test")
    val input = readInput("Day${day}")
    val test1 = part1(testInput)
    check(test1 == 157)
    println("Part 1 => ${part1(input)}")
    val test2 = part2(testInput)
    check(test2 == 70)
    println("Part 2 => ${part2(input)}")
}