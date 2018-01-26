import java.io.File
import java.nio.file.Paths

data class Node<T>(var data: T? = null, val neighbors: ArrayList<Node<T>> = ArrayList()) {
    override fun toString(): String {
        val nData = neighbors.map { n -> n.data }
        return "$data->$nData"
    }
}
data class Graph<T>(val root: ArrayList<Node<T>> = ArrayList()) {
    override fun toString(): String {
        val roots = root.map { n -> n.data }
        return "Graph(roots=$roots)"
    }
}

fun main(args: Array<String>) {
    val path = Paths.get("").toAbsolutePath().toString()
    val reader = File("$path/input_CCIPathFinder.txt")
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
    println(graph)
    nodes.forEach { _, v -> println(v) }
    nodes.clear() // Just used for building the graph!
    println()
    // =================

    for (i in 0 until tests) {
        val (from, to) = reader.readStringArr()
        println("FindPath($from, $to): !!TODO!!")
    }

    reader.close()
}