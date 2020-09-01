import java.util.*

class GroupSort {

    companion object {
        // Chipotle online coding test
        fun groupSort(arr: Array<Int>): Array<Array<Int>> {
            if (arr.isNullOrEmpty() || arr.size > 100000) {
                throw IllegalArgumentException("array size must be between 1 and 10000 elements")
            }

            val sortedArray = arr.sortedBy{it}

            val frequencyMap = LinkedHashMap<Int, Int>()

            for (integer in sortedArray) {
                if (frequencyMap.containsKey(integer)) {
                    val frequency = frequencyMap[integer]!!
                    frequencyMap[integer] = frequency + 1
                } else {
                    frequencyMap[integer] = 1
                }
            }

            // Need to sort by descending value, then ascending key.
            // To sort by value first, multiply it by the largest possible array size which is 10^5;
            // to sort next by ascending key, we "invert" the key by subtracting its value
            val selector: (Pair<Int, Int>) -> Int = { (key, value) -> value * 1000000 - key }
            val frequencyMapSortedByFrequencyA: Map<Int, Int> =
                frequencyMap.toList().sortedByDescending(selector).toMap()

            var index = 0
            val outerArray: Array<Array<Int>?> = arrayOfNulls(frequencyMapSortedByFrequencyA.size)
            for ((number, frequency) in frequencyMapSortedByFrequencyA) {
                val innerArray = arrayOf(number, frequency)
                outerArray[index++] = innerArray
            }

            // now that we know the array is populated, cast to non-optional
            return outerArray as Array<Array<Int>>
        }
    }
}