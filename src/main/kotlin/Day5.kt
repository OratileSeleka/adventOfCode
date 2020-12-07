class Day5(private val input: List<String>) {

    private fun reduce(listInput: MutableList<Int>, value: String): MutableList<Int> {
        return if(value == REGION.F.name || value == REGION.L.name) {
            listInput.size.let {
                val half = it/2
                listInput.subList(0, half)
            }
        } else if(value == REGION.B.name || value == REGION.R.name) {
            listInput.size.let {
                val half = it/2
                listInput.subList(half, it)
            }
        } else listInput
    }

    fun generateListOfIDs() : List<Int> {
        val answersList = mutableListOf<Int>()
        input.forEach { entry ->
            var list = IntArray(128) { i -> i }.toMutableList()
            var list2 = IntArray(8) {i -> i }.toMutableList()
            entry.forEach { code->
                when {
                    list.size != 1 ->  list = reduce(list, code.toString())
                    list2.size != 1 -> list2 = reduce(list2, code.toString())
                }
            }
            answersList.add(list[0] * 8 + list2[0])
        }
        return answersList
    }

    fun findMissingID() {
        var prevToMissing : Int? = null
        val list = generateListOfIDs().sortedBy{ it }
        generateListOfIDs().sortedBy { it }.forEachIndexed { index, entry ->
            if(index != 0 && (entry - list[index - 1] != 1)) {
                prevToMissing = entry
            }
        }
        println("Missing ID: ${prevToMissing?.minus(1)}")
    }

    enum class REGION {
        F, B, L, R
    }
}