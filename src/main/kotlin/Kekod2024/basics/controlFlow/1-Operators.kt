package Kekod2024.basics.controlFlow

fun main() {
    // Operator Fonksiyonları için bir tablo oluştur bence çok güzel durur.
    var numberOne = 10
    val numberTwo = 5

    println("NumberOne: $numberOne")
    println("NumberOne: ${numberOne++}")
    println("NumberOne: ${numberOne}")
    println("NumberOne: ${++numberOne}")

    println(numberOne.compareTo(numberTwo) < 0) // a < b // false
    println(numberOne.compareTo(numberTwo) > 0) // a > b // true
    println(numberOne.compareTo(numberTwo) == 0) // false

    println("${numberOne + numberTwo}")
    println("${numberOne.plus(numberTwo)}")

    println("${numberOne - numberTwo}")
    println("${numberOne.minus(numberTwo)}")

    println("${numberOne * numberTwo}")
    println("${numberOne.times(numberTwo)}")

    println("${numberOne / numberTwo}")
    println("${numberOne.div(numberTwo)}")

    println("${numberOne % numberTwo}") // 10 % 2 = 0 -- 11 % 2 = 1
    println("${numberOne.rem(numberTwo)}")


    println(numberOne.compareTo(numberTwo) == -1)
    println(numberOne.compareTo(numberTwo) == 1)
    println(numberOne.compareTo(numberTwo) == 0)

    println(numberOne compareTo numberTwo == -1)
    println(numberOne compareTo numberTwo == 1)
    println(numberOne compareTo numberTwo == 0)


    val nullNumber: Int? = null


    /**
     * Fonksiyon yapıları mı yoksa operatör kullanımı mı?
     *
     * Ne zaman operator olarak ne zaman operator fonksiyon olarak kullanılır.
     */


    var a = 20
    var b = 10
    a += b
    println("a+=b: " + a)
    a -= b
    println("a-=b: " + a)
    a *= b
    println("a*=b: " + a)
    a /= b
    println("a/=b: " + a)
    a %= b
    println("a%=b: " + a)

    //  println("a+=b : ${a = a + b}") String içerisinde atama işlemleri yapamayız.
    /*
        a+=b // a.plusAssign(b)
        a-=b // a.minusAssign(b)
        a*=b // a.timesAssign(b)
        a/=b // a.divAssign(b)
        a%=b // a.remAssign(b)

     */

    val numbOn = 10
    val numTwo = 5
    println("+a: ${+numbOn}")
    println("+a: ${-numTwo}")
    println("+a: ${-numTwo}")
    println("+a: ${-numTwo}")


    println(numbOn + numTwo.unaryMinus())


    numTwo.unaryMinus()
    /**
     * +a unaryMinus()
     * -a unaryPlus()
     * ++a inc() a = a + 1
     * --a dec() a = a-1
     * !a not()
     */
}