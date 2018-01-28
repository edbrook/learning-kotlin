fun doMeet(x1: Int, v1: Int, x2: Int, v2: Int): Boolean {
    val ans = (x2-x1).toFloat().div(v1-v2)
    val intAns = ans.toInt()
    return ans.compareTo(intAns) == 0 && intAns > 0
}

fun main(args: Array<String>) {
    val (x1, v1, x2, v2) = readLine()!!
            .split(" ")
            .map { n -> n.toInt() }
    if (doMeet(x1, v1, x2, v2)) {
        println("YES")
    } else {
        println("NO")
    }
}