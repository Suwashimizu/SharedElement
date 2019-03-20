package org.suwashizmu.mymotionlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.second_frag.*

/**
 * Created by KEKE on 2019/03/20.
 */
class SecondFragment : Fragment(), MotionLayout.TransitionListener {

    companion object {
        fun newInstance() =
            SecondFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.second_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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