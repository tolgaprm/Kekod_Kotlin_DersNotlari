package Kekod2024.basic_types

fun main() {

    /**
     *
     * 16 bit alan kaplar
     *
     * Tek tırnakların arasına, harf, sayi, escape char ya da unicode yazrak kullanırız.
     *
     *  Çift tırnak içerisne yazar isek String olur.
     */

    val firstCharOfName = 'T'
    val firstCharOfName2 = "T" // String
    // val firstCharOfName3 = 'TO' // Bu şekilde tek tırnaklar içerisine birden fazla character ekleyemeiz

    println('H'.toInt())


    val charCode = '9' // Eğer bir character'e sayı verirsek ASCI tablosu
    // Burada bunu charCode.code (yada toInt()) diye bir çevirim yaparsak 9 değerinin ASCI tablosundaki
    // decimal karşılığını bize verecektir. Yani bu işlemin çıktısı 57 olacaktır.

    // Ama eğer bu char içerisindeki sayısal olarak değeri ile işlem yapmak istiyorum,
    // ASCII tablosundali değeri ile değil diyorsak digitToInt() fonksiyonunu kullanabiliriz.
    // Burada dikkat etmelitiz eğer char içerisinde Int'e dönüşü yapılamayacak bir değer var ise
    // programımız hata verecektir.


    // Escape karakterlerini tanımlamak için de kullanılır. Char tipi.
    // \n \t \\b

    // Unicode
    val blackHeart = '\u2665'
    val heavyBlackHeart = '\u2764'

    val ANSI_RED = "\u001B[31m"
    // ANSI Renk sıfırlama kodu (Metni varsayılan rengine döndürür.)
    val ANSI_RESET = "\u001B[0m"

    println("First commit with $ANSI_RED$blackHeart$ANSI_RESET")
}