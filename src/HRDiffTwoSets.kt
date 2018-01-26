fun main(args: Array<String>) {
    readLine() // Ignore first line
    val lcm = readIntArr().reduce({ a, b -> lcm(a, b) })
    val gcd = readIntArr().reduce({ a, b -> gcd(a, b) })
    var count = 0
    var l = lcm
    while (l <= gcd) {
        if (gcd % l == 0) count++
        l += lcm
    }
    println(count)
}