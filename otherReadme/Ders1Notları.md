### 1 - Intellij Idea Kısayollar

- [(Ümit Köse) Youtube'da kısayolları anlattığı bir video](https://youtu.be/XOniJYHaiEY?si=jCoyOZ1-QuOAEdzm)
- [key-promoter-x](https://plugins.jetbrains.com/plugin/9792-key-promoter-x) - IDE üzerinde plugin
- IDE üzerinden `Help/Keyboard Shortcuts PDF` seçeneğine tıklayarak PDF'e ulaşabilirsiniz.

### 2 - Debugging

Debugging işlemi, yazılımın doğru çalışmasını engelleyen hataları tespit etmek amacıyla yapılır.
Detaylı bilgi için ve debug temellerini öprenmek
için [The Full Guide to Debugging Your Android Apps (İngilizce)](https://www.youtube.com/watch?v=ln5hc-zprEM) göz
atabilirsiniz.

### 3 - Type Inference (Tip Çıkarımı) Nedir ?

- Eşitliğin karşı tarafındaki değere bakarak, değişkenin tipinin ne olacağını IDE'nin karar vermesi.
- Bir değişkene değer atadığımızda o verinin hangi türde olacağını tam olarak belirtmediysek IDE'nin o verinin
  hangi türde olacağını bilmesidir.

```kt
  val name: String = "Tolga"
val age = 23 // Type Inference
// age değişkenini tanımlarken tam olarak (Explicitly) bir şekilde belirtmedik.
// IDE burada değişkenin tipini otomatik olarak kendisi tespit edecektir.
```

Number değer tipine sahip değişkenler için önemli bir bilgi:

* Type Inference sırasında eğer sayi `Int` ifadeden büyük değilse tipi `Int` set edilir.
* Ama `Int` değer aralığından daha büyükse tipi `Long` olarak set edilir.

```kt
    val amongIntValue = 900334 // Int
val higherInt = 1_000_0000_000 // Long

// Burada biraz daha anlamlı olabilecek bir örnek üzerinden bakalım
val number: Short = 40
val number2: Short = 50
val totalNumber = number + number2
```

Burada iki `short` değişkeni topladık ve `totalNumber` değişkenine eşitledik
`totalNumber` değişkeninin tipini belirtirken **Type Inference'dan** faydalandık.
Peki burada totalNumber değişkeni `Short` mu, `Int` mi, yoksa `Long` mu olacak.

Aslında yukarıda belirtmiştik. Type Inference sırasında eşitliğin karşı tarafındaki
değer `Int` değişkenin sınırları arasında ise `Int` olarak belirlenir. 
Ama eğer sayımız `Int` değerin alabileceği max değeri geçti ise `Long` olarak belirlenir.

### 4 - `val` ve `var` İle Oluşturulan Bir Değişkenin En Temel Farkı?

- **`val` Değişkenleri:**
    - Değişken bir kere atandığında sabit kalır. `Value` sabit kelimesinin kısaltmasıdır.
    - Bu durum, değişkenin tipini ve değerini belirledikten sonra bir daha değiştirilemeyeceği anlamına gelir.


- **`var` Değişkenleri:**
    - Değişken daha sonra değiştirilebilir. `Variable` değişken kelimesinin kısaltmasıdır.
    - Esneklik sağlar ve değer sonradan değiştirilebilir.
    - Performans açısından `val` değişkenlerden biraz daha avantajlıdır.

- #### `val` - `var` hangisi daha hızlıdır? Yani bir `val` değişken oluşturmak mı bize daha maliyetli yoksa `var` bir değişken oluşturmak mı daha maliyetli?

> `val` değişkenleri daha maliyetli kılan ana neden, değişkenin bir kere atandıktan
> sonra değiştirilemeyeceği şartını içermesidir.Bu şartın kontrol edilmesi, ek bir maliyet getirir.
> Ama `var` kullanımında ekstra bir şartımız yok.
(Teorik olarak aslında akılda kalıcı olması için böyle bir açıklama yapıldı derste.
> Yoksa tam olarak böyle bir durum yok.)

#### Özet olarak;

> Akademik olarak düşündüğümüzde `var` değişkenler daha performanslıdır ama bu göz ardı edilebilecek bir performans
> farkı yaratır.
**Günlük hayat problemlerinde ise `val` kullanmak daha avantajlıdır.**
> Bu tercihin arkasındaki sebep, sektördeki uygulamalarda çok sayıda multi-thread işleminin gerçekleştirildiği
> durumlardır.

### 5 - `var` ile tanımlanmış bir değişkeni, `var` keyword'unu kullanarak `val` değişken nasıl yapılabilir?

Örneğin bir `var isMale = true` değişkenimiz var. Her bir değişkenimizin arka planda
yazılan `get()` ve `set()` fonksiyonu vardır.(Bunu ilerideki derslerde daha detaylı göreceğiz property vs field
farklarında)

Biz bu fonksiyonlara visibility modifier ekleyebiliriz.
Eğer `set()` fonksiyonuna `private` visibility modifier eklersek değiştirilemez bir değişken elde etmiş oluruz.

   ```kt
  class Ders1 {
    var isMale: Boolean = true
        private set
}
  ```