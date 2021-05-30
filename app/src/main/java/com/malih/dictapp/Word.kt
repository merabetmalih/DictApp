package com.malih.dictapp

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Word(val name:String, val description:String, val videoLink:String?=null, @RawRes val audioLink: Int?=null, @DrawableRes val picture:Int?=null): Parcelable