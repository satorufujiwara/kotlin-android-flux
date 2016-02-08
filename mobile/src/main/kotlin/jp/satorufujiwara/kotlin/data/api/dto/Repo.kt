package jp.satorufujiwara.kotlin.data.api.dto

import android.os.Parcel
import android.os.Parcelable

data class Repo(var id: String, val name: String) : Parcelable {

    constructor(src: Parcel) : this(
            id = src.readString(),
            name = src.readString()
    )


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(id)
        dest?.writeString(name)
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Repo> = object : Parcelable.Creator<Repo> {
            override fun createFromParcel(source: Parcel): Repo? {
                return Repo(source)
            }

            override fun newArray(size: Int): Array<out Repo?>? {
                return arrayOfNulls(size)
            }
        }
    }
}
