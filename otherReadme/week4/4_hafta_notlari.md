
### 1- Operatörler

Operatörler, çeşitli işlemleri gerçekleştirmek için kullanılan sembol veya işaretlerdir. Kotlin'deki operatörler
genellikle
sayılar arasında matematiksel işlemleri gerçekleştirmek, karşılaştırmalar yapmak, mantıksal operasyonları
gerçekleştirmek için kullanılır.

İşte Kotlin'de sık kullanılan bazı operatör fonksiyonları:

| Operatör | İşlev                 | Fonksiyon Hali | Örnek Kullanım       |
|----------|-----------------------|----------------|----------------------|
| `+`      | Toplama               | `plus`         | `a.plus(b)`          |
| `-`      | Çıkarma               | `minus`        | `a.minus(b)`         |
| `*`      | Çarpma                | `times`        | `a.times(b)`         |
| `/`      | Bölme                 | `div`          | `a.div(b)`           |
| `%`      | Mod Alma              | `rem`          | `a.rem(b)`           |
| `==`     | Eşit mi?              | `equals`       | `a.equals(b)`        |
| `==`     | Eşit mi?              | `compareTo`    | `a.compareTo(b) == 0` |
| `>`      | Büyük mü?             | `compareTo`    | `a.compareTo(b) > 0` |
| `<`      | Küçük mü?             | `compareTo`    | `a.compareTo(b) < 0` |
| `>=`     | Büyük veya eşit mi?   | `compareTo`    | `a.compareTo(b) >= 0` |
| `<=`     | Küçük veya eşit mi?   | `compareTo`    | `a.compareTo(b) <= 0` |
| `&&`     | Ve (and)              | `and`          | `a.and(b)`           |
|          | Veya (or)             | `or`           | `a.or(b)`            |
| `!`      | Değil (not)           | `not`          | `a.not()`            |
| `++a`    | Increment             | `inc`          | `a.inc()`            |
| `--a`    | Decrement             | `dec`          | `a.dec()`            |
| `+a`     | Pozitif işareti alır. | `unaryPlus`    | `a.unaryPlus()`      |
| `-a`     | Negatif işareti alır  | `unaryMinus`   | `a.unaryMinus()`     |

- ### `compareTo() Fonksiyonu`
  `compareTo` fonksiyonu, iki elemanı karşılaştırarak üç farklı duruma göre geri dönüş değeri sağlar:
    - Eğer iki ifade de eşit ise `0` değerini döndürür.
    - Eğer ilk değer ikinci değerden büyükse, `pozitif bir değer` döndürür.
    - Eğer ilk değer ikinci değerden küçükse, `negatif bir değer` değerini döndürür.
   ```kt
   val numberOne = 10
   val numberTwo = 5
  
    println(numberOne.compareTo(numberTwo) < 0) // a < b // false
    println(numberOne.compareTo(numberTwo) > 0) // a > b // true
    println(numberOne.compareTo(numberTwo) == 0) // false
  
  // Bu fonksiyonu Infix hali ilede kullanabiliriz.

  println(numberOne compareTo numberTwo == -1)
  println(numberOne compareTo numberTwo == 1)
  println(numberOne compareTo numberTwo == 0)
   ```
  Bazı fonksiyonlar için bir açıklama yapmak istiyorum:
    - `+a`  - `unaryPlus()` - Sayının işaretini temsil etmek için kullanılır. Yani burdaki işlemle sayıyı `1` ile
      çarpmış gibi oluyoruz.
    - `-a`  - `unaryMinus()` - Buradaki işlemle de sayıyı `-1` değeri ile çarpmış gibi düşünebiliriz. Sayımız `4`
      ise `-4` dediğimizde `-4` ifadesini
      elde etmiş olduk. Ama sayımız `-10` diyelim ve buna bu fonksiyonu uyguladığımızda `--10` yapmış oluyoruz. İki `-`
      işaret çarpılırsa `+` olacağından sonuç `10` olacaktır.
    - `a++` :  Bu ifade, önce mevcut değeri kullanır ve ardından değeri bir artırır. Yani, a'yı kullanır ve sonra a'yı
      bir artırır
    - `++a`: Bu ifade, önce değeri bir artırır ve ardından artırılmış değeri kullanır. Yani, a'yı bir artırır ve sonra
      artırılmış değeri kullanır.
    > Bu kullanımın `a--` ve `--a` kullanımları da vardır.
  ```kt
   val sayi1 = 5
   val sayi2 = 4
   val sayi3 = -10
   
   println("Sonuç 1: ${+sayi1}")  // Sonuç 1: 5
   println("Sonuç 2: ${-sayi2}")  // Sonuç 2: -4
   println("Sonuç 3: ${-sayi3}")  // Sonuç 3: 10
  
  ```

  ```kt
  var numberOne = 10
  println("NumberOne: ${numberOne}")
  println("NumberOne: ${numberOne++}") // Önce mevcut değeri okur daha sonra artırma işlemini yapar.
  println("NumberOne: ${numberOne}") 
  println("NumberOne: ${++numberOne}") // Önce değeri bir artırır daha sonra artıtılan değeri kullanılır.
  
  /* Sonuç
  NumberOne: 10
  NumberOne: 10
  NumberOne: 11
  NumberOne: 12
   */
  ``` 

    - ### Ne Zaman Operatör Fonksiyonları (Örneğin: plus()) Kullanmalıyız, Ne Zaman Doğrudan Operatörleri (Örneğin: +) Kullanmalıyız?
        Eğer ilk çağırdığımız eleman `nullable`  ise, `?. (safe call)` operatörü kullanılarak null check işlemi
        gerçekleştirilebilir. Bu, eğer ilk eleman null ise, operatör fonksiyonunun(plus(),minus(),div()) çağrılmayacağı anlamına gelir ve sonuç olarak
        null döner.

        Diğer durumlarda, yani ilk eleman nullable değilse, direkt olarak operatör(+,-,/) kullanmak daha mantıklı bir tercih
        olacaktır.
       ```kt
       val nullableNumber:Int? = 10
       val sayı2 = 3
       println(nullableNumber?.plus(sayı2))
      
       println(nullableNumber + sayi2) // Bu şekilde yaptığımızda IDE bize bir null kontrolü gerçekleştirmen
      // gerekiyor diyor. `+` operatörleri nullable receiver olarak desteklenmiyor.
      
      // Eğer ben halen + operatörleri kullanacağım diyorsanız o zaman öncesinde bir null check yapmamız gerekiyor.
      
       if (nullableNumber != null) {
        println(nullableNumber + 1)
       }
      
       nullableNumber?.let { 
           println(nullableNumber + 1)
       }
      ```

