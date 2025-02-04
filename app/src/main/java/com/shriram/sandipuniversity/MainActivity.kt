package com.shriram.sandipuniversity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeBtn = findViewById<Button>(R.id.homeBtn)
        val studentBtn = findViewById<Button>(R.id.studentBtn)
        val staffBtn = findViewById<Button>(R.id.staffBtn)

        homeBtn.setOnClickListener {
            // check user internet available or not
            if (isInternetAvailable(applicationContext)) {
                val intent = Intent(this, home::class.java)
                Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
            }
        }

        studentBtn.setOnClickListener {
            if (isInternetAvailable(applicationContext)) {
                val intent = Intent(this, student::class.java)
                Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
            }
        }

        staffBtn.setOnClickListener {
            if (isInternetAvailable(applicationContext)) {
                val intent = Intent(this, staff::class.java)
                Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
            }
        }
    }


    // function to check user internet availabe or not
    companion object {
        fun isInternetAvailable(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val network = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(network)

            return capabilities != null &&
                    (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
        }
    }
}
