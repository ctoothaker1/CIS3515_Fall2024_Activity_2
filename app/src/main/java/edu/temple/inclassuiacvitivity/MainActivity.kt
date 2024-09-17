package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 2: Populate this array with multiples of 5 from 5 - 100*/
//        val numberArray = arrayOf(int)
//        for (i in 1..20){
//            numberArray.add(i*5)
//       }
        //println(numberArray)
        //println(numberArray.joinToString(" "))
        val numberArray = Array(20) { index -> (index + 1) * 5 }
        /* TODO Step 3: Create adapter to display items from array in Spinner */

        spinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, numberArray)

        // TODO Step 4: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>, p1: View?, position: Int, id: Long) {
                p1?.run {
                    val selectedSize = numberArray[position]
                    displayTextView.textSize = selectedSize.toFloat()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // do nothing
            }


        }
    }
}