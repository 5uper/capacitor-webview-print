package io.simsek.plugins.webviewprint

import android.app.Activity
import android.content.Context
import android.print.PrintAttributes
import android.print.PrintJob
import android.print.PrintManager
import android.webkit.WebView

class WebviewPrint {
    fun print(
            context: Context,
            activity: Activity,
            webView: WebView,
            name: String,
            printAttributes: PrintAttributes,
            callback: (error: Exception?, printJob: PrintJob?) -> Unit
    ) {
        activity.runOnUiThread {
            try {
                val printManager = (context.getSystemService(Context.PRINT_SERVICE)
                        ?: throw Exception("Print service not available")) as PrintManager
                val printAdapter = webView.createPrintDocumentAdapter(name)

                callback(null, printManager.print(name, printAdapter, printAttributes))
            } catch (e: Exception) {
                callback(e, null)
            }
        }
    }
}
