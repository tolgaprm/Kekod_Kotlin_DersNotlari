### 1 - Kotlin'de Primitive Tipler
 
- Öncelikle Primitive Tipler'in tam olarak ne olduğunu anlamaya çalışalım.

> Primivite tipler normalde, hem kapladıkları alan, hem de erişim hızları
     bakımından reference tipli değişkenlere göre (yani bir class'ın nesnesine)
     göre çok daha hızlı çalışan değişken tipleridir.
> `Int,Long,Double,Float,Boolean` gibi değişken türleri.

- Primitive Değişkenler
  - Primitive değişkenler doğrudan bellekteki değeri tutar.     
  - Değişken, gerçek değeri içerdiği için bellekte daha düşük bir miktarda alan kaplar.
  - İki primitive tipi karşılaştırırken, değerlerin doğrudan karşılaştırılması yapılır.


- Reference Tipler
  - Bu tipler, bellekte bir referans (adres) tutar ve gerçek değer nesnenin içindedir.
  - İki reference tipi karşılaştırırken, referanslar (adresler) karşılaştırılır, yani iki değişken aynı nesneyi mi 
  gösteriyor kontrol edilir.

  Kotlin'in resmi dokümantasyonuna baktığımızda 
  `In Kotlin, everything is an object in the sense that you can call member functions and properties on any variable.` diye
  bir ifade geçiyor. `Yani kısaca Kotlin'de her şey bir objedir/nesnedir.` 

  Ama biz daha yeni yukarıdaki bilgilere göre objelerin `reference` değer tiplerine denk geldiğini öğrenmiştik. İşte burada o can alıcı 
  sorumuz geliyor.

- ### Peki Kotlin'de herşey birer obje ise, Primitive değişken oluşturamıyor muyuz?

    Kotlin'de primitive tipler birer sınıf (class) gibi görünürler. Ama çalışma zamanında (runtime) primitive hallerine
    optimize edilirler.

    Bunun gerçekten böyle okup olmadığını anlamak istersek, IDE'nin sunduğu `Show Kotlin Byte Code` aracını kullanarak
    deneyebiliriz.

    Kotlin ve Java bir JVM dili olduğu için compile edildiklerinde aynı assemble kodlarını üretirler.

    ```java
        // JAVA
      public class Primitives {
        private int age = 23; // Primitive
        private Integer ageObject = 23; // Reference
  
        private boolean isMale = true; // Primitive
        private Boolean isMaleObject = true; // Reference
    }
   ```
    Yukarıdaki Java kodumuza baktığımızda değişkenleri hem primitive olarak hemde reference olarak
    belirtebildiğimizi fark etmiş olmalısınız.

    ```kt
        // KOTLIN 
        class Primitives{
            private val age:Int = 23
            private val isMale:Boolean = true
        }     
    ```
  
  Şimdi yazmış olduğumuz Kotlin kodunu `Show Kotlin Byte Code` aracını kullanarak oluşturulan assemble
  kodunu decompile ederek Java'daki karşılığını görelim.
  > Araca erişmek için `Tools/Kotlin/Show Kotlin Byte Code`
  
  Yukarıda yazmıl olduğumuz Kotlin kodunu decompile ettikten sonra oluşturulan Java kodu:
  ```java
    public final class Primitives {
        private final int age = 23;
        private final boolean isMale = true;
  }
  ```
  Yukarıdaki kodu incelediğimizde aslında biz Kotlin'de Int olarak belirtmiş olduğumuz bir değişken
  compile edildikten sonra int yani primitive olarak saklanıyor. Diğer primitive değişkenler için de geçerlidir.
