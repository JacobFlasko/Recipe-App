package com.example.android.recipe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val savoryItems = ArrayList<String>()
    private lateinit var savoryAdapter: CustomAdapter

    private val sweetItems = ArrayList<String>()
    private lateinit var sweetAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Recipe List"

        val food = findViewById<EditText>(R.id.inputFood)
        val toast = Toast.makeText(this, "Enter input", Toast.LENGTH_SHORT)

        val savoryView: RecyclerView = findViewById(R.id.savoryItems)
        savoryAdapter = CustomAdapter(savoryItems)
        val savoryLayout = LinearLayoutManager(applicationContext)
        savoryView.layoutManager = savoryLayout
        savoryView.adapter = savoryAdapter

        val addSavoryItem = findViewById<Button>(R.id.addSavory)

        addSavoryItem.setOnClickListener(View.OnClickListener {
            if(food.getText().toString().length == 0)
            {
                toast.show()
            }
            else
            {
                savoryItems.add(food.getText().toString())
                savoryAdapter.notifyDataSetChanged()
            }
        })

        val sweetView: RecyclerView = findViewById(R.id.sweetItems)
        sweetAdapter = CustomAdapter(sweetItems)
        val sweetLayout = LinearLayoutManager(applicationContext)
        sweetView.layoutManager = sweetLayout
        sweetView.adapter = sweetAdapter

        val addSweetItem = findViewById<Button>(R.id.addSweet)

        addSweetItem.setOnClickListener(View.OnClickListener {
            if(food.getText().toString().length == 0)
            {
                toast.show()
            }
            else
            {
                sweetItems.add(food.getText().toString())
                sweetAdapter.notifyDataSetChanged()
            }
        })
    }
}