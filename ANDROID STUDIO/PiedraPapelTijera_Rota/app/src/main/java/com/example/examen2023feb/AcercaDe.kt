package com.example.examen2023feb

import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.examen2023feb.databinding.ActivityAcercaDeBinding
import java.util.*
import java.util.concurrent.TimeUnit

class AcercaDe : AppCompatActivity() {
    private lateinit var binding: ActivityAcercaDeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAcercaDeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageview: ImageView = findViewById(R.id.iv_gif)
        Glide.with(this).load(R.drawable.gato_moviendo_cabeza).into(imageview)

        hacerCuentaAtras()
    }

    private fun hacerCuentaAtras() {
        val tv_cuenta: TextView = findViewById(R.id.tv_cuenta_atras)

        val fechaActual = Calendar.getInstance()
        val fechaFinal = Calendar.getInstance()
        fechaFinal.set(2023, 1, 22, 14, 30)

        // TODO valor diferencia = INTRODUCE UN VALOR
        val diferencia = fechaFinal.timeInMillis - fechaActual.timeInMillis

        val counter = object : CountDownTimer(diferencia, 1000) {
            override fun onTick(p0: Long) {
                var millisHastaTerminar = p0
                val days: Long = TimeUnit.MILLISECONDS.toDays(millisHastaTerminar)
                millisHastaTerminar -= TimeUnit.DAYS.toMillis(days)

                val hours: Long = TimeUnit.MILLISECONDS.toHours(millisHastaTerminar)
                millisHastaTerminar -= TimeUnit.HOURS.toMillis(hours)

                val minutes: Long = TimeUnit.MILLISECONDS.toMinutes(millisHastaTerminar)
                millisHastaTerminar -= TimeUnit.MINUTES.toMillis(minutes)

                val seconds: Long = TimeUnit.MILLISECONDS.toSeconds(millisHastaTerminar)

                tv_cuenta.text = "$days día $hours horas $minutes minutos $seconds segundos"
            }

            override fun onFinish() {
                tv_cuenta.text = "Tiempo terminado"
            }
        }
        counter.start()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}