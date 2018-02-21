package daytwo.com.lrm.kotlinday2.models

import android.text.format.DateFormat
import java.util.*

import java.text.SimpleDateFormat


/**
 * Created by manasi on 7/2/18.
 */
class DateTimeUtils {

    companion object {
        fun getDate(time: Long?): String {
            val sdf = SimpleDateFormat("dd-MM-yyyy")
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"))
            val calendar = Calendar.getInstance()
            if(time!=null) {
                calendar.timeInMillis = time*1000L
            }
            val tz = TimeZone.getDefault()
            sdf.setTimeZone(tz)
            return sdf.format(calendar.time)
        }


        fun getDay(time: Long?): String {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            if (time != null) {
                cal.setTimeInMillis(time*1000L)
            }
            return DateFormat.format("EEEE", cal).toString()
        }

        fun getDateTime(time: Long?): String {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            if(time!=null) {
                cal.setTimeInMillis(time * 1000L)
            }
            return DateFormat.format("hh a", cal).toString()
        }

        fun getDayTime(time: Long?): String {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            if(time!=null) {
                cal.setTimeInMillis(time * 1000L)
            }
            return DateFormat.format("EEEE hh a", cal).toString()
        }
    }

}