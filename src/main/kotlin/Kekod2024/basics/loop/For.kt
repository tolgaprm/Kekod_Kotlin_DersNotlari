package Kekod2024.basics.loop

fun main() {
    /**
     * 3 farklı şekllide for tanımlanabilir
     * value in list                     şeklinde value değerlerini alabilirsiniz.
     * index in list.indices             şeklinde index değerlerini alabilirsiniz.
     * (index,value) in list.withIndex() şeklinde index ve value değerlerini alabilirsiniz. Desuctiring
     */

    val value = 60

    for (value in 1..100) { // 1,2,3,4,5,6,7,8,9,10

    }

    val countryCodeArray = arrayOf("tr", "az", "en", "fr")

    for (value in countryCodeArray) {
        print("$value - ")
    }

    for (index in countryCodeArray.indices) {
        println("$index.değeri: ${countryCodeArray[index]}")
    }


    // Destructuring declarations
    // Indexed value
    for ((index, value) in countryCodeArray.withIndex()) {
        println("Index: $index  Value:$value")
    }


    /**
     * repeat(size) herhangi bir listeye ihityaç duymadan tekrarlayan işler yapabilirz.
     *
     */

    repeat(5) {
        print("")
    }

    /**
     * return kullanarak ilgili şart sağlanırsa, döngüden çıkabilirsiniz.
     * continue kullanarak ilgigli şart sağlanırsa, döngüye o değeri atlayarak devam edebilirsiniz.
     */


    for (value in 1..50) {
        if (value % 2 == 1) {
            continue
        }
        println(value)
    }


    for (value in 1..50) {
        if (value % 2 == 1) {
            break
        }
        println(value)
    }

    /**
     * İç içe for kullandığımızda bir üsteki for değil de istediğimiz bir fora dönmek istiyorsak label kullanabiliriz.
     * label@
     */

    /**
     * return fonksiyon içerisinden çıkmamızı sağlıyor.
     * Scope fonksiyon içerisinde de return@let diye bir kullanım yapabilyoruz. Çünkü adı üstünde zaten bir fonksiyon
     */

    outerForLabel@ for (value in 1..50) {
        for (value2 in 1..20) {
            if (value2 == 5) {
                continue@outerForLabel
            }

            println("")
        }
    }


    breakLabel@ for (value in 1..50) {
        for (value2 in 1..20) {
            if (value2 == 5) {
                break@breakLabel
            }

            println("")
        }
    }

}