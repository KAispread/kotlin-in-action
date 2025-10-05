package introduce_kotlin.lec17

import java.io.BufferedReader
import java.io.FileReader

class FilePrinter {

    fun readFile(path: String) {
        val block: (BufferedReader) -> Unit = { reader ->
            println(reader.readLine())
        }
        BufferedReader(FileReader(path)).use(block)
    }
}