package com.studytrial.synrgyintent

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataParcel(val nama: String, val umur: Int) : Parcelable
