package Kekod2024.basic_types

fun main() {
    /**
     * Array'ler  aynı türden veya alt türlerinden oluşan sabit sayıda değer tutan bir veri yapısıdır.
     * Object Type Array & Primitive Type Array
     */

    // Object Type Array
    /**
     * Kotlin'de array oluşturmak için aşağıdaki yardımcı fonksiyonlar kullanılabilir.
     * arrayOf(hepsi aynı tip)
     * arrayOf<Any>(farklı tip değerler) // Buradaki değerler Boxed olark mı yoksa UnBoxed
     * arrayOfNulls<Type>(size) boyut kadar null değer içeren dizi tanımlanabilir
     * emptyArray() boş array tanımlar
     *
     * Aynı zamanda Array() constructor yapısı ile de bir array oluşturabiliriz.
     *
     * Bu fonksiyonlarla oluşturduğumuz array'ler Object-Type Array olarak adlandırılır. Yani Boxed halleridir.
     * Bu kullanım durumunun performansa etkisi vardır. Bunun nedeni object type bir array oluşturduğumuzda
     */
    //index:   0,  1,  2,  3
    val studentNumbers = arrayOf(13, 14, 15, 16) // Int Array
    val studentNames = arrayOf("Ömer", "Arda", "Doğaç") // String Array
    val studentHeight = arrayOf(185.3, 184.3, 180.0) // Double Array
    val differentTypeArray = arrayOf<Any>("Tolga", true, 23, 2.0)
    // Burada ek bilgi olarak <> bu yapıya da bir interface dendiğini bilelim.
    // Buradaki tüm tipler Any classından extend edildiği için farklı tipler verebiliyoruz. Bu durumda array'in tipi
    // Array<Any> olmuş oluyor
    /**
     * Burada şu anda Any tipinde bir class olacağı söylenmiş. İlerleyen konularda kendi sınıflarımız(class) yazıp
     * bu array içierisinde kendi sınıf yapılarımızı da kullanabileceğiz. Şimdilik bu kadarını bilmemiz yeterlidir.
     */

    println("Student Numbers: ${studentNumbers.joinToString()}")
    println("Student Names: ${studentNames.joinToString()}")
    println("Student Height: ${studentHeight.joinToString()}")
    println("Different Type Array: ${differentTypeArray.joinToString()}")

    /**
     * Varsayılan olarak verilen size bilgisi kadar içerisinde null değer bulunduran arrayler oluşturmak için kullanılır.
     *
     */
    val arrayOfNulls = arrayOfNulls<String>(5)
    println("arrayOfNulls: ${arrayOfNulls.joinToString()}")

    /**
     * Bu fonksiyon bize boş bir array oluşturur. Ve bu array şuan da kaç elemana sahip olduğunu bilmiyor.
     */
    val emptyArray = emptyArray<Int>()
    println("emptyArray: ${emptyArray.joinToString()}")

    //emptyArray[5] = 60
    // Biz bu eklemeyi yapmak istediğimizde ArrayIndexOutOfBoundsException hatasını alırız. Çünkü bu array'in kaç
    // değere sahip olacağını belirtmedik. Kotlin'de boş bir diziyi temsil eden bir dizi nesnesi oluşturulur.
    // Ancak, bu dizi aslında boş bir dizi olduğu için, bellekte bir dizi elemanı için yer ayrılmaz.
    // Yani, bu durumda, sadece boş bir dizi referansı oluşturulmuş olur ve herhangi bir eleman içermez.

    /**
     * Constuructor Yapıları ile Array oluşturma
     * Array<Type>(size){ higher order Function }
     * Bu durumda higher order function içerisinde son satıra denk gelen değerler diziyi oluşturur.
     * Şimdilik higher Order fonksiyonların ne olduğuna girmeyeceğim. Bunu da ileride daha detaylı bir şekilde
     * öğreneceğiz.
     *
     * Bu örnekte, Array(5) ifadesi 5 elemanlı bir array oluşturur. Ardından, süslü parantezler içindeki kod bloğu,
     * her bir array elemanını başlangıç değeri olan it (bu durumda indis değerini temsil eder) ile 40'a ekleyerek
     * bir array oluşturur.
     */
    val studentNotes = Array(5) {
        // Bazı işlemler yapılabilir
        it + 40
    }

    println("Student Notes: ${studentNotes.joinToString()}")

    /**
    PRIMITIVE ARRAY TANIMLAMA
     */

    val booleanPrimitiveArray = BooleanArray(3)
    val bytePrimitiveArray = ByteArray(3)
    val charPrimitiveArray = CharArray(3)
    val doublePrimitiveArray = DoubleArray(3)
    val floatPrimitiveArray = FloatArray(3)
    val intPrimitiveArray = IntArray(3)
    val longPrimitiveArray = LongArray(3)
    val shortPrimitiveArray = ShortArray(3)

    /**
     * Direkt bu şekilde de oluşturabiliriz.  Fonksiyon
     * içerisinde herhangi bir değer vermezsek bize boş bir array oluşturur, ama bizim vermek istediğimiz bir değerler ile oluşturulmasını istiyorsak
     * o değerleri de fonksiyon parametresine yapısında belirtebilriz.
     */
    val booleanPrimitiveArray2 = booleanArrayOf(true, false, true, true)
    val bytePrimitiveArray2 = byteArrayOf()
    val charPrimitiveArray2 = charArrayOf('A', 'B', 'C')
    val doublePrimitiveArray2 = doubleArrayOf()
    val floatPrimitiveArray2 = floatArrayOf()
    val intPrimitiveArray2 = intArrayOf(3, 4, 67)
    val longPrimitiveArray2 = longArrayOf()
    val shortPrimitiveArray2 = shortArrayOf()

    println("booleanPrimitiveArray: ${booleanPrimitiveArray.joinToString()}")
    println("bytePrimitiveArray: ${bytePrimitiveArray.joinToString()}")
    println("charPrimitiveArray: ${charPrimitiveArray.joinToString()}")
    println("doublePrimitiveArray: ${doublePrimitiveArray.joinToString()}")
    println("floatPrimitiveArray: ${floatPrimitiveArray.joinToString()}")
    println("intPrimitiveArray: ${intPrimitiveArray.joinToString()}")
    println("longPrimitiveArray: ${longPrimitiveArray.joinToString()}")
    println("shortPrimitiveArray: ${shortPrimitiveArray.joinToString()}")

    // Bu şekide oluşturduğumuz zaman içerisinde verdiğimiz size değeri kadar varsıyaln değerler ile oluşturulur.
    // Eğer constructor yapısındaki higherorder fnksion ile (süslü parantezler içindeki kod bloğu) ile oluşturmak istersek
    // o şkilde de array oluşturabiliriz.

    /**
     * Object Type Array ve Primitive Type Array’ler Arasında Dönüşüm İşlemleri
     *
     */

    // Primitive type olan bir array'i object type olan array'e dönüştürmek için `toTypedArray()` fonksiyonu kullanılır.
    val convertPrimitiveToObjectType = booleanPrimitiveArray.toTypedArray()
    // Array<Boolean> tipinde olacaktır


    /**
     * Object Type olan bir array'i primitive type olan bir array'e dönüştürmek için aşağıda belirtilen fonsiyonları
     * kullanabiliriz.
     *
     * `toBooleanArray()`: Boolean primitive bir array'e dönüştürmek için kullanılır.
     * `toByteArray()`: Byte primitive bir array'e dönüştürmek için kullanılır.
     * `toCharArray()`: Char primitive bir array'e dönüştürmek için kullanılır.
     * `toDoubleArray()`: Double primitive bir array'e dönüştürmek için kullanılır.
     * `toFloatArray()`: Float primitive bir array'e dönüştürmek için kullanılır.
     * `toIntArray()`: Int primitive bir array'e dönüştürmek için kullanılır.
     * `toLongArray()`: Long primitive bir array'e dönüştürmek için kullanılır.
     * `toShortArray()`: Short primitive bir array'e dönüştürmek için kullanılır.
     *
     */

    val convertObjectTypeToPrimitiveType = studentNotes.toIntArray()

//----------------------------------------------------------------------------------------------------------------------
    // Çok Boyutlu Diziler Oluşturma (Multi Dimensional Array)

    val twoDArray = Array(2) { Array(2) { 0 } }
    println("TwoD Array: ${twoDArray.contentDeepToString()}")  // [[0,0], [0,0]]

    val threeDArray = Array(2) { Array(2) { Array(2) { 0 } } }
    println("ThreeD Array: ${threeDArray.contentDeepToString()}")
    // [[[0, 0], [0, 0]], [[0, 0], [0, 0]]]

//----------------------------------------------------------------------------------------------------------------------
    // Array Karşılaştırmaları -‘contentEquals``contentDeepEquals`

    /**
     * Array Karşılaştırma Durumları
     *
     * == operatörünü kullanırız ama reference karşılaştırmalarını yapar
     *
     * contentEquals yada contentDeepEquals kullanmamız lazım
     *
     * contentEquals()
     * contentDeepEquals()
     *
     *  Bu iki yöntem de: Karşılaştırılan iki array arasında hem aynı değerlere sahip olup olmadığını hemde
     *      * aynı sırada bulunup bulunmadığını karşılaştırırç
     */

    /**
     * Arraylerde karşılaştırma işlemi yaparken '==' operatörünü değilde
     *
     * Array'lerde '==' operatörü ile iki array'in aynı referansa sahip olup olmadığı kontrolü yapılır. Eğer biz
     * arraylerin içerisindeki değerlerin aynı olup olmadığı karşılaştırmasını yapmak istersek
     *
     */

    val simpleArray = arrayOf(1, 2, 3)
    val anotherArray = arrayOf(1, 2, 3)

    println("== İle Yapılan Karşılaştırma: ${simpleArray == anotherArray}")
    println("contentEquals() İle Yapılan Karşılaştırma: ${simpleArray.contentEquals(anotherArray)}")
    println("contentDeepEquals() İle Yapılan Karşılaştırma: ${simpleArray.contentDeepEquals(anotherArray)}")

    simpleArray contentEquals anotherArray // Infix olarak Kullanımı

    simpleArray contentDeepEquals anotherArray // Infix Olarak Kullanımı

// ----------------------------------------------------------------------------------------------------------------------

    /**
     * Array'erlerin sabit bir büyüklüğü vardır. Array'lere ekleme ve çıkarma işlemi yaptığımızda String'lerde olduğu gibi
     * bellekte yeni bir array oluşturulur ve bizim değişkenimiz yeni oluşturulan array'in reference adresini tutar.
     * Diğer array ise GarbageCollector ile belli bir zaman sonra yok edilir.
     */
    var cities = arrayOf("Kayseri", "İstanbul", "İzmir")

    println("Cities Before Add Sivas: ${cities.joinToString()}")
    cities += "Sivas" // Adding Sivas
    println("Cities After Add Sivas: ${cities.joinToString()}")
    // Veya bu şekilde yani bir array eklemesi de yapılabilir.
    cities += arrayOf("Nevşehir", "Bursa")
    println("Cities After Add New Cities Array: ${cities.joinToString()}")


    /**
     * val ile tanımlanmış bir arrayin herhangi bir index'deki değerini [] index operatörü ile değiştirebiliriz.
     * val indexdeki değerlerin değişmesine karışmaz.
     * Ancak ilgili diziyi başka bir dizi ile eşitlememize izin verilmez
     */

    val array3 = arrayOf(1, 2, 3, 4)
    println("Before Modify Array3 ${array3.joinToString()}")
    array3[2] = 10 // Array'deki 2. indesde bulunan değeri 10 ile değiştirdim.
    println("After Modify Array3 ${array3.joinToString()}")

    // Bu durumda yeni bir array oluşturma işlemi olmaz, sadece o indisde duran değer değiştirilmiş olur.
// ----------------------------------------------------------------------------------------------------------------------


    // Array'lar invariant'dır. Arrayler üst class'ları yerine atanamazlar.

   // val arrayOfString = arrayOf("")
   // var arrayOfAny: Array<Any> = arrayOfString
// ----------------------------------------------------------------------------------------------------------------------


    /**
     * vararg kelimesi ile fonksiyonlarımızda istediğimiz sayıda parametre kabul edebiliriz.
     * Eğer vararga denk gelecek şeklide bir array kullanmak istiyorsak `spread` * operatüörünü kullanabiliriz.
     * Spread operatorü verdiğiniz arrayin elemanlarıını her birini bir variable olcak şekilde
     */

    fun printAllStrings(vararg strings: String) {
        for (string in strings) {
            print(string)
        }
    }

    val lettersArray = arrayOf("c", "d")
    // printAllStrings("a", "b", *lettersArray)
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Array Fonksiyonları
     *
     * Arraylerde Collections yapılarında kullandığımız birçok yardımcı fonksiyonu da kullanabiliyoruz.
     *
     * Bunlardan bazıları filter, first, last, find, shuffle ve çok daha fazlası.
     *
     * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/
     */

    val students = arrayOf("Tolga", "Gökhan", "Ömer", "Arda", "Barış", "Ayşe")

    val studentWithStartingA = students.filter { it.first() == 'A' }

    println("Student Starting name with A:  $studentWithStartingA")

    val numbers = arrayOf(1, 2, 3, 4, 5)

    numbers.shuffle()

    println("Shuffled Numbers: ${numbers.joinToString()}")

//----------------------------------------------------------------------------------------------------------------------


    // Arrayleri list ve set dönüşrütme


    /**
     * Kullandığımız array yapılarını set, map, list gibi collections yapılarına dönüştürebiliriz.
     *
     *
     */

    val simpleArray2 = arrayOf("a", "b", "c", "c")

    println("Converted to set: ${simpleArray2.toSet()}") // a,b,c
    /**
     * Set yapısı içerisinde değer olarak, benzersiz elemanları içeren bir yapıdır. O yüzden array'i set'e çevirdiğimizde
     * ve print ettiğimzde sadece a,b,c göreceğiz ikinci c'i göremeyiz.
     */

    println("Converted to list: ${simpleArray2.toList()}") // a,b,c,c


    /**
     *  Arrayleri Map'e  dönüştürmek içim .toMap() fonksiyonunu kullanabilirz.
     *  Ama array değerleri Pair<K,V> formunda olması gerekiyor.
     *
     *  Pair çiftleri dediğimiz bir değeri key-value formatında saklamak için kullanılır.
     *
     *  Pair oluşturmak için Pair("Tolga", 23) veya 'to' infix notasyonu kullanarak oluşturabiliriz
     *  "Tolga" to 23
     */


    /**
     * Pair sadece iki eleman içerir. Birinci eleman ve ikinci eleman olarak adlandırılan iki değerden oluşur.
     * Map ise içerisinde birden fazla Pair çiftlerini içerir
     * Kısacası, Pair iki elemanlı bir çifti temsil ederken, Map birçok anahtar-değer çiftini içeren bir koleksiyonu temsil eder.
     * Pair küçük çiftlerle çalışmak için kullanışlıdır, ancak daha karmaşık ilişkileri temsil etmek ve verileri daha düzenli bir şekilde organize etmek istiyorsanız, Map daha uygundur.
     */

    Pair("Tolga", 23)
    val pairArray = arrayOf("Tolga" to 23, "Ahmet" to 25, "Sena" to 20)

    println("Converted to Map: ${pairArray.toMap()}")

}