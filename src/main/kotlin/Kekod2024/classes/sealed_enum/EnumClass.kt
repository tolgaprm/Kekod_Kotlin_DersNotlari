package Kekod2024.classes.sealed_enum

/**
 * Gruplayabildiğimiz benzer tiplere sahip elemanlar
 */

fun main() {
    val fenerbahce = "FENERBAHCE"
    val galatasaray = "GALATASARAY"
    val besiktas = "BESIKTAS"
    val kayserispor = "KAYSERİSPOR"

    val student = 0
    val teacher = 1
    val manager = 2

    val userType = student

    when (userType) {
        0 -> println("student")
        1 -> println("teacher")
        2 -> println("manager")
    }

    // Bu kodu yaz ve üzerinden bir anlat neden bu kodun kötü bir yaklaşım olduğunu daha sonrada bunun enum class ile yazılmış
    // verisyonu ile bir örnek yaz ve karşılaştır.

}

/**
 * Visibility modifierlarla ilgili bir kısıtı yok
 * Primary constructor tanımlanabiliyor. - init bloğu kullanılabiliyor
 * secondary constructor tanımlanabiliyor.
 *
 * Enum classlar başka herhangi bir class'ı miras alamazlar. Başka enum class'ı da miras alamazlar.
 * Enum classlar interface'ler implement edilebiliyor. Eğer implement edeilen interface'in body'siz bir fonksiyonu varsa
 * bu durumda bu fonksiyon ya enum class'ın içerisinde ya da enum sabitlerinin her birinin içerisinde ayrı ayrı override
 * edilmek zorundadir.
 *
 * Enum classların nesnesi oluşturulamaz. (Ben bir class'ın nesnesini oluşturamıyorsam constructorlarıyla alakalı bir durum olduğunu anlamalıyız.)
 * Enum classlarda primary constructor'ı default olarak private'dır ve bunu değiştirmemize izin verilmiyor.
 *
 * İçerisine function tanımına izin veriliyor.
 * İçerisinde abstract fun tanımına izin veriyor. Ancak bunu yaptığımzda tüm enum sabitleri bu fonksiyonu override etmek
 * zorunda olacaktır. -- Buradan aslında enum class'ların çalışma mantığını anlayabilirz.
 *
 * open fun tanımlayabiliyoruz. Bu durumda enum sabitleri override etmek zorunda kalmıyor (opsiyonel)
 *
 * enum sabitlerinin constructorları bulunabilir ama içlerine direkt olarak property tanımlanamaz. Ancak enum class'ın kendi
 * constructorında bir property sahipse tüm enum sabitleri bu property'e kendi constructorlarında sahip olmak zorundadir. Bu propertyler yine default değerlere
 * sahip olabilir.
 * (Peki neden böyle bir zorunluluk var??????) Çünkü enum sabitleri yazılan enum class'ı miras aldığı için o parent class'ın
 * constructorındaki değerlerini enum sabirlerinde de kullanmak zorundayız.
 *
 * Sabitler tek başlarına bir class'ı miras alamazlar yada bir interface'i tek başlarına implement edemezler
 *
 * Enum class'ların entries ve values() fonksiyonları bize o enum class'ın enum sabitlerinin listesini verir.
 * Kotlin 1.9'dan sonra entries values() fonksiyonunun yerini almıştır.
 *
 * valuesOf() fonksiyonu ise, o enumdaki belli bir enum sabitini bize döndürür. Eğer verilen değer enum sabitlerinin içerisinde yoksa
 * IllegalArgumentException hatası alınır.
 *
 * Enum sabitleri name ve ordinal diye 2 tane property'e sahiptir.
 * name Enum sabitinin ismini birebir döner. toString()'den bağımsızdır.
 * ordinal ise Enum sabitinin enum içerisindeki sırasını bize belirtir. (0'dan başlar)
 *
 * Enum sabitinin ismine direkt olarak erişeceksek, bir format kaygımız yoksa enum class'ın name prorperysini kullanabiliriz.
 * Ama eğer bu enum sabitinin isminde bir değişiklik veya format farklılığına ihityaç var ise bu durumda toString() override etmek en doğru yöntem olur.
 */
enum class Team(starCount: Int) {
    FENERBAHCE(starCount = 3) {
        override fun foo() {

        }
    },
    GALATASARAY(starCount = 4) {},
    BESIKTAS(starCount = 3),
    KAYSERISPOR(starCount = 0);

    //abstract fun boo()

    open fun foo() {

    }

}

/**
 * Bir teknik bilgiyi öğrenirken şu üç kelime çok önemlidir.
 * Pitfalls(tuzaklar), bottlenecks, codesmell
 */