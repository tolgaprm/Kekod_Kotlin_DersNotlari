### 1. Değişkenler Bellekte Nasıl Saklanır? Stack - Heap Kavramları

Değişkenlerin bellek(RAM) üzerinde nasıl saklandığına bir göz atalım.
RAM üzerinde `STACK` ve `HEAP` olarak adlandırılan iki bölüm bulunur.

- `STACK` bölümünde primitive ifadelerin değerleri bu bölümde tutulur. Primitive değişkenlerin hızlı olmasının
  sebeplerinden
  birisi bellekte bu bölümde tutulmalarıdır. Çünkü `STACK`, `HEAP`'den daha hızlı çalışır.

- `HEAP` bölümünde ise reference değerli olan tiplerin (class) değerleri ve nesneleri `HEAP` bölümünde,
- bu değerlerin adreslerini gösteren değişkenler ise `STACK` bölümünde tutulur.


  ![](screenshots/stack_heap.jpg)
  
### 2. Smart Cast Nedir?
  - `is` ve `!is` Operatörleri
    
    Çalışma zamanında (runtime) bir nesnenin belirli bir türe uygun olup olmadığı işleminin kontrol 
    edilmesi işlemidir.
    
    ```kt
    val value: Any = "Merhaba, Kotlin!"

    if (value is String) {
        println(value.length)
    }

    if (value !is Int) {
        println("Değişken bir Int türünde değildir.")
    }
    ```
    
    Örneğin bu örnekte `Any` tipine sahip bir değişkenimiz var. İlk olarak, `is` anahtar kelimesiyle, değişkenin `String` 
    türünde olup olmadığını kontrol ediyoruz. Eğer öyleyse, ilgili mesajı yazdırıyoruz. Ardından, `!is` kullanarak,
    değişkenin `Int` türünde olmadığını kontrol ediyoruz.


  - Peki  `Smart Cast` Nedir?

    Kotlin dilinde bir değişkenin tipi üzerinde `compiler` tarafından otomatik olarak dönüşümün gerçekleştirilme
    işlemidir. Bu şekilde açık bir şekilde `Type Conversion` işlemini yapmadan o tipin sahip olduğu bütün özellikleri
    methodları kullanmamıza sağlar.

    Yine yukarıdaki örnekten devam edelim, `value` değişkeninin `String` olup olmadığını kontrol ettik ve 
    `if` içerisinde açık bir şekilde `Type Conversion` işlemini yapmadan `String` tipine ait olan `length` özelliğini
    kullanabildim. İşte tam olarak bu duruma `Smart Cast(Akıllı Dönüşüm)` denir.
    
    ### 3. İki `Int.MAX` Değerin Toplanması Durumu

    ```kt
    val totalIntMax = Int.MAX_VALUE + Int.MAX_VALUE

    println(totalIntMax) // Sonuç: -2
    ```
    
    Burada INT değerlerinin max değerleri ile bir toplama işlemi gerçekleştiriyorum ve `totalIntMax` değişkenim
    `Long` bir değer olması gerekirken `Int` bir değer olarak belirleniyor.
    
    Ama biz bir önceki hafta eğer değer `Int` değer aralığının üzerinde ise `Type Inference` ile bu değişkenin
    `Long` olarak atanacağını öğrenmiştik. Evet bu bilgi doğru ama IDE aritmetik işlemler de bu şekilde bir belirleme yapmıyor.
    
    Önce olası durumlara bir bakalım:

    ```kt
    val intValuePlusLong = 34 + 43L // Long Toplama işleminde hangi tipin aralık değeri fazla ise o değerin tipi belirlenir.
    val byteMaxPlusByteMax = Byte.MAX_VALUE + Byte.MAX_VALUE // Int
    val shortMaxPlusShortMax = Short.MAX_VALUE + Short.MAX_VALUE // Int
    ``` 
    `Short` ve `Byte` değerlerlerini topladığımızda ise tip `Int` olarak belirlenir. Burada yine dilin bu değerler için sağlamış
    olduğu özel optimizasyonlar sebebi ile `Int` olarak atanır.

    #### Peki neden `Int.MAX_VALUE + Int.MAX_VALUE` toplamını yaptığımızda tip `Long` olarak belirlenir?
    
    Burada IDE her bir toplama işlemi yapıldığında hangi değer aralığına geleceğini kontrol etmiyor. Bunu yapamaz mı?
    İsterse tabiki yapar sadece bir if kontrolü gerekiyor. Ama biz her toplama işlemi yaptığımızda arka planda bu işlem 
    kontrolü sağlanacak ve bu da ek bir maliyet getirir.
    Buradan `Defansif Programlama` kavramına bir geçiş yapalım.

    - #### Defansif Programlama Nedir?
    
        Yazılımcıların yazdıkları kodda olası tüm durumları (edge case) ele alması durumudur.
        Burada gerçekten bütün edge case durumlarını değerlendirmelimiyiz. Bu en uç noktadaki edge case
        durumunu değerlendirmek bize bir performans kaybı yaratır mı? Eğer yaratacaksa bunu gerçekten kullanmalımıyız?
        
        Yukarıdaki örnek gibi eğer her toplama işleminde bu değerlerin `Int` max değerini geçtiğini kontrol yapılsa idi 
        gereksiz bir maliyet oluşturacaktı.

