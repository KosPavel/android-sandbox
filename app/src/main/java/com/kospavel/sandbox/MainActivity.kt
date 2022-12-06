package com.kospavel.sandbox

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.kospavel.sandbox.utils.TextUtils
import com.kospavel.sandbox.utils.TextUtilsJava

class MainActivity : ComponentActivity() {

    private var expanded = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main_activity)

        initTextView1()
        initTextView2()
    }

    private fun initTextView1() {
        val textView1 = findViewById<TextView>(R.id.tvTextContent1)
        textView1.text = TextUtils.text600Symbols
        textView1.setOnClickListener {
            textView1.maxLines = if (expanded) {
                5
            } else {
                Int.MAX_VALUE
            }
            expanded = !expanded
        }
    }

    private fun initTextView2() {
        val textView2 = findViewById<TextView>(R.id.tvTextContent2)
        textView2.text = TextUtils.text1000Symbols

        TextUtilsJava.makeTextViewResizable(textView2, 5, "expand text here", true);
    }
}