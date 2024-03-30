package com.pushkovav.medic.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pushkovav.medic.R
import com.pushkovav.medic.adapter.AnalyzeAdapter
import com.pushkovav.medic.adapter.BannersAdapter
import com.pushkovav.medic.data.models.Analyze
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

        val analyze = Analyze(R.string.analyze1,R.string.countDay1,R.string.priceAnalyze1)
        val analyze1 = Analyze(R.string.analyze2,R.string.countDay2,R.string.priceAnalyze2)
        val analyze2 = Analyze(R.string.analyze3,R.string.countDay3,R.string.priceAnalyze3)
        val analyze3 = Analyze(R.string.analyze4,R.string.countDay4,R.string.priceAnalyze4)

        val analyzeList = arrayListOf(analyze,analyze1,analyze2,analyze3)

        val adapterAnalyze = AnalyzeAdapter(
            analyzeList
        )

        val recyclerViewAnalyze = view.findViewById<RecyclerView>(R.id.recyclerViewAnalyzes)
        recyclerViewAnalyze.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL,false)
        recyclerViewAnalyze.adapter = adapterAnalyze


    }

}