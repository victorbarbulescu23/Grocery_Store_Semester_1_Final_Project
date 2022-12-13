import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//Beverages child class inherits Product. Takes in information about what kind of beverage the item is.
class Beverages (isSoda: Boolean,
                isAlcoholic: Boolean,
                name: String,
                aisle: Int,
                nutritionFacts: NutritionFacts):
                Product(name,aisle,nutritionFacts) {

    var isSoda = isSoda
        get() = field
        set(value) {
            field = value
        }

    var isAlcoholic = isAlcoholic
        get() = field
        set(value) {
            field = value
        }

    constructor(parcel: Parcel) : this(
        TODO("isSoda"),
        TODO("isAlcoholic"),
        TODO("name"),
        TODO("aisle"),
        TODO("nutritionFacts")
    ) {
    }

    //Overrides the getSummary function in Product to output a summary specific to beverages
    override fun getSummary() {
        if (isAlcoholic){
            println( "Name: $name \n" +
                    "Aisle: $aisle \n" +
                    "Beverage Type: Alcoholic \n" +
                    "Ingredients: ${nutritionFacts.nutritionSummary()} \n")
        } else if (isSoda){
            println( "Name: $name \n" +
                    "Aisle: $aisle \n" +
                    "Beverage Type: Soda \n" +
                    "Ingredients: ${nutritionFacts.nutritionSummary()} \n")
        } else {
            println( "Name: $name \n" +
                    "Aisle: $aisle \n" +
                    "Beverage Type: Water \n" +
                    "Ingredients: ${nutritionFacts.nutritionSummary()} \n")
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Beverages> {
        override fun createFromParcel(parcel: Parcel): Beverages {
            return Beverages(parcel)
        }

        override fun newArray(size: Int): Array<Beverages?> {
            return arrayOfNulls(size)
        }
    }
}