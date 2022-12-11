package Day08

import utils.Loader

class Day08 {

    fun analyseTreeMap() {
        val stringMap = Loader.readFileAsLinesUsingReadLines("src/main/resources/data_aoc_08.txt")
        val treeMap = restructureTreeMap(stringMap)
        println(checkTreeVisibility(treeMap))
        println(findBestTreeSpotByScenicScore(treeMap))
    }

    private fun restructureTreeMap(treeMap: List<String>): Array<IntArray> {
        val rows = treeMap.size
        val col = treeMap[0].length
        val treeMap2D = Array(rows) { IntArray(col) }
        treeMap.forEachIndexed() { idx, line ->
            line.subSequence(0, line.length).forEachIndexed { cidx, cint ->
                treeMap2D[idx][cidx] = cint.digitToInt()
            }
        }
        return treeMap2D
    }

    private fun checkTreeVisibility(treeMap: Array<IntArray>): Int {
        var visible: Int = treeMap.size * 2 + treeMap[0].size * 2 - 4

        for (y in 1 until treeMap.size - 1) {
            for (x in 1 until treeMap[0].size - 1) {
                var r_vis = true
                var l_vis = true
                var t_vis = true
                var b_vis = true

//                look right
                for (rx in 0 until x) {
                    if (treeMap[y][rx] >= treeMap[y][x]) {
                        r_vis = false
                        break
                    }
                }
//                look left
                for (lx in x + 1 until treeMap[0].size) {
                    if (treeMap[y][lx] >= treeMap[y][x]) {
                        l_vis = false
                        break
                    }
                }
//                look up
                for (ty in 0 until y) {
                    if (treeMap[ty][x] >= treeMap[y][x]) {
                        t_vis = false
                        break
                    }
                }
//                look down
                for (by in y + 1 until treeMap.size) {
                    if (treeMap[by][x] >= treeMap[y][x]) {
                        b_vis = false
                        break
                    }
                }
                if (r_vis || l_vis || b_vis || t_vis) {
                    visible += 1
                }
            }
        }
        return visible
    }

    private fun findBestTreeSpotByScenicScore(treeMap: Array<IntArray>): Int {
//        var visible:Int = treeMap.size * 2 + treeMap[0].size * 2 - 4
        var bestScore = 0
        for (y in 0 until treeMap.size) {
            for (x in 0 until treeMap[0].size) {
                var seenL = 0
                var seenR = 0
                var seenT = 0
                var seenB = 0

//                look left
                for (lx in x-1 downTo 0) {
                    if (treeMap[y][lx] < treeMap[y][x]) {
                        seenL++
                    } else if(treeMap[y][lx] >= treeMap[y][x]) {
                        seenL++
                        break
                    }
                }
//                look right
                for (rx in x + 1 until treeMap[0].size) {
                    if (treeMap[y][rx] < treeMap[y][x]) {
                        seenR++
                    }
                    else if (treeMap[y][rx] >= treeMap[y][x]) {
                        seenR++
                        break
                    }
                }
//                look up
                for (ty in y - 1 downTo 0) {
                    if (treeMap[ty][x] < treeMap[y][x]) {
                        seenT += 1
                    }
                    else if (treeMap[ty][x] >= treeMap[y][x]) {
                        seenT += 1
                        break
                    }
                }
//                look down
                for (by in y + 1 until treeMap.size) {
                    if (treeMap[by][x] < treeMap[y][x]) {
                        seenB += 1
                    }
                    else if (treeMap[by][x] >= treeMap[y][x]) {
                        seenB += 1
                        break
                    }
                }
                val score = seenB * seenL * seenR * seenT
                if (score > bestScore) {
                    bestScore = score
                }
            }
        }
        return bestScore
    }


}