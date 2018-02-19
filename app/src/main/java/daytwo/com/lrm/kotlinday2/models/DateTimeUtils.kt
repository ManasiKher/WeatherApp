package daytwo.com.lrm.kotlinday2.models

import android.text.format.DateFormat
import java.util.*

/**
 * Created by manasi on 7/2/18.
 */
class DateTimeUtils {

    companion object {
        fun getDate(time: Long): String {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            cal.setTimeInMillis(time)
            return DateFormat.format("dd-MM-yyyy", cal).toString()
        }


        fun getDay(time: Long?): String {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            if (time != null) {
                cal.setTimeInMillis(time)
            }
            return DateFormat.format("EEEE", cal).toString()
        }

        fun getDateTime(time: Long?): String {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            time?.let { cal.setTimeInMillis(it) }
            return DateFormat.format("hh a", cal).toString()
        }

        fun getDayTime(time: Long?): String {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            time?.let { cal.setTimeInMillis(it) }
            return DateFormat.format("EEEE hh a", cal).toString()
        }
    }

}