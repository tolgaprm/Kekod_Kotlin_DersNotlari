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
    - `--a`: Bu ifade, önce değeri bir artırır ve ardından artırılmış değeri kullanır. Yani, a'yı bir artırır ve sonra
      artırılmış değeri kullanır
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
  println("NumberOne: ${numberOne++}")
  println("NumberOne: ${numberOne}")
  println("NumberOne: ${++numberOne}")
  
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
       val sayı1:Int? = 10
       val sayı2 = 3
       println(sayı1?.plus(sayı2))
      ```

### 2. Operator Overloading