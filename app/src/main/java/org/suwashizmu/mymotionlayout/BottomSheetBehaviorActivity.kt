package org.suwashizmu.mymotionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet_behavior_act.*

/**
 * Created by KEKE on 2019-07-18.
 */
class BottomSheetBehaviorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_sheet_behavior_act)

        BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_HIDDEN

        openButton.setOnClickListener {
            BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}