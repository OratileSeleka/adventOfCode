class Day4(private val passports: List<String>) {

    fun calculateNumberOfValidPassports() {
        var numberOfValidFields = 0
        var numberOfValidPassports = 0
        passports.forEachIndexed { index, entry ->
            if(entry.isNotEmpty()) {
                entry.split(' ').let {
                    it.forEach { keyValue ->
                        FIELDS.values().any { field ->
                            field.name.equals(keyValue.split(':')[0], true) && field.name != FIELDS.CID.name && validateField(field, keyValue.split(':')[1])
                        }.let { result ->
                            println(result)
                            if (result) numberOfValidFields++
                        }
                    }
                }
            }
            if (entry.isEmpty() || index == passports.size - 1) {
                if (numberOfValidFields == 7) numberOfValidPassports++
                numberOfValidFields = 0
            }
        }
        println("Total Number Of New Lines: $numberOfValidPassports")
    }

    private fun validateField(key: FIELDS, value: String): Boolean {
        var isValid = false
        return when (key) {
            FIELDS.BYR -> {
                if(value.length == 4) {
                    isValid = value.toIntOrNull() != null && value.toInt() in 1920..2002
                }
                isValid
            }
            FIELDS.IYR -> {
                if(value.length == 4) {
                    isValid = value.toIntOrNull() != null && value.toInt() in 2010..2020
                }
                isValid
            }
            FIELDS.EYR -> {
                if(value.length == 4) {
                    isValid = value.toIntOrNull() != null && value.toInt() in 2020..2030
                }
                isValid
            }
            FIELDS.HGT -> {
                val metric = value.substring(0, value.length - 2)
                if(value.endsWith("cm") && metric.toIntOrNull() != null) {
                   isValid = metric.toInt() in 150..193
                } else if (value.endsWith("in") && metric.toIntOrNull() != null) {
                   isValid = metric.toInt() in 59..76
                }
                isValid
            }
            FIELDS.HCL -> {
                if(value.startsWith("#") && value.length == 7) {
                    value.forEach { character ->
                        isValid = character.toInt() != 35 && character.toInt() in 48..57 || character.toInt() in 97..102
                    }
                }
                isValid
            }
            FIELDS.ECL -> {
                val eyeColours = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
                isValid = eyeColours.any { eyeColour -> eyeColour == value }
                isValid
            }
            FIELDS.PID -> {
                isValid = value.length == 9 && value.toIntOrNull() != null
                isValid
            }
            else -> isValid
        }
    }
}


enum class FIELDS(field: String) {
    BYR("byr"),
    IYR("iyr"),
    EYR("eyr"),
    HGT("hgt"),
    HCL("hcl"),
    ECL("ecl"),
    PID("pid"),
    CID("cid")
}