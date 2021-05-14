
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
import com.example.tictactoe.databinding.ActivityMainBinding
import java.util.*


open class Play :AppCompatActivity() {
    lateinit var binding: ActivityBasicBinding
    lateinit var  resetButton:Button
    lateinit var obj:Parent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasicBinding.inflate(layoutInflater)
//define the object
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
            buSelected.textSize= 32F
            buSelected.setTextColor(Color.RED)

            player1.add(cellID)
            activePlayer = 2
            autoPlay()
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






fun autoPlay() {
    val emptyCells = ArrayList<Int>()
    for (c in 1..9) {
        if (!(player1.contains(c) || player2.contains(c))) {
            emptyCells.add(c)
        }
    }

    val r = Random()
    val randIndex = r.nextInt(emptyCells.size - 0) + 0
    val c = emptyCells[randIndex]

    var buSelected: Button
    when (c) {
        1 -> buSelected = binding.bu1
        2 -> buSelected = binding.bu2
        3 -> buSelected = binding.bu3
        4 -> buSelected = binding.bu4
        5 -> buSelected = binding.bu5
        6 -> buSelected = binding.bu6
        7 -> buSelected = binding.bu7
        8 -> buSelected = binding.bu8
        9 -> buSelected = binding.bu9
        else -> buSelected = binding.bu1

    }


    playGame(c, buSelected)

}



}
