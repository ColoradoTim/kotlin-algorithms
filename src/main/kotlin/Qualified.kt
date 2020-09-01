import java.lang.IllegalArgumentException

class Qualified {
    // Kroger interview on qualified.io
    fun getMiddle(word: String): String {
        if (word.isEmpty()) return ""

        if (word.length >= 1000) {
            throw IllegalArgumentException("string length must be < 1000")
        }

        val evenLength = word.length % 2 == 0
        return if (evenLength) {
            middleTwoChars(word)
        } else {
            middleChar(word)
        }
    }

    fun middleTwoChars(word: String): String {
        val middleIndex = (word.length / 2) - 1
        return word.substring(middleIndex, middleIndex + 2)
    }

    fun middleChar(word: String): String {
        val middleIndex = (word.length - 1) / 2
        return word.substring(middleIndex, middleIndex + 1)
    }


    fun breakChocolate(n: Int, m: Int): Int {
        if (n < 1 || m < 1) {
            return 0
        }

        if (n > 10 || m > 10) {
            throw IllegalArgumentException("values must be <= 10")
        }

        val numBreaksBarToColumn = n - 1
        val numBreaksColumnsInto1x1 = n * (m - 1)
        return numBreaksBarToColumn + numBreaksColumnsInto1x1
    }

    fun findParity(integers: Array<Int>): Int {
        var numOdds = 0
        var numEvens = 0
        var lastOdd: Int? = null
        var lastEven: Int? = null
        for (num in integers) {
            val isEven = (num % 2 == 0)
            if (isEven) {
                lastEven = num
                numEvens += 1
            } else {
                lastOdd = num
                numOdds += 1
            }

            if (numEvens > 1 && lastOdd != null) {
                return lastOdd
            }
            if (numOdds > 1 && lastEven != null) {
                return lastEven
            }
        }
        return 0
    }

}
