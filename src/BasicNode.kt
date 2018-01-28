data class BasicNode<T>(var data: T, var next: BasicNode<T>? = null) {
    override fun toString(): String {
        return "Node(data=$data,next=" + next?.data + ")"
    }
}