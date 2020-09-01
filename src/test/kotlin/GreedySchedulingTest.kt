import GreedyScheduling.Companion.maxEvents
import kotlin.test.assertEquals
import kotlin.test.Test

class GreedySchedulingTest {
    @Test
    fun maxEvents_simple() {
        assertEquals(4, maxEvents(arrayOf(1, 2, 3, 4), arrayOf(1, 1, 1, 1)))
    }

    @Test
    fun maxEvents_four() {
        assertEquals(4, maxEvents(arrayOf(1, 3, 3, 5, 7), arrayOf(2, 1, 2, 2, 3)))
    }

    @Test
    fun maxEvents_one() {
        assertEquals(3, maxEvents(arrayOf(1, 3, 3, 5, 7), arrayOf(20, 1, 2, 2, 3)))
    }

    @Test
    fun maxEvents_short() {
        assertEquals(1, maxEvents(arrayOf(1, 2), arrayOf(20, 20)))
    }
}
