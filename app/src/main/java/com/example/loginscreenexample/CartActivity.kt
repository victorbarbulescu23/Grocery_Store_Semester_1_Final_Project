package com.example.loginscreenexample

import Product
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList


class CartActivity : AppCompatActivity() {

    lateinit var purchaseButton: Button
    lateinit var numItemsText: TextView
    lateinit var cartOutput: TextView

    private val totalItems: Int = intent.getIntExtra("EXTRA_TOTAL_ITEMS",0)
    var shoppingCart: ArrayList<Product>? = intent.getParcelableArrayListExtra("EXTRA_SHOPPING_CART")
    private lateinit var outputText: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        purchaseButton = findViewById(R.id.purchase_button)
        numItemsText = findViewById(R.id.num_items_output)
        cartOutput = findViewById(R.id.cart_output)

        numItemsText.setText(totalItems)

        for (i in shoppingCart?.indices!!){
            outputText += "${shoppingCart!![i].getSummary()}"
        }

        cartOutput.text = outputText

    }
}