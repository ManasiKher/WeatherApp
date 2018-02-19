package daytwo.com.lrm.kotlinday2.views

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import daytwo.com.lrm.kotlinday2.R
import daytwo.com.lrm.kotlinday2.models.DateTimeUtils
import daytwo.com.lrm.kotlinday2.network.response.MainWeatherResponse

/**
 * Created by manasi on 6/2/18.
 */
class VerticalAdapter (val timeSlotList: List<MainWeatherResponse>?) : RecyclerView.Adapter<VerticalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: VerticalAdapter.ViewHolder, position: Int) {
        holder.bindItems(timeSlotList?.get(position))
    }

    override fun getItemCount(): Int {
        if (timeSlotList==null)
        {
            return 0;
        }
        return timeSlotList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(timeSlot: MainWeatherResponse?)
        {
            val tvDay = itemView.findViewById(R.id.tv_day_time) as TextView
            val ivDayTime  = itemView.findViewById(R.id.iv_day_time) as ImageView
            val tvDatTemp =itemView.findViewById(R.id.tv_day_temp) as TextView

            tvDay.text = timeSlot?.getTime().toString()
            var dateTime = DateTimeUtils.getDayTime(timeSlot?.getTime()?.toLong())
            tvDay.text = "$dateTime"

            tvDatTemp.text = timeSlot?.getTemperature().toString()


            if(timeSlot?.getIcon().equals("clear-day"))
            {
                ivDayTime.setBackgroundResource(R.drawable.sun)
            }

            else if(timeSlot?.getIcon().equals("cloudy"))
            {
                ivDayTime.setBackgroundResource(R.drawable.cloud)
            }
            else if(timeSlot?.getIcon().equals("partly-cloudy-day"))
            {
                ivDayTime.setBackgroundResource(R.drawable.subnet)
            }
            else if(timeSlot?.getIcon().equals("clear-night"))
            {
                ivDayTime.setBackgroundResource(R.drawable.moon)
            }
            else if(timeSlot?.getIcon().equals("partly-cloudy-night"))
            {
                ivDayTime.setBackgroundResource(R.drawable.wan)
            }


        }
    }

}