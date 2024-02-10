package Kekod2024

// Bu fonksiyonda bir başlangıç noktasıdır.
// Bu args başlangıç parametresi vermek için kullanılır.
/*fun main(args: Array<String>) {
}*/

fun main() {
    // Bu özel bir fonksiyon, bir uygulamanın başlangıç noktası main fonksiyonudur. Console uygulamaları için.
    println("Hello World!")

    val name: String = "Tolga"
    val age = 23 // Type Inference
}

class Ders1 {
    var isMale: Boolean = true
        private set
}

/*Intellij Idea Kısayollar
* Kod yazarken kısayolları kullanmak, yapacağımız işi daha hızlı bir şekilde yapabilmemizi sağlar.
*  Bu kısa yolları öğrenmek çalışırken daha verimli bir şekilde çalışmamıza olanak sağlar.
*
* Whatsapp grubunda kısayollar ile ilgili birkaç kaynak paylaşıldı. Onları da buraya ekleyeyim.
*  - https://youtu.be/XOniJYHaiEY?si=jCoyOZ1-QuOAEdzm - (Ümit Köse) Kendisi youtube'da bunu için bir video hazırlamış.
*  - https://plugins.jetbrains.com/plugin/9792-key-promoter-x - Bu da IDE üzerinde plugini kurarak,
* anlık yaptığımız işlemlerin kısa yollarını bize gösteriyor. Bu şekilde bu kısayolları da öğrenebiliriz.
*
*  - Eğer direkt bu yaygın olarak kullanılan kısayolları PDF olarak görmek istiyorsak;
*  IDE üzerinden Help/Keyboard Shortcuts PDF seçeneğine tıklayarak PDF'e ulaşabilirsiniz.
* */

/* Debugging
* Debugging işlemi, yazılımın doğru çalışmasını engelleyen hataları tespit etmek,
* bu hataların nedenlerini anlamak ve ardından bu hataları düzeltmek amacıyla gerçekleştirilir.
*
* Debugging temellerini öğrenebileceğiniz https://www.youtube.com/watch?v=ln5hc-zprEM (İngilizce) videosuna bakabilirsiniz.
*
* */

/*
 statement ve expression
* - Expression:
*
* - Statement:
* */

/*
* - Type Inference: -- Ne zaman önemli? - İş Görüşmesi Sorusudur.
*  Değişkenin değerini direkt olarak ilk değer atamasını yapmıyorsak daha sonra tanımlayacakasak,
* bunun tipinin ne olacağını IDE'ye söylememiz gerekiyor.
*
* Bir değişkene değer atadığımızda o verinin hangi türde olacağını tam olarak belirtmediysek IDE'nin o verinin
* hangi türde olacağını bilmesidir.
*
* */

/*
* val(value) vs var(variable) - İş Görüşmesi Sorusudur.
*  val - var ile oluşturulan bir değişkenin en temel farkı,
* - val ile tanımladığımız bir değişken daha sonra değiştirilemez olurken yani bir kere atandığında sabit kalır,
* - var ile tanımladığımız bir değişkeni daha sonra değiştirebiliriz.
*
*  - val - var hangisi daha hızlıdır?
* Yani bir val değişken oluşturmak mı bize daha maliyetli yoksa
* var bir değişken oluşturmak mı daha maliyetli
*
*  Aralarındaki performans farkı yok denecek kadar azdır. Genel anlamda val yada var ile tanımlamamız bir şey ifade
* etmeyecektir.
*
* Olan ufacık bir performans farkı nedir? Merak edenler için?
* val değişkenler, var değişkenlere göre daha maliyetlidir.
* Yani var değişkenler daha performanslıdır.
*
*  Bunun nedeni val ile bir değişken tanımlarken bir şart belirtiyoruz (Bunu daha sonra değiştirilemez.)
* Ama var kullanımında ekstra bir şartımız yok.
*
* Eğer ekstra bir şartımız varsa arka planda bunun için bir kod yazılmış olması lazımdır.
* - (Teorik olarak aslında akılda kalıcı olması için böyle bir açıklama yapıldı derste.
* Yoksa tam olarak böyle bir durum yok.)
*
* Özet olarak;
*  Akademik olarak düşündüğümüzde var değişkenler daha performanslıdır ama bu göz ardı edilebilecek bir performans
*  farkı yaratır.
*
* Günlük hayat problemlerinde ise val kullanmak daha avantajlıdır. Bunun sebebi sektörde olan uygulamarda
* çok fazla multi-thread işlemler yaptığımız için.
*
* "multi-threading" veya çoklu iş parçacığı kullanımı,
*  bir bilgisayar programının aynı anda birden fazla işlemi eşzamanlı olarak gerçekleştirmesine
*  olanak tanıyan bir programlama kavramıdır.
* */

/* var ile tanımlanmış bir değişkeni, var keyword'unu kullanarak val değişken nasıl
yapabilirsin? - İş Görüşmesi Sorusudur.

 Örneğin bir `var isMale = true` değişkenimiz var. Her bir değişkenimizin arka planda
 yazılan get() ve set fonksiyonu vardır. Ve bu fonksiyonların get() ve set() fonksiyonlarına
 bir visibility modifier ekleyebiliriz. Eğer set() fonksiyonuna private visibility modifier
 eklersek değiştirilemez bir değişken elde etmiş oluruz.

  var isMale: Boolean = true
        private set
* */