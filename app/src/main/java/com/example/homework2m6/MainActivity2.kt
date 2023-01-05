package com.example.homework2m6

import android.view.LayoutInflater
import com.example.homework2m6.databinding.ActivityMain2Binding

class MainActivity2 : BaseActivity<ActivityMain2Binding>() {

    private lateinit var adapter: Adapter
    private var images = arrayListOf<Model>()
    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMain2Binding {
        return ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun imageSend() {
         images = intent.getSerializableExtra("key") as ArrayList<Model>
        adapter = Adapter( images,this::ONClick )
        binding.selectedRecycler.adapter = adapter
    }

    private fun ONClick(model:Model) {

    }

    override fun initView() {
    }

    override fun loadImage() {
    }
}