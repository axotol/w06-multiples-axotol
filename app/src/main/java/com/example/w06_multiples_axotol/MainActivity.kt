package com.example.w06_multiples_axotol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvFactorLayout1 = findViewById<TextInputLayout>(R.id.tilFactor1)
        val tvFactor1 = findViewById<TextInputEditText>(R.id.factor1)
        val tvFactorLayout2 = findViewById<TextInputLayout>(R.id.tilFactor2)
        val tvFactor2 = findViewById<TextInputEditText>(R.id.factor2)
        val multiply = findViewById<Button>(R.id.btnMultiply)

        //val factor1 = Random.nextInt(from = 1, until = 13)
        //val factor2 = Random.nextInt(from = 1, until = 13)

        //tvFactor1.text = factor1.toString()
        //tvFactor2.text = factor2.toString()

        multiply.setOnClickListener {
            /* step 2
            val i = Intent(this, ResultActivity::class.java)
            i.putExtra("result", factor1 * factor2)
             */

            /* step 3
            val i = Intent(this, ResultActivity::class.java).apply {
                putExtra("factor1", factor1)
                putExtra("factor2", factor2)
            }
             */

            var proceed: Boolean = true

            var factor1 = -1
            var factor2 = -1

            if (tvFactor1.text.toString() == "") {
                tvFactor1.error = "Please enter a number" // or can use tvFactorLayout1
                proceed = false
            } else {
                factor1 = tvFactor1.text.toString().toInt()
                if (factor1 < 1 || factor1 > 12) {
                    tvFactor1.error = "Value must be between 1-12"
                    proceed = false
                } else {
                    tvFactor1.error = null
                }
            }

            if (tvFactor2.text.toString() == "") {
                tvFactor2.error = "Please enter a number"
                proceed = false
            } else {
                factor2 = tvFactor2.text.toString().toInt()
                if (factor2 < 1 || factor2 > 12) {
                    tvFactor2.error = "Value must be between 1-12"
                    proceed = false
                } else {
                    tvFactor2.error = null
                }
            }

            if (proceed) {
                /* step 4
                val i = Intent(this, ResultActivity::class.java).apply {
                    putExtra("result", Result(factor1 * factor2))
                }
                startActivity(i)
                 */

                val fragment = ResultFragment.newInstance(factor1 * factor2)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.result_container, fragment)
                    .commit()
            }
        }
    }
}