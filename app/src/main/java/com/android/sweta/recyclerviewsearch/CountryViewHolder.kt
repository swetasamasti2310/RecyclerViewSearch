package com.android.sweta.recyclerviewsearch

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.sweta.recyclerviewsearch.model.Country

class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(country: Country) {
        val textViewName = itemView.findViewById(R.id.country_name) as TextView
        textViewName.text = country.nameWithFlag
    }

}