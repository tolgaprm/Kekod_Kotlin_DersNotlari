### Data Class

Şimdi Data Class nedir, neden kullanılır, normal class'lardan farkı nedir? Bize getirdiği avantajlar nedir bunlardan
bahsedeceğim.

- ### Data Class Nedir?
  Kotlin'de data class'lar veri taşıma ve saklama amacıyla kullanılan sınıflardır. Bu sınıflar, otomatik olarak bazı
  fonksiyonları
  bizim için generate eder ve veri taşıma operasyonlarını daha kolay ve güvenilir hale getirir.

    - ### Data Class Tanımlarken Uymamız Gereken Kurallar
        - Mutlaka `primary constructor`'a sahip olmalı
        - `Primary constructor` içerisinde en az bir parametre belirtilmeli ve bu parametreler `val` yada `var` ile
          yazılmış olması gerekiyor.
      > #### Peki Neden `val` yada `var` ile bir parametre belirtmek zorundayız.
      >   Data Class içerisinde bizim için generate ettiği fonksiyonlar olduğundan bahsetmiştik.(İlerleyen kısımda bu
      fonksiyonlara da değineceğim.)
      Bu fonksiyonlar içerisinde `primary constructor` içerisinden gelen değişkenlere erişebilmek için o
      değişkenlerin `val/var` ile tanımlanması gerekiyor.

- ### Şimdi Gelelim Data Class'ların Sahip Olduğu Özelliklere
    - Data class'ları `open` yada `abstract` olarak belirtemiyoruz. Yani data class'ları herhangi başka bir sınıf miras
      alamaz anlamına geliyor.
      ![](/screenshots/week7/data_class_not_use_open.png)
      ![](/screenshots/week7/data_class_not_use_abstract.png)

    - Data class'lar `abstract` yada `open` ile belirtilmiş class'ları miras alabilir.
    - İnterface yapılarını da implement edebilirler.

```kt

data class Pokemon(
    val name: String,
    val type: String,
    val age: Int,
    val origin: String
) : AbstractPokemon()

abstract class AbstractPokemon()
```

- Şimdi bizim için generate ettiği fonksiyonlara bir bakalım.
  ![](/screenshots/week7/data_class_generated_functions.png)
  IDE'nin `Show Kotlin ByteCode` aracını kullanarak oluşturulan Java kodunu inceleyelim. İncelediğimizde bizim için
  generate edilen
  fonksiyonları görüyoruz. Şimdi gelelim bunların ne işe yaradığına hepsine teker teker bakalım.
- #### `equals()` Fonksiyonu
  İki nesnenin eşit olup olmadığını karşılaştırır ve geriye bir booelan değer döndürür. Bu fonksiyon içerisinde bu
  karşılaştırmanın
  nasıl yapılması gerektiği ile ilgili kurallar belirlenir. Kotlin bunu bizim için otomatik için yapıyor.
- #### `hashCode()` Fonksiyonu
  Nesnenin hash kodunu döndürür.
- #### `toString()` Fonksiyonu
  Bunu bir örnek üzerinden göstereyim. Bir adet normal class'ım bir adet de data class'ım var. Ve bunları `print()` ile
  ekrana yazdırmak istiyorum. Bakalım sonuç ne olacak.

```kt
data class PokemonData(
    val name: String,
    val type: String,
    val age: Int
)


class Pokemon(
    val name: String,
    val type: String,
    val age: Int,
)

fun main() {
    val pokemonData = PokemonData(name = "Bulbasaur", type = "Grass", age = 3)
    val pokemon = Pokemon(name = "Ivysaur", type = "Fire", age = 5)

    println(pokemonData)
    println(pokemon)
}
```

![](/screenshots/week7/data_class_to_string.png)

Ekranda gördüğümüz şekilde ilk yazdırdığımız class `data class` ikinci olarak yazdırdığımız ise `normal class` yapısı.
`Normal class` yazdırdığımızda ekranda gördüğümüz çıktı pokemon nesneninin bellekte nerede tutulduğunu gösteren bir
adrestir.
İşte `toString()` metodu bize ne döndürüyorsa bir bir nesneyi print etmeye çalıştığımızda o çıktıyı
verecektir. `Data class`'larda
bu fonksiyon nesne ile bilgileri güzel bir formatta yazdırmak için bizim için oluşturuluyor. `Normal class`'larda ise
default olarak
bellek adresini döndürüyor ama istersek `toString()` fonksiyonunun `override` ederek istediğimiz formatta yazdırmasını
da isteyebiliriz.

- #### `copy()` Fonksiyonu
  Bu fonksiyonu verimiz üzerinde diyelim ki bir parametreyi değiştirmek istiyoruz ama diğer parametreler aynı olsun ben
  sadece
  istediğim birkaç tane parametreyi değiştirmek istiyorum. Bunu `copy()` fonksiyonu ile yapabiliriz.

```kt
val pokemonData = PokemonData(name = "Bulbasaur", type = "Grass", age = 3)

val pokemonCopy = pokemonData.copy(
    age = 10
)
```

