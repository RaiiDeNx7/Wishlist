package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WishlistAdapter
    private val itemList = mutableListOf<Item>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.wishlistRV)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = WishlistAdapter(itemList)
        recyclerView.adapter = adapter

        val itemInput = findViewById<EditText>(R.id.itemInput)
        val itemCost = findViewById<EditText>(R.id.itemCost)
        val linkInput = findViewById<EditText>(R.id.linkInput)
        val submitButton = findViewById<Button>(R.id.SubmitBtn)

        submitButton.setOnClickListener {
            val name = itemInput.text.toString()
            val price = itemCost.text.toString()
            val link = linkInput.text.toString()

            if (name.isNotEmpty() && price.isNotEmpty() && link.isNotEmpty()) {
                itemList.add(Item(name, price, link))
                adapter.notifyItemInserted(itemList.size - 1)

                // Clear inputs after adding
                itemInput.text.clear()
                itemCost.text.clear()
                linkInput.text.clear()
            }

        }



    }
}