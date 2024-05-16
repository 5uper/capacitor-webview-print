package io.simsek.plugins.webviewprint

import android.print.PrintAttributes
import com.getcapacitor.JSObject
import com.getcapacitor.JSArray
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "WebviewPrint")
class WebviewPrintPlugin : Plugin() {
    private val implementation = WebviewPrint()

    @PluginMethod
    fun print(call: PluginCall) {
        val name = call.getString("name") ?: return call.reject("Name is required")

        val webView = this.bridge.webView ?: return call.reject("WebView not found")

        val printAttributes = PrintAttributes.Builder()
        printAttributes.setColorMode(PrintAttributes.COLOR_MODE_COLOR)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            printAttributes.setDuplexMode(PrintAttributes.DUPLEX_MODE_SHORT_EDGE)
        }

        val pageSize = android.print.PrintAttributes.MediaSize.ISO_A4
        pageSize.asPortrait()

        printAttributes.setMediaSize(pageSize)
        printAttributes.setMinMargins(PrintAttributes.Margins.NO_MARGINS)

        implementation.print(
                this.context,
                this.activity,
                webView,
                name,
                printAttributes.build()
        ) { error, printJob ->
            if (printJob == null) {
                error?.printStackTrace()
                call.reject(error?.message ?: "No print job")
            } else {
                val result = JSObject()

                result.putSafe("state", printJob.info.state)
                result.putSafe("label", printJob.info.label)
                result.putSafe("creationTime", printJob.info.creationTime)
                result.putSafe("isCancelled", printJob.isCancelled)
                result.putSafe("isBlocked", printJob.isBlocked)
                result.putSafe("isFailed", printJob.isFailed)
                result.putSafe("isCompleted", printJob.isCompleted)
                result.putSafe("isQueued", printJob.isQueued)
                result.putSafe("isStarted", printJob.isStarted)
                result.putSafe("printerId", printJob.info.printerId.toString())
                result.putSafe("copies", printJob.info.copies)

                if (printJob.info.pages != null) {
                    val pages = JSArray()
                    for (page in printJob.info.pages!!) {
                        val pageObject = JSObject()
                        pageObject.putSafe("start", page.start)
                        pageObject.putSafe("end", page.end)
                        pages.put(pageObject)
                    }
                    result.putSafe("pages", pages)
                }

                call.resolve(result)
            }
        }
    }
}
