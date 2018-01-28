/*
 * HackerRank Challenge: Arrays: Left Rotation
 *
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 */

fun main(args: Array<String>) {
    val reader = System.`in`.bufferedReader()

    val rot = reader.readLine()
            .split(" ")
            .last()
            .toInt()

    val numbers = reader.readLine()
            .split(" ")
            .map { it.toInt() }
            .toTypedArray()

    rotateLeft(numbers, rot)

    println(numbers.joinToString(" "))
}

fun <T> rotateLeft(arr: Array<T>, by: Int = 1) {
    if (by <= 0 || arr.size < 2 || by % arr.size == 0) return
    val rot = by % arr.size
    val tmp = arr.slice(0 until rot)
    for (i in rot until arr.size) {
        arr[i-rot] = arr[i]
    }
    for (i in 0 until tmp.size) {
        arr[arr.size - rot + i] = tmp[i]
    }
}