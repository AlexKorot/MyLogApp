package com.onix.internship.task

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.calender.CalendarUtils
import com.onix.internship.calender.RecyclerCalendarConfiguration
import com.onix.internship.calender.SimpleEvent

import java.util.*

class mDialogFragment:DialogFragment  (R.layout.dialog_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStyle(STYLE_NO_FRAME,R.style.AppDialogTheme)
            //   val calendarRecyclerView  = findViewById<RecyclerView>(R.id.calendarRecyclerView)

        val date = Date()
        date.time = System.currentTimeMillis()

        val startCal = Calendar.getInstance()

        val endCal = Calendar.getInstance()
        endCal.time = date
        endCal.add(Calendar.MONTH, 12)

        val configuration: RecyclerCalendarConfiguration =
            RecyclerCalendarConfiguration(
                calenderViewType = RecyclerCalendarConfiguration.CalenderViewType.VERTICAL,
                calendarLocale = Locale.getDefault(),
                includeMonthHeader = true
            )

        configuration.weekStartOffset = RecyclerCalendarConfiguration.START_DAY_OF_WEEK.MONDAY

    /*    // Some Random Events
        for (i in 0..30 step 3) {
            val eventCal = Calendar.getInstance()
            eventCal.add(Calendar.DATE, i * 3)
            val eventDate: Int =
                (CalendarUtils.dateStringFromFormat(
                    locale = configuration.calendarLocale,
                    date = eventCal.time,
                    format = CalendarUtils.DB_DATE_FORMAT
                )
                    ?: "0").toInt()
            eventMap[eventDate] = SimpleEvent(
                eventCal.time,
                "Event #$i",
                ContextCompat.getColor(applicationContext, R.color.colorAccent)
            )
        }

        val calendarAdapterVertical: VerticalRecyclerCalendarAdapter =
            VerticalRecyclerCalendarAdapter(
                startDate = startCal.time,
                endDate = endCal.time,
                configuration = configuration,
                eventMap = eventMap,
                dateSelectListener = object : VerticalRecyclerCalendarAdapter.OnDateSelected {
                    override fun onDateSelected(date: Date, event: SimpleEvent?) {
                        val selectedDate: String =
                            CalendarUtils.dateStringFromFormat(
                                locale = configuration.calendarLocale,
                                date = date,
                                format = CalendarUtils.LONG_DATE_FORMAT
                            )
                                ?: ""

                        if (event != null) {
                            AlertDialog.Builder(this@VerticalCalendarActivity)
                                .setTitle("Event Clicked")
                                .setMessage(
                                    String.format(
                                        Locale.getDefault(),
                                        "Date: %s\n\nEvent: %s",
                                        selectedDate,
                                        event.title
                                    )
                                )
                                .create()
                                .show()
                        }
                    }
                }
            );

       calendarRecyclerView.adapter = calendarAdapterVertical
    }*/
    }
}