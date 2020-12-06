import java.io.File

fun main(args: Array<String>) {
    val inputLines = readFileLineByLine("C:\\Users\\oratile.seleka\\Desktop\\adventOfCode\\src\\main\\day3_input.txt")
    val day3 = Day3(inputLines)
    println("Number Of Trees: ${day3.firstChallenge(3, 1)}")
    println(" ${day3.firstChallenge(1, 1)}")
    println(" ${day3.firstChallenge(3, 1)}")
    println(" ${day3.firstChallenge(5, 1)}")
    println(" ${day3.firstChallenge(7, 1)}")
    println(" ${day3.firstChallenge(1, 2)}")
    val product = day3.firstChallenge(1, 1) *
            day3.firstChallenge(3, 1) *
            day3.firstChallenge(5, 1) *
            day3.firstChallenge(7, 1) *
            day3.firstChallenge(1, 2)

    println("Product: $product")
}

fun day1() {
    val numbers = readFileLineByLine("C:\\Users\\oratile.seleka\\Desktop\\advent-of-code\\src\\main\\day1_input.txt")
    val below1000 = numbers.map{it to it.toInt()}.filter { it.second <= 1000 }.toMap()
    val numbersThatAddsTo2020 = mutableListOf<Pair<Int, Int>>()
    numbers.forEach { strNumber ->
        if(below1000[strNumber] == null) {
            below1000.forEach {
                val sum = strNumber.toInt() + it.value
                println("Sum is $sum")
                if(sum == 2020) {
                    numbersThatAddsTo2020.add(Pair(strNumber.toInt(), it.value))
                }
            }
        }
    }
/*
    below1000.forEach {
        println(it.value)
    }*/
    var max = numbersThatAddsTo2020[0].first * numbersThatAddsTo2020[0].second
/*

    below1000.forEach {
        println(it.value)
    }

    val sum = below1000.values.reduce{sum, element -> sum + element}

    println(below1000.size)
*/
    below1000.entries.forEachIndexed { index, entry ->
        below1000.entries.toList().subList(index, below1000.size).forEach { entry1 ->
            (2020 - (entry.value + entry1.value)).let {  diff ->
                if(below1000[diff.toString()] != null) {
                    println("1: ${entry.value} 2: ${entry1.value} 3: $diff ")
                    println("Sum: ${entry.value + entry1.value + diff}")
                    println("Product: ${entry.value * entry1.value * diff}")
                    return
                }
            }
        }
    }
/*
    println("Sum is: $sum")*/

}

fun day2One() {
    val inputLines = readFileLineByLine("C:\\Users\\oratile.seleka\\Desktop\\advent-of-code\\src\\main\\day2_input.txt")
    var totalCorrectPasswords = 0
    inputLines.forEach { inputLine->
        inputLine.split(' ').let { partsOfInputLine ->
            partsOfInputLine[2].let {
                it.count { character -> character == partsOfInputLine[1][0] }.let { numberOfOccurences ->
                    partsOfInputLine[0].split('-').let { upperAndLowerBounds ->
                        val lowerBound = upperAndLowerBounds[0].toInt()
                        val upperBound = upperAndLowerBounds[1].toInt()
                        if(numberOfOccurences in lowerBound..upperBound)
                            totalCorrectPasswords++
                    }
                }
            }
        }
    }
    println("Total Number Of Correct Passwords Is: $totalCorrectPasswords")
}

fun day2Two() {
    val passwords = readFileLineByLine("C:\\Users\\oratile.seleka\\Desktop\\advent-of-code\\src\\main\\day2_input.txt")
    var totalCorrectPasswords = 0
    passwords.forEach {  password->
        password.split(' ').let { passwordParts ->
            passwordParts[0].split('-').let { upperAndLower ->
                val firstCharacter = passwordParts[2][upperAndLower[0].toInt() - 1]
                val secondCharacter = passwordParts[2][upperAndLower[1].toInt() - 1]
                passwordParts[1][0].let { character ->
                    if((character == firstCharacter && character != secondCharacter) || (character != firstCharacter && character == secondCharacter))
                        totalCorrectPasswords++
                }
            }
        }
    }
    println("Total Valid Passwords: $totalCorrectPasswords")
}



fun readFileLineByLine(file: String) : List<String> = File(file).useLines { it.toList()}