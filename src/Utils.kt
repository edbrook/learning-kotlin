import java.io.BufferedReader

fun readIntArr(): List<Int> {
    return readLine()!!
            .split(" ")
            .map { n -> n.toInt() }
}

fun readStringArr(): List<String> {
    return readLine()!!.split(" ")
}

fun BufferedReader.readIntArr(): List<Int> {
    return this.readLine()!!
            .split(" ")
            .map { n -> n.toInt() }
}

fun BufferedReader.readStringArr(): List<String> {
    return this.readLine()!!
            .split(" ")
}