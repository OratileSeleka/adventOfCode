import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class Day3Test {

    private lateinit var day3: Day3

    @Before
    fun setUp() {
        day3 = Day3(generateData())
    }

    private fun generateData() : List<String> {
        val list = mutableListOf<String>()
        list.add(".#####......")
        list.add("...#.#.#....")
        list.add(".......#..#.")
        return list
    }

    @Test
    fun test_firstChallenge_returnExpectedNumberOfTrees() {
        assertEquals(1, day3.firstChallenge(3, 1))
    }
}