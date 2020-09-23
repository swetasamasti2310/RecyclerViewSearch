package com.android.sweta.recyclerviewsearch

import com.android.sweta.recyclerviewsearch.model.Country
import java.util.*
import kotlin.collections.ArrayList

fun getCountriesList() : ArrayList<Country> {
    val countriesISOArray = Locale.getISOCountries()
    val countriesListWithFlag = ArrayList<Country>()
    for (countryISO in countriesISOArray) {
        val locale = Locale("", countryISO)
        val countryName = locale.displayCountry
        val countryFlagEmoji = getFlagEmoji(countryISO)
        countriesListWithFlag.add(Country("$countryName    $countryFlagEmoji"))
    }
    return countriesListWithFlag
}

fun getFlagEmoji(countryISO : String): String {
    val asciiOffset = 0x41 // character A
    val flagOffset = 0x1F1E6 // Regional indicator of A
    val firstChar = Character.codePointAt(countryISO, 0) - asciiOffset + flagOffset
    val secondChar = Character.codePointAt(countryISO, 1) - asciiOffset + flagOffset
    val flagEmoji = (String(Character.toChars(firstChar)) + String(Character.toChars(secondChar)))
    return flagEmoji
}
