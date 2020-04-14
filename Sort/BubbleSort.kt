import java.io.*
import java.util.*
import java.text.*

/**
 * Algoritma BubbleSort
 */
fun main(args: Array<String>) {
	// Object yang akan digunakan untuk mengambil nilai dari input
	val scanner = Scanner(System.`in`)

	// 1. Input jumlah item yang akan disort
	val itemCount = scanner.nextInt()

	// 2. Input nilai dari setiap item
	val array = arrayListOf<Int>()
	for(i in 0..itemCount - 1) {
		val item = scanner.nextInt()
		array.add(item)
	}

	// 3. Proses BubbleSort
	for(i in 0..itemCount - 1) {
		var isSorted = true
		for (j in 0..itemCount - 2) {
			val firstItem = array[j]
			val secondItem = array[j+1]
			if (firstItem > secondItem) {
				val tempItem = firstItem
				array[j] = secondItem
				array[j+1] = tempItem

				isSorted = false
			}
		}

		if (isSorted) break
	}

	// 4. Tampilkan nilai setiap item dari hasil proses BubbleSort
	array.forEach { item ->
		print("$item ")
	}
	println()
}
