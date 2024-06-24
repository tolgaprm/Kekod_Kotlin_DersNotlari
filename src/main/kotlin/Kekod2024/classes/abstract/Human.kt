package Kekod2024.classes.abstract

abstract class Human(val name: String, val eventManager: EventManager) {

    val eyeColor: String = "blue"
    open val age = 23
    abstract val surname: String
    abstract val middleName: String

    abstract fun display()
}

abstract class Turk(eventManager: EventManager, override val middleName: String) : Human("Türk", eventManager) {
    override val surname: String = "Pirim"
    abstract val skinColor: String

    override val age: Int
        get() = 24
}


open class Kurt(eventManager: EventManager, override val middleName: String) : Human("Kürt", eventManager) {
    override val surname: String = "sdasd"

    override fun display() {
    }
}

class ChildTurk(override val surname: String) : Turk(eventManager = EventManager(), middleName = "middleName") {
    override val skinColor: String = ""
    override fun display() {

    }
}

/**
 * Abstract sınıflarda çok detaylı bilgilere yer vermemelilyiz. Tüm child sınıflarda kullanılmayacak bilgileri
 * koymamamız gerekiyor. Örneğin bir yapının insan olabilmesi için mutlaka şu şu özelliklere ve şu fonksiyon setlerine mutlaka
 * sahip olmalıdır dersin ama bunun detaylarını vermezsin.
 */

/**
 * Eğer abstract bir class, yine abstract olan başka bir class tarafından inheritance(miras) alınıyorsa,
 * bu durumda üst sınıfdan gelen override edilmesi zorunlu olan abstract fonkisyonların ve propertylerin de
 * override edilme zorunluluğu ortadan kalkıyor.
 */


/**
 * Eğer bir abstract class, başka bir abstarct classı miras alıyorsa ve miras aldığı abstract classın üye bir
 * abstact proprty veya fonksiyonu override ediyorsa kendi içerisinde bunun child classslarında override edilen fonksiyonun
 * yada override edilen propertynin override edilme zorunluluğunu ortadan kaldırmış oluyoruz.
 */


/**
 * Human'dan gelen override edilmesi zorunlu olan surname child class'da overrride edilemez hale getirmek istiyorsak
 * o değişkene final keywordünü eklersek child class'da override edilmesine engellemiş oluruz.
 *
 * override edilen bir yapıyı bir fonksiyonu yada propertiyi final yapabiliriz ama abstract olan bir yapıyı final yapamayız.
 */


/**
 * Open sınıflar abstract yapılar içeremez.
 */


/**
 * Eğer iki tane birebir aynı ekranımız var. Aynı görevleri yapıyor. o zaman bunkarın detayl bilgilerini de içeren,
 *implemantasyonlarınıda içeren tüm yapıyı open class olarak yazabiliriz.
 *
 * Ama UI olarak bierebir aynı olmasına rağmen içerisindeki textler, içerisindeki imagelar, içlerindeki butonların
 * tıklandığında yaptığı işler birbirlerinden farklı ise abstract class kullanmamız gerekiyordu.
 */


class EventManager {
    fun sendEvent(name: String) {

    }

    fun getEvent(name: String): Event? {
        return Event()
    }
}

class Event