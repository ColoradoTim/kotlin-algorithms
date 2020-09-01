import kotlin.test.assertEquals
import org.junit.Test

class GreeterTest {

    @Test
    fun testSayHello() {
        assertEquals("Hello, Qualified!", Greeter.sayHello("Qualified"))
    }
}