package Kekod2024.classes

/*
    Eğer biz primary constructor yazmak isek arka planda bizim için boş bir constructor oluşturulur.

    private falan yapacaksak kullanabiliriz veya depedency injection olduğunda.
 */
class Turtle constructor(val name: String, val feetCount: Int) {
    companion object {
        private val vvv: String = ""
    }

    init {
        // Primary Constructor'ın body'sidir.
        // Class'tan bir nesne oluşturduğumuzda çalışan blok.
        println("Primary constructor created with Turtle Name: $name")
    }

    constructor(name: String, feetCount: Int, isMarried: Boolean) : this(name, feetCount) {
        println("Secondary constructor created")
    }
}


class Person(val firstName: String, val lastName: String, val age: Int) {
    init {
       println("primary constructor created with $firstName and $lastName")
    }

    constructor(firstName: String, lastName: String, age: Int, isMarried: Boolean) : this(
        firstName = firstName,
        lastName = lastName,
        age = age
    ) {
    println("secondary constructor created with $firstName and $lastName")
    }
}

fun main() {
    val turtleWithPrimaryConstructor = Turtle(name = "Murtle", 3)
    val turtleWithSecondaryConstructor = Turtle(name = "Kurtle", 3, isMarried = true)

    /**
     * Secondary constructor ile bir çağrım yaptığımızda bile ilk olarak init bloğu çağrılır daha sonra
     * secondary constructor içerisinde ki kod bloğu çalışır.
     *
     * */

    val person1 = Person("Tolga", "Pirim", 23) // primary constructor
    val person2 = Person("Tolga", "Pirim", 23, false) // secondary constructor

}

/**
 * data class özelliklerinden bahsedebilir misin?
 * Peki burada constructor içerisinde val yada var dememiz zorunlu
 * - En az bir adet değişken belirtmeliyiz. ve bu değişkeni belirtirken val yada var söylememiz gerekiyor.
 * - Arka planda constructorda var olan her bir parametre için component() fonksiyonları oluşturulur. component1(), component2() vs..
 * - Equals, toString, hashCode, copy fonksiyonlarını oluşturur.
 * BUrada tanımladığımız değişkenlerde val veya var olarak belirtme zorunluluğu arka planda oluşturulmuş olan
 * üye fonksiyonlar içeriisnde bu değişkenlere ve aynı zamanda dışarıdan ulaşılmasına izin veriyor.
 *
 *
 * Bu constructorlarda val veya var yazmadığımızda o sınıfdaki üye fonksiyonlarından ve bu sınıftan bir nesne oluşturduğumuzda
 * dışarıdan erişime kapalı durumda olur. Normal sınıflarda val veya var yazmadığımızda o değişkenlere sadece init bloğu içerisinden
 * erişebiliriz. Bunun sebebi ise init bloğu primary constructor'ın kod bloğu olmasından kaynaklanıyor.
 */


/**
 * Visibility Modifiers
 * internal, public, private, protected
 *
 * Eğer herhangi bir class'a, fonksiyona visibility modifier vermez isek o default olarak public olur.
 * Java'da ise private'dır.
 *
 * internal -> Bu modifier kullandığımızda sadece o modül içerisinden erişilir.
 * public ->
 * private -> Üye değişkenlerimizin class'n dışından erişilmesini engeller.
 * protected -> Sadece kalıtım (inherit) edilen sınıflar içerisinde erişilebilir.
 *
 * --- Encapsulation
 * Elindeki üye olan şeyleri sakla bu üye olan şeylere kullanıma ihtiyaç duyulduğunda ona erişilecek fonksiyonlar yaz.
 *
 * Peki neden Kotlin'de default olarak public tutma eğilimindeyiz?
 *
 * Aslında arka planda zaten fieldlar private olarak tutuluyor ona erişecek fonksiyonlar yani get ve set'le biz iş yapıyoruz.
 * Biz Kotlin'de bir değişkene visibility modifier verdiğimizde bu değişkenlerin get ve set fonksiyonlarının görünürlüğünü değiştirmiş oluyoruz.
 * Kotlin'de değişkenlerin memory'de yer kaplayan değişkeni buna Kotlin'de backing field diyoruz. Bunu hiçbir şekilde değiştiyemıyoruz zaten.
 * Ama Javada bunu değiştirebiliriz.
 *
 *
 * Local değişkenler biz direkt olarak backing field'ına erişebiliyoruz. Fonksiyonlar içerisinde
 */