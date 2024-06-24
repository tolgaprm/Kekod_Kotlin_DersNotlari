### 1- Object Oriented Programming (Nesne Yönelimli Programlama) Mantığı Nedir?

Nesne Yönelimli Programlamada amaç etrafımızda var olan tüm objeleri, nesneleri sahip olduğu karakteristik özellikler ve
davranışsal olarak yazılım dünyasında ele almaya çalıştığımız bir paradigma.

- ### OOP Mantığının Temel İlkeleri
    - ### Sınıflar ve Nesneler (Classes and Objects):
        - Sınıf (Class): Nesnelerin şablonudur. Nesnelerin ortak özelliklerini ve metotlarını tanımlar.
        - Nesne (Object): Sınıflardan türetilen somut örneklerdir.

    - ### Kapsülleme (Encapsulation):
      Verilerin doğrudan erişimini sınırlayarak nesnelerin durumunu korur ve sadece belirlenen metotlar aracılığıyla
      erişime izin verir.
      Kotlin'de aslında default olarak zaten bu encapsulation işlemi yapılıyor. Biz sınıflarımız içerisindeki
      değişkenlerimize
      yazmış olduğumuz visibility modifierlar ile aslında o değişkenlerin(propertylerin) _getter_ ve _setter_
      fonksiyonlarının
      yazılıp yazılmayacağını ayarlıyoruz. Çünkü Kotlin'de **backging field** her zaman `private` durumundadır.
        ```kt
        class Encapsulation {
            var name: String = "Tolga"
            val age:Int = 23
            val surname: String = "Pirim"
        }
      ```
      Bu şekilde yazılmış olan bir sınıfımızın Show Kotlin ByteCode özelliğini kullanarak üretilen Java kodunu
      inceleyelim.
        ```java
      public final class Encapsulation {
          @NotNull
          private String name = "Tolga";
          @NotNull
          private final String surname = "Pirim";
          @NotNull
          private final int age = 23;

          @NotNull
          public final String getName() {
            return this.name;
          }

          public final void setName(@NotNull String var1) {
            Intrinsics.checkNotNullParameter(var1, "<set-?>");
            this.name = var1;
          }

         @NotNull
         public final String getSurname() {
           return this.surname;
         }
        }
       ```
      Bu kodu incelediğimizde öncelikle sınıfın en üst tarafında backing field olarak adlandırdığımız değişkenlerin
      private
      olarak yazıldığını görüyoruz yani ben Kotlin'de bir değişkene private gibi herhangi bir visibility modifier
      eklediğimde aslında o
      değişkenin _getter_ ve _setter_ fonksiyonlarının yazılıp yazılmayacağını belirtmiş oluyoruz. Kodu incelemeye devam
      ettiğimizde
      Kotlin'de `var` olarak tanımlanmış `name` değişkeninin hem set hemde get fonksiyonlarının, `val` olarak
      tanımlanmış bir değişkenin
      ise sadece `get` fonksiyonunun yazıldığını, `private` olarak işaretlenmiş bir değişkenin ise hiçbir şekilde ne get
      ne de set fonksiyonlarının
      yazılmadığını görüyoruz.

    - ### Kalıtım (Inheritance):
      Bir sınıfın başka bir sınıftan özellik ve metotları miras almasıdır. Üst sınıf (parent/base class) ve alt sınıf (
      child/derived class) ilişkisi kurulur.

    - ### Çok Biçimlilik (Polymorphism):
      Aynı isime sahip fonksiyonların farklı parametre ve dönüş değerleri vererek farklı şekilllerde davranabilmesini
      sağlar.

    - ### Soyutlama (Abstraction):
      Soyutlama, gereksiz detayların gizlenmesi ve nesnelerin yalnızca gerekli özelliklerinin ve metotlarının sunulması.

- ### Visibility Modifiers
  Visibility modifierlar Kotlin'de fonksiyonların, sınıfların veya değişkenlerin hangi seviyede dışarıdan ulaşılabilir
  olup
  olmayacağını belirlemek için kullanılır. 4 adet modifier vardır. Bunlar;
    - **public:** Kotlin'de bütün fonksiyonlar, sınıflar ve değişkenkler varsayılan olan `public` durumundadır.
    - **private:** Üye değişkenlerin class dışarısından erişilmesini engeller, sadece sınıf içerisinden erişilebilir
      durumda olur.
    - **protected:** Üye değişkenler sadece kalıtım(inheritance) edilen child sınıflar içerisinden erişilebilir durumda
      olur aksi durumlarda
      o üye değişkenlere erişemeyiz.
    - **internal:** Sadece kullanılan modül içerisinden erişilebilir başka bir modül içerisinden erişim sağlayamayız.

