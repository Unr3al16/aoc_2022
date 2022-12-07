package Day01

import utils.Loader

class Day01() {
    fun getResultForCalories()
    {
        println(calculateCalories().max())
        println(calculateCalories().sortedDescending().subList(0,3).sum())
    }

    private fun calculateCalories():List<Int>{
        val content  = Loader.readFileAsLinesUsingReadLines("src/main/resources/data_aoc_01.txt")
        val sums:ArrayList<Int> = ArrayList()
        var sum = 0
        content.forEach{
            if (it == "")
            {
                sums.add(sum)
                sum = 0
            }
            else{
                sum += it.toInt()
            }
        }
        return sums
    }

}