import Foundation

@objc public class WebviewPrint: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
