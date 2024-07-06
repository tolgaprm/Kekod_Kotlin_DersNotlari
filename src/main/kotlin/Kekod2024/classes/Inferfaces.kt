package Kekod2024.classes

interface TextWatcher {
    // Peki bunu nasıl kullanıyoruz, kullanabilmemizin sebebi propery vs field farkını bilmekten geçiyor aslında
    // Bunun herhangi bir backging field yoktur.
    val text: String

    fun onTextChanged()
    open fun beforeTextChanged()
    abstract fun afterTextChanged()

    fun funWithBody() {

    }

    // Interface içerisinde companion object kullanımı yaptığımızda
    // state tutabiliriz. Ama bunu yapmamamız gerekiyor.
    companion object {
        val name: String = "Tolga"
    }
}

interface Vehicle {
    fun drive()
    fun stop()

    val accelerate get() = 120
}

// Interface'ler state tutamazlar ama abstarct sınıflar state tutabilirler

/**
 * Bir interface başka bir interface'i inheritance yapabilir
 */
interface ChildInterface : TextWatcher {

}

// Bir interface herhangi bir sınıfı(open, abstract) miras alamaz
open class Base
//interface ChildInterface : Base {}

/**
 * Bir interface constructorlara sahip olamaz
 * İnterface içerisindeki fonksiyonlarda final keywordu kullanılamaz
 */

/**
 * Interface içerisinde body'si olab bir fonksiyon tanımlayarak static bir sınıf ve static bir fonksiyon oluşturmuş
 * oluyoruz.
 */

fun main() {
    // Object expression Kullanımı Tek seferlik kullanımı olan interface yada classlar diyeceğiz ilerde
    /**
     * Arka planda nesnesi oluşturulur. Normalde interfacelerden nesne oluşturamayız.

     */
    val textWatcher = object : TextWatcher {
        override val text: String
            get() = TODO("Not yet implemented")

        override fun onTextChanged() {}

        override fun beforeTextChanged() {}

        override fun afterTextChanged() {}
    }
}

/**
 * bir class abstract ise bir interface'i
 * implement ettikten sonra o interface'in fonksiyonlarını override etme zorunluluğu kalkar"
 */