package com.pushkovav.medic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pushkovav.medic.R
import com.pushkovav.medic.data.models.Banners

class BannersAdapter(
    banners: ArrayList<Banners>
): RecyclerView.Adapter<BannersAdapter.BannersHolder>() {

    private val bannersList = banners

    class BannersHolder(private val item: View): RecyclerView.ViewHolder(item) {
        fun bind(banners: Banners){
            val img = item.findViewById<ImageView>(R.id.image)
            val header = item.findViewById<TextView>(R.id.header)
            val research = item.findViewById<TextView>(R.id.countResearches)
            val price = item.findViewById<TextView>(R.id.price)

            img.setImageResource(banners.peopleImg)
            header.setText(banners.header)
            research.setText(banners.countResearches)
            price.setText(banners.price)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannersHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return BannersHolder(view)
    }

    override fun getItemCount(): Int {
        return bannersList.size
    }

    override fun onBindViewHolder(holder: BannersHolder, position: Int) {
        holder.bind(bannersList[position])
    }

}
