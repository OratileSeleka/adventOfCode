import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class Day6Test {
    private lateinit var day6: Day6

    private fun generateData() : List<String> {
        val list = mutableListOf<String>()
        list.add("abc")
        list.add("")
        list.add("a")
        list.add("b")
        list.add("c")
        list.add("")
        list.add("ab")
        list.add("ac")
        list.add("")
        list.add("a")
        list.add("a")
        list.add("a")
        list.add("a")
        list.add("")
        list.add("b")
        return list
    }

    @Before
    fun setUp() {
        day6 = Day6(generateData())
    }

    @Test
    fun test_calculate_first_returnExpectedNumberOfQuestions() {
        assertEquals(11, day6.calculateFirst())
    }

    @Test
    fun test_calculate_second_returnExpectedNumberOfQuestions() {
        assertEquals(6, day6.calculateSecond())
    }

}