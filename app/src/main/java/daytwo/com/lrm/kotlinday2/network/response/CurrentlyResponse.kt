package daytwo.com.lrm.kotlinday2.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by manasi on 5/2/18.
 */
class CurrentlyResponse {
    @SerializedName("time")
    @Expose
    private var time: Int = 0
    @SerializedName("summary")
    @Expose
    private var summary: String? = null
    @SerializedName("icon")
    @Expose
    private var icon: String? = null
    @SerializedName("precipIntensity")
    @Expose
    private var precipIntensity: Double = 0.0
    @SerializedName("precipProbability")
    @Expose
    private var precipProbability: Double = 0.0
    @SerializedName("temperature")
    @Expose
    private var temperature: Double = 0.toDouble()
    @SerializedName("apparentTemperature")
    @Expose
    private var apparentTemperature: Double = 0.toDouble()
    @SerializedName("dewPoint")
    @Expose
    private var dewPoint: Double = 0.toDouble()
    @SerializedName("humidity")
    @Expose
    private var humidity: Double = 0.toDouble()
    @SerializedName("pressure")
    @Expose
    private var pressure: Double = 0.toDouble()
    @SerializedName("windSpeed")
    @Expose
    private var windSpeed: Double = 0.toDouble()
    @SerializedName("windGust")
    @Expose
    private var windGust: Double = 0.toDouble()
    @SerializedName("windBearing")
    @Expose
    private var windBearing: Int = 0
    @SerializedName("cloudCover")
    @Expose
    private var cloudCover: Double = 0.toDouble()
    @SerializedName("uvIndex")
    @Expose
    private var uvIndex: Int = 0
    @SerializedName("ozone")
    @Expose
    private var ozone: Double = 0.toDouble()

    fun getTime(): Int {
        return time
    }

    fun setTime(time: Int) {
        this.time = time
    }

    fun getSummary(): String? {
        return summary
    }

    fun setSummary(summary: String) {
        this.summary = summary
    }

    fun getIcon(): String? {
        return icon
    }

    fun setIcon(icon: String) {
        this.icon = icon
    }

    fun getPrecipIntensity(): Double {
        return precipIntensity
    }

    fun setPrecipIntensity(precipIntensity: Double) {
        this.precipIntensity = precipIntensity
    }

    fun getPrecipProbability(): Double {
        return precipProbability
    }

    fun setPrecipProbability(precipProbability: Double) {
        this.precipProbability = precipProbability
    }

    fun getTemperature(): Double {
        return temperature
    }

    fun setTemperature(temperature: Double) {
        this.temperature = temperature
    }

    fun getApparentTemperature(): Double {
        return apparentTemperature
    }

    fun setApparentTemperature(apparentTemperature: Double) {
        this.apparentTemperature = apparentTemperature
    }

    fun getDewPoint(): Double {
        return dewPoint
    }

    fun setDewPoint(dewPoint: Double) {
        this.dewPoint = dewPoint
    }

    fun getHumidity(): Double {
        return humidity
    }

    fun setHumidity(humidity: Double) {
        this.humidity = humidity
    }

    fun getPressure(): Double {
        return pressure
    }

    fun setPressure(pressure: Double) {
        this.pressure = pressure
    }

    fun getWindSpeed(): Double {
        return windSpeed
    }

    fun setWindSpeed(windSpeed: Double) {
        this.windSpeed = windSpeed
    }

    fun getWindGust(): Double {
        return windGust
    }

    fun setWindGust(windGust: Double) {
        this.windGust = windGust
    }

    fun getWindBearing(): Int {
        return windBearing
    }

    fun setWindBearing(windBearing: Int) {
        this.windBearing = windBearing
    }

    fun getCloudCover(): Double {
        return cloudCover
    }

    fun setCloudCover(cloudCover: Double) {
        this.cloudCover = cloudCover
    }

    fun getUvIndex(): Int {
        return uvIndex
    }

    fun setUvIndex(uvIndex: Int) {
        this.uvIndex = uvIndex
    }

    fun getOzone(): Double {
        return ozone
    }

    fun setOzone(ozone: Double) {
        this.ozone = ozone
    }

}