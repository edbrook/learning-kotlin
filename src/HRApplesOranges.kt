import kotlin.test.assertEquals

fun readIntList(): List<Int> {
    return readLine()!!
            .split(" ")
            .map { n -> n.toInt() }
}

fun scoreThrow(housePosition: IntRange, playerPosition: Int, fruitPosition: Int): Int {
    val onTarget = playerPosition + fruitPosition in housePosition
    if (onTarget) return 1
    return 0
}

fun main(args: Array<String>) {
    val (s, t) = readIntList()
    val (larryPosition, robPosition) = readIntList()
    val (m, n) = readIntList()
    val apples = readIntList()
    val oranges = readIntList()

    assertEquals(m, apples.size)
    assertEquals(n, oranges.size)

    val houseRange = s..t

    val scoreLarry = apples.sumBy { scoreThrow(houseRange, larryPosition, it) }
    val scoreRob = oranges.sumBy { scoreThrow(houseRange, robPosition, it) }

    println("$scoreLarry $scoreRob")
}