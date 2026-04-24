package com.example.wealthtrackersa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.sa_ni_view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.sa_ni_tab_layout)

        viewPager.adapter = WealthPagerAdapter(this)

        // Surname "ახვლედიანი" starts with ა (vowel) -> horizontal
        val surname = "ახვლედიანი"
        val vowels = listOf('ა', 'ე', 'ი', 'ო', 'უ')
        if (surname.first() in vowels) {
            viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        } else {
            viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        }

        val tabTitles = listOf("Data", "Results", "About Me")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}
