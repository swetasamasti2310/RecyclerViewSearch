package com.android.sweta.recyclerviewsearch

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewManager: RecyclerView.LayoutManager
    private lateinit var countriesListAdapter: CountriesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewManager = LinearLayoutManager(this)
        countriesListAdapter = CountriesListAdapter(getCountriesList())

        countriesRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = recyclerViewManager
            adapter = countriesListAdapter
        }

        val cancelSearchIcon = countrySearchView.findViewById<ImageView>(R.id.search_close_btn)
        cancelSearchIcon.setColorFilter(Color.WHITE)

        val searchIcon = countrySearchView.findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.WHITE)

        val searchText = countrySearchView.findViewById<TextView>(R.id.search_src_text)
        searchText.setTextColor(Color.WHITE)

        countrySearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(searchText: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(searchText: String?): Boolean {
                countriesListAdapter.filter.filter(searchText)
                return false
            }
        })

    }
}