import GridSearch.Companion.countIslands
import kotlin.test.Test
import kotlin.test.assertEquals

class GridSearchTest {
    @Test
    fun countIslands_small() {
        // LWW
        // WWL
        val row1: BooleanArray = booleanArrayOf(true, false, false)
        val row2: BooleanArray = booleanArrayOf(false, false, true)
        val grid: Array<BooleanArray> = arrayOf(row1, row2)
        assertEquals(2, countIslands(grid))
    }

    @Test
    fun countIslands_5x5() {
        /*
        LLWWW
        WLWWL
        WWWLL
        WWWWW
        LWLWL
         */
        val row1: BooleanArray = booleanArrayOf(true, true, false, false, false)
        val row2: BooleanArray = booleanArrayOf(false, true, false, false, true)
        val row3: BooleanArray = booleanArrayOf(false, false, false, true, true)
        val row4: BooleanArray = booleanArrayOf(false, false, false, false, false)
        val row5: BooleanArray = booleanArrayOf(true, false, true, false, true)
        val grid: Array<BooleanArray> = arrayOf(row1, row2, row3, row4, row5)
        assertEquals(5, countIslands(grid))
    }
}