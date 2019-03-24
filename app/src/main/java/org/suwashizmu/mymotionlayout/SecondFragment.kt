package org.suwashizmu.mymotionlayout

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.second_frag.*

/**
 * Created by KEKE on 2019/03/20.
 */
class SecondFragment : Fragment(), MotionLayout.TransitionListener {

    companion object {

        private const val KEY_TRANSITION_NAME = "transitionName"
        private const val KEY_IMAGE_URL = "imageURL"

        fun newInstance(imageUrl: String? = null, transitionName: String = "image") =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_TRANSITION_NAME, transitionName)
                    if (imageUrl != null) {
                        putString(KEY_IMAGE_URL, imageUrl)
                    }
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postponeEnterTransition()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition =
                TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.second_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setTransitionName(image, requireArguments().getString(KEY_TRANSITION_NAME))

        val imageUrl = requireArguments().getString(KEY_IMAGE_URL)
        if (imageUrl != null) {
            Picasso.get()
                .load(imageUrl)
                .noFade()
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(image, object : Callback {
                    override fun onSuccess() {
//                        startPostponedEnterTransition()
                    }

                    override fun onError(e: Exception?) {
//                        startPostponedEnterTransition()
                    }
                })
        }
        motionLayout.setTransitionListener(this)
    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

    }

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
    }

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
        if (p3 >= 0.9f) {
            fragmentManager?.popBackStack()
        }
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {

    }
}