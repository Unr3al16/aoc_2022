import Day04.Day04
import day01.Day01
import day02.Day02
import day03.Day03

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
}