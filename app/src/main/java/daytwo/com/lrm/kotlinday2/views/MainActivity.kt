package daytwo.com.lrm.kotlinday2.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import daytwo.com.lrm.kotlinday2.R
import daytwo.com.lrm.kotlinday2.network.ApiCallInterface
import daytwo.com.lrm.kotlinday2.network.response.DataResponse
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// json api call https://api.darksky.net/forecast/683447a9451d48fa77948f968e4ecff0/18.5204,73.8567
class MainActivity : AppCompatActivity() {

    private lateinit var viewPager:ViewPager
    private lateinit var pagerAdapter: DayPagerAdapter
    private lateinit var response: DataResponse
    private lateinit var apiCallInterface: ApiCallInterface
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private lateinit var call: Call<DataResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager=findViewById(R.id.vp_day)
        response= DataResponse()
        apiCallInterface = ApiCallInterface.create()
        callApi()
        setData(response)
    }

    fun callApi()
    {

        call = apiCallInterface.getData()
        call.enqueue(object : Callback<DataResponse> { //anonymous inner class. No lambda because there are two methods in Callback interface
            override fun onResponse(call: Call<DataResponse>, responseMain: Response<DataResponse>)
            {
               if(responseMain.body()!=null)
               {
                   response = responseMain.body() as DataResponse
                   setData(response)
               }
            }
            override fun onFailure(call: Call<DataResponse>, t: Throwable){}
        })
    }

    fun setData(response: DataResponse)
    {
        pagerAdapter = DayPagerAdapter(supportFragmentManager, response)
        viewPager.adapter = pagerAdapter
    }




}