### 4. Characters (`Char`)

- ### Char Bir Değişken Tanımlama
    
    - 2 byte(16bits) alan yer kaplar.
    - Tek tırnakların '' arasına harf, sayi, escape karakterlerini veya unicode yazarak kullanırız.
    - Çift tırnak "" kullanırsak `String` olur.
    
    ```kt
      val firstCharOfName = 'T'
      val firstCharOfName2 = "T" // String
      val firstCharOfName3 = 'TO'
    ```
    Yukarıdaki `firstCharOfName3` gibi tek tırnaklar içerisine birden fazla character ekleyemeyiz.
    
- ### ASCII Tablosu
    - ASCII tablosu, ASCII karakterlerini ve karşılık gelen sayısal değerleri içeren bir tablodur. 
    - ASCII tablosu, temel Latin alfabesi karakterlerini, rakamları, noktalama işaretlerini ve diğer özel karakterleri içerir.

    <details>
     <summary>ASCII TABLOSU</summary>
     
  ![](screenshots/ascii_table.png)
    </details>
  
    Eğer bir karakter ifadeyi `toInt()` veya `code` ile `Int` bir değere döndürmeye
    çalıştığımızda bize geri dönecek olan değer tabloda  bu karaktere denk gelen `decimal` karşılığını verecektir.

    ```kt
    println('H'.code) // 72
    println('P'.code) // 80
    println('7'.code) // 55
    ```
    - Burada `toInt()` de kullanabilirdik ama bu fonksiyon `Deprecated` bir duruma geçmiş bunun yerine `code` property 
    kullanmamız isteniyor.
    
    - Eğer karakter içerisindeki sayısal değer ile işlem yapmak istiyorum bunun ASCII tablosundaki decimal karşılığını
    istemiyorum diyorsak, `digitToInt()` fonksiyonunu kullanabiliriz.
    ```kt
     println('7'.digitToInt()) // 7 - Bu sefer decimal karşılığını vermedi.
    ```
    - Burada dikkat etmemiz gereken bir durum var. Eğer char içerisinde Int'e dönüşü yapılamayacak bir değer var ise 
    program `IllegalArgumentException` hatasını verecektir.
    ```kt
  println('T'.digitToInt())
    ```

