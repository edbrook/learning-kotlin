fun main(args: Array<String>) {
    readLine()
    val s = readLine()!!.split(" ").map { n -> n.toInt() }
    var min = s[0]
    var max = s[0]
    var cmin = 0
    var cmax = 0
    for (i in s.slice(1 until s.size)) {
        if (i < min) {
            cmin++
            min = i
        }
        if (i > max) {
            cmax++
            max = i
        }
    }
    println("$cmax $cmin")
}