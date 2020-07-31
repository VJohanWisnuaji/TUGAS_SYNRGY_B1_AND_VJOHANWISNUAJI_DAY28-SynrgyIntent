package com.studytrial.synrgyintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bundle.*

class ActivityBundle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bundle)
        val bundle = intent.extras
        val inputNama = bundle!!.getString("nama")
        val inputUsia = bundle!!.getInt("umur").toString()

        textView.setText("Nama: $inputNama")
        textView2.setText("Umur: $inputUsia Tahun")

        btn_back_bundle.setOnClickListener {
            finish()
        }
    }
}