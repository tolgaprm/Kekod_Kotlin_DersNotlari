package Kekod2024.classes.sealed_enum

/**
 * Enumlarda gruplayabildiğimiz anlamsal olarak aynı çatı altında gruplayabiliyoruz. Yani fenerbahce, galatasaray gibi
 * verileri tek bir çatı altında Team olarak gruplayabiliyoruz.
 *
 *
 * Sealed class'larda biz artık gruplayabildiğimiz verilerle değil, gruplayabileceğimiz classlarla çalışıyoruz.
 *
 *
 * Enum class'larda valueları değerleri grupluyoruz.(Arka planda bu sabitler class olsa da biz onun value özelliğini
 * kullanıyoruz.)
 *
 * Sealed classlarda ise gerçek anlamda kısıtlanmış class yapısı tutmak istiyorsak, ve bu kısıtlama işlemini developerın
 * keyfiyetinden çıkarıp IDE'nin kontrolüne verdiğimiz yapıdır.
 */


/**
 * primary constructor tanımlanabiliyor.
 * init bloğu kullanılabiliyor.
 * secondary constructor tanımlanabilir.
 *
 * Sealed classlar başka bir class'ı miras alabilirler. Bu class'ın open, sealed, abstract olması farketmez.
 * Interface implement edebiliyoruz. Eğer interface'in body'siz bir fonksiyonu ya bunu sealed class içerisinde yada sealed
 * class içerisindeki her bir class içerisinde override etmek zorundayız.
 *
 *  Nesnesi direkt olarak üretilemiyor. Priamry constroctor'ı default olarak private olark değil protected olarak
 *  bulunuyor. Bu primary constroctor içerisinde tanımlaman property subclasslarda ister constroctor içerisinde ister sabit olarak
 *  miras alındığı yerede değeri atanabilir.
 *
 *
 *  Eğer Constructor'ı private yaparsak bu sayede subclass'ların bu class scope'u dışında miras alınmasını engellemiş olursunuz. Bu da özellikle daha da kısıtlı
 *  bir hiyerarşi kurmak istediğiniz kütüphane kullanımlarında (closed api) önemlidir.
 *
 *  Sealed classların compile time'da subclassları bellidir. Bu sebeple de when durumlarında kullanırken else
 *  case'ine ihtiyaç duymazlar.
 *
 *  İçerisine function tanımına izin veriliyor.
 *  İçerisinde abstract fun tanımına izin veriyor. Ancak bunu yaptığımzda tüm subclasslar bu fonksiyonu override etmek
 *  zorunda olacaktır.
 *
 * Direct class -> Sealed class içerisindeki subclasslar bu şekilde de adlandırılıyor.
 *
 *  Subclasslar constructorında sealed class'tan bağımsız propertyler tanımlanabiliyor. -- Enum'la arasındaki öenmli bir fark
 * Subclasslar sealed class'lardan bağımsız interface implement edilebiliyor.
 * Subclasslar zaten açık bir şekilde sealed class'ı miras aldıklarından başka bir class'ı miras alamazlar.
 * Multiple inheritance Kotlin'de desteklenmiyor.
 *
 * Dierct classlar içerisinde normal, open, abstract fun tanımı yapılabilir. Abstract fun tanımı kullanılabilmesi için direct
 * class'ın abstract class olması gerekiyor.
 *
 * Bu direct classlar içerisinde normal class, data class, inner class, abstract class vs türleri olabilirler.
 * Enum class olamaz çünkü zaten enum classlar başka bir sınıfı miras alamıyorlar. Direct class'lar açık bir şekilde zaten
 * sealed class'ı miras alabilmeliler.
 *
 * Direct class'lar enum'lar da olduğu gibi static değillerdir. (sealed class scopu içerisinde kullanılıyorlarsa static olurlar (nested))
 * ama özünde static olmadıkalrı için kullanılırken nesneleri üretilmesi gerekmektedir.
 *
 * Direct class'ların birden fazla nesnesi oluşturulabilir. Enum'larda sabitler tek bir nesne olarak memory'de bulunurlar.
 *
 *
 * -- Özet
 *
 * Enum classlar valueları gruplandırmak için kullanılıyor. Sealed classlar classları gruplamak için kullanılıyor.
 * Grupladığımız sabitlerin tekil olarak instance sahip olmak istiyorsak, çoklu nesne üretmek gibi bir derdimiz yoksa enum,
 * ama birden fazla nesne üreteyim diyorsak sealed class kullanılır.
 *
 * Kullancağımız sabitler direkt class özelliklerini kullanabilsin, data class, object, abstract gibi yine sealed class.
 *
 * Yine başka bir sınıfa miras olarak vermek istiyorsak sealed class.
 *
 * Sealed classların temel amacı gruplandırılmış ve kısıtlandırılmış bir class hiyerarşisi kullanmak.
 */

sealed class Error(val errorCode: Int) : B {

    class NoInternet(val errorMessage: String) : Error(100)

    class ServerError : Error(200)

    class FileIOError(errorCode: Int) : Error(errorCode), SomeInterface {
        override fun someInterfaceMethod() {
            TODO("Not yet implemented")
        }
    }

    //   constructor(errorCode: Int) : this() {}

    override fun someMethod() {
        TODO("Not yet implemented")
    }
}

class BV : Error(100)

interface B {
    fun someMethod()
}

interface SomeInterface {
    fun someInterfaceMethod()
}
