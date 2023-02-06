package com.example.a4botones

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.dialog1.setOnClickListener {

            dialogNormal()

        }

    }
}

private fun dialogNormal() {
    val builder = AlertDialog.Builder(this)
    builder.setTitle("Mensaje del sistema")
    builder.setMessage("Desea salir de la aplicacion")
    builder.setCancelable(false)
    builder.setNegativeButton("Cerrar") { dialog, idButton ->
        Toast.makeText(this, "Cerrado", Toast.LENGTH_LONG).show()
    }

    builder.setPositiveButton("Si") { dialog, idButton ->
        finish()
    }

    builder.setNeutralButton("Nada") { dialog, idButton ->
        Toast.makeText(this, "Cerrado", Toast.LENGTH_LONG).show()

    }

    val dialog = builder.create()
    dialog.show()

    dialog.getButton((AlertDialog.BUTTON_NEGATIVE).setOnClickListerner {
        Toast.makeText(this,"Cerrar", Toast.LENGTH_SHORT). show()
    }


        private fun dialogLista(){
            val builder = AlertDialog.Builder(this)
        builder.setItems(R.array.Lista_colores){dialog, position ->
            bingind.tvOpcion.text = array[position]
        }

        builder.create().show()

        private fun dialogUnaOpcion(){
            val builder = AlertDialog.Builder(this)
            builder.setsingleChoiceItems(R.array.Lista_colores, null){dialog, position, isChecked ->
            Toast.makeText(this, )

            }
            builder.create().show()

            private fun customDialog() {

                val builder = AlertDialog.Builder(this)
                val dialogBinding = CustomDialogBinging.inflate(layaoutInflater)
                builder.setView(dialogBinding.root)

                builder.setPositiveButton("Aceptar")
                user = dialogBinding.password.text.toString()
            }

            val dialog = builder.create()
            dialog.show()

            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener({
                user = dialoBinding.username.txt.toString()

                if(user.isEmpty() password.isempty()){
                    dialogBinding.username.error = "Debes intrducir usuario"
                    dialogBinding.password.error = "Debes introducir password"

                } else {
                    binding.tvOpcion.text = user password
                            dialog.dismiss()
                }
            }
        }


    }
}