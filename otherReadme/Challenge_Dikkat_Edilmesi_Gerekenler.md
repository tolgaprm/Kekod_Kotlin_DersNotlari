# Challengelarda Dikkat Edilmesi Gerekenler - Tavsiyeler

## 1 - Projede Atomic Commit kullanmak

> Atomic commit her bir commitin single responsibility kavramına uymasını sağlamak için söylenen bir terimdir.
> Örneğin bir proje var ve birçok değişiklik yapıyoruz. Her değişiklik tek bir ifade bildirmeli.
> Yani bir özellik eklediniz bunun commiti atılmalı, bu özellikte bir bug oldu ve çözdüysek bunun ayrı bir commiti
> atılmalı. Özelliği ekledikten sonra üstüne bir de bug fix yapınca ikisi tek bir commit yapılmamalı.
> -- Bu açıklamayı *Ömer Sungur* arkadaşımız yapmış.

> Projemizde atomic commitler yaparak uygulamayı tamamladıktan sonra, eğer bu projeyi bir Github vb. bir repoya
> kaydetmemiz isteniyor ise repoya güzel bir README sayfası hazırlayalım ve projede atomic commit kullandığımızı
> belirtelim.

## 2 - Kullanılan Veri Tiplerine Dikkat Edelim

#### Yani tam olarak ne demek? Kullandığımız veri tiplerine dikkat etmek.

> Dikkat etmemiz gereken alan Number kullanımı yaptığımız yerlerde. Kotlin'de Number'ları ifade ettiğimiz birden fazla
> veri tipi var. Bu her bir veri tipinin alabileceği minimum ve maximum değerleri vardır ve bu değerlere göre memory'de
> tuttuğu alan fazla veya daha az olabilir. Örneğin yaş kullandığımız bir yerde UByte tipini kullanabiliriz. UByte
> değerine
> baktığımızda minimum 0 maximum 255 değerini aldığını görüyoruz. Bir insanın yaşı 255'i geçemeyeceğini düşündüğümüzde
> gayet
> mantıklı bir karar vermiş olacağız.

Genelde sektöre girdiğimizde bu değişkenlerin çok fazla kullanılmadığını göreceğiz ama bu challenglarda, challenge
inceleyen
kişiye pozitif bir etki bırakacaktır. Burada bırakacağı etki bu kişi bu değişkenlerin Memory'de daha az yer kaplacağını
karşı tarafa bildiğini gösterecek ve bu gibi ince detayları araştıran bir kişiliğiniz olduğunu öngörecektir.

#### Veri Tipleri ve Max - Min Değerleri

| Type	    | Size (bits) | Min value                                    | Max value                                      |
|----------|-------------|----------------------------------------------|------------------------------------------------|
| `Byte`	  | 8           | -128                                         | 127                                            |
| `Short`	 | 16          | -32768                                       | 32767                                          |
| `Int`	   | 32          | -2,147,483,648 (-2<sup>31</sup>)             | 2,147,483,647 (2<sup>31</sup> - 1)             |
| `Long`	  | 64          | -9,223,372,036,854,775,808 (-2<sup>63</sup>) | 9,223,372,036,854,775,807 (2<sup>63</sup> - 1) |

| Type     | Size (bits) | Min value | Max value                                       |
|----------|-------------|-----------|-------------------------------------------------|
| `UByte`  | 8           | 0         | 255                                             |
| `UShort` | 16          | 0         | 65,535                                          |
| `UInt`   | 32          | 0         | 4,294,967,295 (2<sup>32</sup> - 1)              |
| `ULong`  | 64          | 0         | 18,446,744,073,709,551,615 (2<sup>64</sup> - 1) |

| Type	    | Size (bits) | Significant bits | Exponent bits | Decimal digits |
|----------|-------------|------------------|---------------|----------------|
| `Float`	 | 32          | 24               | 8             | 6-7            |
| `Double` | 64          | 53               | 11            | 15-16          |    

##  3 - Deprecated Olan İşlemleri Kullanmayalım

- Challenglarda kodlarımızda kesinlikle `deprecated` işlemleri kullanmamaya dikkat edelim. `Deprecated` demek,
  bu kod şuan için çalışır ama ileriki versiyonlarda kullanımı tamamen kalkacaktır. Bunun yerine sana önerdiğim başka
  bir
  yöntemi kullanmaya devam etmelisin.

  ![](screenshots/deprecated.png)

  Bir işlemin `deprecated` olduğunu kullandığımız işlemin üzeri çizili bir şekilde gösterilir. Ve bunun üstüne gelip 
  yazan açıklamaya baktığımızda bunun yerine hangi fonksiyonu kullanmamız gerektiği de belirtilir.



