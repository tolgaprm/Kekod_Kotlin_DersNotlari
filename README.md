# Kekod Ders Notları
 - Bu repoda Gökhan Öztürk tarafından youtube'da Kotlin ve Android dersleri sırasında aldığım notlar bulunmaktadır. [Youtube Linki](https://www.youtube.com/@KeKod)
 - Notlarda özellikle iş görüşmelerinde çıkabileceksorular ve cevaplar bulunacaktır.

 - Bu notlara eklemek istediğiniz herhangi ek bir bilgi olur veya yanlış olduğunu düşündüğünüz kısımlar var ise bunları pull-request
   işlemi yaparak yeni notlar veya düzeltmeler yapabilirsiniz.

   Eğer pull request nasıl atılır öğrenmek istiyorsanız. Yasin Maden arkadaşımızın hazırlamış olduğu [Medium yazısına](https://medium.com/@madenyasin/githubda-pull-request-nas%C4%B1l-olu%C5%9Fturulur-2de051dd9419)
   bakabilirsiniz. 

## Ders 1 Notlar
---
<details>
  <summary> <h3> Intellij Idea Kısayollar </h3> </summary>

 Kod yazarken kısayolları kullanmak, yapacağımız işi daha hızlı bir şekilde yapabilmemizi sağlar.
Bu kısa yolları öğrenmek çalışırken daha verimli bir şekilde çalışmamıza olanak sağlar.
 Whatsapp grubunda kısayollar ile ilgili birkaç kaynak paylaşıldı. Onları da buraya ekleyeyim.
  - [(Ümit Köse) Youtube'da kısayolları anlattığı bir video hazırlamış.](https://youtu.be/XOniJYHaiEY?si=jCoyOZ1-QuOAEdzm)
  - [key-promoter-x](https://plugins.jetbrains.com/plugin/9792-key-promoter-x) - Bu da IDE üzerinde plugini kurarak,
 anlık yaptığımız işlemlerin kısa yollarını bize gösteriyor. Bu şekilde bu kısayolları da öğrenebiliriz.
  - Eğer direkt bu yaygın olarak kullanılan kısayolları PDF olarak görmek istiyorsak;

    IDE üzerinden `Help/Keyboard Shortcuts PDF` seçeneğine tıklayarak PDF'e ulaşabilirsiniz.
</details>

<details>
  <summary> <h3> Debugging </h3> </summary>

 Debugging işlemi, yazılımın doğru çalışmasını engelleyen hataları tespit etmek, 
 bu hataların nedenlerini anlamak ve ardından bu hataları düzeltmek amacıyla gerçekleştirilir.
Debugging temellerini öğrenebileceğiniz https://www.youtube.com/watch?v=ln5hc-zprEM (İngilizce) videosuna bakabilirsiniz.
</details>

<details>
  <summary> <h3> Type Inference (Tip Çıkarımı) Nedir?</h3> </summary>

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
</details>

<details>
  <summary> <h3> val(value) vs var(variable) </h3> </summary>
  
### `val` - `var` ile oluşturulan bir değişkenin en temel farkı,
```kt
    var isMale = true
    val isStudent = false
```
 - `val` ile tanımladığımız bir değişken daha sonra değiştirilemez olurken yani bir kere atandığında sabit kalır,
 - `var` ile tanımladığımız bir değişkeni daha sonra değiştirebiliriz.

###### `val` - `var` hangisi daha hızlıdır? Yani bir `val` değişken oluşturmak mı bize daha maliyetli yoksa `var` bir değişken oluşturmak mı daha maliyetli

  Aralarındaki performans farkı yok denecek kadar azdır. Genel anlamda `val` yada `var` ile tanımlamamız bir şey ifade
 etmeyecektir.

### Olan ufacık bir performans farkı nedir?
  `val` değişkenler, `var` değişkenlere göre daha maliyetlidir. Yani `var` değişkenler daha performanslıdır.
  
  Bunun nedeni `val` ile bir değişken tanımlarken bir şart belirtiyoruz (Bunu daha sonra değiştirilemez.)
  Ama `var` kullanımında ekstra bir şartımız yok.
  
 Eğer ekstra bir şartımız varsa arka planda bunun için bir kod yazılmış olması lazımdır.
 - (Teorik olarak aslında akılda kalıcı olması için böyle bir açıklama yapıldı derste.
 Yoksa tam olarak böyle bir durum yok.)
  
 Özet olarak;
   Akademik olarak düşündüğümüzde `var` değişkenler daha performanslıdır ama bu göz ardı edilebilecek bir performans
  farkı yaratır.
 Günlük hayat problemlerinde ise `val` kullanmak daha avantajlıdır. Bunun sebebi sektörde olan uygulamarda
 çok fazla multi-thread işlemler kullanıldığından dolayı diyerek kısa bir cevap verebiliriz.
 
 "multi-threading" veya çoklu iş parçacığı kullanımı,
  bir bilgisayar programının aynı anda birden fazla işlemi eşzamanlı olarak gerçekleştirmesine
 olanak tanıyan bir programlama kavramıdır.
</details>

<details>
  <summary> 
    <h3> var ile tanımlanmış bir değişkeni, var keyword'unu kullanarak val değişken nasıl yapabilirsin?</h3> 
  </summary>

   Örneğin bir `var isMale = true` değişkenimiz var. Her bir değişkenimizin arka planda
 yazılan `get()` ve `set()` fonksiyonu vardır. Biz bu fonksiyonlara visibility modifier ekleyebiliriz. 
 Eğer `set()` fonksiyonuna `private` visibility modifier eklersek değiştirilemez bir değişken elde etmiş oluruz.

 ```kt
class Ders1 {
    var isMale: Boolean = true
        private set
}
```
</details>
