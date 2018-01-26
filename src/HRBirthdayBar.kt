import java.util.*

fun main(args: Array<String>) {
    readLine() // n
    val bar = readIntArr()
    val (d, m) = readIntArr()
    val sub = LinkedList<Int>()
    var count = 0
    var total = 0
    for (i in 0 until bar.size) {
        total += bar[i]
        sub.addLast(bar[i])
        if (i < m-1) continue
        if (total == d) count++
        total -= sub.removeFirst()
    }
    println(count)
}