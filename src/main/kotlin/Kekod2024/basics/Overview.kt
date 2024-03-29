package Kekod2024.basics

fun main() {
    val name: String = "Tolga"
    val age: Int = 34
    val isMale = true
    val firstLetterOfSurname: Char = 'T'
}

/* Primivite Types in Kotlin
*
* Primivite tipler normalde, hem kapladıkları alan, hem de erişim hızları
* bakımından reference tipli değişkenlere göre (yani bir class'ın nesnesine)
* göre çok daha hızlı çalışan değişken tipleridir.
*
* Primitive Types Kotlin'de birer sınıf (class) gibi görünürler. Buna rağmen çalışma zamanında (runtime)
* primitive hallerine optimize edilirler.
*
* Bu değişikliği Show Kotlin Byte Code tool'u ile görebiliriz. (Örnek ile açıkla.)
*
* Bu iş görüşmelerinde Kotlin'de her şey bir sınıf olarak belirtildiyse, değişkenler de bir sınıf olarak belirtildiyse
* biz primitive type olan değişkenleri nasıl tanımlarız.
* */


/*
* val userNameLiveData:LiveData
*   get() = userNameMutableLiveData
* private val userNameMutableLiveData: MutableLiveData
*
* Dk: 52
* */

// val değişkenler Immutable değildir, sadece readOnly dir. Dk 27 - 35 bak bir.
class Box {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 50
    var usedSpace: Int = 0

    val avaliableSpace: Int
        get() = (width * height * length) - usedSpace
}