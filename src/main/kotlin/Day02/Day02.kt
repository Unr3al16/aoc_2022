package Day02

import utils.Loader

class Day02() {

    val win: Int = 6
    val draw: Int = 3

    fun getResultsForRockScissorPaper() {
        println(play()["First"])
        println(play()["Second"])
    }

    private fun play(): Map<String,Int> {
        val listOfData: List<String> = Loader.readFileAsLinesUsingReadLines("src/main/resources/data_aoc_02.txt")
        val pointsOfGame = mutableMapOf<String, Int>()
        var firstRound = 0
        var secondRound = 0
        listOfData.forEach() { line ->
            val challenge: List<Int> = line.split(" ").map { splitString -> reinterpreteCharacter(splitString) }
            firstRound += rockScissorPaper(challenge)
            secondRound += strategicRockScissorPaper(challenge)
        }
        pointsOfGame["First"] = firstRound
        pointsOfGame["Second"] = secondRound
        return pointsOfGame
    }

    private fun rockScissorPaper(challenge:List<Int>):Int
    {
        var points = 0
        if (challenge[0] == challenge[1]) {
            points += challenge[1] + draw
        } else if (challenge[0] - challenge[1] == -1 || challenge[0] - challenge[1] == 2) {
            points += challenge[1] + win
        } else {
            points += challenge[1]
        }
        return points
    }

    private fun strategicRockScissorPaper(challenge:List<Int>):Int
    {
        var points = 0
        if (challenge[1] == 2) {
            points += draw + challenge[0]
        } else if (challenge[1] == 3) {
            points += win + (challenge[0] % 3) + 1
        } else {
            var losePoints = (challenge[0] - 1) % 3
            if (losePoints == 0) {
                losePoints = 3
            }
            points += losePoints
        }
        return points
    }

    private fun reinterpreteCharacter(Character: String): Int {
        if (Character == "A" || Character == "X") {
            return 1
        }
        if (Character == "B" || Character == "Y") {
            return 2
        }
        return 3
    }
}