### 2. Operator Overloading
-  Bu operatör fonksiyonları, ilgili veri türlerinde (sayılar, boolean'lar vb.) kullanılabilecek şekilde tanımlanmıştır. 
    Ayrıca, sınıf ve tiplerin kendi operatör fonksiyonlarını aşırı yüklemeleri (operator overloading) mümkündür, bu sayede özel türler üzerinde operatörlerin davranışını özelleştirmek mümkün olur.
    Bu, belirli bir tür üzerinde kullanılan operatörün farklı durumlar veya türler için nasıl davranacağını özelleştirmenizi sağlar.

    ### Gelin buna bir örnek üzerinden bakalım.

    ```kt
   class Vektor(var x: Int, var y: Int) {
   
        // Toplama operatörünü aşırı yükleyelim (+)
        operator fun plus(other: Vektor): Vektor {
            return Vektor(x + other.x, y + other.y)
        }

        // Çıkarma operatörünü aşırı yükleyelim (-)
        operator fun minus(other: Vektor): Vektor {
            return Vektor(x - other.x, y - other.y)
        }

        // Çarpma operatörünü aşırı yükleyelim (*)
        operator fun times(scalar: Int): Vektor {
            return Vektor(x * scalar, y * scalar)
        }
    }
   ```
    Bu örnekte, bir `Vektor` sınıfı oluşturduk. Bu sınıf, iki boyutlu bir vektörü temsil eder. Sınıf içinde,` plus, minus ve times` operatör fonksiyonlarını aşırı yükleyerek(overload), bu operatörlerin bu vektör sınıfına özel bir davranış sergilemesini sağladık.
    Şimdi, bu Vektor sınıfından iki örnek oluşturduk: vektor1 ve vektor2. Ardından, bu iki vektör arasında plus (toplama) operatör kullanarak bir toplama işlemi gerçekleştirdik.
    ```kt
    val vektor1 = Vektor(x = 2, y = 3)
    val vektor2 = Vektor(x = 4, y = 6)

    val vektorPlus = vektor1 + vektor2 // x= 6, y= 9

    // Eğer biz bu operator fonksiyonlarını kullanmasaydık ve iki vektörü toplamak istediğimizde şu şekilde bir kullanım yapacaktık.
    val vektorPlusWithoutOperatorOverload = Vektor(x = vektor1.x + vektor2.x, y = vektor2.y + vektor2.y)
   ```

### 3. ControlFlow  If-Else

`If` ifadesi, bir koşulun doğru veya yanlış olmasına bağlı olarak belirli bir kod bloğunu çalıştırmak için kullanılır. 

Kotlin'de `If` kullanımının iki farklı kullanımı vardır.

 ###  **1 - State Olarak Kullanımı**
```kt
val answer = readln()

if (answer.contains("Evet", ignoreCase = true)) {
    println("Öğrenci")
} else {
    println("Öğrenci Değil")
}


if (answer.contains("Evet", ignoreCase = true)) println("Öğrenci")
else println("Öğrenci Değil")


if (answer.contains("Evet", ignoreCase = true)) println("Öğrenci") else println("Öğrenci Değil")
```

Yukarıdaki if işlemini 3 farklı şekilde yazıldığını görebiliriz. Fakat bunun en doğru kullanım şekli
ilk baştaki şekilde `{}` kullanılarak yazılan şeklidir.

 ### **2- Expression Olarak Kullanımı**

Yaptığımız if kontrolleri sonrasında yapacağımız işlemlerden sonra bir değişkene değer atamaya ihtiyacımız var ise bunu
expression kullanımı ile yapabiliriz. Burada if veya else blokları içerisindeki son satır değer olarak değişkene atanır.

Expression kullanımında değişkenin tipini belirtmezsek Ide TypeInference ile o tipi belirleyebilir ama best practice olarak
değişkenin tipini belirtmek daha doğru olacaktır.

```kt
val result: String = if (answer.contains("Evet", ignoreCase = true)) {
    println("Expression kullanımı")
    "Öğrencidir"
} else {
    println("Expression kullanımı")
    "Öğrenci Değil"
}

println(result)
```

- ### Kotlin'de Neden Ternary(`condition ? then : else`) Operatörü Yoktur?

Kotlin'de `if-else` kullanımlarının expression olarak kullanılabildiği için `ternary` operatörü yoktur. Ternary yerine aşağıdaki
gibi bir kullanım yapabiliriz.
```kt
val max = if (a > b) a else b
```

- ### `if` `else if` Kullanımı
`if - else if` ifadesi, bir dizi koşulu sırayla kontrol etmek ve ilk doğru koşula uyan kod bloğunu çalıştırmak için kullanılır. Yani, her bir else if bloğu, bir önceki koşulun yanlış olduğu durumu kontrol eder.

```kt
if (koşul1) {
    // Koşul1 doğruysa buradaki kod bloğu çalışır
} else if (koşul2) {
    // Koşul1 yanlış, ancak koşul2 doğruysa buradaki kod bloğu çalışır
} else if (koşul3) {
    // Koşul1 ve koşul2 yanlış, ancak koşul3 doğruysa buradaki kod bloğu çalışır
} else {
    // Hiçbir koşul doğru değilse buradaki kod bloğu çalışır
}


val not = 75

if (not >= 90 && not <= 100) {
    println("Notunuz A")
} else if (not >= 80 && not < 90) {
    println("Notunuz B")
} else if (not >= 70 && not < 80) {
    println("Notunuz C")
} else if (not >= 60 && not < 70) {
    println("Notunuz D")
} else {
    println("Notunuz F")
}
```
 #### if - else Kullanımlarında Önemli Bir Nokta

> Eğer ben `if` içerisinde bir değişkeni kontrol ediyorsam `else-if` bloklarında da aynı değişkenin farklı durumlarını 
> kontrol etmem gerekiyor.
> Eğer `else-if` kısmında başka bir değişkeni de kontrol etmem gerekiyor ise ya o değişken ilk if bloğunda da olmalı yada
> o durum için ayrı bir if yazımı yapmalıyız.

Birden fazla şartlı durumumuz var ise ve bunları `if-else if` blokları ile değil de hepsi için ayrı ayrı `if` blokları olarak
yazdığımızda çok verimli bir işlem yapmamış oluruz. Bunun nedeni `if-else if` bloklarında doğru case bulunduktan sonra
diğer caselerin kontrolü gerçekleştirilmez. Ama aşağıdaki gibi bir kontrol gerçekleştirdiğimizde doğru case bulunsa bile bütün if koşulları kontrol edilecektir.
```kt
    if (grade >= 90 && grade <= 100) {
        println("Notunuz A")
    }
    if (grade >= 80 && grade < 90) {
        println("Notunuz B")
    }
    if (grade >= 70 && grade < 80) {
        println("Notunuz C")
    }
    if (grade >= 60 && grade < 70) {
        println("Notunuz D")
    }
```

> Bazı durumlarda `if-else` yazmaktansa if bloğunun içinde bir durumu kontrol edip, o duruma uymayan durumlar için bir hata fırlatma (throw) veya bir değer döndürme (return) gibi ifadelerle kodu sonlandırma yöntemidir. Bu durum, kodunuzu daha okunabilir ve sade hale getirebilir.
> Örnek olarak bir fonksiyon içerisinde 
>```kt
>fun validatePassword() {
>   val password = "password23"
>
>    if (password.isBlank()) {
>        return
>    }
>
>    if (password.length < 6) {
>        return
>    }
>   
>   // Password doğru ise gerekli işlemleri yapmaya devam et
>}
>```

### 4. ControlFlow When

Kotlin'de `when` ifadesi, diğer dillerdeki `switch-case` yapısına benzer bir yapıdadır. Ancak Kotlin'de daha güçlü ve esnek bir kullanıma 
sahiptir.
- `when` ifadesini, birden çok koşulun kontrol edilmesi gerektiği durumlarda kullanabilirsiniz.
- Birden çok koşulu if-else - else if yazmak yerine tek bir when yapısı kullanarak yazmak daha okunabilir bir kod yazmamıma yardımcı olabilir.

```kt
val x = 5

when (x) {
    1 -> println("x is 1")
    2 -> println("x is 2")
    3, 4 -> println("x is either 3 or 4")
    in 5..10 -> println("x is between 5 and 10")
    else -> println("x is neither 1 nor 2 nor between 3 and 4 nor between 5 and 10")
}
```
- Birden fazla değere karşılık gelmesi için `virgül(,)` kullanılır.
- Belirli bir aralığa karşılık gelmesi için `in` anahtar kelimesi kullanılır.
- Hiçbir koşulun sağlanmadığı durumlar için `else` kullanılabilir.

- ### Expression Kullanımı
```kt
val y = when (x) {
    1 -> "x is 1"
    2 -> "x is 2"
    else -> "x is neither 1 nor 2"
}
```
`when` ifadesi bir değer döndürebilir. Yukarıdaki örnekte `y` değişkenine, `when` ifadesinin sonuçlarından biri atanır.

- ### Tip Kontrolü

```kt
val any: Any = "Hello"

when (any) {
    is String -> println("It's a String")
    is Int -> println("It's an Integer")
    else -> println("It's neither String nor Integer")
}
```
`when` ifadesi tip kontrolü için de kullanılabilir. Bu şekilde, değişkenin hangi türden olduğunu kontrol edebilirsiniz.

### 5. For Loop

Kotlin'de `for` döngüsü, belirli bir aralıkta veya bir koleksiyon üzerinde döngü oluşturmak için kullanılır.

####  3 farklı şekllide for tanımlanabilir
* `value in list`                     şeklinde value değerlerini alabilirsiniz.
* `index in list.indices`             şeklinde index değerlerini alabilirsiniz.
* `(index,value) in list.withIndex()` şeklinde index ve value değerlerini alabilirsiniz.

```kt
    val countryCodeArray = arrayOf("tr", "az", "en", "fr")

    for (value in countryCodeArray) {
        print("$value - ")
    }
    // Çıktı: tr - az - en - fr

    for (index in countryCodeArray.indices) {
        println("$index.değeri: ${countryCodeArray[index]} ")
    }
    /* Çıktı:
      0.değeri: tr 
      1.değeri: az 
      2.değeri: en
      3.değeri: fr
     */

    // Destructuring declarations
    // Indexed value
    for ((index, value) in countryCodeArray.withIndex()) {
        println("Index: $index  Value:$value")
    }
    /* Çıktı
    Index: 0  Value:tr
    Index: 1  Value:az
    Index: 2  Value:en
    Index: 3  Value:fr
    */
```

- ### İç içe Düngüler
```kt
for (i in 1..5) {
    for (j in 1..3) {
        println("$i - $j")
    }
}
```
Kotlin'de iç içe for döngüleri kullanımı da yapabiliriz.

### 6. While Loop
`while` ve `do-while` koşulları sağlandığı sürece gövdelerinde var olan kod bloklarını sürekli olarak çalıştırır.

- `while` döngüsü, belirli bir koşul doğru olduğu sürece döngünün çalışmasını sağlar. Koşul her zaman döngünün başında kontrol edilir ve koşul yanlış olduğunda döngü sona erer.
- `do-while` döngüsü, koşul doğru veya yanlış olsa bile döngünün en az bir kez çalışmasını sağlar. Koşul döngünün sonunda kontrol edilir.

```kt
var i = 0

while (i < 5) {
    println(i)
    i++
}
// ---------------------
var j = 0

do {
    println(j)
    j++
} while (j < 5)
```


- ### Destructuring declarations Nedir?
Destructuring declarations Kotlin'de bir veri yapısının parçalarını ayrı değişkenlere
ayırmanın bir yoludur. Bu yapıyı `data class` konusuna geçtiğimizde daha detaylı bir şekilde anlatacağım.
Örneğin isim ve yaş bilgilerini içeren Person adında  bir data sınıfımız var.
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