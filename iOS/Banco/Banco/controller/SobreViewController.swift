//
//  SobreViewController.swift
//  Banco
//
//  Created by Valéria Cavalcanti on 12/02/2019.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class SobreViewController: UIViewController {

    @IBOutlet weak var lbQuantidade: UILabel!
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        self.lbQuantidade.text = "\(PessoaDAO().count())"
    }
}