- ### Escape (Kaçış) Karakterleri
    
  - `\t`: Tab kadar bir boşluk bırakır.
  - `\b`:
  - `\n`: Yeni bir satıra geçmemizi sağlar.
  - `\r`: Satır başına dönmek için kullanılır.
  - `\'`: Tek tırnak karakterini kullanmak için. Örneğin bir String ifade içerisinde 
   ```"Bu bir tek tırnak içeren bir string\'dir."``` Bunu print ile çıktısını almaya çalıştığımızda sonuç 
  `Bu bir tek tırnak içeren bir string'dir.`
  - `\"`: Çift tırnak karakterini kullanmak için 
  - `\$`: Dollar ($) işaretini kullanmak için 

- ### Unicode
    Unicode, bilgisayar sistemlerinde metin ve sembollerin temsil edilmesi için kullanılan bir karakter kodlama standardıdır.
    Farklı dil ve alfabeleri destekler. (Örneğin Çince veya Japonca alfabelerini) - UTF-8, UTF-16, ve UTF-32 gibi çeşitleri vardır.
    Bu çeşitler arasındaki fark, destekledikleri toplam sembol, karakter sayısı ve kapladıkları alan bakımından kaynaklıdır.
    
    Unicode'da her bir sembolün özel bir kodu bulunur ve biz bu kodları kullanarak programlarımıza entegre edebiliriz.
    
    Kalp elde etmek için
    ```kt 
    print(`\u2665`) 
    ```
- ### Unicode ve ASCII Arasındaki Fark Nedir?
  - **ASCII**: Temel olarak İngilizce alfabesini ve birkaç temel sembolü içerir. Farklı dil ve kültürlerdeki özel karakterlere destek vermez.
  - **Unicode**: Dünya genelinde birçok dil ve kültürü destekler, bu da metin ve sembollerin daha geniş bir yelpazesini temsil etmesine olanak tanır.

### 5. Boolean
- ### Boolean Bir Değişken Tanımlama
  - 2 byte yani 8 bit alan kaplar.
  - `true` yada `false` ataması için kullanılır. Aynı zamanda `null` değerde alabilir.
  - Bazı programlama dillerinde `0` veya `1` de boolean olarak kabul edilebilir ama Kotlin'de kabul edilmez.


- ### Karşılaştırma Operatörleri (`&& - || - !`)
  - `&& - and` - Eğer karşılaştırılan iki değer de `true` ise sonuç `true` olur. Eğer ifadelerden herhangi birisi `false` ise
  `false` cevabını elde ederiz.
     ```kt
     val isAndroidDeveloper = true
     val isKeko:Boolean = false
   
    if(isAndroidDeveloper && isKeko){}
   
    if (isAndroidDeveloper and isKeko){} // Infix Fonksiyon İle Kullanımı
   
    if (isAndroidDeveloper.and(isKeko)){} // Extension Fonksiyon İle Kullanımı
     ```
  - `|| - or` - Eğer karşılaştırılan iki değerden en az birisi `true` ise sonuç `true` olur. Bu karşılaştırmada `false` 
olması için iki değerinde `false` olması gerekiyor.
    ```kt
    val isAndroidDeveloper = true
    val isKeko:Boolean = false

    if(isAndroidDeveloper || isKeko){}

    if (isAndroidDeveloper or isKeko){} // Infix Fonksiyon İle Kullanımı

    if (isAndroidDeveloper.or(isKeko)){} // Extension Fonksiyon İle Kullanımı
     ```
  - `! - not` - Bu operatör ile değerimiz `true` ise `false`, `false` ise `true` yapar.
    ```kt
      val isAndroidDeveloper = true
      println(!isAndroidDeveloper) // Sonuç: false
      println(isAndroidDeveloper.not()) // Sonuç: false // Extension Fonksiyon İle Kullanımı
    ```
    > Boolean değerlerin `true` olma durumunu kontrol etmek için `== true` şeklinde açıkca belirtmeye gerek yoktur. Ama 
     `Nullable` olan değerler için açık bir şekilde kontrol işlemi gerçekleştirmeliyiz.
    > ```kt
    > if (isAndroidDeveloper) {}
    > ```
    > Değişkenimiz `null` olduğunda artık 3 durumumuz var.
     Bunlar `true`, `false` ve `null` olması
    > 
    > ```kt
    >  val isSuccess: Boolean? = null
    > if (isSuccess == true) {
    > 
    > } else {
    >   // Geri kalan iki durum için else durumunu kullanır.
    >  }
    > ```
    
