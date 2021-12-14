package com.yogathadhi.kuliner_purwokerto_app

data class KulinerItem(val jamBukaTutup: String,
                       val kordinat: String,
                       val nama: String,
                       val gambar_url: String,
                       val kategori: String,
                       val id: Int = 0,
                       val alamat: String)


data class DataKuliner(val kuliner: List<KulinerItem>?)