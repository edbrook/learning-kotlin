import kotlin.math.sqrt

fun reduce(list: List<Int>, fn: (Int, Int) -> Int): Int {
    var result = list[0]
    for (n in list.slice(1 until list.size)) {
        result = fn(result, n)
    }
    return result
}

fun gcd(list: List<Int>): Int = reduce(list, {a, b -> gcd(a,b)})
fun gcd(a: Int, b: Int): Int {
    var aa = a
    var bb = b
    var t: Int
    while (bb != 0) {
        t = bb
        bb = aa % bb
        aa = t
    }
    return aa
}

fun lcm(list: List<Int>): Int = reduce(list, {a, b -> lcm(a,b)})
fun lcm(a: Int, b: Int): Int {
    return (a*b) / gcd(a, b)
}

fun pf(num: Int): List<Int> {
    var n = num
    var div = 2
    val maxDiv = sqrt(num.toDouble())
    val factors = ArrayList<Int>()
    while (n != 1 && div <= maxDiv) {
        while (n % div == 0) {
            n /= div
            factors.add(div)
        }
        div += 1 + 2 % div
    }
    if (n > 1) factors.add(n)
    return factors
}
