import java.util.*

fun <T: Comparable<T>> sortStack(a: Stack<T>) {
    val b: Stack<T> = Stack()
    while (!a.empty()) {
        val tmp = a.pop()
        while (!b.empty() && tmp < b.peek()) {
            a.push(b.pop())
        }
        b.push(tmp)
    }
    while (!b.empty()) {
        a.push(b.pop())
    }
}

fun main(args: Array<String>) {
    val testStack = Stack<Int>()

    val rand = Random()
    (0 until 20).forEach {
        testStack.push(rand.nextInt(89) + 10)
    }

    println(testStack)
    sortStack(testStack)
    println(testStack)
    println("HEAD = " + testStack.peek())
}