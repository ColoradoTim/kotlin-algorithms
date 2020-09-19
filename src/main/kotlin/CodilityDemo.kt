/*
codility demo test
Write a function:
fun solution(A: IntArray): Int

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
Given A = [1, 2, 3], the function should return 4.
Given A = [−1, −3], the function should return 1.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
fun solution(A: IntArray): Int {
    A.sort()
    var lastInt = 0
    for (i in A.indices) {
        val value = A[i]
        if (value <= 0 || value == lastInt) {
            continue
        }

        if (lastInt + 1 != value) {
            // found our gap
            return lastInt + 1
        } else {
            lastInt = value
        }
    }

    return if (A.last() < 1) {
        1
    } else {
        A.last() + 1
    }
}


