/*
 * HackerRank Challenge: Strings: Making Anagrams
 *
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 */


fun main(args: Array<String>) {
    val str1 = readLine()!!
    val str2 = readLine()!!
    println(makeAnagram(str1, str2))
}

fun makeAnagram(a: String, b: String): Int {
    val counts = IntArray(26)
    a.forEach { counts[it-'a']++ }
    b.forEach { counts[it-'a']-- }
    return counts.map(Math::abs).sum()
}