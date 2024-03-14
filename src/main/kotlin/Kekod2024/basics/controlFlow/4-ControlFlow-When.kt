package Kekod2024.basics.controlFlow

fun main() {
    /**
     *
     * Kotlin'de `when` ifadesi, diğer dillerdeki `switch-case` yapısına benzer bir yapıdadır. Ancak Kotlin'de daha güçlü ve esnek bir kullanıma
     * sahiptir.
     * - `when` ifadesini, birden çok koşulun kontrol edilmesi gerektiği durumlarda kullanabilirsiniz.
     * - Birden çok koşulu if-else - else if yazmak yerine tek bir when yapısı kullanarak yazmak daha okunabilir bir kod yazmamıma yardımcı olabilir.
     *
     */


    val grade = readln().toInt()!!
    when (grade) {
        in 0..20 -> println("")
        in 21..40 -> println("aasd")
    }

    val country = readln()
    when (country.lowercase()) {
        "az", "tr" -> println("")
    }


    val x = 5

    when (x) {
        1 -> println("x is 1")
        2 -> println("x is 2")
        3, 4 -> println("x is either 3 or 4")
        in 5..10 -> println("x is between 5 and 10")
        else -> println("x is neither 1 nor 2 nor between 3 and 4 nor between 5 and 10")
    }

    /**
     * - Birden fazla değere karşılık gelmesi için `virgül(,)` kullanılır.
     * - Belirli bir aralığa karşılık gelmesi için `in` anahtar kelimesi kullanılır.
     * - Hiçbir koşulun sağlanmadığı durumlar için `else` kullanılabilir.
     */

    //Expression Kullanımı
    /**
     * `when` ifadesi bir değer döndürebilir. Yukarıdaki örnekte `y` değişkenine, `when` ifadesinin sonuçlarından biri atanır.
     */
    val y = when (x) {
        1 -> "x is 1"
        2 -> "x is 2"
        else -> "x is neither 1 nor 2"
    }


    /**
     * `when` ifadesi tip kontrolü için de kullanılabilir. Bu şekilde, değişkenin hangi türden olduğunu kontrol edebilirsiniz.
     */
    val any: Any = "Hello"

    when (any) {
        is String -> println("It's a String")
        is Int -> println("It's an Integer")
        else -> println("It's neither String nor Integer")
    }
}