- #### `component()` Fonksiyonları
  Bu fonksiyonlar constructor'da yer alan her bir parametre için oluşturulur ve `destructuring declaration` yapısını
  kullanmamıza olanak sağlar.
  Constructor içinde yer alan parametreler için sırasıyla `component1`, `component2… `diye fonksiyonları oluşturulur.

- ### Destructuring declarations Nedir?

Destructuring declarations Kotlin'de bir veri yapısının parçalarını ayrı değişkenlere
ayırmanın bir yoludur. Örneğin isim ve yaş bilgilerini içeren Person adında bir data sınıfımız var.

```kt
data class Person(val name: String, val age: Int)
```

Daha sonra bu Person sınıfından bir nesne oluşturdukdan sonra name ve age değişkenlerini ayrı değişkenlere atamak
istedik. Burada Destructuring declaration'dan faydalanabiliriz.

```kt
val person = Person("Tolga", 23) // person nesnesini oluşturduk.
val (name, age) = person // Destructuring declarations Kullanımı
println("Name: $name Age:$age")
```

Destructuring declarations aynı zamanda `for` döngülerinde ve diğer bazı veri yapılarında da kullanılabilir.

```kt
val countryCodeArray = arrayOf("tr", "az", "en", "fr")

for ((index, value) in countryCodeArray.withIndex()) {
    println("Index: $index  Value:$value")
}
// ------------
val map = mapOf("a" to 1, "b" to 2, "c" to 3)

for ((key, value) in map) {
    println("Key: $key, Value: $value")
}
```

Yukarıdaki örnekte, for döngüsünde her bir çifti `key` ve `value` olmak üzere ayrı değişkenlere atarız. Bu, `map.keys`
ve `map.values` gibi yöntemler kullanarak aynı işlemi yapmaktan daha pratik ve okunabilir bir yaklaşımdır.

### Enum Classes
 Enum sınıflar, benzer öğeleri gruplandırmak ve tür güvenliği (Type Safety) sağlamak için kullanılan ve kodun daha okunabilir
ve tahmin edilebilir, anlaşılabilir yazılmasına katkı sağlayan bir sınıf türüdür.

- ### Enum Class'ları Neden Kullanıyoruz?
    Enum sınıflarının önemini anlatmak için bir senaryo üzerinden gidelim. Uygulamamızda birden fazla kullanıcı tipi olduğunu
    düşünelim. Developer, Manager ve Tester. Eğer `Enum` sınıflarını kullanmazsak, bu kullanıcı tiplerini sayılarla temsil 
    etmek zorunda kalabiliriz.
- 
    Örneğin;
    `developer - 0`
    `manager - 1`
    `tester - 2` temsil eder.
- 
    ```kt
     fun handleUser(userType: Int) {
      when(userType){
          0 -> "Developer için gerekli işlemi yap"
          1 -> "Manager için gerekli işlemi yap"
          2 -> "Tester için gerekli işlemi yap"
      }
  }
   ```
  Bu yaklaşım başlangıçta işlevsel görünse de ileride bazı önemli sorunlara yol açabilir.
    
 - ## Bu Yaklaşımın Sorunları

    - 1-) **Okunabilirlik Eksikliği:** Koda baktığımızda, `0`, `1` ve `2` gibi sayılar doğrudan neyi temsil
    ettiklerini söylemez. Bu da özellikle ekip genişledikçe ve kod büyüdükçe kafa karıştırıcı olabilir.
   
    - 2-) **Ölçeklenebilirlik Sorunları:** Daha fazla kullanıcı tipi eklemek istediğinizde sayılarla işlem yapmak karmaşık hale gelir.
   Ve yeni bir kullanıcı tipi ekledik diyelim bunu `userType`'a göre işlem yaptığımız her yerde yeni bir kontrol ekleme işlemini yapmamız gerekiyor.
   Ama bunu yaparken herhangi bir yerde bunu eklemeyi unutabiliriz ve uygulamamız başarılı bir şekilde build almaya devam eder ama bazı yerlerde istenilen şekilde davranışlar gerçekleştiremez.
   Bu da istenilen bir durum değildir.

- ### Enum Sınıfı Çözümü:

    Bu sorunları aşmanın en etkili yönü `Enum` sınıflarını kullanmaktır.

    ```kt
    enum class UserType {
        DEVELOPER,
        MANAGER,
        TESTER
    }

    fun handleUser(userType: UserType) {
        when (userType) {
            DEVELOPER -> "Developer için gerekli işlemi yap"
            MANAGER -> "Manager için gerekli işlemi yap"
            TESTER -> "Tester için gerekli işlemi yap"
        }
    }
  ```
    - ## Enum Sınıflarının Avantajları:

    - 1-) **Daha İyi Okunabilirlik:** Keyfi sayılar yerine anlamlı isimler kullanılır. Kodu okuyan herkes hemen kullanıcı tiplerinin neyi temsil ettiğini anlayabilir.
    - 2-) **Tür Güvenliği:** Enum sınıfları, yanlış değerlerin geçilmesini engeller. Yanlışlıkla bir Int değeri geçtiğinizde derleyici hata verecektir.
    - 3-) **Kolay Ölçeklenebilirlik:** Enum sınıflarına ekstra bir yeni eleman eklemesi yaptığımızda `Enum sınıflarını` kullandığımız yerlerde
    bize uyarı verecektir (*Aşağıdaki fotoğrafa bakabilirsiniz*) ve projeyi compile etmeyecek ve derleme aşamasında biz eksikliği fark edip hemen düzeltebileceğiz.
      ![](/screenshots/week7/enum_class_error.png)

