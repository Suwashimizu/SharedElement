package org.suwashizmu.mymotionlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.grid_frag.*
import kotlinx.android.synthetic.main.item_image.view.*

/**
 * Created by KEKE on 2019/03/20.
 */
class GridFragment : Fragment() {

    private val items = listOf(
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/airplane.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/arctichare.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/baboon.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/barbara.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/boat.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/cat.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/fruits.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/frymire.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/girl.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/goldhill.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/lena.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/monarch.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/mountain.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/peppers.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/pool.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/sails.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/tulips.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/watch.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/zelda.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/airplane.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/arctichare.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/baboon.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/barbara.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/boat.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/cat.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/fruits.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/frymire.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/girl.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/goldhill.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/lena.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/monarch.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/mountain.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/peppers.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/pool.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/sails.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/tulips.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/watch.png"),
        ImageItem("https://homepages.cae.wisc.edu/~ece533/images/zelda.png")
    )

    companion object {
        fun newInstance() =
            GridFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.grid_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.adapter = ItemAdapter(
            items
        )
        list.layoutManager = GridLayoutManager(requireActivity(), 2)

    }

    private class ImageItem(
        val url: String
    )

    private class ItemAdapter(private val items: List<ImageItem>) : RecyclerView.Adapter<ViewHolder>() {


        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(p0.context).inflate(R.layout.item_image, p0, false)
            )
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
            p0.onBind(items[p1])
        }

        override fun getItemCount(): Int = items.size
    }

    private class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(item: ImageItem) {
            Picasso.get()
                .load(item.url)
                .into(view.image)
        }
    }
}