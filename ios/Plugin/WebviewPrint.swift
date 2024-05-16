import Foundation
import WebKit

@objc public class WebviewPrint: NSObject {
    public typealias Handler = (Result<Bool, Error>) -> Void
    
    public func print(webView: WKWebView, name: String, completionHandler: @escaping Handler) {
        let webViewPrint = webView.viewPrintFormatter()
        
        let printInfo = UIPrintInfo(dictionary: nil)
        printInfo.jobName = name
        printInfo.outputType = UIPrintInfo.OutputType.general
        printInfo.orientation = UIPrintInfo.Orientation.portrait
        
        let printController = UIPrintInteractionController.shared
        printController.printInfo = printInfo
        printController.printFormatter = webViewPrint
        
        DispatchQueue.main.async {
            printController.present(animated: true) { UIPrintInteractionController, printed, error in
                if (error != nil) {
                    completionHandler(.failure(error!))
                } else {
                    completionHandler(.success(printed))
                }
            }
        }
    }
}
