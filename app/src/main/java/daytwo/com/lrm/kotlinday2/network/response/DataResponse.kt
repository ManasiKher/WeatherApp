package daytwo.com.lrm.kotlinday2.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * Created by manasi on 5/2/18.
 */
class DataResponse : Serializable {

    @SerializedName("latitude")
    @Expose
    private var latitude: Double = 0.toDouble()
    @SerializedName("longitude")
    @Expose
    private var longitude: Double = 0.toDouble()
    @SerializedName("timezone")
    @Expose
    private var timezone: String? = null
    @SerializedName("currently")
    @Expose
    private var currently: CurrentlyResponse? = null
    @SerializedName("hourly")
    @Expose
    private var hourly: HourlyResponse? = null
    @SerializedName("daily")
    @Expose
    private var daily: DailyResponse? = null
    @SerializedName("flags")
    @Expose
    private var flags: FlagsResponse? = null
    @SerializedName("offset")
    @Expose
    private var offset: Double = 0.toDouble()

    fun getLatitude(): Double {
        return latitude
    }

    fun setLatitude(latitude: Double) {
        this.latitude = latitude
    }

    fun getLongitude(): Double {
        return longitude
    }

    fun setLongitude(longitude: Double) {
        this.longitude = longitude
    }

    fun getTimezone(): String? {
        return timezone
    }

    fun setTimezone(timezone: String) {
        this.timezone = timezone
    }

    fun getCurrently(): CurrentlyResponse? {
        return currently
    }

    fun setCurrently(currently: CurrentlyResponse) {
        this.currently = currently
    }

    fun getHourly(): HourlyResponse? {
        return hourly
    }

    fun setHourly(hourly: HourlyResponse) {
        this.hourly = hourly
    }

    fun getDaily(): DailyResponse? {
        return daily
    }

    fun setDaily(daily: DailyResponse) {
        this.daily = daily
    }

    fun getFlags(): FlagsResponse? {
        return flags
    }

    fun setFlags(flags: FlagsResponse) {
        this.flags = flags
    }

    fun getOffset(): Double {
        return offset
    }

    fun setOffset(offset: Double) {
        this.offset = offset
    }

}