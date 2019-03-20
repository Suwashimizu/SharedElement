package org.suwashizmu.mymotionlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.main_frag.*

/**
 * Created by KEKE on 2019/03/20.
 */
class MainFragment : Fragment() {

    companion object {
        fun newInstance() =
            MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image.setOnClickListener {
            moveToSecond()
        }
    }

    private fun moveToSecond() {

        if (requireFragmentManager().findFragmentById(R.id.details) == null)
            requireFragmentManager()
                .beginTransaction()
                .add(R.id.details, SecondFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }
}