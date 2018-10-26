package com.badikirwan.dicoding.footballclub.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.badikirwan.dicoding.footballclub.R
import com.badikirwan.dicoding.footballclub.adapter.ItemClubAdapter
import com.badikirwan.dicoding.footballclub.model.Item
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private val Items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()

        val mAdapter = ItemClubAdapter(Items) { item ->
            startActivity(intentFor<DetailClubActivity>("data" to item))
        }

        MainActivityyUI(mAdapter).setContentView(this)
    }

    class MainActivityyUI(private val clubAdapter: ItemClubAdapter) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {

            relativeLayout {
                padding = dip(16)
                lparams(matchParent, wrapContent)

                recyclerView {
                    lparams(matchParent, wrapContent)
                    layoutManager = LinearLayoutManager(ctx)
                    adapter = clubAdapter
                }
            }
        }
    }

    fun initData() {
        val imageLogo = resources.obtainTypedArray(R.array.club_image)
        val name = resources.getStringArray(R.array.club_name)
        val description = resources.getStringArray(R.array.club_desc)

        Items.clear()

        for (i in name.indices) {
            Items.add(Item(name[i], imageLogo.getResourceId(i,0), description[i]))
        }

        imageLogo.recycle()
    }
}