- ### Enum Sınıfların Özellikleri
    Enum sınıflarının ne olduğunu ve neden kullanıldığını anladığımıza göre Enum sınıflarının özelliklerinden ve arka planda
    nasıl bir çalışma mantığı olduğuna bir göz gezdirelim. Let's Goooooo :)
    
  - #### 1-) Enum Sınıflar herhangi bir sınıfı miras (inheritance) alamıyorlar.
      ```kt
      // Bu örnek derlenmez çünkü enum sınıfları başka bir sınıftan türetilemez.
      open class BaseClass
      enum class UserType : BaseClass() {
          DEVELOPER,
          MANAGER,
          TESTER
      }
     ```
  - #### 2-) Enum Sınıflar interface yapılarını implement edebilirler.
    - Enum Sınıflar `interface` yapılarını `implement` edebilirler. Eğer implement edilen interface'in body'siz
      fonksiyonları varsa bu durumda bu fonksiyonu ya `Enum Class` içerisinde ya da `Enum sabitlerinin` **her birinin içerisinde
      ayrı ayrı** `override` işlemini gerçekleştirmemiz gerekiyor.
    ```kt
    interface Role {
        fun description(): String
    }
    
    enum class UserType : Role {
        DEVELOPER {
            override fun description() = "Writes code"
        },
        MANAGER {
            override fun description() = "Manages team"
        },
        TESTER {
            override fun description() = "Tests the product"
        }
    }
    
    fun main() {
        val userType = UserType.DEVELOPER
        println(userType.description()) // Çıktı: Writes code
    }     
    ```
    - #### 3-) Enum Sınıflarının nesnesi oluşturulamaz.
    - #### 4-) Enum sabitlerinin constructor'ları olabilir, ancak doğrudan property tanımlanamaz.
      - Enum sabitlerine constructor ekleyebiliriz, ancak her sabit, enum sınıfının sahip olduğu constructor parametrelerine sahip olmak zorundadır.
      ```kt
        enum class UserType(val role: String) {
            DEVELOPER("Writes code"),
            MANAGER("Manages team"),
            TESTER("Tests the product");
        
            fun printRole() {
                println("Role: $role")
            }
        }
        
        fun main() {
            UserType.DEVELOPER.printRole() // Çıktı: Role: Writes code
        }    
      ```
    - #### 5-)Enum Sınıflarının `entries` ve `values()` Fonksiyonları
      - `entries` ve `values()` fonksiyonları, bir enum sınıfının tüm sabitlerinin listesini verir.
      - Kotlin 1.9'dan itibaren, `values()` fonksiyonu yerine `entries` kullanılmaktadır.
      ```kt
        enum class UserType {
            DEVELOPER,
            MANAGER,
            TESTER
        }
        
        fun main() {
            // entries ile enum sabitlerinin listesini alalım
            val allEntries = UserType.entries
            println(allEntries) // Çıktı: [DEVELOPER, MANAGER, TESTER]
        
            // Eski yöntem: values()
            val allValues = UserType.values()
            println(allValues.joinToString()) // Çıktı: DEVELOPER, MANAGER, TESTER
        }      
      ```
    - #### 6-) valuesOf() fonksiyonu 
        - `valuesOf()` fonksiyonu ise, o enumdaki belli bir enum sabitini bize döndürür. Eğer verilen değer enum sabitlerinin içerisinde yoksa
        `IllegalArgumentException` hatası alınır.
      ```kt
        enum class UserType {
            DEVELOPER,
            MANAGER,
            TESTER
        }
        
        fun main() {
            // Geçerli bir enum sabiti
            val developer = UserType.valueOf("DEVELOPER")
            println(developer) // Çıktı: DEVELOPER
        
            // Geçersiz bir enum sabiti
            try {
                val invalidType = UserType.valueOf("ADMIN")
            } catch (e: IllegalArgumentException) {
                println("Hata: ${e.message}") // Çıktı: Hata: No enum constant UserType.ADMIN
            }
        }
      
      ```
    - #### 7-) Enum Sabitlerinin name ve ordinal Property'leri
      - `name:` Enum sabitinin ismini verir.
      - `ordinal:` Enum sabitinin sıralamasını (index) verir.
      ```kt
        enum class UserType {
            DEVELOPER,
            MANAGER,
            TESTER
        }
        
        fun main() {
            val userType = UserType.MANAGER
            println("Name: ${userType.name}")     // Çıktı: Name: MANAGER
            println("Ordinal: ${userType.ordinal}") // Çıktı: Ordinal: 1
        }      
      ```