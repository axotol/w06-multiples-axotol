package com.example.w06_multiples_axotol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.result)

        /* step 2
        val result = intent.getIntExtra("result", -1)
        tvResult.text = result.toString()
         */

        /* step 3
        val factor1 = intent.getIntExtra("factor1", -1)
        val factor2 = intent.getIntExtra("factor2", -1)
        val result = factor1 * factor2
        tvResult.text = result.toString()
         */

        // step 4
        val result = intent.getParcelableExtra<Result>("result")
        tvResult.text = result?.opResult.toString()
    }
}