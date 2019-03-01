package com.txl.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.txl.testPi.TestTopicVal
import jnilearn.com.txl.kotlinlearn.R

class MainActivity : AppCompatActivity() {

    var b:Int
        get() = te()
        set(value)  {
            value
        }

    val isEmpty: Boolean
        get() = te() == 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity"," values is $b")
        val  topicVal = TestTopicVal()
        topicVal.setB(this)
        Log.d("MainActivity"," values is $b")
        val m = View.OnClickListener {

        }
        findViewById<View>(R.id.tv_aa).setOnClickListener {

        }
    }

    fun te():Int{
        return 5
    }
}
