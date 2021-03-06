package com.studytrial.synrgyintent

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_bundle.*
import kotlinx.android.synthetic.main.fragment_parcelable.*
import kotlinx.android.synthetic.main.fragment_serializable.*
import java.lang.NumberFormatException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSerializable.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSerializable : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_serializable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_serializable.setOnClickListener {
            if (et_serializable_nama.text.toString().isEmpty() && et_serializable_umur.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(
                    context,
                    "Masukan Nama dan Umur",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val nama = et_serializable_nama.text
                val umur = Integer.parseInt(et_serializable_umur.text.toString())
                val dataSeri = DataSeri("$nama", umur)
                val intent = Intent(context, ActivitySerializable::class.java)
                intent.putExtra("DATA_SERIALIZABLE", dataSeri)
                startActivity(intent)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentSerializable.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSerializable().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}