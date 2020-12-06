class Day3(private val inputLines: List<String>) {

    fun firstChallenge(stepsToTheRight: Int, stepsDown: Int) : Int {
        var numberOfTrees = 0
        var count = 0
        val numberOfColumns = inputLines[0].length
        val point = Point()
        for(i in inputLines.indices) {
            for(j in 1..stepsToTheRight + stepsDown) {
                point.y.let {
                    if(it > numberOfColumns -1) {
                        point.y = 0
                    }
                }

                if(j <= stepsToTheRight) {
                    point.y ++
                } else if(point.x != inputLines.size - 1) {
                    point.x ++
                    if(j == stepsDown + stepsToTheRight) {
                        inputLines[point.x][point.y].let { obstacle ->
                            if(obstacle == Obstacle.TREE.symbol) {
                                numberOfTrees++
                                count++
                            }
                        }
                    }
                } else {
                    break
                }
            }
        }
        return numberOfTrees
    }

}

data class Point(var x: Int = 0, var y: Int = 0)

enum class Obstacle(val symbol: Char) {
    OPEN_SQUARE('.'),
    TREE('#')
}