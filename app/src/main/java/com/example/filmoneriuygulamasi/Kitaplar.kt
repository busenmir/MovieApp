package com.example.filmoneriuygulamasi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kitaplar(var id : Int, var resim : Int, var yazi :String,var aciklama : String ) : Parcelable {
}