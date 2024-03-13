package com.example.eportal.ui.slideshow

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
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

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        //No data found textview
        val errorNoDataFound : TextView = binding.textNoData

        //Recycler View setup
        val userListRecyclerView : RecyclerView = binding.userList
        val linearLayoutManager = LinearLayoutManager(activity)
        userListRecyclerView.layoutManager = linearLayoutManager

        //Check if user list is empty or not
        if(slideshowViewModel.usersList.isEmpty()){
            //Show No Data Found
            userListRecyclerView.visibility = View.GONE
            errorNoDataFound.visibility = View.VISIBLE
        }else{
            //Show Users from List

            //Sorted List
            //val list = slideshowViewModel.recyclerView.sorted().toMutableList()

            //Normal List

            val list = slideshowViewModel.usersList

            val adapter = UserListAdapter(list, onDeleteClick = { _user, position ->

                val dialog = MaterialDialog(requireActivity())
                dialog.title(text = "Warning")
                dialog.message(text = "Are you sure to delete the Item?")
                dialog.positiveButton {
                    if (position >= 0 && position < list.size) {
                        list.removeAt(position)
                        userListRecyclerView.adapter?.notifyItemRemoved(position)
                        userListRecyclerView.adapter?.notifyItemRangeChanged(position,list.size)
                    }
                }
                dialog.negativeButton {
                    it.dismiss()
                }
                dialog.show()

            }, onEditClick = { _user, position ->
                //userListRecyclerView.adapter?.no
                _user.name = "V"
                _user.city = "W"
                userListRecyclerView.adapter?.notifyItemChanged(position)
            })
            //val adapter = UserListAdapter(list)
            userListRecyclerView.adapter = adapter

        }
        binding.btnAdd.setOnClickListener {
            val name = "A"
            val city = "K"
            slideshowViewModel.usersList.add(User(name,city))
            userListRecyclerView.adapter?.notifyDataSetChanged()

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
data class User(
    var name : String,
    var city : String
)