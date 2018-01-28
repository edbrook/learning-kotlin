fun getRoundedGrade(grade: Int): Int {
    if (grade >= 38) {
        val toNextGrade = 5 - grade % 5
        if (toNextGrade < 3) {
            return grade + toNextGrade
        }
    }
    return grade
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val grade = readLine()!!.toInt()
        println(getRoundedGrade(grade))
    }
}
