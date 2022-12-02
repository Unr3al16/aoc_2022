package utils

import java.io.File

class Loader {
    companion object {
        fun readFileAsLinesUsingReadLines(fileName: String): List<String> = File(fileName).readLines()
    }
}