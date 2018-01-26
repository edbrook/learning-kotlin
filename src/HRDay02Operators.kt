fun main(args: Array<String>) {
    val cost = readLine()!!.toDouble()
    val tip = readLine()!!.toInt()
    val tax = readLine()!!.toInt()
    val total = cost + ((cost * tip) + (cost * tax)) / 100.0
    val totalRounded = (total + 0.5).toInt()
    println("The total meal cost is $totalRounded dollars.")
}