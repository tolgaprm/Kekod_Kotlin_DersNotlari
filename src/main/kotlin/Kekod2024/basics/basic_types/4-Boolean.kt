package Kekod2024.basics.basic_types

fun main() {
    /**
     *
     * 8 bit alan kaplar
     *
     * true yada false ataması için kullanılır. Nullable versiyonları null değer de alır.
     *  0 uada 1 Boolean olarak kullanılmaz.
     *  Bazı programlama dillerinde 0 ve 1 de Boolean olarak kabul edilebilir ama Kotlin'de kabul edilmez.
     *
     */

    val isKeko = false

    val isAndroidDeveloper = true

    /**
     *
     *  ||(or) &&(and) !(not) gibi operatörler ile beraber kullanılır.
     *
     *  And'de iki değer de true ise true döndürür. Eğer bir ifade false olursa false döner.
     *  Veya da ise iki değerden herhangi birisi true ise true döner.
     */

    if (isAndroidDeveloper && isKeko) {

    }

    if (isAndroidDeveloper and isKeko) {

    }

    if (isAndroidDeveloper || isKeko) {

    }

    if (isAndroidDeveloper or isAndroidDeveloper) {

    }

    if (isAndroidDeveloper.or(isAndroidDeveloper)) {

    }

    if (isKeko.not()) {

    }

    if (!isKeko) {

    }

    /***
     *  Boolean değerleri true olma durumunu kontrol etmek
     *  için == true şklinde açıkca yazmaya gerek yoktur.
     *
     *  Ama nullable ise yapmak zorunludurç
     */

    if (isAndroidDeveloper) {

    }

    val isSuccess: Boolean? = null

    /**
    // Bir ifademiz null olduğunda artık üç durumumuz vardı
     * Bunlar true, false ve null olması
     */
    if (isSuccess == true) {

    } else {
        // Geri kalan iki durum için else durumunu kullanır.
    }

    /**
     * Kotlin'de || && operatörleri lazily çalışma mekanizmasına
     * sahiptir. Bu ne demektir?
     *
     * Kod daha hızlı çalışsın diye dilin yaptığı bir optimizasyondur.
     */
}