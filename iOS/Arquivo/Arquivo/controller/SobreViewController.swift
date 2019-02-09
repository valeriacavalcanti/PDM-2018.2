//
//  SobreViewController.swift
//  Arquivo
//
//  Created by Valéria Cavalcanti on 09/02/2019.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class SobreViewController: UIViewController {

    @IBOutlet weak var lbQuantidade: UILabel!
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        let delegate = UIApplication.shared.delegate as! AppDelegate
        self.lbQuantidade.text = String(delegate.cadastro.count())
    }
}
