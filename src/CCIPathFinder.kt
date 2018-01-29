import java.io.File
import java.nio.file.Paths
import java.util.*

class Node<T>(var data: T,
              val neighbors: ArrayList<Node<T>> = ArrayList(),
              private var seen: Int = 0) {

    fun isSeen(n: Int): Boolean {
        if (seen == n) return true
        return false
    }

    fun setSeen(n: Int) {
        seen = n
    }

    override fun toString(): String {
        val nData = neighbors.map { n -> n.data }
        return "$data->$nData"
    }
}

class Graph<T>(val root: ArrayList<Node<T>> = ArrayList()) {
    private var seen: Int = 0

    fun pathExists(from: T, to: T): Boolean {
        if (from == to) return true

        val queue: Queue<Node<T>> = LinkedList()
        var fromFound = false
        var toFound = false
        queue += root
        seen++

        while (!queue.isEmpty()) {
            val node = queue.remove()
            print("Current: $node")

            if (node.data == from) {
                print(" --START--")
                fromFound = true
                seen++          // Found start, reset seen nodes
                queue.clear()   // Found start, reset search
            }

            if (fromFound) {
                if (node.data == to) {  // Found the end so done
                    println(" --END--\n")
                    toFound = true
                    break
                }
            }

            node.setSeen(seen)
            node.neighbors.filterNotTo(queue) { it.isSeen(seen) } // Only add not-seen children to queue
            println(" queue: $queue")
        }

        return fromFound && toFound
    }

    override fun toString(): String {
        val roots = root.map { n -> n.data }
        return "Graph(roots=$roots)"
    }
}

fun main(args: Array<String>) {
    val path = Paths.get("").toAbsolutePath().toString()
    val reader = File("$path/input_CCIPathFinder2.txt")
            .inputStream()
            .bufferedReader()

    val nodes = HashMap<String, Node<String>>()
    val graph = Graph<String>()

    val (links, tests) = reader.readIntArr()

    for (i in 0 until links) {
        val (from, to) = reader.readStringArr()
        val nodeFrom = nodes.getOrPut(from, { Node(from) })
        val nodeTo = nodes.getOrPut(to, { Node(to) })
        if (graph.root.isEmpty()) graph.root.add(nodeFrom)
        nodeFrom.neighbors.add(nodeTo)
    }

    // DEBUG ===========
    println("$graph\n")
    nodes.toSortedMap().forEach { _, v -> println(v) }
    nodes.clear() // Just used for building the graph!
    println()
    // =================

    for (i in 0 until tests) {
        val (from, to) = reader.readStringArr()
        println("pathExists($from, $to): " + graph.pathExists(from, to))
        println()
        println("pathExists($to, $from): " + graph.pathExists(to, from))
    }

    reader.close()
}