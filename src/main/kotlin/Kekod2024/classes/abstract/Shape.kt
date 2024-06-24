package Kekod2024.classes.abstract

abstract class Shapes {

    abstract fun calculateArea(): Double
}

class Circle(private val radius: Double) : Shapes() {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle2(private val width: Double, private val height: Double) : Shapes() {
    override fun calculateArea(): Double {
        return width * height
    }
}


abstract class Shape {
    val edge: Int = 0
    abstract val area: Double
}

abstract class Rectangle : Shape() {

}