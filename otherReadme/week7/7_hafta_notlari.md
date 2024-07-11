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
    Bu fonksiyonu verimiz üzerinde diyelim ki bir parametreyi değiştirmek istiyoruz ama diğer parametreler aynı olsun ben sadece
    istediğim birkaç tane parametreyi değiştirmek istiyorum. Bunu `copy()` fonksiyonu ile yapabiliriz.
```kt
val pokemonData = PokemonData(name = "Bulbasaur", type = "Grass", age = 3)

val pokemonCopy = pokemonData.copy(
    age = 10
)
```

- #### `component()` Fonksiyonları 
  Bu fonksiyonlar constructor'da yer alan her bir parametre için oluşturulur ve `destructuring declaration` yapısını kullanmamıza olanak sağlar.
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
val person = Person("Tolga",23) // person nesnesini oluşturduk.
val (name,age) = person // Destructuring declarations Kullanımı
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
Yukarıdaki örnekte, for döngüsünde her bir çifti `key` ve `value` olmak üzere ayrı değişkenlere atarız. Bu, `map.keys` ve `map.values` gibi yöntemler kullanarak aynı işlemi yapmaktan daha pratik ve okunabilir bir yaklaşımdır.