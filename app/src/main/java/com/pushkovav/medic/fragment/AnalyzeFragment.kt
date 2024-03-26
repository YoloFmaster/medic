package com.pushkovav.medic.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pushkovav.medic.R
import com.pushkovav.medic.adapter.BannersAdapter
import com.pushkovav.medic.data.models.Banners

class AnalyzeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_analyze, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val banners1 = Banners(R.drawable.pacient1,R.string.header1,R.string.research1,R.string.price1)
        val banners2 = Banners(R.drawable.pacient1,R.string.header2,R.string.research2,R.string.price2)

        val bannerList = arrayListOf(banners1,banners2)

        val adapter = BannersAdapter(
            bannerList
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL,false)
        recyclerView.adapter = adapter
    }

}