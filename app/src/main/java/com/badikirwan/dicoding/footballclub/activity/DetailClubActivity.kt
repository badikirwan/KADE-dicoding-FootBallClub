package com.badikirwan.dicoding.footballclub.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.badikirwan.dicoding.footballclub.model.Item
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailClubActivity : AppCompatActivity() {

    private lateinit var item: Item
    private lateinit var nameTextView: TextView
    private lateinit var descTextView: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)
            gravity = Gravity.CENTER_HORIZONTAL

            imageView = imageView().lparams {
                width = dip(100)
                height = dip(100)
            }

            nameTextView = textView().lparams {
                width = wrapContent
                height = wrapContent
            }

            descTextView = textView().lparams {
                width = wrapContent
                height = wrapContent
            }
        }

        val intent = intent
        item = intent.getParcelableExtra("data")
        nameTextView.text = item.name
        descTextView.text = item.description
        Glide.with(this)
                .load(item.image)
                .into(imageView)
    }
}