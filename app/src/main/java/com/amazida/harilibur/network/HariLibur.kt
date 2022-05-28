package com.amazida.harilibur.network


import com.squareup.moshi.Json

data class HariLibur(
    @Json(name = "nama_bulan")
    val namaBulan: String,
    val liburan: List<String>
)