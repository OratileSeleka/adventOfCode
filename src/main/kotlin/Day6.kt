class Day6(private val input: List<String>) {

    fun calculateFirst() : Int {
        var totalYesCounts = 0
        var counter = 0
        val listOfAnswersAnsweredYes = mutableListOf<Char>()
        input.forEachIndexed { index, entry ->
            entry.forEach {  question ->
                listOfAnswersAnsweredYes.any { it == question }.let {  result ->
                    if(!result) listOfAnswersAnsweredYes.add(question)
                }
            }

            if (entry.isEmpty() || index == input.size - 1) {
                counter++

                println("$counter: ${listOfAnswersAnsweredYes.size}")

                totalYesCounts += listOfAnswersAnsweredYes.size
                listOfAnswersAnsweredYes.clear()
            }

        }

        println("Total Yes: $totalYesCounts")
        return totalYesCounts
    }

    fun calculateSecond() : Int {
        val listOfAnswersAnsweredYes = mutableMapOf<Char, Int>()
        var totalParticipantsInGroup = 0
        var totalYesCounts = 0

        input.forEachIndexed { index, entry ->
            totalParticipantsInGroup ++
            entry.forEach {  question ->
                listOfAnswersAnsweredYes.any { pair -> pair.key == question }.let { result ->
                    if(result) listOfAnswersAnsweredYes[question] = listOfAnswersAnsweredYes.getOrDefault(question, 0) + 1 else listOfAnswersAnsweredYes[question] = 1
                }
            }

            if (entry.isEmpty() || index == input.size - 1) {
                val temp = if(index == input.size - 1) totalParticipantsInGroup else totalParticipantsInGroup - 1
                println("Total Participants: $temp")
                val valid = listOfAnswersAnsweredYes.filter { it.value != 0 && it.value == temp }
                totalYesCounts += valid.size
                println("Total Yeses: $valid")
                listOfAnswersAnsweredYes.clear()
                totalParticipantsInGroup = 0
            }
        }
        return totalYesCounts
    }

}