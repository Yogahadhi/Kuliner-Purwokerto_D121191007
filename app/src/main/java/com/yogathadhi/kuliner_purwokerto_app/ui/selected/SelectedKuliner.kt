package com.yogathadhi.kuliner_purwokerto_app.ui.selected

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso


class SelectedKuliner : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_kuliner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get()
            .load(StaticData.gambar)
            .into(gambar_selected)

        nama_selected.text = StaticData.nama
        jam_selected.text = StaticData.jamBukaTutup
        alamat_selected.text = StaticData.alamat
        koordinat_selected.text = StaticData.kordinat
        kategori_selected.text = StaticData.kategori

        share.setOnClickListener{
            val nama = StaticData.nama.toUpperCase()
            val kategori = StaticData.kategori
            val alamat = StaticData.alamat
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Halo teman - teman, ketika mengunjungi kota Purwakerto jangan lupa mengunjungi " +
                        "$nama, deskripsinya adalah sebagai berikut! \n$kategori \n$alamat")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SelectedKuliner()
    }
}