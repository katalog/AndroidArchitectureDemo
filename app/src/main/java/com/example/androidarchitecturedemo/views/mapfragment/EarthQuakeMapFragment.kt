package com.example.androidarchitecturedemo.views.mapfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidarchitecturedemo.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1_MAP = "param1"
private const val ARG_PARAM2_MAP = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [EarthQuakeMapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EarthQuakeMapFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1_MAP)
            param2 = it.getString(ARG_PARAM2_MAP)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_earth_quake_map, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EarthQuakeMapFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EarthQuakeMapFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1_MAP, param1)
                    putString(ARG_PARAM2_MAP, param2)
                }
            }
    }
}