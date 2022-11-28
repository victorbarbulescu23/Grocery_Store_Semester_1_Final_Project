//Exists only to store nutritional information about each product type
class NutritionFacts (isProduce: Boolean,
                      isCandy: Boolean,
                      isBeverage: Boolean,
                      hasGluten: Boolean) {

    //parameters are passed in the main function (see Main.kt line 36), then passed into the Product object
    private var hasGluten: Boolean = false
    private var isProduce = false
    private var isCandy = false
    private var isBeverage = false

    init {
        this.isProduce = isProduce
        this.isCandy = isCandy
        this.isBeverage = isBeverage
    }

    //NutritionSummary returns a summary of the nutrition facts based on what kind of product it is
    fun nutritionSummary(): String {
        if (isProduce){
            if (hasGluten){
                return "Sugar: 4g \n" +
                        "Sodium: 120mg \n" +
                        "Saturated Fats: 1.3g \n" +
                        "Trans Fats: 6.7g \n" +
                        "This Product Contains Gluten"
            }

            return "Sugar: 4g \n" +
                    "Sodium: 120mg \n" +
                    "Saturated Fats: 1.3g \n" +
                    "Trans Fats: 6.7g \n"
        } else if (isCandy){
            if (hasGluten){
                return "Sugar: 16g \n" +
                        "Sodium: 350mg \n" +
                        "Saturated Fats: 8g \n" +
                        "Trans Fats: 4g \n" +
                        "This Product Contains Gluten"
            }

            return "Sugar: 16g \n" +
                    "Sodium: 350mg \n" +
                    "Saturated Fats: 8g \n" +
                    "Trans Fats: 4g \n"
        } else if (isBeverage){
            if (hasGluten){
                return "Sugar: 10g \n" +
                        "Sodium: 80mg \n" +
                        "Saturated Fats: 3g \n" +
                        "Trans Fats: 6g \n" +
                        "This Product Contains Gluten"
            }

            return "Sugar: 10g \n" +
                    "Sodium: 80mg \n" +
                    "Saturated Fats: 3g \n" +
                    "Trans Fats: 6g \n"
        } else {
            return "unidentified product, no nutritional information can be found"
        }
    }


}