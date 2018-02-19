package daytwo.com.lrm.kotlinday2.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import daytwo.com.lrm.kotlinday2.R
import daytwo.com.lrm.kotlinday2.models.DateTimeUtils
import daytwo.com.lrm.kotlinday2.network.response.DataResponse
import daytwo.com.lrm.kotlinday2.network.response.MainWeatherResponse

/**
 * Created by manasi on 5/2/18.
 */
class DayFragment : Fragment() {

    private lateinit var response: DataResponse
    private lateinit var recyclerViewVertical:RecyclerView
    private lateinit var recyclerViewHorizontal:RecyclerView
    private lateinit var verticalAdapter: VerticalAdapter
    private lateinit var horizontalAdapter: HorizontalAdapter
    private lateinit var tvCityName:TextView
    private lateinit var  tvWeatherReport:TextView
    private lateinit var  tvTemperature:TextView
    private lateinit var tvTempVal:TextView
    private lateinit var tvDayDetails :TextView
    private lateinit var tvWeatherSummary:TextView
    private lateinit var tvSunrise:TextView
    private lateinit var tvSunset:TextView
    private lateinit var tvHumidity:TextView
    private lateinit var tvWind :TextView
    private lateinit var tvPrecipitation: TextView
    private lateinit var tvPressure: TextView
    private lateinit var tvUvIndex:TextView
    private var verticalList:List<MainWeatherResponse>? = null
    private var horizontalList:List<MainWeatherResponse> ?=null
    companion object {
        val ARG_RES:String ="ARG_RES"
        fun newInstance(response: DataResponse): DayFragment {
            val fragment = DayFragment()
            val args = Bundle()
            // assign its Value
            args.putSerializable(ARG_RES, response)
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments.getSerializable(ARG_RES) != null) {
            response = arguments.getSerializable(ARG_RES) as DataResponse
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater!!.inflate(R.layout.fragment_day, container, false)
        tvCityName =root.findViewById(R.id.tv_city_name) as TextView
        tvWeatherReport=root.findViewById(R.id.tv_weather_report) as TextView
        tvTemperature=root.findViewById(R.id.tv_city_temperature) as TextView
        recyclerViewVertical = root.findViewById(R.id.rv_vertical) as RecyclerView
        recyclerViewHorizontal = root.findViewById(R.id.rv_horizontal) as RecyclerView
        tvTempVal =root.findViewById(R.id.tv_day_temp_details)
        tvDayDetails=root.findViewById(R.id.tv_day_details)
        tvWeatherSummary=root.findViewById(R.id.tv_weather_summary)
        tvSunrise=root.findViewById(R.id.tv_sunrise)
        tvSunset=root.findViewById(R.id.tv_sunset)
        tvHumidity=root.findViewById(R.id.tv_humidity)
        tvWind =root.findViewById(R.id.tv_wind)
        tvPrecipitation=root.findViewById(R.id.tv_precipitation)
        tvPressure=root.findViewById(R.id.tv_pressure)
        tvUvIndex=root.findViewById(R.id.tv_uv_index)
        setData()
        return root
    }


    fun setData()
    {
        //adding a layoutmanager
        recyclerViewVertical.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
        recyclerViewHorizontal.layoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false) as RecyclerView.LayoutManager?

        verticalList= ArrayList<MainWeatherResponse>() as List<MainWeatherResponse>?
        horizontalList=  ArrayList<MainWeatherResponse>()
        verticalList = response.getDaily()?.getData()
        verticalAdapter = VerticalAdapter(verticalList)

        horizontalList = response.getDaily()?.getData()
        horizontalAdapter = HorizontalAdapter(horizontalList)
        //now adding the adapter to recyclerview
        recyclerViewVertical.adapter = verticalAdapter
        recyclerViewHorizontal.adapter = horizontalAdapter

        tvCityName.text = "Pune"
        tvWeatherReport.text = response.getCurrently()?.getSummary().toString()
        tvTemperature.text= response.getCurrently()?.getTemperature().toString()

        val temp1 =response.getCurrently()?.getTemperature()
        val temp2 =response.getCurrently()?.getApparentTemperature()
        tvTempVal.text= " ${temp1?.toInt()} ${temp2?.toInt()} "

        tvDayDetails.text="${DateTimeUtils.getDay(response.getCurrently()?.getTime()?.toLong())} today"

        var summary=response.getHourly()?.getSummary()
        tvWeatherSummary.text= "Weather Summary: $summary"
        var sunrise=response.getHourly()?.getData()?.get(0)?.getTime().toString()
        tvSunrise.text= "Sunrise: $sunrise"
        var sunset=response.getHourly()?.getData()?.get(0)?.getTime().toString()
        tvSunset.text= "Sunset: $sunset"
        var windSpeed = response.getCurrently()?.getWindSpeed().toString()
        tvWind.text="WindSpeed: $windSpeed"
        var humidity = response.getCurrently()?.getHumidity().toString()
        tvHumidity.text= "Humidity: $humidity"
        var precipitation = response.getCurrently()?.getPrecipIntensity().toString()
        tvPrecipitation.text="Precipitation: $precipitation"
        var pressure = response.getCurrently()?.getPressure().toString()
        tvPressure.text="Pressure: $pressure"

        var uvIndex = response.getCurrently()?.getUvIndex().toString()
        tvUvIndex.text="Uv Index: $uvIndex"
    }







}