package com.example.eoghan.soundmateapp

import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                var network1 = network()
                network1.execute("hello")
                message.setText("sent packet")
                var b = ""
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    inner class network : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg p0: String): String {
            var networker = Network()
            networker.send(p0[0])
            return ""
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
