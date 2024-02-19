package Kekod2024.basic_types

import java.util.*

fun main() {
    /**
     * Yaklaşık olarak her karakter 2 byte yer kaplar. UTF -16 encoding kullanır.
     *
     * Çift tırnak içerisine yazılan karakterler bütünüdür.
     *
     * String bir ifadenin tüm karakterlerini tek tek alıp bir Char listeye atabiliriz.
     *
     */

    val studentName = "Tolga"
    val studentNameLowercase = studentName.toLowerCase()

    val awesomeKeKod = "KeKod is Awesome"
    val firstCharOfAwesomeKekod = awesomeKeKod[awesomeKeKod.indices.first]
    val firstCharOfAwesomeKekod2 = awesomeKeKod[1] // e
    val lastCharOfAwesomeKekod = awesomeKeKod[awesomeKeKod.indices.last]
    val lastCharOfAwesomeKekod2 = awesomeKeKod[16] // 16 değil 16 dersek index out of range exception hatasını verir.


    /**
     * Stringler immutable'dır. Yani ilk değer ataması yapıldıktan sonra
     * değeri değiştirilemez yada yeni bir değer set edilemez.
     *
     * String üzerinde yapacağımız tüm işlemler bize yeni bir string nesnesi dönecektir.
     */

    val name = "Tolga"

    println(name.uppercase()) // "TOLGA"
    println(name) // Tolga

    /**
     * String referance tip gibi gözükür ama primitive olarak çalışır.
     * Bu Javada dahi böyledir.
     * Burada bir garbage collector örneği ver.
     */


    /**
     * Farklı bir değişkenin önüne String bir değişken yada ifade
     * koyarak toplarsak, sonuç String olacaktır.
     *
     * Ancak String bir değişken yada ifadenin sonuna + operatörü ile
     * farklı tipte bir değişken eklerseniz kod çalışmaz.
     *
     * Burada String'in ve Int'in sahip olduğu plus fonksiyonlarına bak.
     * String değişkenin plus() fonksyionu Any tipine sahip değişkenleri kabul ederken,
     * Int değişkenin plus() fonksiyonu 'Byte,Short,Int,Float,Double' istediğini göreceksin.
     * Burada bu işlemlerin çalışmamasının arkasındaki sebep budur.
     *
     */

    val numbersValue: String = "value" + (4 + 2 + 6) // value12

  //  val numbersValue2: String = (4 + 2 + 6) + "value"

    /**
     * Herhangi bir değişken + operatörüne ihtiyaç duyulmadan
     * direkt olarak "" arasına yazılarak kullanılabilir.
     *
     * Bunun için sadece $ işaretine ihtiyacımız vardır. Bu yapıya
     * String Template denir. Eğer değişkenin bir özelliğine ihtiyaç duyacaksak
     * ${} kullanılır.
     */

    val age = 23
    println("Age $age")
    println("Age " + age)
    println("Price \$34") // $ Kotlin'de özel anlamı olan bir karakter(placeholder), bunu bir String içerisinde kullanacaksak
    // \(backslash) ile kullanmamız gerekiyor.


    /**
     *
     * 3 tane cift tirnak kullanarak Raw String (Multiline String) olusturulabilir.
     * Raw String 'ler ide'ye nasil yaziliyorsa oyle kullanilir. Hizalamada bozulma olmaz.

     * trimIndent() fonksiyonu ile bu Raw String'in kenar bosluklarini silebilirsiniz.
     * Bu silme islemini yaparken tum satirlardaki en soldaki karakteri baz alarak silme islemini saglar.
     * Alttaki ornek icin 3 satirdan da $ isaretinin solundaki bosluga kadarini siler.
     * Raw Stringlerin icinde escape karakterler calismaz.
     * En sondaki karaktere göre kalan sol taraftaki tüm stringleri siler.
     */

    /**
     * trimMargin(marginPrefix ="|")
     */

    // Row Stringler içerisinde \ (backslash) esacpe karakterler için kullanmamıza izin vermez.

    /**
     * Kotlin'de String.format() methodu, Javadaki format methodunu kullanır.
     * Bu method, belirli bir String içinde yer tutucuları belirtilen değerlerle değiştirerek yeni
     * bir String oluşturmamıza olanak tanır.
     *
     *
     * %s : String
     * %d Integer için
     * %f Float/Double
     * %n Yeni bir satıra geçmek iöin
     */

    val boy = 1.753
    val boyMesaj = String.format("Boyum: %.2f metre", boy) // 2f 2 ondalık basamakla olduğunu belirtir.
    println(boyMesaj) // Burada 1.75 döndürür. Sondaki 3'ü almaz Çünkü biz 2 ondalık basamak kısmını al dedik.
    // Noktadan sonra ne kadar ifade alacağını belirtmiş olduk.


    val sayi = 1234567.8954768
    // 1,234,567.8954768
    val usFormat = String.format(Locale.US, "US formatında: %,.2f", sayi)
    println(usFormat) // "US formatında: 1,234,567.89" yazdırır.
    //Türkçe için Locale nesnesi, "tr" ISO 639 dil kodu ve "TR" ISO 3166 Ülke kodu ile oluşturulabilir
    val localeTR = Locale("tr", "TR") // Türkçe için Locale nesnesi oluşturuluyor
    val usFormatTR = String.format(localeTR, "TR formatında: %,.3f", sayi)
    // 2f çünkü, .'dan sonra 2 karakter goster diyoruz, bunu ,2f ile yapamayiz
    // Yani yukarıdaki sayı değeri ingilizce de normalde 1,234,567.8954768 bu şekilde olduğu için yani yüzdelik kısımları
    // ayırmak için , ondalık kısımları ayırmak için . kullanılıyor. Buradki ilk , ifadesi sayıdaki , kısımlarını
    // temsil etmiş oluyor. YANİ BU FONKSYİONDA diyoruz ki ben bu formatta o kısımlara , koyacağım ama bunu
    // Türkçeye göre yap.
}