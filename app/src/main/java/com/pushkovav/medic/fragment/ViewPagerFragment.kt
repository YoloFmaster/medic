package com.pushkovav.medic.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.pushkovav.medic.AntefactionActivity
import com.pushkovav.medic.R
import com.pushkovav.medic.adapter.ViewPagerAdapter
import com.pushkovav.medic.fragment.onboarding.FirstScreen
import com.pushkovav.medic.fragment.onboarding.SecondScreen
import com.pushkovav.medic.fragment.onboarding.ThirdScreen
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator


@Suppress("NAME_SHADOWING")
class ViewPagerFragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        
        val springDotsIndicator = view.findViewById<SpringDotsIndicator>(R.id.spring_dots_indicator)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)

        viewPager.adapter = adapter
        springDotsIndicator.attachTo(viewPager)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.skip)
        button.setOnClickListener{
            activity?.finish()
            val i = Intent(this.context, AntefactionActivity::class.java)
            startActivity(i)
        }

    }

}
