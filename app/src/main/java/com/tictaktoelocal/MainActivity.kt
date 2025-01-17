package com.tictaktoelocal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View)
    {
        val buSelected = view as Button
        var cellID=0
        when(buSelected.id){
            R.id.button1 -> cellID=1
            R.id.button2 -> cellID=2
            R.id.button3 -> cellID=3
            R.id.button4 -> cellID=4
            R.id.button5 -> cellID=5
            R.id.button6 -> cellID=6
            R.id.button7 -> cellID=7
            R.id.button8 -> cellID=8
            R.id.button9 -> cellID=9
        }

        playGame(cellID,buSelected)
    }

    private var player1=ArrayList<Int>()
    private var player2=ArrayList<Int>()
    private var activePlayer=1

    private fun playGame(cellID:Int, buSelected:Button){

        if (activePlayer==1){
            buSelected.text="X"
            player1.add(cellID)
            activePlayer=2
            autoPlay()
        }
        else{
            buSelected.text="O"
            player2.add(cellID)
            activePlayer=1
        }

        buSelected.isEnabled=false
        checkWiner()
    }

    private fun checkWiner(){
        var winer=0

        //row 1
         if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winer=1
        }
        else if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winer=2
        }

        //row 2
        else if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winer=1
        }
        else if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winer=2
        }

        //row 3
        else if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winer=1
        }
        else if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winer=2
        }

        //col 1
        else if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winer=1
        }
        else if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winer=2
        }

        //col 2
        else if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winer=1
        }
        else if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winer=2
        }

        //col 3
        else if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winer=1
        }
        else if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winer=2
        }

         // diagonal 1
         else if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
             winer=1
         }
         else if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
             winer=2
         }

         // diagonal 2
         else if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
             winer=1
         }
         else if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
             winer=2
         }

        if(winer!=0){
            if (winer==1){
                Toast.makeText(this, "Player 1 win the game",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this, "Player 2 win the game",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun autoPlay(){
        val emptyCells=ArrayList<Int>()
        for (cellID in 1..9){
            if (!player1.contains(cellID) && !player2.contains(cellID)){
                emptyCells.add(cellID)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellID=emptyCells[randIndex]

        var buSelect:Button?=null
        when(cellID){
            1 -> buSelect=button1
            2 -> buSelect=button2
            3 -> buSelect=button3
            4 -> buSelect=button4
            5 -> buSelect=button5
            6 -> buSelect=button6
            7 -> buSelect=button7
            8 -> buSelect=button8
            9 -> buSelect=button9
        }

        if (buSelect !=null) {
            playGame(cellID, buSelect)
        }

    }
}
