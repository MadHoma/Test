package madhoma.test.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class State(
    @SerializedName("id") val id: Int,
    @SerializedName("country") val country: String,
    @SerializedName("name") val name: String,
    @SerializedName("abbr") val abbr: String,
    @SerializedName("area") val area: String,
    @SerializedName("largest_city") val largest_city: String,
    @SerializedName("capital") val capital: String
): Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    fun info(): String{
        return "$country $abbr"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(country)
        parcel.writeString(name)
        parcel.writeString(abbr)
        parcel.writeString(area)
        parcel.writeString(largest_city)
        parcel.writeString(capital)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<State> {
        override fun createFromParcel(parcel: Parcel): State {
            return State(parcel)
        }

        override fun newArray(size: Int): Array<State?> {
            return arrayOfNulls(size)
        }
    }
}