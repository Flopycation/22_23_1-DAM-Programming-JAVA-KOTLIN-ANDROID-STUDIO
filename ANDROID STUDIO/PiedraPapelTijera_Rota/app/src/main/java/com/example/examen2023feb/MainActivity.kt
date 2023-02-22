package com.example.examen2023feb

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.examen2023feb.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    enum class Objeto {
        ROCK, SCISSORS, PAPER
    }

    private var playerGames = 0
    private var computerGames = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val array = resources.getStringArray(R.array.array)
        val adapter = ArrayAdapter(this, R.layout.mytextview, R.id.tv_option, array)
        binding.spinner.adapter = adapter

        binding.btnJugar.setOnClickListener {
            val selectUsuario = binding.spinner.selectedItemPosition

            val random = Random()
            val selectComputer = random.nextInt(3)

            rockScissorsPaper(selectUsuario, selectComputer)
        }


    }

    /**
     * Función que simula el juego
     *
     * @param selectUsuario -> la selección numérica del usuario
     * @param selectComputer -> la selección numérica del computador
     * @sample 0 -> PIEDRA, 1 -> TIJERAS, 2 -> PAPEL
     */
    private fun rockScissorsPaper(selectUsuario: Int, selectComputer: Int) {
        mostrarImagenes(selectUsuario, selectComputer)

        val playerObject = Objeto.values()[selectUsuario]
        val computerObject = Objeto.values()[selectComputer]

        if (playerObject != computerObject) {

            if (playerObject == Objeto.ROCK && computerObject == Objeto.SCISSORS
                || playerObject == Objeto.SCISSORS && computerObject == Objeto.PAPER
                || playerObject == Objeto.PAPER && computerObject == Objeto.ROCK
            ) {

                playerGames += 1
                Toast.makeText(this, "Has ganado", Toast.LENGTH_SHORT).show()

                binding.tvMarcador.text = playerGames.toString()
            } else {
                computerGames += 1
                Toast.makeText(this, "Has perdido", Toast.LENGTH_SHORT).show()

                binding.tvComputer.text = computerGames.toString()
            }
        } else {
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Función que muestra las imágenes de piedra papel o tijera en imageview
     * @param selectUsuario -> la selección numérica del usuario
     * @param selectComputer -> la selección numérica del computador
     */
    private fun mostrarImagenes(selectUsuario: Int, selectComputer: Int) {
        val imgUsuario = getPaperScissorStone(selectUsuario)
        val imgComputer = getPaperScissorStone(selectComputer)

        binding.ivUsuario.setImageResource(imgUsuario)
        binding.ivComputer.setImageResource(imgComputer)
    }

    /**
     * Función que devuelve la imagen como drawable según un número dado
     * @param number ->  0 -> PIEDRA, 1 -> TIJERAS, 2 -> PAPEL
     * @return -> devuelve el recurso correspondiente
     */
    private fun getPaperScissorStone(number: Int) = when (number) {
        0 -> R.drawable.stone
        1 -> R.drawable.scissors
        else -> R.drawable.paper
    }
}