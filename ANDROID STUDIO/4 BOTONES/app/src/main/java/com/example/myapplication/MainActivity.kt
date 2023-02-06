package com.example.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var opcionElegida = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialog1.setOnClickListener {
            dialogNormal()
        }
        binding.dialog2.setOnClickListener {
            dialogLista()
        }
        binding.dialog3.setOnClickListener {
            dialogUnaOpcion()
        }
        binding.dialog4.setOnClickListener {
            customDialog()
        }
    }

    private fun dialogNormal() {
        val builder = AlertDialog.Builder(this).apply {
            setTitle("Mensaje del sistema")
            setMessage("Desea salir de la aplicación?")
            setCancelable(false)
            setNegativeButton("Cerrar", null)
            setPositiveButton("Sí") { _, _ ->
                finish()
            }
            setNeutralButton("Nada") { _, _ ->
                Toast.makeText(this@MainActivity, "Nada", Toast.LENGTH_SHORT).show()
            }
        }


        //builder.create().show()
        val dialog = builder.create()
        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener {
            Toast.makeText(this, "Cerrar", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
    }

    private fun dialogLista() {
        val array = resources.getStringArray(R.array.lista_colores)

        val builder = AlertDialog.Builder(this)
        builder.setItems(R.array.lista_colores) { dialog, position ->
            binding.tvOpcion.text = array[position]
        }
        builder.create().show()
    }

    private fun dialogUnaOpcion() {
        val array = resources.getStringArray(R.array.lista_colores)

        val builder = AlertDialog.Builder(this)
        builder.setSingleChoiceItems(R.array.lista_colores, opcionElegida) { dialog, position ->
            opcionElegida = position
        }
        builder.setNegativeButton("OK") { _, _ ->
            binding.tvOpcion.text = array[opcionElegida]
        }

        builder.create().show()
    }

    private fun dialogLstadoOpciones() {
        val array = resources.getStringArray(R.array.lista_colores)

        val builder = AlertDialog.Builder(this)
        builder.setMultiChoiceItems(R.array.lista_colores, null) { dialog, position, isChecked ->
            Toast.makeText(this, "posicion: $position, checked: $isChecked", Toast.LENGTH_SHORT)
                .show()
        }
        builder.setNegativeButton("OK") { _, _ ->

        }

        builder.create().show()
    }

    private fun customDialog() {
        var user = ""
        var password = ""

        val builder = AlertDialog.Builder(this)
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
        builder.setView(dialogBinding.root)

        builder.setPositiveButton("Aceptar", null)

        val dialog = builder.create()
        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            user = dialogBinding.username.text.toString()
            password = dialogBinding.password.text.toString()

            if (user.isEmpty() || password.isEmpty()) {
                dialogBinding.username.error = "Debes introducir usuario"
                dialogBinding.password.error = "Debes introducir password"
            } else {
                binding.tvOpcion.text = "$user - $password"
                dialog.dismiss()
            }
        }
    }
}













