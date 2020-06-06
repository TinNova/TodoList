import UIKit
import SharedCode

class ViewController: UIViewController {

    @IBOutlet weak var myLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let example = ExampleClass()
        myLabel.text = "Calling from \(example.getPlatform())"
    }
}
