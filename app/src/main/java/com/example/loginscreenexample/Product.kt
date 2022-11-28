//Abstract parent class that contains information about a products name, aisle, and nutrition.
abstract class Product (name: String,
                        aisle: Int,
                        nutritionFacts: NutritionFacts){

    var name: String = ""
        get() = field
        set(value) {
            field = value
        }
    var aisle: Int = 0
        get() = field
        set(value) {
            field = value
        }
    var nutritionFacts: NutritionFacts

    init {
        this.name = name
        this.aisle = aisle
        this.nutritionFacts = nutritionFacts
    }

    //Abstract fun getSummary() is overriden in child classes to output a summary specific to every product
    abstract fun getSummary()
}