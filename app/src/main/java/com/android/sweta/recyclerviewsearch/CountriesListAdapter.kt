package com.android.sweta.recyclerviewsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.android.sweta.recyclerviewsearch.model.Country
import java.util.*
import kotlin.collections.ArrayList

class CountriesListAdapter(val countriesList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryViewHolder>(), Filterable {

    private var countryFilterList = ArrayList<Country>()

    init {
        countryFilterList = countriesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val countryView =
            LayoutInflater.from(parent.context).inflate(R.layout.country_row, parent, false)
        val countryHolder = CountryViewHolder(countryView)
        return countryHolder
    }

    override fun getItemCount(): Int {
        return countryFilterList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bindItem(countryFilterList[position])
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(searchChar: CharSequence?): FilterResults {
                val charSearched  = searchChar.toString()
                if (charSearched.isEmpty()) {
                    countryFilterList = countriesList
                }
                else {
                    val filteredList = ArrayList<Country>()
                    for (country in countriesList) {
                        if ((country.nameWithFlag).toLowerCase(Locale.ROOT).contains(
                                charSearched.toLowerCase(Locale.ROOT)
                            )
                        ) {
                            filteredList.add(Country(country.nameWithFlag))
                        }
                    }
                    countryFilterList = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = countryFilterList
                return filterResults
            }

            override fun publishResults(searchChar: CharSequence?, results: FilterResults?) {
                countryFilterList = results?.values as ArrayList<Country>
                notifyDataSetChanged()
            }
        }
    }

}