- ### Accessibility Modifier
    - **final:** `final` belirleyicisi, bir sınıfın veya üyenin başka bir sınıf tarafından kalıtım(miras) alınmasını
      engeller. Aynı zamanda
      yazılan fonksiyonların ve değişkenlerin alt sınfılardan override edilmesini engeller. Kotlin'de varsayılan olarak
      bütün yapılar
      `final` olarak belirtilmiştir.

    - **open:** `open` belirleyicisi, bir sınıfın başka bir sınıf tarafından kalıtım(miras) alınabilmesini sağlar. Aynı
      zamanda yazılan fonksiyonların
      ve değişkenlerin de alt sınıflardan override edilebilmesini sağlar.

- ### Primary ve Secondary Constructor
  Constructor yapısı, bir sınıfın nesnesi oluşturulurken gerekli başlatma işlemlerini yapmak için kullanılır. Örneğin,
  bir sınıfın özelliklerine başlangıç değerleri atamak için constructor kullanılır.

    ```kt
        class Car constructor(wheelCount: Int, color: String) {
        }
    ```
  Bu primary constructor öncesinde herhangi bir annotation veya visibility modifier yok ise
  `constructor` anahtar kelimesini belirtmemize gerek yok. Yine bu parametreler içerisinde default değerler de
  kullanabiliyoruz.

    ```kt
        class Car(wheelCount: Int, color: String = "red") {
        }
    ```

  Constructorlar nesne oluşturulurken belirli iş mantığını uygulamak için kullanılabilir.
  `Primary constructor`da verilen değerler için nesne oluşturmada bir iş mantığını yazmak istiyorsak
  `init` bloklarını kullanabiliriz.

    ```kt
    class Person(val name: String, var age: Int) {
       init {
           if (age < 0) {
               throw IllegalArgumentException("Age cannot be negative")
           }
       }
    }
   ```
  Constructor'lar aynı sınıf için farklı şekilde nesne oluşturma senaryolarını da
  destekleyerek esneklik sağlar. Bir sınıfta birden fazla constructor tanımlayarak, nesnelerin farklı parametrelerle
  başlatılmasına olanak tanır.
  Bu şekilde yazılan constructorlara `secondary constructor` olarak
  adlandırılıyor. `secondary constructorlar` `primary constructorları`
  işaret etmelidir.

```kt
class Person(val firstName: String, val lastName: String, val age: Int) {
    init {
        println("primary constructor")
    }

    constructor(firstName: String, lastName: String, age: Int, isMarried: Boolean) : this(
        firstName = firstName,
        lastName = lastName,
        age = age
    ) {
        println("secondary constructor")
    }
}
```

Şimdi bu `Person` sınıfında nesne oluşturmaya bakalım. 2 adet nesne oluşturalım ve bunların birisini
`primary constructor` diğerini de `secondary constructor` yardımı ile yapalım.

```kt
    val person1 = Person("Tolga", "Pirim", 23) // primary constructor
val person2 = Person("Tolga", "Pirim", 23, false) // secondary constructor
```

Şimdi de çıktılara bir göz atalım. İlk olarak `primary constructor` ile oluşturduğumuzda oluşan çıktıya bir bakalım.

```
  primary constructor
```

Ardından da `secondary constructor` ile oluşturulan çıktıya bakalım.

```
  primary constructor
  secondary constructor
```

Çıktıları incelediğimizde `secondary constructor` ile bir çağrım yaptığımızda bile ilk olarak `init` bloğu çağrılır daha
sonra
`secondary constructor` içerisinde ki kod bloğunun çalıştığını fark etmiş olmalıyız.

- ### Abstract(Soyut) Kavramı Nedir?

Abstract sınıflar temelde bir şablon görevi görürler. Bir nesnenin tanımlamasını yaparken o nesnede olması gereken ortak
davranışları ve özellikleri tanımlamak için kullanılır.

Yani bir nesnenin yapısal olarak tüm özelliklerini içeren ve yapabildiği tüm fonksiyon setlerini içeren bir class
yapısıdır.
Örneğin telefonlarla ilgili bir uygulama yapıyorum ve bir telefonda olması gerekn tüm özellikleri ve fonksiyonaliteyi
içeren bir
sınıf oluşturmam gerekiyor. Burada hangi özellikleri ekleyebilirim bu sınıf içerisine?

- Marka, model ve ne zaman üretildiği bilgisini
- Sahip olduğu ekran boyutu, pilinin ve depolamasının kapasitesi
- Hangi işletim sistemini kullandığı gibi bir telefonun olmazsa olmaz özelliklerini belirtiriz.

Abstract sınıflarda çok detaylı bilgilere yer vermemeliyiz. Tüm child sınıflarda kullanılmayacak bilgileri
koymamaız gerekiyor. Örneğin bir yapının telefon olabilmesi için şu şu özelliklere ve şu fonksiyon setlerine sahip
olmalıdır dersin
ama bunun detaylarını vermezsin. Bunun detaylarını child sınıflar içerisinde doldurulur. Tabi burada bir fonksiyonumuz
var ve tüm child sınıflar
içerisinde aynı işlemi yapıyor ise onun için gerekli işlemler yazılabilir.

