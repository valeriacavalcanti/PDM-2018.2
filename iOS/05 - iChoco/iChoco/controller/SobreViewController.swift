//
//  SobreViewController.swift
//  iChoco
//
//  Created by IFPB on 31/01/19.
//  Copyright © 2019 IFPB. All rights reserved.
//

import UIKit

class SobreViewController: UIViewController {
    @IBOutlet weak var lbQuantidade: UILabel!

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        let delegate = UIApplication.shared.delegate as! AppDelegate
        self.lbQuantidade.text = String(delegate.cadastro.size())
    }
}
