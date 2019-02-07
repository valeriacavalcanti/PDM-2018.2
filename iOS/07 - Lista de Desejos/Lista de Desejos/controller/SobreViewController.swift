//
//  SobreViewController.swift
//  Lista de Desejos
//
//  Created by IFPB on 01/02/19.
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
