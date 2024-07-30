package com.nanz.catto.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatResponse(
    val breeds: Breeds = Breeds(),
    val id: String = "",
    val url: String = ""
): Parcelable

@Parcelize
data class Breeds(
    val id: String = "",
    val name: String = "",
    val temperament: String = "",
    val origin: String = "",
    val description: String = "",
    @SerializedName("life_span")
    val lifeSpan: String = ""
): Parcelable