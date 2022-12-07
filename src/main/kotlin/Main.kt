import Day04.Day04
import Day05.Day05
import Day01.Day01
import Day02.Day02
import Day03.Day03
import Day06.Day06

fun main() {
    println("---------------------------------------------")
    println("Day 1\n")
    val d1 = Day01()
    d1.getResultForCalories()
    println("---------------------------------------------")
    println("Day 2\n")
    val d2 = Day02()
    d2.getResultsForRockScissorPaper()
    println("---------------------------------------------")
    println("Day 3\n")
    val d3 = Day03()
    d3.printBackPackPackingResult()
    println("---------------------------------------------")
    println("Day 4\n")
    val d4 = Day04()
    d4.runReassignmentProcess()
    println("---------------------------------------------")
    println("Day 5\n")
    val d5 = Day05()
    d5.startCraneProcedure()
    println("---------------------------------------------")
    println("Day 6\n")
    val d6 = Day06()
    d6.startSignalProcessing()

}