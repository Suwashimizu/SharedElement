package org.suwashizmu.mymotionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GridActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, GridFragment.newInstance())
                .commit()
        }

    }
}
