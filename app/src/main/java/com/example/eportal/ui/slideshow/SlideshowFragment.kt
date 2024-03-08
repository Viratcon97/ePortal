package com.example.eportal.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eportal.adapter.slideshow.UserListAdapter
import com.example.eportal.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        //No data found textview
        val errorNoDataFound : TextView = binding.textNoData

        //Recycler View setup
        val userListRecyclerView : RecyclerView = binding.userList
        val linearLayoutManager = LinearLayoutManager(activity)
        userListRecyclerView.layoutManager = linearLayoutManager

        //Check if user list is empty or not
        if(slideshowViewModel.recyclerView.isEmpty()){
            //Show No Data Found
            userListRecyclerView.visibility = View.GONE
            errorNoDataFound.visibility = View.VISIBLE
        }else{
            //Show Users from List
            val adapter = UserListAdapter(slideshowViewModel.recyclerView)
            userListRecyclerView.adapter = adapter
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}