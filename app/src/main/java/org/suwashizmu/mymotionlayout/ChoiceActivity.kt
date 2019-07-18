package org.suwashizmu.mymotionlayout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.choise_act.*

class ChoiceActivity : AppCompatActivity() {

    private val items = listOf(
        Item("MotionLayout", MainActivity::class.java),
        Item("recyclerView", GridActivity::class.java),
        Item("BottomSheet", BottomSheetBehaviorActivity::class.java)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choise_act)

        list.adapter = ListAdapter(
            this,
            items
        )
        list.setOnItemClickListener { _, _, position, _ ->
            startActivity(Intent(this@ChoiceActivity, items[position].classs))
        }
        Picasso.get().setIndicatorsEnabled(true)
    }

    private class ListAdapter(context: Context, items: List<Item>) :
        ArrayAdapter<Item>(context, android.R.layout.simple_list_item_1, items) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val textView = super.getView(position, convertView, parent) as TextView
            textView.text = getItem(position)?.name

            return textView
        }
    }

    private data class Item(
        val name: String,
        val classs: Class<*>
    )
}
