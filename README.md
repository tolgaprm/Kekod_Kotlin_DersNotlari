> > > # Kekod Ders Notları

- Bu repoda Gökhan Öztürk tarafından Youtube'da Kotlin ve Android dersleri sırasında aldığım notlar
  bulunmaktadır. [Youtube Linki](https://www.youtube.com/@KeKod)

- Bu notlara eklemek istediğiniz herhangi ek bir bilgi olur veya yanlış olduğunu düşündüğünüz kısımlar var ise bunları
  pull-request
  işlemi yaparak yeni notlar veya düzeltmeler yapabilirsiniz.

- Eğer pull request nasıl atılır öğrenmek istiyorsanız. Yasin Maden arkadaşımızın hazırlamış
  olduğu [Medium yazısına](https://medium.com/@madenyasin/githubda-pull-request-nas%C4%B1l-olu%C5%9Fturulur-2de051dd9419)
  bakabilirsiniz.

### [Challengelarda Dikkat Edilmesi Gerekenler - Tavsiyeler](otherReadme/Challenge_Dikkat_Edilmesi_Gerekenler.md)

> Bu kısımda ders sırasında Gökhan Öztürk tarafından challenglarda dikkat etmemiz gerektiğini söylediği
> tavsiyeleri bulunmaktadır.

## Ders 1

> [Ders 1 Notlarına buradan ulaşabilirsiniz.](otherReadme/Ders1Notları.md)

### İçindekiler

1. Intellij Idea Kısayolların Kullanımı
2. Debugging Öğrenmek için Kaynaklar
3. Type Inference (Tip Çıkarımı) Nedir ?
4. `val` ve `var` İle Oluşturulan Bir Değişkenin En Temel Farkı? 
   - Bir `val` değişken oluşturmak mı bize daha maliyetli yoksa `var` bir değişken oluşturmak mı daha maliyetli?
5. `var` ile tanımlanmış bir değişkeni, `var` keyword'unu kullanarak `val` değişken nasıl yapılabilir?

## Ders 2

> [Ders 2 Notlarına buradan ulaşabilirsiniz.](otherReadme/Ders2Notları.md)

### İçindekiler

1. Kotlin'de Primitive Tipler
   - Primitive Tip Nedir? 
   - Primitive vs Reference
   - Kotlin'de her şey birer obje ise, Primitive değişken oluşturamıyor muyuz?
     - IDE üzerinde `Show Kotlin Byte Code` kullanımı.


2. `val` değişkenler immutable değildir. Sadece read-only'dir. Bunun açıklaması.
    - `const val` ve `val` arasındaki fark nedir? Neden `const val` immutable bir değişken olabiliyorken
   `val` immutable bir değişken olamıyor?
   

3. Kotlinde Nullable(?) İfadeler
   - Nullable ifadelerin tanımı ve kullanımı
   - Nothing Değişkenler
   - `!!` ve `?.` Operatörlerinin Kullanımı
   - Peki ne zaman `!!` veya `?.` kullanmalıyım? Bunun Best Practice Nedir?
   - Primitive Tipleri Nullable Yaptığımızda Ne Olur?


4. Numbers Değişkenler
   - Değişkenlerin değer aralıkları 
   - Unsigned Değişkenler Nedir?
   - Boxed - UnBoxed ve Eşitlikler(`==` ve `===`)
        - `==` ve `===` Operatörleri Arasındaki Fark Nedir?
   - Reference Değer Karşılaştırmasında `Byte` Aralığının Oluşturduğu Spesifik Durum 


5. Type Conversion