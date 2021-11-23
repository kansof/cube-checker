class Cube(var configuration: String) {
    private val block: Block = Block(configuration)

    fun checkScramble(s: String): Boolean {
        for (c in s.uppercase())
            if (!block.move(c.toString()))
                return false
        return true
    }
}

data class Block(val str: String) {
    private var map = mutableMapOf(
        "U" to ("U" in str.uppercase()),
        "E" to ("E" in str.uppercase()),
        "D" to ("D" in str.uppercase()),
        "L" to ("L" in str.uppercase()),
        "M" to ("M" in str.uppercase()),
        "R" to ("R" in str.uppercase()),
        "F" to ("F" in str.uppercase()),
        "S" to ("S" in str.uppercase()),
        "B" to ("B" in str.uppercase())
    )

    fun move(s: String): Boolean {
        if (map[s] == null || map[s.middle()] == true)
            return false

        val newmap = mutableMapOf<String, Boolean>()
        for (k in map.keys) {
            newmap[k] = map[k.rotate(s)]!!
        }
        map = newmap

        return true
    }
}

fun String.middle() = when (this) {
    "U", "D" -> "E"
    "L", "R" -> "M"
    "F", "B" -> "S"
    else -> ""
}

fun String.rotate(move: String) = when (move) {
    "U" -> when (this) {
        "U", "E", "D" -> this
        "L" -> "B"
        "F" -> "L"
        "B" -> "R"
        "R" -> "F"
        "M" -> "S"
        "S" -> "M"
        else -> ""
    }

    "D" -> when (this) {
        "U", "E", "D" -> this
        "L" -> "F"
        "F" -> "R"
        "R" -> "B"
        "B" -> "L"
        "M" -> "S"
        "S" -> "M"
        else -> ""
    }

    "F" -> when (this) {
        "F", "S", "B" -> this
        "L" -> "U"
        "U" -> "R"
        "R" -> "D"
        "D" -> "L"
        "E" -> "M"
        "M" -> "E"
        else -> ""
    }

    "B" -> when (this) {
        "F", "S", "B" -> this
        "L" -> "D"
        "D" -> "R"
        "R" -> "U"
        "U" -> "L"
        "E" -> "M"
        "M" -> "E"
        else -> ""
    }

    "L" -> when (this) {
        "L", "M", "R" -> this
        "U" -> "F"
        "F" -> "D"
        "D" -> "B"
        "B" -> "U"
        "S" -> "E"
        "E" -> "S"
        else -> ""
    }

    "R" -> when (this) {
        "L", "M", "R" -> this
        "U" -> "B"
        "B" -> "D"
        "D" -> "F"
        "F" -> "U"
        "S" -> "E"
        "E" -> "S"
        else -> ""
    }

    else -> ""
}
