package Kekod2024.basics.basic_types

fun main() {
    /**
     * Sonlu sayıli bir aralık oluşturmak oluşturmak için kullanılır
     */

    /**
     * Küçükten büyüğe liste oluşturmak için
     * .. operatörünü yada rangeTo(),
     * ..< operatörünü yada rangeUntil(),
     *
     */


    val numbers: IntProgression = 1..100 step 2// [1,100]
    val numbers2 = 1.rangeTo(100) step 2

    println("NumberRange First:${numbers.first}")
    println("NumberRange Last:${numbers.last}")
    println("NumberRange Step:${numbers.step}")
    println("NumberRange Count:${numbers.count()}")


    val numbersUntil = 1..<100 step 3//[1,100)
    val numbersUntil2 = 1.rangeUntil(100) step 3 /// 1,2,3,4,...,99


    /**
     *  until kullanarak da küçükten büyüğe range tanımlanabilir. Bu durumda bitiş değeri listeye dahil edilmemiş olur.
     */

    val gradeNumbers = 30.until(90) step 5
    val gradeNumbers2 = 30 until 90 step 5// rangeUntil'de kullanılabilir. yada ..<
    println()
    gradeNumbers.forEach { print("$it ") }

    /**
     * Char'lardan oluşan bir liste oluşturabilirz. Türkçe karakterlerini içermez.
     *
     */

    val alphabet = 'A'..'Z'
    println()
    alphabet.forEach { print("$it ") }

    /**
     * Büyükten küçüğe bir range oluşturmak için kullanılan fonksiyon
     */

    val reversedNumbers = 100.downTo(1)
    val reversedNumbers2 = 100 downTo 1 step 2
    println()
    reversedNumbers2.forEach { print("$it ") }

    /**
     * step fonksiyonunu kullanarak liste oluştururken belli sayıda atlamalar yaparak bir liste oluşturur.
     */

    val steppedNumbers = 1..100 step 2
    val reversedSteppedNumbers = 100 downTo 1 step 2


    /**
     * Bu range yapıları Progression olarak da adlandırılır.
     *  "Progression", aritmetik bir ilerleme (progression) türünü temsil eder. Bu ilerleme türleri,
     *  genellikle sayısal (integral) türlerle ilişkilidir ve belirli bir başlangıç, bitiş ve adım değeri arasında belirli
     *  bir sıra veya diziyi temsil ederler.
     *
     *  IntProgression, LongProgression, CharProgression
     *
     *  Bu Progression yapıları Iterable interface'ini uyguladığı için map, filter gibi collections fonksiyonlarını
     *  kullanabiliriz.
     */
}