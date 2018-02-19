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
class HorizontalAdapter(val timeSlotList: List<MainWeatherResponse>?) : RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalAdapter.ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal, parent, false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: HorizontalAdapter.ViewHolder, position: Int) {
            holder.bindItems(timeSlotList)
        }

        override fun getItemCount(): Int {
            if (timeSlotList==null)
            {
                return 0;
            }
            return timeSlotList.size
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bindItems(timeSlotList: List<MainWeatherResponse>?)
            {
                val tvDay = itemView.findViewById(R.id.tv_day_time) as TextView
                val ivDayTime  = itemView.findViewById(R.id.iv_day_time) as ImageView
                val tvDatTemp =itemView.findViewById(R.id.tv_day_temp) as TextView

                var dateTime = DateTimeUtils.getDateTime(timeSlotList?.get(position)?.getTime()?.toLong())
                tvDay.text = "Time: $dateTime"
                if(timeSlotList?.get(position)?.getIcon().equals("clear-day"))
                {
                    ivDayTime.setBackgroundResource(R.drawable.sun)
                }

                else if(timeSlotList?.get(position)?.getIcon().equals("cloudy"))
                {
                    ivDayTime.setBackgroundResource(R.drawable.cloud)
                }
                else if(timeSlotList?.get(position)?.getIcon().equals("partly-cloudy-day"))
                {
                    ivDayTime.setBackgroundResource(R.drawable.subnet)
                }
                else if(timeSlotList?.get(position)?.getIcon().equals("clear-night"))
                {
                    ivDayTime.setBackgroundResource(R.drawable.moon)
                }
                else if(timeSlotList?.get(position)?.getIcon().equals("partly-cloudy-night"))
                {
                    ivDayTime.setBackgroundResource(R.drawable.wan)
                }

                tvDatTemp.text = timeSlotList?.get(position)?.getTemperature().toString()

            }
        }

}