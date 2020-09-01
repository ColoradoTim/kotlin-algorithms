import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

class QualifiedTest {

    @Test
    fun getMiddle(){
        assertEquals("t", Qualified().getMiddle("testing"))
        assertEquals("A", Qualified().getMiddle("A"))
        assertEquals("es", Qualified().getMiddle("test"))
        assertEquals("dd", Qualified().getMiddle("middle"))
    }

    @Test
    fun breakChocolate() {
        assertEquals(0, Qualified().breakChocolate(-1,-1))
        assertEquals(1, Qualified().breakChocolate(1,2))
        assertEquals(24, Qualified().breakChocolate(5,5))
        assertEquals(27, Qualified().breakChocolate(7, 4))
        assertEquals(99, Qualified().breakChocolate(10, 10))
    }

    @Test(expected = IllegalArgumentException::class)
    fun breakChocolate_throws() {
        Qualified().breakChocolate(11, 11)
    }

    @Test
    fun findParity() {
        val exampleTest1 = arrayOf(2,6,8,-10,3)
        val exampleTest2 = arrayOf(206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781)
        val exampleTest3 = arrayOf(Integer.MAX_VALUE, 0, 1)
        assertEquals(3, Qualified().findParity(exampleTest1))
        assertEquals(206847684, Qualified().findParity(exampleTest2))
        assertEquals(0, Qualified().findParity(exampleTest3))
    }
}

