package com.example.eportal.ui.gallery

import android.app.AlertDialog
import android.app.Dialog
import android.content.ClipData.Item
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.eportal.R
import com.example.eportal.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, galleryViewModel.itemList)
        binding.listView.adapter = adapter



        /*binding.listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position).toString()

            val dialog = AlertDialog.Builder(requireActivity())
            dialog.setTitle("Selected Item!")
            dialog.setMessage(selectedItem)
            dialog.setCancelable(true)
            dialog.setPositiveButton("Yes") { dialog, _ ->
                dialog.dismiss()
            }
            dialog.show()
            //Toast.makeText(requireActivity(),selectedItem, Toast.LENGTH_LONG).show()
        }*/
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}