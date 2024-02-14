package Kekod2024.basic_types

fun main() {

    // Kotlin'de bir değişkee null ataması yapabilmek için ? işareti ile belirtmeliyiz.
    // Null demek aslında bu değişkenin bir değeri yoktur demektir.
    val name: String? = null

    /*
    * Eğer bir değişkene bir tip verilmez ve o değişkene null ataması yapılırsa,
    * IDE tip çıkarımı yaparken (type Inference) bu değişkenin değerini Nothing? olarak belirler.*/
    val number = null //Nothing?

    /* Nothing değişkenler daha çok herhangi bir fonksiyonun bir değer döndürmek zorunda olmadığı
     durumlarda kullanılır. Genelde exception fırlatmalarda görürüz.
     Unit'den farklıdır ama Unit bir boş da olsa bir değer döndüğünü söyler Nothing hiçbir şeydir */

    /*
    *   Kotlin null safety'dir
    *   ?. && !! Operatörleri
    *
    *  name?.lowercase() -- kullanımı ile null ise bu işlemi gerçekleştirmez. Eğer null değil ise işlemi gerçekleştirir.
    *  ve herhangi bir hata meydana getirmez.
    *
    *  name!!.lowercase() - kullanımı ise, bu değişkenin zorla IDE'ya null olmayacağını garanti ettiğimizi belirtiyoruz.
    *  Ama eğer değişken null ise program çalışma zamanında (runtime)'da NullPointerException hatasını fırlatır.
    *  Eğer null değil ise zaten işlemi gerçekleştirir ve herhangi bir hata meydana gelmez.
    *
    *  Peki ne zaman !! veya ?. kullanmalıyım? Bunun Best Practice Nedir?- 46.dk
    *
    *  Yazdığımız alan çok kritik bir yer değil ise -
    * */

    // println(SearchingChallenge(10))
}

private class Ornek() {
    val studentName: String? = "Tolga"
    val studentAge: Int? = 23
    val isMale: Boolean? = true
}