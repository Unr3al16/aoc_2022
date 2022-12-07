package Day04

import utils.Loader

class Day04 {

    fun runReassignmentProcess() {
        val assignments: List<String> = Loader.readFileAsLinesUsingReadLines("src/main/resources/data_aoc_04.txt")
        val restructureAssignements = restructureAssignements(assignments)
        getAmmountOfDroppedAndOverlapsedAssignments(restructureAssignements)
    }

    private fun restructureAssignements(assignments: List<String>): ArrayList<IntRange> {
        val restructuredAssignemnets: ArrayList<IntRange> = ArrayList<IntRange>()
        assignments.forEach() { assignment ->
            assignment.trim().split(",").forEach() {
                val indexes: List<String> = it.split("-")
                restructuredAssignemnets.add(IntRange(indexes[0].toInt(), indexes[1].toInt()))
            }
        }
        return restructuredAssignemnets
    }

    private fun getAmmountOfDroppedAndOverlapsedAssignments(listOfAssignments: ArrayList<IntRange>) {
        var dropped_duplicates = 0
        var overlapsed_assignments = 0
        for (i in 0..listOfAssignments.size - 2 step 2) {
            val first_as: IntRange = listOfAssignments[i]
            val second_as: IntRange = listOfAssignments[i + 1]
            if ((first_as.contains(second_as.first) && first_as.contains(second_as.last)) ||
                (second_as.contains(first_as.first) &&
                        second_as.contains(first_as.last))
            ) {
                dropped_duplicates += 1
            }
            if ((first_as.contains(second_as.first) || first_as.contains(second_as.last)) ||
                (second_as.contains(first_as.first) ||
                        second_as.contains(first_as.last))
            ) {
                overlapsed_assignments += 1
            }
        }
        println("Dropped duplicates: " + dropped_duplicates)
        println("Overlapsing assignments: " + overlapsed_assignments)
    }

}