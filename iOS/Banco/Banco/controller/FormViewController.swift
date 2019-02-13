//
//  ViewController.swift
//  Banco
//
//  Created by Valéria Cavalcanti on 12/02/2019.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class FormViewController: UIViewController {

    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tfIdade: UITextField!
    
    var dao = PessoaDAO()
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        self.tfNome.becomeFirstResponder()
    }
 
    @IBAction func salvar(_ sender: Any) {
        let nome = self.tfNome.text
        let idade = Int(self.tfIdade.text!)
        
        self.dao.add(nome: nome!, idade: idade!)
        print("Quantidade: \(self.dao.count())")
        print("Pessoas: \(self.dao.get())")
        
        self.navigationController?.popViewController(animated: true)
    }
}

