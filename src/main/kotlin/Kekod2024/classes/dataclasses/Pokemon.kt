package Kekod2024.classes.dataclasses

/**
 * Data class'la normal classları ayıran fark ne?
 *
 */


open class OpenPokemon()

abstract class AbstractPokemon()

/**
 * - Mutlaka primary constructor'a sahip olacak
 * - Mutlaka en azından 1 tane parametre içerecek primary constructor
 * - Mutlaka bu parametreler val/var ile yazılmış olacak. Peki neden? -> Primary constructor içerisinden gelen değişkenlerin
 * içerideki üye fonksiyonlarda kullanılabilmesi için o değişkenler val/var ile tanımlanması gerekiyor.
 *
 * - Parametreleri default değer alabilir. Bu konu mapping kütüphanelerinin boş constructor'a sahip olması gerekliliğinden
 * ötürü önemlidir.
 *
 * - Secondary constructor içerebilir.
 * - Member property ve function tanımlanabilir
 * - Member propertylerin componentN fonksiyonları üretilmez.
 * -Member propertyler copy, hashcode, equals ve toString fonksiyonları generate edilirken kullanılmazlar.
 *
 * - copy, hashcode, equals ve toString generate edeilir ve içlerindeki gerekli işlemleri sadece primary constructor içerisindeki değişkenleri kullanarak yapar.
 * -- Bu üretilen componentN fonksiyonlarından faydalanarak Destructuring declaration özelliğini kullanabiliyoruz.
 *
 * - open kullanamıyorum yani miras alamayız. default olarak final olarak kullanılıyor
 * - abstract yada open sınıfları miras olarak alabilir.
 *
 * - interfac implement edebiliriz.
 **/


data class PokemonData(
    val name: String,
    val type: String,
    val age: Int
)


class Pokemon(
    val name: String,
    val type: String,
    val age: Int,
)

fun main() {
    val pokemonData = PokemonData(name = "Bulbasaur", type = "Grass", age = 3)

    val pokemonCopy = pokemonData.copy(
        age = 10
    )
}