package Kekod2024.classes


// Primary Constructor

// Bu primary constructor öncesinde bir annotation veya visiblity modifier var ise
// burada constructor belirtmemiz gerekir.
class Car(wheelCount: Int, color: String = "") {

    init {
        println("primary constructor init bloğu")
    }

    // Secondary Constructor
    // Her secondary constructorlar primary constructor'ı işaret etmelidir.
    constructor(wheelCount: Int, color: String = "", name: String) : this(wheelCount = wheelCount, color = color) {
        "1. secondary constructor created".printLog()
    }

    constructor(name: String, madeOf: String) : this(wheelCount = 4) {
        "2. secondary constructor created".printLog()
    }

    val asasd = ""
}

fun String.printLog() {
    println(this)
}

fun main() {
    val car = Car(wheelCount = 2)
    val car1 = Car(wheelCount = 2, color = "Blue")
    val car2 = Car(wheelCount = 2, color = "Blue", name = "Mercedes")
}

// Eğer primary constructor'ın beklediği parametrelere kadar olan kısmını veriyorsam ben nesne oluşturmada
// o zaman sadece init bloğu çalışıyor. -- Car(wheelCount = 2), Car(wheelCount = 2, color = "Blue")

// Ama ben harici olarak primary constructorda bulunmayan başka bir parametreyi veriyorsam nesne
// oluştururken - Car(wheelCount = 2, color = "Blue", name = "") name primary const içerisinde değil-
// yine init bloğu çalışıyor ama devamında hangi secondary constructor'a uygun parametreyi verdiysem o çalışacak.

// Yani her zaman init bloğu çalışıyor çünkü Kotlin'de secondary constructorlar primary constructor ile
// bağlantılı olmalıdır. Daha sonra secondary constructor içerisinde çalışır.