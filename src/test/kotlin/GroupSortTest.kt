import GroupSort.Companion.groupSort
import kotlin.test.Test
import kotlin.test.assertTrue

class GroupSortTest {
    @Test
    fun sort() {
        val actual = groupSort(arrayOf(1))
        val expected = arrayOf(arrayOf(1, 1))
//        print("expected=")
//        println(expected.contentDeepToString())
//        print("actual=")
//        println(actual.contentDeepToString())

        assertTrue(expected.contentDeepEquals(actual))
    }

    @Test
    fun sort_7123() {
        val actual = groupSort(arrayOf(7, 12, 3))
        val expected = arrayOf(arrayOf(3, 1), arrayOf(7, 1), arrayOf(12, 1))

        assertTrue(expected.contentDeepEquals(actual))
    }

    @Test
    fun sort_complex() {
        val actual = groupSort(arrayOf(3,3,1,2,1))
        val expected = arrayOf(arrayOf(1,2), arrayOf(3,2), arrayOf(2, 1))

        assertTrue(expected.contentDeepEquals(actual))
    }

    @Test
    fun sort_6() {
        val actual = groupSort(arrayOf(66, 66, 66, 32, 32, 32, 45, 45, 45))
        val expected = arrayOf(arrayOf(32,3), arrayOf(45, 3), arrayOf(66, 3))

        assertTrue(expected.contentDeepEquals(actual))
    }
}