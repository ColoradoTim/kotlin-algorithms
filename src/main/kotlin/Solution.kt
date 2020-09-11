// hired.com Android assessment
class DuplicatesAndReverseNumber {
    // return true if list has duplicates, else false
    fun hasDuplicates(nums: List<Long>): Boolean {
        if (nums.isEmpty()) return false

        val set = HashSet<Long>()
        for (num in nums) {
            if (set.contains(num)) {
                return true
            } else {
                set.add(num)
            }
        }
        return false
    }

    // reverse digits in a signed long, ex. -65000 -> -56
    fun reverseSignedNumber(x: Long): Long {
        if (x == 0L) return 0L

        var reversed: Long = 0
        try {
            var num = x

            // shift right to pull off each digit
            // shifting is divide by 10 then grab remainder
            while (num > 0 || num < 0) {
                val digit = num % 10
                // now multiply to shift digits left
                reversed *= 10
                reversed += digit
                num /= 10
            }
        } catch (e: Exception) {
            return 0
        }
        return reversed
    }
}
