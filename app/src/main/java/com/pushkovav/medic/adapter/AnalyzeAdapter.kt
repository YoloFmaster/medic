package com.pushkovav.medic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pushkovav.medic.R
import com.pushkovav.medic.data.models.Analyze

class AnalyzeAdapter(
    analyze: ArrayList<Analyze>
): RecyclerView.Adapter<AnalyzeAdapter.AnalyzeHolder>() {

    private val analyzeList = analyze

    class AnalyzeHolder(item: View): RecyclerView.ViewHolder(item){
        private val item = item
        fun bind(analyze: Analyze){
            val header = item.findViewById<TextView>(R.id.header)
            val countDay = item.findViewById<TextView>(R.id.countDay)
            val priceAnalyze = item.findViewById<TextView>(R.id.priceAnalyze)

            header.setText(analyze.analyze)
            countDay.setText(analyze.countDay)
            priceAnalyze.setText(analyze.priceAnalyze)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalyzeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_analyze_item, parent, false)
        return AnalyzeAdapter.AnalyzeHolder(view)
    }

    override fun getItemCount(): Int {
        return analyzeList.size
    }

    override fun onBindViewHolder(holder: AnalyzeHolder, position: Int) {
        holder.bind(analyzeList[position])
    }

}