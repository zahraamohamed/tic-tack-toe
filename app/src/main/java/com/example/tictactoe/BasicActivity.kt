
package com.example.tictactoe



import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.tictactoe.databinding.ActivityBasicBinding
import java.util.*


open class BasicActivity :AppCompatActivity() {
    lateinit var binding: ActivityBasicBinding
    lateinit var  resetButton:Button
    lateinit var obj:Parent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasicBinding.inflate(layoutInflater)
        obj=Parent()
        setContentView(binding.root)
        // reset the game
        resetButton =  findViewById(R.id.bu10)
        resetButton.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)
            startActivity( Intent(this,MainActivity::class.java))

        }
    }

    fun buClick(view: View) {
        //fun of click button
        val buSelected = view as Button
        var cellID = 0
        when (buSelected.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9


        }

       playGame(cellID, buSelected)
    }//end buClick fun

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    private fun playGame(cellID: Int, buSelected: Button) {
        if (activePlayer == 1) {
            buSelected.text = "X"
          buSelected.setTextColor(Color.RED)
            buSelected.textSize= 32F
            player1.add(cellID)
            activePlayer = 2

        } else {
            buSelected.text = "o"
            buSelected.textSize= 32F
            buSelected.setTextColor(Color.RED)
            buSelected.setBackgroundColor(Color.parseColor("#ffffff"))
            player2.add(cellID)
            activePlayer = 1
        }
        buSelected.isEnabled = false;
        obj.checkWinner()
    }








}





