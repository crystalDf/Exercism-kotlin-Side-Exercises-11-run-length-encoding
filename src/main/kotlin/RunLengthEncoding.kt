object RunLengthEncoding {

    fun encode(input: String): String {

        val chars = mutableListOf<Char>()

        for ( i in input.indices) {

            chars.add(input[i])

            if ((i < input.length - 1) && (input[i] != input[i + 1])) {
                chars.add(',')
            }
        }

        return chars.joinToString("").split(",")
                .joinToString("") {
                    when (it.length) {
                        0 -> ""
                        1 -> "${it.first()}"
                        else -> "${it.length}${it.first()}"
                    }
                }
    }

    fun decode(input: String): String {

        val chars = mutableListOf<Char>()

        for ( i in input.indices) {

            chars.add(input[i])

            if ((i < input.length - 1) && (input[i].isLetter() || input[i] == ' ')) {
                chars.add(',')
            }
        }

        return chars.joinToString("").split(",")
                .joinToString("") {
                    when (it.length) {
                        0 -> ""
                        1 -> it
                        else -> "${it.last()}".repeat(it.dropLast(1).toInt())
                    }
                }
    }
}
