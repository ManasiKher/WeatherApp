package daytwo.com.lrm.kotlinday2.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by manasi on 5/2/18.
 */
class DailyResponse
{
    @SerializedName("summary")
    @Expose
    private var summary: String? = null
    @SerializedName("icon")
    @Expose
    private var icon: String? = null
    @SerializedName("data")
    @Expose
    private var data: List<MainWeatherResponse>? = null

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

    fun getData(): List<MainWeatherResponse>? {
        return data
    }

    fun setData(data: List<MainWeatherResponse>) {
        this.data = data
    }

}