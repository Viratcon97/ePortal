package com.example.eportal.ui.gallery

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.eportal.R
import com.example.eportal.databinding.FragmentGalleryBinding
import com.example.eportal.model.JsonResponse
import com.google.gson.Gson
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset

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

        //Reading JSON File
        val jsonFileName = R.raw.dummy
        val jsonData = readJsonFromRaw(requireActivity(),jsonFileName)
        val gson = Gson()
        val data = gson.fromJson(jsonData.toString(),JsonResponse::class.java)


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

    private fun readJsonFromRaw(context: Context, resourceId: Int): JSONObject {
        val inputStream: InputStream = context.resources.openRawResource(resourceId)
        val json = inputStream.bufferedReader(Charset.defaultCharset()).use { it.readText() }
        return JSONObject(json)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}