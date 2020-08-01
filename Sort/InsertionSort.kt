import java.util.Scanner

/**
 * Algoritma InsertionSort
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
    for(i in 0 until itemCount) {
        var leftIndex = i.minus(1)
        var currentIndex = i

        while(currentIndex > 0 && array[leftIndex] > array[currentIndex]) {    
            val temp = array[leftIndex]
            array[leftIndex] = array[currentIndex]
            array[currentIndex] = temp

            leftIndex = leftIndex.minus(1)
            currentIndex = currentIndex.minus(1)
        }
    }

    array.forEach { item ->
        print("$item ")
    }

    println()
}
