package com.pushkovav.medic.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pushkovav.medic.R
import com.pushkovav.medic.adapter.AnalyzeAdapter
import com.pushkovav.medic.adapter.BannersAdapter
import com.pushkovav.medic.data.models.Analyze
import com.pushkovav.medic.data.models.Banners
import java.util.Locale

class AnalyzeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_analyze, container, false)
    }

    private lateinit var recyclerViewAnalyze: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var analyzeList: ArrayList<Analyze>
    private lateinit var adapterAnalyze: AnalyzeAdapter
    private lateinit var noneResult: TextView


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

        val analyze = Analyze("ПЦР-тест на определение РНК коронавируса стандартный",R.string.countDay1,R.string.priceAnalyze1)
        val analyze1 = Analyze("Клинический анализ крови с лейкоцитарной формулировкой",R.string.countDay2,R.string.priceAnalyze2)
        val analyze2 = Analyze("Биохимический анализ крови, базовый",R.string.countDay3,R.string.priceAnalyze3)
        val analyze3 = Analyze("СОЭ(венозная кровь)",R.string.countDay4,R.string.priceAnalyze4)

        analyzeList = arrayListOf(analyze,analyze1,analyze2,analyze3)

        adapterAnalyze = AnalyzeAdapter(
            analyzeList
        )
        recyclerViewAnalyze = view.findViewById(R.id.recyclerViewAnalyzes)
        recyclerViewAnalyze.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL,false)
        recyclerViewAnalyze.adapter = adapterAnalyze

        noneResult = view.findViewById(R.id.noneResult)

        searchView = view.findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }
    fun filterList(query: String?){
        if (query != null){
            val filteredAnalyzeList = ArrayList<Analyze>()
            for(i in analyzeList){
                if (i.analyze.lowercase(Locale.ROOT).contains(query)) filteredAnalyzeList.add(i)
            }

            if (filteredAnalyzeList.isEmpty()){
                recyclerViewAnalyze.visibility = View.INVISIBLE
                noneResult.visibility = View.VISIBLE
            }
            else{
                recyclerViewAnalyze.visibility = View.VISIBLE
                noneResult.visibility = View.INVISIBLE
                adapterAnalyze.setFilteredAnalyzeList(filteredAnalyzeList)
            }
        }
    }
}