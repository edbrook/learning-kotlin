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

    fun findPath(from: T, to: T): List<T> {
        if (from == to) return listOf()

        val path: Stack<T> = Stack()
        val queue: Queue<Node<T>> = LinkedList()
        var fromNode: Node<T>? = null
        var toFound = false
        queue += root
        seen++

        while (!queue.isEmpty()) {
            val node = queue.remove()

            if (node.data == from) {
                fromNode = node
                seen++          // Found start reset seen nodes
                queue.clear() // Found start so reset search
            }

            if (fromNode != null) {
                path.push(node.data)
                if (node.data == to) {  // Found the end so done
                    toFound = true
                    break
                }
            }

            node.setSeen(seen)
            node.neighbors.filterNotTo(queue) { it.isSeen(seen) } // Only add not-seen children to queue
        }

        if (!toFound) path.clear()
        return path
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
    nodes.forEach { _, v -> println(v) }
    nodes.clear() // Just used for building the graph!
    println()
    // =================

    for (i in 0 until tests) {
        val (from, to) = reader.readStringArr()
        println("FindPath($from, $to): " + graph.findPath(from, to))
    }

    reader.close()
}