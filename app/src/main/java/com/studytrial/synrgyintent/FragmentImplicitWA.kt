package com.studytrial.synrgyintent

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_implicit_w_a.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentImplicitWA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentImplicitWA : Fragment() {
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
        return inflater.inflate(R.layout.fragment_implicit_w_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_wa.setOnClickListener {
            val code = "62"
            val nomer = et_wa_nomer.text.toString()
            if (et_wa_nomer.text.toString().isEmpty() && et_wa_pesan.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(
                    context,
                    "Masukan nomer tujuan dan pesan yang ingin dikirimkan",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (nomer.length <= 0) {
                    Toast.makeText(this.context, "Isi Nomer Tujuan", Toast.LENGTH_SHORT).show()
                } else {
                    val isWhatsappInstalled: Boolean = whatsappInstalledOrNot("com.whatsapp")

                    if (isWhatsappInstalled) {
                        val pesan = et_wa_pesan.text
                        val sendIntent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(
                                "https://wa.me/$code$nomer?text=$pesan"
                            )
                        }
                        startActivity(sendIntent)
                        et_wa_nomer.setText("")
                        et_wa_pesan.setText("")
                    } else {
                        Toast.makeText(
                            this.context,
                            "WhatsApp belum terinstall",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun whatsappInstalledOrNot(uri: String): Boolean {
        val packageManager = activity!!.packageManager
        var app_installed = false
        try {
            packageManager.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            app_installed = true
        } catch (e: PackageManager.NameNotFoundException) {
            app_installed = false
        }
        return app_installed
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentImplicitWA.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentImplicitWA().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}