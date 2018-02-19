package daytwo.com.lrm.kotlinday2.views

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import daytwo.com.lrm.kotlinday2.network.response.DataResponse

/**
 * Created by manasi on 5/2/18.
 */
class DayPagerAdapter (fragmentManager: FragmentManager, private val response: DataResponse) :
    FragmentStatePagerAdapter(fragmentManager) {

    // METHOD 2
    override fun getItem(position: Int): Fragment {
        return DayFragment.newInstance(response)
    }

    // METHOD 3
    override fun getCount(): Int {
        return 3
    }
}