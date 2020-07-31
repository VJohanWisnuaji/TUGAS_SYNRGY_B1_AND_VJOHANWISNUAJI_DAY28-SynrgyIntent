package com.studytrial.synrgyintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bundle.*
import kotlinx.android.synthetic.main.activity_serializable.*

class ActivitySerializable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serializable)

        val dataSeri = intent.getSerializableExtra("DATA_SERIALIZABLE") as DataSeri
        val inputNama = dataSeri.nama
        val inputUsia = dataSeri.umur.toString()

        tv_serializable_nama.setText("Nama: $inputNama")
        tv_serializable_umur.setText("Umur: $inputUsia Tahun")

        btn_back_serializable.setOnClickListener {
            finish()
        }
    }
}