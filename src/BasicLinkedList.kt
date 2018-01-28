import java.util.Random

class LinkedList<T: Comparable<T>>(data: T) {
    private var head: BasicNode<T> = BasicNode(data)
    private var tail: BasicNode<T> = head
    private var ptr: BasicNode<T>? = null
    private var ptrPrev: BasicNode<T>? = null

    fun getHead(): T {
        return head.data
    }

    fun getTail(): T {
        return tail.data
    }

    fun addHead(data: T) {
        val node = BasicNode(data)
        node.next = head
        head = node
    }

    fun addTail(data: T) {
        val node = BasicNode(data)
        tail.next = node
        tail = node
    }

    fun reset() {
        ptr = head
    }

    fun next(): T? {
        if (ptr == null) {
            ptr = head
        } else {
            ptrPrev = ptr
            ptr = ptr?.next
        }
        return ptr?.data
    }

    fun deleteCurrent() {
        if (ptr != null) {
            ptrPrev?.next = ptr?.next
            ptr = ptr?.next
        }
    }

    fun partition(n: T) {
        var node: BasicNode<T>? = head
        tail = head
        var c = 0
        while (node != null && c++ < 20) {
            val next = node.next
            if (node.data < n) {
                node.next = head
                head = node
            } else {
                tail.next = node
                tail = node
            }
            node = next
        }
        tail.next = null
    }

    fun removeDuplicates() {
        var left: BasicNode<T>? = head
        while (left != null) {
            var right = left
            while (right?.next != null) {
                if (left.data == right.next?.data) {
                    right.next = right.next?.next
                } else {
                    right = right.next
                }
            }
            left = left.next
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var ptr: BasicNode<T>? = head
        while (ptr != null) {
            sb.append(ptr.data)
            if (ptr.next != null) sb.append(", ")
            ptr = ptr.next
        }
        return sb.toString()
    }
}


fun main(args: Array<String>) {
    val list = LinkedList(3)
    list.addTail(5)
    list.addTail(8)
    list.addTail(5)
    list.addTail(10)
    list.addTail(2)
    list.addTail(1)
    println(list)
    list.partition(5)
    println(list)
    println(list.next())
    println(list.next())
    println(list.next())
    list.deleteCurrent()
    println(list)

    val lst = LinkedList(0)
    val rand = Random()
    for (i in 0..19) {
        lst.addTail(rand.nextInt(10))
    }
    println("------")
    println(lst)
    lst.removeDuplicates()
    println(lst)
}

