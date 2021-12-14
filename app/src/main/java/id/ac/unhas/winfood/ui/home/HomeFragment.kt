 package id.ac.unhas.winfood.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.unhas.winfood.Adapter.HomeAdapter
import id.ac.unhas.winfood.KulinerItem
import id.ac.unhas.winfood.R
import id.ac.unhas.winfood.ui.selected.SelectedKuliner
import id.ac.unhas.winfood.utilities.StaticData
import kotlinx.android.synthetic.main.fragment_home.*

 class HomeFragment : Fragment() {

    lateinit var viewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HomeFragment", "onCreate Called")
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("HomeFragment", "onCreateView Called")
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("HomeFragment", "onViewCreated Called")

        recyview_home.setHasFixedSize(true)
        recyview_home.layoutManager= LinearLayoutManager(context)

        if(viewModel.listMakanan.size==0) {
            viewModel.getDataFromApi(recyview_home,progressBar, object : HomeViewModel.onClickListener{
                override fun onClick(kulinerItem: KulinerItem) {
                    StaticData.fill(kulinerItem)
                    val fragment: Fragment = SelectedKuliner.newInstance()
                    val fragmentManager:FragmentManager = activity!!.supportFragmentManager
                    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.container_fragment, fragment)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            } )
        } else {
            recyview_home.adapter= HomeAdapter(viewModel.listMakanan, object : HomeAdapter.OnItemClickListener{
                override fun onClick(kulinerItem: KulinerItem) {
                    StaticData.fill(kulinerItem)
                    val fragment: Fragment = SelectedKuliner.newInstance()
                    val fragmentManager:FragmentManager = activity!!.supportFragmentManager
                    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.container_fragment, fragment)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            })
            progressBar.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeFragment", "onDestroy Called")
    }


    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}