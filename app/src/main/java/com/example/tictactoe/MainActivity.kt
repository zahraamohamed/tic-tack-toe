package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tictactoe.databinding.ActivityMainBinding


open class MainActivity : AppCompatActivity() {
    lateinit var  binding1: ActivityMainBinding
    lateinit var bu_manual:Button
    lateinit var bu_app:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding1.root)
        bu_manual=findViewById(R.id.button_manual)
        bu_app=findViewById(R.id.button_app)

        game()
    }

    private fun game() {
        bu_manual.setOnClickListener {
            val intent= Intent(this,BasicActivity::class.java)

            startActivity(intent)
        }
        bu_app.setOnClickListener {
            val intent= Intent(this,Play::class.java)

            startActivity(intent)
        }
    }

}
