package daytwo.com.lrm.kotlinday2.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by manasi on 5/2/18.
 */
class FlagsResponse {

    @SerializedName("sources")
    @Expose
    private var sources: List<String>? = null
    @SerializedName("isd-stations")
    @Expose
    private var isdStations: List<String>? = null
    @SerializedName("units")
    @Expose
    private var units: String? = null

    fun getSources(): List<String>? {
        return sources
    }

    fun setSources(sources: List<String>) {
        this.sources = sources
    }

    fun getIsdStations(): List<String>? {
        return isdStations
    }

    fun setIsdStations(isdStations: List<String>) {
        this.isdStations = isdStations
    }

    fun getUnits(): String? {
        return units
    }

    fun setUnits(units: String) {
        this.units = units
    }

}