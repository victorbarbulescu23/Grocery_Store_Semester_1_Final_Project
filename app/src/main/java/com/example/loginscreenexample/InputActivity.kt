package com.example.loginscreenexample

import Beverages
import NutritionFacts
import Produce
import Product
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class InputActivity() : AppCompatActivity(), Parcelable {

    lateinit var foodTypeSpinner: Spinner

    lateinit var glutenCheckBox: CheckBox
    lateinit var nameInput: EditText
    lateinit var aisleInput: EditText
    lateinit var expireDateInput: EditText

    lateinit var isSodaButton:RadioButton
    lateinit var isAlcoholButton:RadioButton
    lateinit var radioGroup: RadioGroup

    lateinit var addToCart: Button
    lateinit var doneShopping: Button


    var shoppingCart = arrayListOf<Product>().apply {
        //parcelIn.readArrayList(Product::class.java.classLoader)
        newArray(10)
    }

    constructor(parcel: Parcel) : this() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        foodTypeSpinner = findViewById(R.id.food_type_spinner)

        glutenCheckBox = findViewById(R.id.has_gluten)
        nameInput = findViewById(R.id.product_name_input)
        aisleInput = findViewById(R.id.aisle_input)
        expireDateInput = findViewById(R.id.expire_date_input)

        isSodaButton = findViewById(R.id.isSoda)
        isAlcoholButton = findViewById(R.id.isAlcohol)
        radioGroup = findViewById(R.id.radioGroup)

        addToCart = findViewById(R.id.add_to_cart)
        doneShopping = findViewById(R.id.done_shopping)

        /*
        var shoppingCart = arrayListOf<Product>().apply {
            parcelIn.readArrayList(Product::class.java.classLoader)
        }

         */
        var totalItems = 0

        addToCart.setOnClickListener {
            val productName: String
            val aisle: Int
            val expirationDate: String
            val shelfLife: String
            var hasGluten: Boolean = false

            var isSoda: Boolean = false
            var isAlcohol: Boolean = false

            if (checkData(foodTypeSpinner.selectedItem.toString())){
                if (foodTypeSpinner.selectedItem.toString() == "Produce"){

                    productName = nameInput.text.toString();
                    aisle = aisleInput.text.toString().toInt()
                    expirationDate = expireDateInput.text.toString()
                    if (glutenCheckBox.isChecked){
                        hasGluten = true
                    }

                    val nutritionFacts = NutritionFacts(true,false,false, hasGluten)
                    val item = Produce(expirationDate,productName,aisle,nutritionFacts)
                    shoppingCart.add(item)
                    totalItems++

                    Toast.makeText(this@InputActivity, "Item Added Successfully!", Toast.LENGTH_SHORT).show()
                    reset(glutenCheckBox,nameInput,aisleInput,expireDateInput,radioGroup)

                } else if (foodTypeSpinner.selectedItem.toString() == "Candy") {
                    productName = nameInput.text.toString();
                    aisle = aisleInput.text.toString().toInt()
                    shelfLife = expireDateInput.text.toString()
                    if (glutenCheckBox.isChecked){
                        hasGluten = true
                    }

                    val nutritionFacts = NutritionFacts(false,true,false, hasGluten)
                    val item = Produce(shelfLife,productName,aisle,nutritionFacts)
                    shoppingCart.add(item)
                    totalItems++

                    Toast.makeText(this@InputActivity, "Item Added Successfully!", Toast.LENGTH_SHORT).show()
                    reset(glutenCheckBox,nameInput,aisleInput,expireDateInput,radioGroup)

                } else if (foodTypeSpinner.selectedItem.toString() == "Beverage"){
                    productName = nameInput.text.toString();
                    aisle = aisleInput.text.toString().toInt()

                    if (isSodaButton.isChecked){
                        isSoda = true
                    } else {
                        isAlcohol = true
                    }

                    val nutritionFacts = NutritionFacts(false,false,true, hasGluten)
                    val item = Beverages(isSoda,isAlcohol,productName,aisle,nutritionFacts)
                    shoppingCart.add(item)
                    totalItems++

                    Toast.makeText(this@InputActivity, "Item Added Successfully!", Toast.LENGTH_SHORT).show()
                    reset(glutenCheckBox,nameInput,aisleInput,expireDateInput,radioGroup)


                }
            } else {
                (foodTypeSpinner.getSelectedView() as TextView).error = "Please Select a Food Type"
                Toast.makeText(this@InputActivity, "ERROR: Please select a food type", Toast.LENGTH_SHORT).show()
            }

        }

        doneShopping.setOnClickListener {

            Intent(this@InputActivity, CartActivity::class.java).also {
                val bundle = Bundle()
                bundle.putParcelableArrayList("EXTRA_SHOPPING_CART", shoppingCart)
                it.putExtras(bundle)
                it.putExtra("EXTRA_TOTAL_ITEMS", totalItems)
                startActivity(it)
            }
        }


    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InputActivity> {
        override fun createFromParcel(parcel: Parcel): InputActivity {
            return InputActivity(parcel)
        }

        override fun newArray(size: Int): Array<InputActivity?> {
            return arrayOfNulls(size)
        }
    }
}

fun checkData(foodType: String): Boolean {
    return foodType != "Select your Product Type"
}

fun reset(glutenCheckBox:CheckBox, nameInput:EditText, aisleInput: EditText, expireDateInput: EditText, radioGroup: RadioGroup){
    glutenCheckBox.isChecked = false
    nameInput.setText("")
    aisleInput.setText("")
    expireDateInput.setText("")
    radioGroup.clearCheck()
}

