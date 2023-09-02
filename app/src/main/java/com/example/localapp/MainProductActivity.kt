package com.example.localapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.localapp.models.Product
import com.squareup.picasso.Picasso

class MainProductActivity : AppCompatActivity() {

    private lateinit var imgProduct: ImageView
    private lateinit var txtTitle: TextView
    private lateinit var txtDescription: TextView
    private lateinit var txtPrice: TextView
    private lateinit var txtDiscount: TextView
    private lateinit var txtRating: TextView
    private lateinit var txtBrand: TextView
    private lateinit var txtCategory: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_product)

        imgProduct = findViewById(R.id.imgProduct)
        txtTitle = findViewById(R.id.txtTitle)
        txtDescription = findViewById(R.id.txtDescription)
        txtPrice = findViewById(R.id.txtPrice)
        txtDiscount = findViewById(R.id.txtDiscount)
        txtRating = findViewById(R.id.txtRating)
        txtBrand = findViewById(R.id.txtBrand)
        txtCategory = findViewById(R.id.txtCategory)

        val product = intent.getParcelableExtra<Product>("product")

        if(product != null){
            Picasso.get().load(product.thumbnail).into(imgProduct)
            txtTitle.text = product.title
            txtDescription.text = product.description
            txtBrand.text = "Brand: "+ product.brand
            txtPrice.text = "Price: "+ product.price
            txtDiscount.text = "Discount: "+ product.discountPercentage +"%"
            txtRating.text = "Rating: "+ product.rating
            txtCategory.text = "Category: "+ product.category
        }


    }
}