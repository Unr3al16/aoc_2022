package Day06

import utils.Loader

class Day06 {

    fun startSignalProcessing(){
        val signal = Loader.readFileAsLinesUsingReadLines("src/main/resources/data_aoc_06.txt")[0]
        println( searchFirstMarkerInSignal(signal=signal,4))
        println( searchFirstMarkerInSignal(signal=signal,14))
    }

    private fun searchFirstMarkerInSignal(signal:String, searchWindow:Int): Int{
        var countOfProcessedCharacter = 0
        for (i in searchWindow .. signal.length step 1){
            val sub_signal = signal.subSequence(i-searchWindow,i)
            var found = false
            sub_signal.forEachIndexed(){index, Character ->
                if (sub_signal.count { it == Character } > 1)
                    found = true
            }
            if (found){
                countOfProcessedCharacter += 1
            }else{
                countOfProcessedCharacter += searchWindow
                return countOfProcessedCharacter
            }
        }
        return signal.length
    }

}