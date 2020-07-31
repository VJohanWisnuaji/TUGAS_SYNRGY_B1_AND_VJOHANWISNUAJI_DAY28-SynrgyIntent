package com.studytrial.synrgyintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_parcelable.*

class ActivityParcelable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val dataParcel = intent.getParcelableExtra<DataParcel>("DATA_PARCELABLE") as DataParcel
        val inputNama = dataParcel.nama
        val inputUsia = dataParcel.umur.toString()

        tv_parcelable_nama.setText("Nama: $inputNama")
        tv_parcelable_umur.setText("Umur: $inputUsia Tahun")

        btn_back_parcelable.setOnClickListener {
            finish()
        }
    }
}