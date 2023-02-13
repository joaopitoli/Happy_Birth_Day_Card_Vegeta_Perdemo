package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView




 // Essa atividade permite ao usuario jogar um dado e ver seu resultado na tela
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Variavel do tipo Button sendo relacionada o botão de id button
        val rollButton: Button = findViewById(R.id.button)

        //Um listener é adicionado ao botão para que chame a função rollDice() quando for clicado
        rollButton.setOnClickListener { rollDice() }
    }


    //A função rollDice cria um objeto Dice de X lados e depois chama a função roll()
    private fun rollDice() {
        //Cria um objeto "Dado" com X lados
        val dice = Dice(6)

        //Chama a função que joga o dado e retorna o valor para o objeto
        val diceRoll = dice.roll()
        val diceRollB = dice.roll()

        //Atualiza a tela com o resultado obtido ao jogar o dado
        val resulTextView: TextView = findViewById(R.id.textView)
        val resulTextViewB: TextView = findViewById(R.id.textView2)
        //Passa o resultado do dado de Int para String para poder ser exibido na tela no TextView
        resulTextView.text = diceRoll.toString()
        resulTextViewB.text = diceRollB.toString()
    }
}

//Class Dice recebe um Inteiro como sendo o numero de lados do dado
class Dice(private val numSides: Int) {
    //Função roll() retorna um inteiro aleatorio entre 1 e o numero de lados do dado
    fun roll(): Int {
        return (1..numSides).random()
    }
}