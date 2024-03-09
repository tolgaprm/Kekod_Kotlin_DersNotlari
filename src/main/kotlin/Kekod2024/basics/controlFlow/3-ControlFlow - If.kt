package Kekod2024.basics.controlFlow

fun main() {
    // İf ifadesi, bir koşulun doğru veya yanlış olmasına bağlı olarak belirli bir kod bloğunu çalıştırmak için kullanılır.


    /**
     * Kotlin'de if ifadelerini kullanırken iki şek
     * State Kullanımı
     * Expression Kullanımı
     *
     * Kotlin'de sadece aynı tip'lerin birbiri ile karşılaştırılması yapılabilir.
     */

    val answer = readln()

    if (answer.contains("Evet", ignoreCase = true)) {
        println("Öğrenci")
    } else {
        println("Öğrenci Değil")
    }


    if (answer.contains("Evet", ignoreCase = true)) println("Öğrenci")
    else println("Öğrenci Değil")


    if (answer.contains("Evet", ignoreCase = true)) println("Öğrenci") else println("Öğrenci Değil")


    val grade = 75

    if (grade >= 90 && grade <= 100) {
        println("Notunuz A")
    } else if (grade >= 80 && grade < 90) {
        println("Notunuz B")
    } else if (grade >= 70 && grade < 80) {
        println("Notunuz C")
    } else if (grade >= 60 && grade < 70) {
        println("Notunuz D")
    } else {
        println("Notunuz F")
    }

    if (grade >= 90 && grade <= 100) {
        println("Notunuz A")
    }
    if (grade >= 80 && grade < 90) {
        println("Notunuz B")
    }
    if (grade >= 70 && grade < 80) {
        println("Notunuz C")
    }
    if (grade >= 60 && grade < 70) {
        println("Notunuz D")
    }

    /*
        if if if yazmak ile
        if else yazmanın farkı nedir? Mülatakt sorusu
 */

    /**
     * İLk başta bir if durumu yapın sonra diğer durum else olarak ele alınsın
     * bu durda return desin anladın sen onu
     */


    /**
     * if - else if kullanımınında ilk if içerisinde grade kısmını kpntorl ettik isek
     * diğer else if ifadelerinde de grade için farklı sonuçlarını kontrol etmeliyiz. Bu else if
     * içerisinde farklı bir durumu kontrol etmemeliyiz. o zamna ayrı bir if yazmalıyız.
     */
}

fun validatePassword() {
    val password = "password23"

    if (password.isBlank()) {
        return
    }

    if (password.length < 6) {
        return
    }
}