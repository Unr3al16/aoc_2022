package day03

import utils.Loader
import java.util.ListResourceBundle

class Day03 {

    val ALPHABETH = listOf<Char>(
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't',
        'u',
        'v',
        'w',
        'x',
        'y',
        'z'
    )

    fun printBackPackPackingResult() {
        val backpacks: List<String> = Loader.readFileAsLinesUsingReadLines("src/main/resources/data_aoc_03.txt")
        println(findWrongItemsInBackpack(backpacks))
        println(findWrongItemInGroupedBackpacks(backpacks))
    }

    private fun findWrongItemInGroupedBackpacks(backpackList: List<String>):Int {
        var duplicated_points:Int = 0
        for (i in 0 .. backpackList.size - 3 step 3) {
            val packs:List<String> = backpackList.subList(i, i+3)
            val duplicates: List<Char> = packs[0].toList().intersect(packs[1].toList()).toList().intersect(packs[2].toList()).toList()
            duplicates.forEach() { item ->
                val l_item = item.lowercaseChar()
                duplicated_points += ALPHABETH.indexOf(l_item) + 1
                if (item.isUpperCase())
                    duplicated_points += 26
            }
        }
        return duplicated_points
    }

    private fun findWrongItemsInBackpack(backpackList: List<String>): Int {
        var duplicate_points = 0
        backpackList.forEach() {
            val pack_one: String = getPartialBackpack(it, 1)
            val pack_two: String = getPartialBackpack(it, 2)
            val duplicates: List<Char> = pack_one.toList().intersect(pack_two.toList()).toList()
            duplicates.forEach() { item ->
                val l_item = item.lowercaseChar()
                duplicate_points += ALPHABETH.indexOf(l_item) + 1
                if (item.isUpperCase())
                    duplicate_points += 26
            }
        }
        return duplicate_points
    }

    private fun getPartialBackpack(backpackCompartmenss: String, numberOfBackpack: Int): String {
        val packSize = backpackCompartmenss.length

        val subList: String
        if (numberOfBackpack == 1)
            subList = backpackCompartmenss.substring(0, packSize / 2)
        else if (numberOfBackpack == 2)
            subList = backpackCompartmenss.substring(packSize / 2)
        else
            subList = ""
        return subList
    }
}