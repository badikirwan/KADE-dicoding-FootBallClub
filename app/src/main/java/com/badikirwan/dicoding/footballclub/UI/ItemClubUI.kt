package com.badikirwan.dicoding.footballclub.UI

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.badikirwan.dicoding.footballclub.R
import org.jetbrains.anko.*

class ItemClubUI : AnkoComponent<Context> {

    companion object {
        val clubImageId = 1
        val clubNameId = 2
    }

    override fun createView(ui: AnkoContext<Context>): View = with(ui){
       linearLayout {
           lparams(matchParent, wrapContent)
           padding = dip(16)

           imageView {
               id = clubImageId
               setImageResource(R.drawable.img_mu)
           }.lparams {
               width = dip(50)
               height = dip(50)
               setMargins(0,0, dip(16), 0)
           }

           textView {
               id = clubNameId
               textSize = sp(10).toFloat()
               text = "Heloo"
           }.lparams {
               width = wrapContent
               height = wrapContent
               gravity = Gravity.CENTER_VERTICAL
           }
       }
    }


}