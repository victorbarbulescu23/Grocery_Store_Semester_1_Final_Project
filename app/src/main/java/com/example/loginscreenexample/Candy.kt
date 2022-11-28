//Candy child class, inherits Product and takes in information about what kind of candy is being purchased
class Candy (shelfLife: Int,
            isHardCandy: Boolean,
            isGummyCandy: Boolean,
            isIceCream: Boolean,
            name: String,
            aisle: Int,
            nutritionFacts: NutritionFacts):
            Product(name,aisle,nutritionFacts){

    var shelfLife: Int = shelfLife
        get() = field
        set(value) {
            field = value
        }
    var isHardCandy: Boolean = isHardCandy
        get() = field
        set(value) {
            field = value
        }
    var isGummyCandy: Boolean = isGummyCandy
        get() = field
        set(value) {
            field = value
        }
    var isIceCream: Boolean = isIceCream
        get() = field
        set(value) {
            field = value
        }

    //overrides the getSummary function in Product to output data specifically about Candy
    override fun getSummary() {
        if (isHardCandy){
            println( "Name: $name \n" +
                    "Aisle: $aisle \n" +
                    "Candy Type: Hard \n" +
                    "Shelf life: $shelfLife \n" +
                    "Ingredients: ${nutritionFacts.nutritionSummary()} \n")
        } else if (isGummyCandy) {
            println( "Name: $name \n" +
                    "Aisle: $aisle \n" +
                    "Candy Type: Gummy \n" +
                    "Shelf life: $shelfLife \n" +
                    "Ingredients: ${nutritionFacts.nutritionSummary()} \n")
        } else if (isIceCream){
            println( "Name: $name \n" +
                    "Aisle: $aisle \n" +
                    "Candy Type: Ice Cream \n" +
                    "Shelf life: $shelfLife \n" +
                    "Ingredients: ${nutritionFacts.nutritionSummary()} \n")
        } else {
            println( "Name: $name \n" +
                    "Aisle: $aisle \n" +
                    "Candy Type: Chocolate \n" +
                    "Shelf life: $shelfLife \n" +
                    "Ingredients: ${nutritionFacts.nutritionSummary()} \n")
        }
    }
}