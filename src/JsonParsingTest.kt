import java.io.File
import java.nio.file.Paths
import org.json.JSONObject

const val KEY_BASE_URL = "base_url"
const val KEY_COINS = "coins"
const val KEY_NAME = "name"
const val KEY_ICON = "icon"

fun main(args: Array<String>) {
    val path = Paths.get("").toAbsolutePath().toString()
    val reader = File(path + "/icons.json")
            .inputStream()
            .bufferedReader()

    val json = JSONObject(reader.readText())

    val baseUrl = json[KEY_BASE_URL]
    val coins = json.getJSONObject(KEY_COINS)

    for (sym in coins.keys().asSequence().sorted()) {
        val coin = coins.getJSONObject(sym)
        println("$sym [" + coin[KEY_NAME] + "] -> $baseUrl" + coin[KEY_ICON])
    }
}