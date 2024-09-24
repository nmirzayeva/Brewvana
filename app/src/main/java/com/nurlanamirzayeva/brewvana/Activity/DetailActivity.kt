package com.nurlanamirzayeva.brewvana.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project1762.Helper.ManagmentCart
import com.nurlanamirzayeva.brewvana.Model.ItemsModel
import com.nurlanamirzayeva.brewvana.R
import com.nurlanamirzayeva.brewvana.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel
    private lateinit var managmentCart: ManagmentCart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle()

    }

    private fun bundle() {
        binding.apply {

            item = intent.getParcelableExtra("object")!!
            titleTxt.text = item.title
            descriptionTxt.text = item.description
            priceTxt.text = "$" + item.price
            ratingBar.rating = item.rating.toFloat()

            addToCartBtn.setOnClickListener {
                item.numberInCart = Integer.valueOf(
                    numberItemTxt.text.toString()
                )
                managmentCart.insertItems(item)
            }

            backBtn.setOnClickListener {
                startActivity(
                    Intent(
                        this@DetailActivity,
                        MainActivity::class.java
                    )
                )
            }
            plusCart.setOnClickListener {
                numberItemTxt.text=(item.numberInCart+1).toString()
                item.numberInCart++
            }


        }


    }

}