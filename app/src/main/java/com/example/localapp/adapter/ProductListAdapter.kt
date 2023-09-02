package com.example.localapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.localapp.R
import com.example.localapp.models.Product
import com.squareup.picasso.Picasso

class ProductListAdapter (var context: Context, var productModelList: List<Product>):
    RecyclerView.Adapter<ProductListAdapter.MyViewModel>(){

    var onItemClick : ((Product) -> Unit)? = null

    inner class MyViewModel(itemView: View): RecyclerView.ViewHolder(itemView){
        var imgProduct: ImageView
        var txtProductName: TextView
        var txtBrand: TextView
        var txtPrice: TextView
        var txtDiscount: TextView
        var txtRating: TextView

        init {
            imgProduct = itemView.findViewById(R.id.imgProduct)
            txtProductName = itemView.findViewById(R.id.txtProductName)
            txtBrand= itemView.findViewById(R.id.txtBrand)
            txtPrice= itemView.findViewById(R.id.txtPrice)
            txtDiscount= itemView.findViewById(R.id.txtDiscount)
            txtRating = itemView.findViewById(R.id.txtRating)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.layout_product_list,parent,false))
    }

    override fun onBindViewHolder(holder: ProductListAdapter.MyViewModel, position: Int) {

        val product = productModelList[position]
        Picasso.get().load(product.thumbnail).into(holder.imgProduct)
        holder.txtProductName.text = product.title
        holder.txtBrand.text = product.brand
        holder.txtPrice.text = "Price: "+ product.price
        holder.txtDiscount.text = "Discount: "+ product.discountPercentage +"%"
        holder.txtRating.text = "Rating: "+product.rating

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(product)
        }
    }

    override fun getItemCount(): Int {
        return productModelList.size
    }

}