- ### Abstract Class

Hemen bir örnek ile devam edelim isterseniz. Örneğin elimizde daire ve dörtgen olacak şekilde
iki adet geometrik şeklimiz var ve her şeklin alanını hesaplamak istiyorum. Burada her geometrik şekil içerisinde
bu alan hesaplama fonksiyonunu ayrı ayrı tanımlamak yerine bir abstract sınıf içerisinde tanımlayalım ve bu şekilleri
ana sınıftan
miras alalım.

```kt
abstract class Shape {

    abstract fun calculateArea(): Double
}

class Circle(private val radius: Double) : Shape() {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle(private val width: Double, private val height: Double) : Shape() {
    override fun calculateArea(): Double {
        return width * height
    }
}

```

#### Peki biz şimdi bu yapıyla ne kazandık?

- Bütün şekil sınıflarını bir üst sınıftan miras alarak bir hiyerarşi oluşturduk. Bu bize kodun hem okunmasını
  kolaylaştırdı
  hemde kodun sürdürülebilirliğini artırdı.
- Tüm şekil sınıfları içerisinde olması gereken fonksiyonları kolay bir şeklide override etmiş olduk böylece bu şekil
  içerisinde
  gerekli olan tüm yapıları unutmadan yazmamızı sağladı. Burada örneğin Shape sınıfı içerisinde 1 tane değil de 20 adet
  fonksiyon olsaydı
  her birini unutmadan alt sınıflarda belirtmem gerekirdi. Ama bunu abstract bir sınıf ile yaptığımda yazmam gereken bir
  fonksiyonu
  yazmadığımda bana hata verecektir ve gerekli fonksiyonu yazmamı bekleyecektir.

### Şimdi gelelim abstract sınıfların özelliklerine;

- Abstract sınıflar içerisindeki abstract fonksiyonlar ve propertyler child sınıflar içerisinde override edilme
  zorunluluğu vardır.

- Yine abstract sınıflar içerisinde body'e sahip olan fonksiyonlar veya varsayılan değere sahip değişkenler
  tanımlanabilir.
  Eğer bu tanımlanan bodyli fonksiyonları veya değişkenleri de alt sınıflar içerisinden override edilebilir olmasını
  istiyorsak
  `open` keywordü ile tanımlama yapmalıyız. Bunun sebebi ise Kotlin'de tüm yapılar varsayılan olarak `final` olmasıdır.
  Bir yapının
  `final` olması alt sınıflar tarafından miras alınmasını engeller.

```kt
abstract class Human(val name: String) {

    val eyeColor: String = "blue"
    open val age = 23
    abstract val surname: String
    abstract val middleName: String

    abstract fun display()
}
```

Bu sınıfı bir alt sınıfdan miras aldığımızda `name`, `surname`, `middleName` ve `display` yapılarını alt sınıf
içerisinde
override etmek zorundayız. `age` değişkeninde `open` anahtar kelimesini kullandığımız içinde istersek override
edebiliriz.
Ama `eyeColor` değişkeni varsayılan olarak `final` olduğu için istesek de override edemeyiz.

- Abstract sınıflar içerisinde state tutabiliriz.

```kt 
abstract class Shape {
    val edge: Int = 0
    abstract val area: Double
}
```

Yazmış olduğumuz bu `Shape` sınıfının Java koduna `Show Kotlin ByteCode` yardımı ile bir bakalım.

![](/screenshots/week6/state_tutma.png)

Oluşturulan Java kodunu incelediğimizde varsayılan olarak değeri atanmış olan `edge` değişkeninin `backing field`'ının
oluşturulduğunu
görüyoruz bu da bize abstract sınıflar içerisinde state tutabildiğimizi kanıtlamış oluyor. Ama dikkatimizi çekmesi
gereken bir nokta var. O nokta ise
`abstract` olarak belirtmiş olduğum `area` değişkeninin `backing field`'ı oluşturulmamış. Neden?

Çünkü `area` değişkeni `abstract` bir yapı olduğu için ve alt sınıf içerisinde override edilmesi zorunlu olduğundan, alt
sınıfta
tanımlaması yapıldığında bu değişkenin alt sınıfta `backing field`'ı oluşturulacaktır.

- Abstract sınıflardan nesne oluşturulamaz.
- Eğer abstract bir class, yine abstract olan başka bir sınıf tarafından inheritance(miras) alınıyorsa, bu durumda
  üst sınıftan gelen override edilmesi zorunlu olan abstract fonksiyonların ve propertylerin de override edilme
  zorunluluğu
  kalkar.

>![](/screenshots/week6/abstract_to_class.png)
>
>Bu şekilde `Rectangle` sınıfına abstract anahtar kelimesini koymadığımızda hata veriyor ama abstract olarak belirttiğimizde
>herhangi bir hata almıyoruz.
>
>![](/screenshots/week6/abstract_to_abstract.png)



