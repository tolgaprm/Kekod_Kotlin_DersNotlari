>>> # Kekod Ders Notları
- Bu repoda Gökhan Öztürk tarafından Youtube'da Kotlin ve Android dersleri sırasında aldığım notlar bulunmaktadır. [Youtube Linki](https://www.youtube.com/@KeKod)
- Notlarda özellikle iş görüşmelerinde çıkabilecek sorular ve cevaplar bulunacaktır.

- Bu notlara eklemek istediğiniz herhangi ek bir bilgi olur veya yanlış olduğunu düşündüğünüz kısımlar var ise bunları pull-request
  işlemi yaparak yeni notlar veya düzeltmeler yapabilirsiniz.

- Eğer pull request nasıl atılır öğrenmek istiyorsanız. Yasin Maden arkadaşımızın hazırlamış olduğu [Medium yazısına](https://medium.com/@madenyasin/githubda-pull-request-nas%C4%B1l-olu%C5%9Fturulur-2de051dd9419)
  bakabilirsiniz.

 ### [Challengelarda Dikkat Edilmesi Gerekenler - Tavsiyeler](otherReadme/Challenge_Dikkat_Edilmesi_Gerekenler.md)
      
> Bu kısımda ders sırasında Gökhan tarafından challenglarda dikkat etmemiz gereken tavsiyeler
> bulunmaktadır.

<details>
<summary> <h3>Ders 1</h3></summary>

### Intellij Idea Kısayollar

- [(Ümit Köse) Youtube'da kısayolları anlattığı bir video](https://youtu.be/XOniJYHaiEY?si=jCoyOZ1-QuOAEdzm)
- [key-promoter-x](https://plugins.jetbrains.com/plugin/9792-key-promoter-x) - IDE üzerinde plugin
- IDE üzerinden `Help/Keyboard Shortcuts PDF` seçeneğine tıklayarak PDF'e ulaşabilirsiniz.

### Debugging

Debugging işlemi, yazılımın doğru çalışmasını engelleyen hataları tespit etmek amacıyla yapılır.
Detaylı bilgi için ve debug temellerini öprenmek
için [The Full Guide to Debugging Your Android Apps (İngilizce)](https://www.youtube.com/watch?v=ln5hc-zprEM) göz
atabilirsiniz.

### Type Inference (Tip Çıkarımı) Nedir ?

  Değişkenin değerini direkt olarak ilk değer atamasını yapmıyorsak daha sonra tanımlayacakasak,
  bunun tipinin ne olacağını IDE'ye söylememiz gerekiyor.
  
  Bir değişkene değer atadığımızda o verinin hangi türde olacağını tam olarak belirtmediysek IDE'nin o verinin
  hangi türde olacağını bilmesidir.
  
  ```kt
  val name: String = "Tolga"
  val age = 23 // Type Inference
 // age değişkenini tanımlarken tam olarak (Explicitly) bir şekilde belirtmedik.
 // IDE burada değişkenin tipini otomatik olarak kendisi tespit edecektir.
  ```

### `val` ve `var` İle Oluşturulan Bir Değişkenin En Temel Farkı?

-`val`: Değişken bir kere atandığında sabit kalır. `Value` sabit kelimesinin kısaltmasıdır.

-`var`: Değişken daha sonra değiştirilebilir. `Variable` değişken kelimesinin kısaltmasıdır.

- #### `val` - `var` hangisi daha hızlıdır? Yani bir `val` değişken oluşturmak mı bize daha maliyetli yoksa `var` bir değişken oluşturmak mı daha maliyetli

    ```kt
         Bir var değişkenini val yapmak için private set kullanılabilir.
    ```
- #### Olan ufacık bir performans farkı nedir?

- **`val` Değişkenleri:**
    - Bir kere atandığında sabit kalır. (Değiştirilemez)
    - Bu durum, değişkenin tipini ve değerini belirledikten sonra bir daha değiştirilemeyeceği anlamına gelir.


- **`var` Değişkenleri:**
    - Daha sonra değiştirilebilir.
    - Esneklik sağlar ve değer sonradan değiştirilebilir.
    - Performans açısından `val` değişkenlerden biraz daha avantajlıdır.


> `val` değişkenleri daha maliyetli kılan ana neden, değişkenin bir kere atandıktan 
    sonra değiştirilemeyeceği şartını içermesidir.Bu şartın kontrol edilmesi, ek bir maliyet getirir.
    Ama `var` kullanımında ekstra bir şartımız yok.
    (Teorik olarak aslında akılda kalıcı olması için böyle bir açıklama yapıldı derste.
    Yoksa tam olarak böyle bir durum yok.)

#### Özet olarak;

> Akademik olarak düşündüğümüzde `var` değişkenler daha performanslıdır ama bu göz ardı edilebilecek bir performans
farkı yaratır.
**Günlük hayat problemlerinde ise `val` kullanmak daha avantajlıdır.**
Bu tercihin arkasındaki sebep, sektördeki uygulamalarda çok sayıda multi-thread işleminin gerçekleştirildiği durumlardır.

### `var` ile tanımlanmış bir değişkeni, `var` keyword'unu kullanarak `val` değişken nasıl yapılabilir?

  Örneğin bir `var isMale = true` değişkenimiz var. Her bir değişkenimizin arka planda
  yazılan `get()` ve `set()` fonksiyonu vardır.(Bunu ilerideki derslerde daha detaylı göreceğiz property vs field farklarında)

  Biz bu fonksiyonlara visibility modifier ekleyebiliriz.
  Eğer `set()` fonksiyonuna `private` visibility modifier eklersek değiştirilemez bir değişken elde etmiş oluruz.
  
   ```kt
  class Ders1 {
      var isMale: Boolean = true
          private set
  }
  ```
</details>