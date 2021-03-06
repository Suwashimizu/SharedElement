package org.suwashizmu.mymotionlayout

import android.os.Bundle
import android.transition.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.SharedElementCallback
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.grid_frag.*
import kotlinx.android.synthetic.main.item_image.view.*
import java.util.*

/**
 * Created by KEKE on 2019/03/20.
 */
class GridFragment : Fragment() {

    private val items = listOf(
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/baboon.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/barbara.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/boat.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/cat.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/fruits.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/frymire.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/girl.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/goldhill.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/lena.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/monarch.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/mountain.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/peppers.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/pool.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/sails.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/tulips.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/watch.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/zelda.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/baboon.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/barbara.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/boat.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/cat.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/fruits.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/frymire.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/girl.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/goldhill.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/lena.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/monarch.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/mountain.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/peppers.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/pool.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/sails.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/serrano.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/tulips.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/watch.png"),
        ImageItem(UUID.randomUUID().toString(), "https://homepages.cae.wisc.edu/~ece533/images/zelda.png")
    )

    companion object {
        fun newInstance() =
            GridFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.grid_frag, container, false).apply {

            //フラグメントのトランザクションが発生して Fragment が終了するときと、Fragment がバックスタックからポップされて（「戻る」のナビゲーション）再度開始されるときに呼び出されることに注意してください
            setExitSharedElementCallback(object : SharedElementCallback() {
                override fun onMapSharedElements(
                    names: MutableList<String>?,
                    sharedElements: MutableMap<String, View>?
                ) {
                    val pos = items.indexOfFirst { it.uuid == names!![0] }
                    val viewHolder = list.findViewHolderForAdapterPosition(pos) as? ViewHolder
                    if (viewHolder != null) {
                        sharedElements?.put(names!![0], viewHolder.imageView)
                    }
                }
            })

            exitTransition = Fade()

            postponeEnterTransition()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.adapter = ItemAdapter(
            items,
            ::moveToSecond
        ) {
            startPostponedEnterTransition()
        }

        list.layoutManager = GridLayoutManager(requireActivity(), 2)
    }

    private fun moveToSecond(item: ImageItem, imageView: ImageView) {
        if (requireFragmentManager().findFragmentById(R.id.details) == null) {

            val secondFragment = SecondFragment.newInstance(item.url, item.uuid).apply {
                sharedElementEnterTransition = DetailsTransition()
                sharedElementReturnTransition = DetailsTransition()
            }

            val transitionName = ViewCompat.getTransitionName(imageView)
            if (transitionName != null) {

                requireFragmentManager()
                    .beginTransaction()
                    //setAllowOptimization before 26.1.0
                    .setReorderingAllowed(true)
                    .addSharedElement(imageView, transitionName)
                    .replace(R.id.container, secondFragment)
                    .addToBackStack(null)
                    .commit()
            } else {

                requireFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, secondFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    private class ImageItem(
        val uuid: String,
        val url: String
    )

    private class ItemAdapter(
        private val items: List<ImageItem>,
        private val clickListener: (item: ImageItem, imageView: ImageView) -> Unit,
        private val onLoadCompleted: () -> Unit
    ) : RecyclerView.Adapter<ViewHolder>() {


        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(p0.context).inflate(R.layout.item_image, p0, false),
                onLoadCompleted
            )
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
            p0.onBind(items[p1])
            p0.itemView.setOnClickListener {
                clickListener(items[p1], p0.imageView)
            }

            ViewCompat.setTransitionName(p0.imageView, items[p1].uuid)
        }

        override fun getItemCount(): Int = items.size
    }

    private class ViewHolder(
        private val view: View,
        private val onLoadCompleted: () -> Unit
    ) : RecyclerView.ViewHolder(view) {

        val imageView = view.image

        fun onBind(item: ImageItem) {
            Picasso.get()
                .load(item.url)
                .into(view.image, object : Callback {
                    override fun onSuccess() {
                        onLoadCompleted()
                    }

                    override fun onError(e: Exception?) {
                        onLoadCompleted()
                    }
                })
        }
    }

    private class DetailsTransition : TransitionSet() {
        init {
            ordering = ORDERING_TOGETHER
            addTransition(ChangeBounds())
                .addTransition(ChangeTransform())
                .addTransition(ChangeImageTransform())
        }
    }
}