package com.example.homework2m6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework2m6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = arrayListOf<Model>()

    private val listSelect = arrayListOf<Model>()

    private lateinit var adapter: Adapter

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadImage()
        initView()
        imageSend()
    }

    fun imageSend() {
        list.add(Model(R.drawable.ic_cat, true))
        list.add(Model(R.drawable.ic_elephant, true))
        list.add(Model(R.drawable.ic_elephant, true))
        list.add(Model(R.drawable.ic_elephant, true))
        list.add(Model(R.drawable.ic_elephant, true))
    }

    private fun initView() {

        adapter = Adapter(list, this::onClick)
        binding.recyclerview.adapter = adapter
    }

    private fun onClick(imageModel: Model) {
        imageModel.select = !imageModel.select
        if (imageModel.select) {
            listSelect.add(imageModel)
        } else {
            listSelect.remove(imageModel)
        }
    }

    fun loadImage() {
        binding.btnSend.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("key", listSelect)
            startActivity(intent)
        }
    }
}