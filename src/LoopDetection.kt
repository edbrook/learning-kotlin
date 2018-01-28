fun <T> detectLoop(root: BasicNode<T>): List<BasicNode<T>>? {
    var slow: BasicNode<T>? = root
    var fast: BasicNode<T>? = root
    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) {
            val cp = fast
            slow = root
            while (slow != fast) {
                slow = slow?.next
                fast = fast?.next
            }
            val lo = fast
            return listOf(lo!!, cp!!)
        }
    }
    return null
}

fun genBasicNodeList(path: String): BasicNode<String>? {
    val nodes = HashMap<String, BasicNode<String>>()
    var root: BasicNode<String>? = null
    var last: BasicNode<String>? = null
    path.split("->")
            .forEach {
                val node = nodes.getOrPut(it, { BasicNode(it) })
                if (root == null) root = node
                last?.next = node
                last = node
            }
    return root
}

fun displayBasicNodePath(root: BasicNode<String>) {
    var node: BasicNode<String>? = root
    while (node != null) {
        print(node.data)
        node = node.next
        if (node != null) print("->")
    }
    println()
}

fun main(args: Array<String>) {
    val paths = listOf(
            "A->B->A",
            "A->B->C->B",
            "A->B->C->D->B",
            "A->B->C->D->E->C",
            "A->B->C->D->E->F->G->H->I->J->D",
            "A->B->C->D->E->F->G->H->I->J->K")

    paths.forEach {
        val root = genBasicNodeList(it)
        if (root != null) {
            val loopResult = detectLoop(root)
            if (loopResult != null) {
                val (lo, cp) = loopResult
                println("Loop @ $lo [Collision @ $cp]")
            } else {
                displayBasicNodePath(root)
            }
        }
    }
}