import android.content.DialogInterface
import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el WebView
        webview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                // Mostrar el ProgressBar al cargar la página
                progressbar.visibility = WebView.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                // Ocultar el ProgressBar al terminar la carga de la página
                progressbar.visibility = WebView.GONE
                // Mostrar el título de la página en el TextView
                textview.text = view?.title
            }
        }

        // Cargar la URL por defecto
        webview.loadUrl("https://www.google.com/")

        // Configurar los botones
        button_back.setOnClickListener {
            // Navegar hacia atrás en la navegación web, si es posible
            if (webview.canGoBack()) {
                webview.goBack()
            }
        }

        button_forward.setOnClickListener {
            // Navegar hacia adelante en la navegación web, si es posible
            if (webview.canGoForward()) {
                webview.goForward()
            }
        }

        button_reload.setOnClickListener {
            // Recargar la página actual
            webview.reload()
        }

        button_stop.setOnClickListener {
            // Parar la carga de la página actual
            webview.stopLoading()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Mostrar el cuadro de diálogo al pulsar el botón atrás físico del dispositivo
        if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            showExitDialog()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun showExitDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialog_exit_title)
        builder.setMessage(R.string.dialog_exit_message)
        builder.setPositiveButton(R.string.dialog_exit_positive_button) { _: DialogInterface, _: Int ->
            finish()
        }
        builder.setNegativeButton(R.string.dialog_exit_negative_button, null)
        builder.show()
    }
}
