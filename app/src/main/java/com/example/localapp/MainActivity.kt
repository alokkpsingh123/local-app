package com.example.localapp

import android.content.Intent
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.localapp.adapter.ProductListAdapter
import com.example.localapp.viewmodels.MainViewModel
import com.example.localapp.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductListAdapter
    lateinit var layoutManager: LinearLayoutManager


    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //field injection
        (application as ProductApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager

        mainViewModel.productsLiveData.observe(this) {
            Log.d("Alok", it.products.toString())

            if (it != null) {
                adapter = ProductListAdapter(this, it.products)
                adapter.onItemClick = {
                    val intent = Intent(this, MainProductActivity::class.java)
                    intent.putExtra("product", it)
                    startActivity(intent)
                }
                adapter!!.notifyDataSetChanged()
                recyclerView!!.adapter = adapter
            }
        }


    }
}