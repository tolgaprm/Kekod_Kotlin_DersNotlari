package Kekod2024.basics.basic_types

fun main() {

    // Kotlin'de implicit type conversion yoktur. Explicit olarak belirtmeliyiz. toInt(), toString() vs

    // Değer aralığı küçük olan tipler büyük olan tiplere sorunsuz bir şekilde değiştirilebilir.

    val schoolNumber1: Short = 1809
    val convertedNumber = schoolNumber1.toInt()
    println(convertedNumber) // Çıktı:

    // Ama büyük değer aralığında olan bir değişkeni, küçük değer aralığı olan bir değişken tipine dönüştürme işlemi
    // yaptığınızda anlamsız bir sonuç alabilirsiniz. 

    val schoolNumber = 1809
    val convertedValue = schoolNumber.toByte()

    println(convertedValue)

    /*
    * İki number arasında matematiksel işlem yapılırsa, sonuç değeri çıkan değerin tipinde olacaktır.
    * */

    val longValue = 400000L
    val intValue = 34
    val totalValue = longValue + intValue // Long + Int = Long
}