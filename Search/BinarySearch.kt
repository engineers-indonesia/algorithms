fun binarySearch(input: Array<Int>, target: Int): Int {
    var l = 0
    var r = input.size - 1

    println("def: l = $l, r = $r")

    while(l <= r) {
        val mid = l + (r - l) / 2

        println("@ mid = $mid")

        if (input[mid] == target) {
            println("*** Eureka!")
            return mid;
        }

        if (input[mid] < target) {
            println("### increase l = ( ${mid + 1} )")
            l = mid + 1
        } else {
            println("### decrease r = ( ${mid - 1} )")
            r = mid - 1
        }
    }

    return -1
}

fun main(args: Array<String>) {
    val input = arrayOf(1, 3, 6, 7, 8, 9, 14, 23, 48, 50, 57, 66, 68, 69, 80)
    val target = 14
    val indexResult = binarySearch(input, target)

    println("Found target on index: $indexResult")
}

