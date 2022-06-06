package hey.there.calcage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private var sdate:TextView?=null
    private var hello:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button5: Button = findViewById(R.id.button5)
        sdate=findViewById(R.id.sdate)
        hello=findViewById(R.id.head7)
        button5.setOnClickListener {
            clickdatepicker()
        }
    }

    private fun clickdatepicker(){
        val mycalendar= Calendar.getInstance()
        val year= mycalendar.get(Calendar.YEAR)
        val month= mycalendar.get(Calendar.MONTH)
        val day=mycalendar.get(Calendar.DAY_OF_MONTH)
        val sudhanshu=DatePickerDialog(this,
        {_, Year, Month, dayofmonth ->

            Toast.makeText(
                this,
               "year was $Year, month was ${Month+1}, day was $dayofmonth", Toast.LENGTH_LONG
            ).show()


            val selectedDate= "$dayofmonth.${month+1}.$year"
            sdate?.text=selectedDate

            val sdk=SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)
            val thedate=sdk.parse(selectedDate)
            thedate?.let {
                val selectedDateInMinutes=thedate.time/60000
                val currentdate=sdk.parse(sdk.format(System.currentTimeMillis()))
                currentdate?.let {
                    val currentDateInMinutes=currentdate.time/60000
                    val  differenceInMinutes= currentDateInMinutes-selectedDateInMinutes
                    hello?.text=differenceInMinutes.toString()
                }

            }




        },
        year,
        month,
        day
        )
        sudhanshu.datePicker.maxDate=System.currentTimeMillis()-86400000
        sudhanshu.show()




    }

}