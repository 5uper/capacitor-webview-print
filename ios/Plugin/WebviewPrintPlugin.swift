import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(WebviewPrintPlugin)
public class WebviewPrintPlugin: CAPPlugin {
    private let implementation = WebviewPrint()
    
    @objc func print(_ call: CAPPluginCall) {
        let webView = self.webView
        
        if (webView == nil) {
            call.reject("WebView not found")
            return
        }
        
        guard let name = call.getString("name") else {
            call.reject("Name option is required")
            return
        }
        
        
        self.implementation.print(webView: webView!, name: name) { result in
            switch result {
            case .success(let printed):
                call.resolve([ "printed": printed ])
            case .failure(let error):
                call.reject(error.localizedDescription, "", error)
            }
        }
    }
}
