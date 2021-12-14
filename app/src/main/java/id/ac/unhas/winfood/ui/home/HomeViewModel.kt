package id.ac.unhas.winfood.ui.home

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.winfood.Adapter.HomeAdapter
import id.ac.unhas.winfood.DataKuliner
import id.ac.unhas.winfood.KulinerItem
import id.ac.unhas.winfood.Network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel:ViewModel() {

    init {
        Log.d("HomeVIewModel","Created")
    }

    var listMakanan : ArrayList<KulinerItem> = arrayListOf()


    interface onClickListener{
        fun onClick(kulinerItem: KulinerItem)
    }


    fun getDataFromApi(recyclerView: RecyclerView,progressBar:ProgressBar, listener : onClickListener){

        RetrofitClient.instance.getDataKuliner().enqueue(object :Callback<DataKuliner> {
            override fun onFailure(call: Call<DataKuliner>, t: Throwable) {
                Log.d("HomeViewModel", "onFailure")
            }

            override fun onResponse(call: Call<DataKuliner>, response: Response<DataKuliner>) {
                val data = response.body()?.kuliner
                listMakanan.addAll (data as ArrayList<KulinerItem>)
                recyclerView.adapter = HomeAdapter(data as ArrayList<KulinerItem>, object : HomeAdapter.OnItemClickListener{
                    override fun onClick(kulinerItem: KulinerItem) {
                        listener.onClick(kulinerItem)
                    }

                })
                progressBar.visibility = View.GONE
            }


        })
    }

}