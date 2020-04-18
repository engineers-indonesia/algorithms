import java.util.Scanner

/**
 * Algoritma SelectionSort
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // 1. Input jumlah item yang akan disort
    print("Input jumlah item: ")
    val itemCount = scanner.nextInt()

    // 2. Input nilai dari setiap item
    val array = arrayListOf<Int>()
    for(i in 0 until itemCount) {
        print("Item ${i.plus(1)}: ")
        val item = scanner.nextInt()
        array.add(item)
    }

    // 3. Proses InsertionSort
    for (i in 0 until itemCount) {
        var indexMinimumItem = i
        for (j in i until itemCount) {
            if (array[indexMinimumItem] > array[j]) {
                indexMinimumItem = j
            }
        }

        if (array[i] > array[indexMinimumItem]) {
            val temp = array[i]
            array[i] = array[indexMinimumItem]
            array[indexMinimumItem] = temp
        }
    }

    array.forEach { item ->
        print("$item ")
    }

    println()
}
