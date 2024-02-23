> > > # Kekod Ders Notları

- Bu repoda Gökhan Öztürk tarafından Youtube'da Kotlin ve Android dersleri sırasında aldığım notlar
  bulunmaktadır. [Youtube Linki](https://www.youtube.com/@KeKod)

- Bu notlara eklemek istediğiniz herhangi ek bir bilgi olur veya yanlış olduğunu düşündüğünüz kısımlar var ise bunları
  pull-request
  işlemi yaparak yeni notlar veya düzeltmeler yapabilirsiniz.

- Eğer pull request nasıl atılır öğrenmek istiyorsanız. Yasin Maden arkadaşımızın hazırlamış
  olduğu [Medium yazısına](https://medium.com/@madenyasin/githubda-pull-request-nas%C4%B1l-olu%C5%9Fturulur-2de051dd9419)
  bakabilirsiniz.

### [Challengelarda Dikkat Edilmesi Gerekenler - Tavsiyeler](otherReadme/challenge/Challenge_Dikkat_Edilmesi_Gerekenler.md)

> Bu kısımda ders sırasında Gökhan Öztürk tarafından challenglarda dikkat etmemiz gerektiğini söylediği
> tavsiyeleri bulunmaktadır.

---

## 1. Hafta Notları

> [1.Haftanın Notlarına buradan ulaşabilirsiniz.](otherReadme/week1/1_Hafta_Notları.md)

### İçindekiler

1. Intellij Idea Kısayolların Kullanımı
2. Debugging Öğrenmek için Kaynaklar
3. Type Inference (Tip Çıkarımı) Nedir ?
4. `val` ve `var` İle Oluşturulan Bir Değişkenin En Temel Farkı?
    - Bir `val` değişken oluşturmak mı bize daha maliyetli yoksa `var` bir değişken oluşturmak mı daha maliyetli?
5. `var` ile tanımlanmış bir değişkeni, `var` keyword'unu kullanarak `val` değişken nasıl yapılabilir?

---

## 2. Hafta Notları

> [2.Haftanın Notlarına buradan ulaşabilirsiniz.](otherReadme/week2/2_Hafta_Notları.md)

### İçindekiler

### 1. Kotlin'de Primitive Tipler
- Primitive Tip Nedir? 
- Primitive vs Reference
- Kotlin'de her şey birer obje ise, Primitive değişken oluşturamıyor muyuz?
    - IDE üzerinde `Show Kotlin Byte Code` kullanımı.


### 2. `val` değişkenler immutable değildir. Sadece read-only'dir. Bunun açıklaması.
- `const val` ve `val` arasındaki fark nedir? Neden `const val` immutable bir değişken olabiliyorken
`val` immutable bir değişken olamıyor?


### 3. Kotlinde Nullable(?) İfadeler
- Nullable ifadelerin tanımı ve kullanımı
- Nothing Değişkenler
- `!!` ve `?.` Operatörlerinin Kullanımı
- Peki ne zaman `!!` veya `?.` kullanmalıyım? Bunun Best Practice Nedir?
- Primitive Tipleri Nullable Yaptığımızda Ne Olur?


### 4. Numbers Değişkenler
- Değişkenlerin değer aralıkları
- Unsigned Değişkenler Nedir?
- Boxed - UnBoxed ve Eşitlikler(`==` ve `===`)
  - `==` ve `===` Operatörleri Arasındaki Fark Nedir?
- Reference Değer Karşılaştırmasında `Byte` Aralığının Oluşturduğu Spesifik Durum


### 5. Type Conversion

---

## 3. Hafta Notları

> [3.Haftanın Notlarına buradan ulaşabilirsiniz.](otherReadme/week3/3_Hafta_Notları.md)

### İçindekiler

### 1. Değişkenler Bellekte Nasıl Saklanır? Stack ve Heap Kavramları


### 2. Smart Cast Nedir?
- `is` ve `!is` Operatörleri


### 3. İki `Int.MAX` Değerin Toplanması Durumu
- Defansif Programlama Kavramı


### 4. Characters (`Char`)
- Char Bir Değişken Tanımlama
- ASCII Tablosu
- Escape(Kaçış) Karakterleri
- Unicode
- Unicode ve ASCII Arasındaki Fark Nedir?


### 5. Boolean
- Boolean Bir Değişken Tanımlama
- Karşılaştırma Operatörleri(`&&, ||, !`)
  - Bu operatörlerin Lazily Çalışma Mekanizmasına Sahip Olması


### 6. String
- String Bir Değişken Tanımlama ve String'de Index Yapısı
- Stringler Immutable'dır
- Stringler'de `+` Operatörü - Birleştirme İşlemleri
- String Template Kullanımı - `Length:${name.length}`
- String `format()` Fonksiyonu


### 7. Array
- Array Tanımlama
   - Object Type & Primitive Type Array
   - Object Type Array ve Primitive Type Array’ler Arasında Dönüşüm İşlemleri
   - Çok Boyutlu Diziler Oluşturma (Multi Dimensional Array)
  

- Array Karşılaştırmaları - `contentEquals` & `contenDeepEquals`

- Array'lerde Ekleme, Çıkarma İşlemleri Yapmak
   - Array'ler Invariant
   - `vararg` ve `Spread(*)` Operatörü ile İlişkisi
   - Array'lerde Bulunan Bazı Yardımcı Fonksiyonlar
   - Array'leri Collections Yapılarına Dönüştürme İşlemleri - `Set`, `List`, `Map`
   - Ne Zaman Array’leri Kullanmalıyız? Ne Zaman Collections Yapılarını Kullanmalıyız?
     

### 8. Range - Progression
- Küçükten Büyüğe Range Tanımlama
   - `step` İle Kullanımı
- Büyükten Küçüğe Range Tanımlama
   - `step` İle Kullanımı


