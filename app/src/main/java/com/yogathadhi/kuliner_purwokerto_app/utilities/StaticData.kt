package com.yogathadhi.kuliner_purwokerto_app.utilities

class StaticData {
    companion object{
        var jamBukaTutup: String = ""
        var kordinat: String = ""
        var nama: String = ""
        var gambar: String = ""
        var kategori: String = ""
        var id: Int = 0
        var alamat: String = ""

        fun fill(kulinerItem: KulinerItem){
            if(kulinerItem.jamBukaTutup != null){
                jamBukaTutup = "Jam Buka: " + kulinerItem.jamBukaTutup
            } else{
                jamBukaTutup = "Jam Buka: - "
            }
            if(kulinerItem.kordinat != null){
                kordinat = "Titik Koordinat: " + kulinerItem.kordinat
            } else{
                kordinat = "Titik Koordinat: - "
            }
            if(kulinerItem.nama != null){
                nama = kulinerItem.nama
            } else{
                nama = " - "
            }
            if(kulinerItem.gambar_url != null){
                gambar = kulinerItem.gambar_url
            } else{
                gambar = " - "
            }
            if(kulinerItem.kategori != null){
                kategori = "Kategori: " + kulinerItem.kategori
            } else{
                kategori = "Kategori: - "
            }
            if(kulinerItem.alamat != null){
                alamat = "Alamat: " + kulinerItem.alamat
            } else{
                alamat = "Alamat: - "
            }

        }
    }
}