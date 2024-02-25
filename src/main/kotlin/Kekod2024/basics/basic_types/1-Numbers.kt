package Kekod2024.basics.basic_types

fun main() {

    // Para işlemlerinde bankacılık işlemlerinde BigDecimal veri tipi kullanılır.


    /*
     */

    /*
    * Tip Çıkarımı (Type Inference)
    * Eşitliğin karşı tarafındaki değere bakarak, değişkenin tipinin ne olacağını IDE'nin karar vermesi.
    * Type Inference sırasında eğer sayi Int ifadeden büyük değilse tipi Int set edilir.
    * Ama Int değer aralığında daha büyükse tipi Long olarak set edilir.
    *
    *
    * Long - değişkenler için sayının sonuna "L" konularak değer ataması yapılabilir.
    * Float - değişkenler için sayının sonuna "F","f" konularak değer ataması yapılabilir.
    *
    * Float kısmında "f" ve "F" varken, Long kısmında neden sadece "L" var ve küçük "l" kullanamıyoruzç
    * Bunun cevabı bazı fontlarda "l" '1' e benzediği için kullanılmaz.
    *
    * */


    // Number değişken tanımı yapılırken underscore "_" kullanılabilir.
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456

    /* Boxed - Unboxed
    * Boxed : Değişkenin obje referansı olarak tutulmasıdır.
    * UnBoxed: Değişkenin primitive olarak tutulmasıdır.
    *
    * === operatörü değişkenlerin memorydeki referanslarını karşılaştırıken kullanılır.
    * == operatörü değişkenlerin değerlerini(value) karşılarştırmak için kullanılır.
    *
    *
    * Eğer primitive bir değişkeni nullable yapıyorsak, yani değişken artık null bir değer alabildiğini de
    * türün sonuna ? ile belirtiyorsak. Örnek Int?, Boolean? gibi. O değişken artık primitive bir değişken olarak değil,
    * class tipine dönüşüyor.
    * */


    // /*
    //* Reference vs Value
    //* */
    val boxedNumber: Int? = 127
    val anotherBoxedNumber: Int? = 127
    println(boxedNumber === anotherBoxedNumber) // true


    val number2: Int = 129
    val boxedNumber2: Int? = number2
    val anotherBoxedNumber2: Int? = number2
    println(boxedNumber2 === anotherBoxedNumber2) // false

    // Yukaridaki örnekte byte özel bir optimizasyon yapıldığı için, referans karşılaştırmasında byte değer aralığında
    // olmayan değerler için false dönerken, byte değer aralığında ise true dönüyor.
    // TODO Bunun neden sadece byte değişkenlere özel bir optimizasyon sağlandı da short vs sağlanmadı araştır.
}