//
//  ViewController.swift
//  Telinhas
//
//  Created by IFPB on 14/12/18.
//  Copyright © 2018 IFPB. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {
    @IBOutlet weak var swStatus: UISwitch!
    @IBOutlet weak var lbStatus: UILabel!
    
    @IBAction func definirStatus(_ sender: Any) {
        if (self.swStatus.isOn){
            self.lbStatus.text = "Ligado"
        }else{
            self.lbStatus.text = "Desligado"
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print("[MVC]: ViewDidLoad")
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        print("[MVC]: ViewWillAppear")
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        print("[MVC]: ViewDidAppear")
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(true)
        print("[MVC]: ViewWillDisappear")
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(true)
        print("[MVC]: ViewDidDissapear")
    }
}

