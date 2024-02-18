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

    ### Peki neden `Int.MAX_VALUE + Int.MAX_VALUE` toplamını yaptığımızda tip `Long` olarak belirlenir?
    
    Burada IDE her bir toplama işlemi yapıldığında hangi değer aralığına geleceğini kontrol etmiyor. Bunu yapamaz mı?
    İsterse tabiki yapar sadece bir if kontrolü gerekiyor. Ama biz her toplama işlemi yaptığımızda arka planda bu işlem 
    kontrolü sağlanacak ve bu da ek bir maliyet getirir.
    Buradan `Defansif Programlama` kavramına bir geçiş yapalım.

    - ### Defansif Programlama Nedir?
    
        Yazılımcıların yazdıkları kodda olası tüm durumları (edge case) ele alması durumudur.
        Burada gerçekten bütün edge case durumlarını değerlendirmelimiyiz. Bu en uç noktadaki edge case
        durumunu değerlendirmek bize bir performans kaybı yaratır mı? Eğer yaratacaksa bunu gerçekten kullanmalımıyız?
        
        Yukarıdaki örnek gibi eğer her toplama işleminde bu değerlerin `Int` max değerini geçtiğini kontrol yapılsa idi 
        gereksiz bir maliyet oluşturacaktı.

