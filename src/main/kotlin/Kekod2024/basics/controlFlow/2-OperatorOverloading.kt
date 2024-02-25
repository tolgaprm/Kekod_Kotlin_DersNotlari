package Kekod2024.basics.controlFlow


data class PairNumber(val numberOne: Int, val numberTwo: Int) {

    operator fun minus(other: PairNumber): PairNumber {

        val localNumberOne = numberOne - other.numberOne
        val localNumberTwo = numberTwo - other.numberTwo

        val newPairObject = PairNumber(
            numberOne = localNumberOne,
            numberTwo = localNumberTwo
        )

        return newPairObject
    }
}

class Vektor(var x: Int, var y: Int) {
    // Toplama operatörünü aşırı yükleyelim (+)
    operator fun plus(other: Vektor): Vektor {
        return Vektor(x + other.x, y + other.y)
    }

    // Çıkarma operatörünü aşırı yükleyelim (-)
    operator fun minus(other: Vektor): Vektor {
        return Vektor(x - other.x, y - other.y)
    }

    // Çarpma operatörünü aşırı yükleyelim (*)
    operator fun times(scalar: Int): Vektor {
        return Vektor(x * scalar, y * scalar)
    }
}

fun main() {
    val vektor1 = Vektor(x = 2, y = 3)
    val vektor2 = Vektor(x = 4, y = 6)

    val vektorPlus = vektor1 + vektor2

    // Eğer biz bu operator fonksiyonlarını kullanmasaydık ve iki vektörü toplamak istediğimizde şu şekilde bir kullanım yapacaktık.
    val vektorPlusWithoutOperatorOverload = Vektor(x = vektor1.x + vektor2.x, y = vektor2.y + vektor2.y)


    val pairNumber = PairNumber(5, 7)
    val pairNumber2 = PairNumber(-8, 11)
    val resultOne = pairNumber.numberOne - pairNumber.numberTwo

    val resultPairMinusNumber = pairNumber - pairNumber2
    // val resultPairPlusNumber = pairNumber + pairNumber2 plus operatörü overload edilmediği için kullanamayız.


    // What is invoke operator

    // Eğer yukarıdaki minus fonksiyonuna operator keyword kullanmasaydık, - operatorü ile işlem yapamazdık. Ama minus
    // fonksiyonunu kullanabiliriz.

    // Ama her fonksiyona operator keyword'ü tanımlayamayız.
    /**
     * operator fun foo(){}
     */
}