import java.time.format.DateTimeFormatter

//Produce child class, inherits Product
class Produce (expirationDate: String,
               name: String,
               aisle: Int,
               nutritionFacts: NutritionFacts):
                Product(name,aisle,nutritionFacts){

    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")

    var expirationDate = expirationDate
        get() = field
        set(value) {
            field = value
        }

    //Overrides the Product getSummary function to specifically output data about produce
    override fun getSummary() {
        println("Name: $name \n" +
                "Aisle: $aisle \n" +
                "Ingredients: ${nutritionFacts.nutritionSummary()}" +
                "Expiration Date: ${expirationDate.format(formatter)}")
    }

}