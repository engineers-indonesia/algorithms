import java.util.*

/**
 * Algoritma QuickSort.
 * 1. Set PIVOT dari median sebuah array.
 * 2. Swap item PIVOT dengan item terakhir. Proses ini untuk mengurangi resiko worst case.
 * 3. Sort array items dengan membandingkan items kiri dan kanan.
 Jika item kiri lebih besar dari pivot harus diswap dengan item kanan.
 Jika item kanan lebih kecil dari pivot harus diswap dengan item kiri.
 * 4. Jika index item kiri > index item kanan, swap item kiri dengan pivot.
 * 5. Lakukan proses 1-4 untuk items kiri dari pivot
 * 6. Lakukan proses 1-5 untuk items kanan dari pivot.  
 */
fun quickSort(
    startIndex: Int,
    endIndex: Int,
    array: MutableList<Int>
): MutableList<Int> {

    if (startIndex >= endIndex) {                       
        return array
    }
            
    // Proses 1 - set pivot
    val indexOfPivot = (startIndex + endIndex)/2
    val pivot = array[indexOfPivot]

    // Proses 2 - swap pivot dengan item terakhir
    val tempLastItem = array[endIndex]
    array[endIndex] = pivot
    array[indexOfPivot] = tempLastItem

    // Proses 3 - sort array
    val sortResult = sortArray(array, startIndex, endIndex, pivot)
    val positionItemFromLeft = sortResult.first
    val newArray = sortResult.second

    // Proses 5 - quick sort items kiri dari pivot
    quickSort(startIndex, positionItemFromLeft-1, newArray)

    // Proses 6 - quick sort items kanan dari pivot
    quickSort(positionItemFromLeft+1, endIndex, newArray)

    return newArray
}

fun sortArray(
    array: MutableList<Int>,
    startIndex: Int,
    endIndex: Int,
    pivot: Int
): Pair<Int, MutableList<Int>> {
    var positionItemFromLeft = startIndex
    // pivot tidak termasuk item yang harus diloop
    var positionItemFromRight = endIndex - 1

    while (positionItemFromLeft <= positionItemFromRight) {
        val itemFromLeft = array[positionItemFromLeft]
        val itemFromRight = array[positionItemFromRight]

        // jika item kiri lebih kecil atau sama dengan pivot, tidak usah diswap dengan item kanan
        if (array[positionItemFromLeft] <= pivot) {
            positionItemFromLeft += 1
        }

        // jika item kanan lebih besar atau sama dengan pivot, tidak usah diswap dengan item kiri
        if (array[positionItemFromRight] >= pivot) {
            positionItemFromRight -= 1
        }

        if (itemFromLeft > pivot && itemFromRight < pivot) {
            val tempItemFromLeft = itemFromLeft
            array[positionItemFromLeft] = itemFromRight
            array[positionItemFromRight] = tempItemFromLeft

            positionItemFromLeft += 1
        }
    }

    // Proses 4 - swap item kiri dengan pivot       
    val tempLeftItem = array[positionItemFromLeft]
    array[positionItemFromLeft] = array[endIndex]
    array[endIndex] = tempLeftItem
            
    return Pair(positionItemFromLeft, array)
}

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

    // 3. Proses QuickSort
    val result = quickSort(0, array.size - 1, array)

    result.forEach {item ->
        print("$item ")
    }

    println()
}
