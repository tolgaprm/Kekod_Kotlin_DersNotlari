package Kekod2024.classes


// Classlar içerisindeki değişkenler, fonkisyonlar, nested ve inner classlar bulunur.
// Bu elemanları mümkün olduğunca private tutup, hangi elemanların dışarıya açık olmasını ve hangi seviyede ulaşılmasını belirlememize denir.
// Bulunan bu elemanları ne seviyede dışarı açmak istiyorsun.
// Bazen bunu sadece child sınıflardan erişilmesini istersin - protected
// Bazen nesnesi oluşturulmuş olan düğer tüm classlar tarafından erişilmesini istersin - public
// Bazen sadece kendi modülü içerisinden erişilmesini istersin - internal
class Encapsulation {
    var name: String = "Tolga"
    private val age:Int = 23
    val surname: String = "Pirim"
}

/**
 * Encapsulation Neden Önemli?
 *
 * Encapsulation'nın önemli olmasının nedenlerinden birisi, bir değişkenin değerini yanlışlıkla başka bir developer
 * veya bizim değiştirmesini engellemek için kullanılabilir.
 *
 *
 * Yada bir SDK veya bir kütüphane yazdığımızda, o kütüphaneyi kullanan kişilerin sadece kullanabileceği fonksiyonları
 * görmesi hem karmaşayı azaltır hemde yanlış bir şey değiştirmesini engeller.
 *
 */