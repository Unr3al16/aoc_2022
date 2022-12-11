package Day10


import utils.Loader


class Day10 {

    fun readSignalInstruction(){
        val instructions = Loader.readFileAsLinesUsingReadLines("src/main/resources/data_aoc_10.txt")
        val runCycles:List<Int> = listOf(20,60,100,140,180,220)
        var signalStrengthSum = 0
        runCycles.forEach { cycleCount ->
            val signalStrength = calculateSignalStrengthAtCycle(cycleCount, instructions)* cycleCount
            signalStrengthSum += signalStrength
        }
        println(signalStrengthSum)
        drawSprite(instructions)
    }

    private fun calculateSignalStrengthAtCycle(cylces:Int, instrctions:List<String>): Int{
        assert(cylces >= instrctions.size)
        var currentCycle = 2
        var strength = 1
        instrctions.forEach { inst ->
            if (currentCycle > cylces)
            {
                return strength
            }
            if (inst.startsWith("addx")){
                currentCycle += 1
                if (currentCycle > cylces)
                {
                    return strength
                }
                strength += inst.split(" ")[1].toInt()
                currentCycle += 1
            }
            else if (inst.startsWith("noop"))
            {
                currentCycle += 1
            }
        }
        return -1
    }

    private fun drawSprite(instructions:List<String>){
        var currentPos = 1
        var cursorPos = 0
        var cycleIndex = 0
        instructions.forEach { inst ->
            if (inst.startsWith("addx")){
                cycleIndex += 1

                printSign(cursorPos, currentPos)
                if (cycleIndex % 40 == 0){
                    println()
                    cursorPos = 0
                    cycleIndex += 1
                    printSign(cursorPos, currentPos)
                    cursorPos += 1
                    currentPos += inst.split(" ")[1].toInt()
                    return@forEach
                }
                cursorPos += 1
                cycleIndex += 1
                printSign(cursorPos, currentPos)
                cursorPos += 1
                currentPos += inst.split(" ")[1].toInt()
            }
        if (inst.startsWith("noop")){
            cycleIndex += 1
            printSign(cursorPos, currentPos)
            cursorPos += 1
        }
        if (cycleIndex % 40 == 0){
            println()
            cursorPos = 0
        }
        }

    }

    private fun printSign(cursorPos:Int, currentPos:Int){
        if (cursorPos == currentPos - 1 ||
            cursorPos == currentPos ||
            cursorPos == currentPos + 1)
        {
            print("#")
        }
        else{
            print(".")
        }
    }
}