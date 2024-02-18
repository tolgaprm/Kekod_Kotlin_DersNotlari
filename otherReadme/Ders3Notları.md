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