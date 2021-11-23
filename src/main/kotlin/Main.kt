import java.util.*

fun main(args: Array<String>) {
    print("Input bandage cube: ")
    val s = Scanner(System.`in`)
    val cube = Cube(s.next())

    print("Input scramble: ")
    val scr = s.next()

    println(cube.checkScramble(scr))
}