- ### Bu Operatörlerin Lazily Çalışma Mantığına Sahip Olması
    `&&` ve `||` operatörleri Lazily çalışma mantığına sahiptir. Bu mantığa sahip olması demek;
    
  - Eğer `||`  ile iki değeri kontrol ettiğimizde ilk değer `true` ise, ikinci değer hiçbir şekilde kontrol edilmez. Ama
    ilk değer `false` ise, diğer ifadenin de kontrol işlemi gerçekleştirilir.
  - Eğer `&&`  ile iki değeri kontrol ettiğimizde ilk değer `true` ise, ikinci değer de kontrol edilir. Ama ilk değer `false`
    ise ikinci ifadenin kontrol işlemi gerçekleştirilmez.

### 6. String
- ### String Bir Değişken Tanımlama ve String'de Index Yapısı
  - Yaklaşık olarak her karakter 2 byte (16 bits) yer kaplar.
  - Çit tırnak `""` içerisine yazılan karakterler bütünüdür.
  - `String` bir değişken üzerindeki her bir karaktere index operatorü ile tek tek ulaşabiliriz. 
     ```kt
      private val name = "Tolga"
      println(name[0]) // T -- Indexler 0 ile başlar
     println(name[1]) // o
     println(name[5]) // Tolga string ifadesi 5 length uzunluğuna sahip ama bu ifadenin son
    // karakterine ulaşmak istediğimizde indexini 4 olarak belirtmeliyiz. Çünkü indexlenen 
    // ifadelerde index 0 (sıfır) ile başlar.
    // Olmayan bir index'e ulaşmak istediğimizde ise program bize StringIndexOutOfBoundsException hatasını
    // fırlatır.
    ```
- ### `String` Immutable'dır
    String değişkenler immutabledır. Yani bir kez tanımlandıktan sonra, değerini değiştiremeyiz yada yeni bir değer
    set edilemez.
    > Şimdi aklımıza söyle bir soru gelmiş olabilir. Ben `var` keywordünü kullanarak `String` tanımladıktan sonra o değişkenin
    değerini değiştirebiliyorum. Ama sen burada yeni bir değer atayamazsın ve değiştiremezsin diyorsun. Tam olarak anlamdım
  > diyebilirsin?
  > #### Şimdi gelelim cevabımıza:
  > Bunun arkasındaki yatan sebep `String` değişkenlerin bellekte saklanma durumlarından dolayıdır. Hatırlarsanız bu haftanın
  > ilk sorusunda `HEAP` ve `STACK` kavramlarından bahsetmiştik. Reference değerli olan değişkenlerin `value` ları `HEAP`
  > tarafında ve bu value değerini referans eden değişkenlerin ise `Stack` bölümünde tutulduğundan konuşmuştuk.
  > `String` değişkenlerin de değerleri **primitive** bir değişken olmasına rağmen `Heap` bölümünde tutulur. Yani biz 
  > `String` bir değişkene değer atadığımızda `HEAP` bölümünde yeni bir nesne oluşturulur ve değişkenimiz o nesneyi referans eder.
  > `String` üzerinde yapacağımız tüm işlemler bize yeni bir `string` nesnesi dönecektir.
  ```kt
    val name = "Tolga"
    println(name.uppercase()) // TOLGA
    println(name) // Tolga name değişkeni üzerinde değişiklik yapmadı. 
    // Eğer ben String bir ifade üzerinde işlem yaptıktan sonra, işlem gerçekleşmiş değişken
    // ile işlemlerime devam etmek istiyorum diyorsanız onu yeni bir değişkene atamamız gerekiyor.
    
    val nameUppercase = name.uppercase() 
    println(nameUppercase) // TOLGA
  ```