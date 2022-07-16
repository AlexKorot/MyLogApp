package com.onix.internship.task

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.calender.CalendarUtils
import com.onix.internship.databinding.MainTaskFragmentBinding
import com.onix.internship.calender.CalendarUtils.Companion.DISPLAY_MONTH_FORMAT
import com.onix.internship.calender.HorizontalRecyclerCalendarAdapter
import com.onix.internship.calender.RecyclerCalendarConfiguration
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class MainTaskFragment: BaseFragment<MainTaskFragmentBinding>(R.layout.main_task_fragment) {
    override val viewModel: SplashViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigation.setOnItemSelectedListener{
            when(it.itemId) {

                    R.id.home_main -> {
                        navigate(R.id.developFragment, clearStack = false)
                true
            }
                R.id.activity -> {
                    navigate(R.id.developFragment, clearStack = false)
                    true
                }
                R.id.document -> {
                    navigate(R.id.mDialogFragment, clearStack = false)
                true
            }
                R.id.folder -> {
                    navigate(R.id.developFragment, clearStack = false)
                    true
                }
                else -> false
            }
        }

    val calendarRecyclerView: RecyclerView=binding.calendarRecyclerView
    val date = Date()
    date.time = System.currentTimeMillis()

    val startCal = Calendar.getInstance()
        val endCal = Calendar.getInstance()
    endCal.time = date
    endCal.add(Calendar.DAY_OF_WEEK, 0)

    val configuration: RecyclerCalendarConfiguration =
        RecyclerCalendarConfiguration(
            calenderViewType = RecyclerCalendarConfiguration.CalenderViewType.HORIZONTAL,
            calendarLocale = Locale.getDefault(),
            includeMonthHeader = true
        )
    configuration.weekStartOffset = RecyclerCalendarConfiguration.START_DAY_OF_WEEK.MONDAY

   binding.tvMound.text =
    CalendarUtils.dateStringFromFormat(
    locale = configuration.calendarLocale,
    date = date,
    format = DISPLAY_MONTH_FORMAT
    ) ?: ""

    val calendarAdapterHorizontal: HorizontalRecyclerCalendarAdapter =
        HorizontalRecyclerCalendarAdapter(
            startDate = startCal.time,
            endDate = endCal.time,
            configuration = configuration,
            selectedDate = date,
            dateSelectListener = object : HorizontalRecyclerCalendarAdapter.OnDateSelected {
                override fun onDateSelected(date: Date) {
                  binding.textViewSelectedDate.text =
            CalendarUtils.dateStringFromFormat(
                            locale = configuration.calendarLocale,
                            date = date,
                            format = CalendarUtils.LONG_DATE_FORMAT
                        )
                            ?: ""
                }
            }
        )

    calendarRecyclerView.adapter = calendarAdapterHorizontal

    val snapHelper = PagerSnapHelper() // Or LinearSnapHelper
    snapHelper.attachToRecyclerView(calendarRecyclerView)


}
}

