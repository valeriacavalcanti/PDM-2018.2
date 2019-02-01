//
//  ViewController.swift
//  Lista de Desejos
//
//  Created by IFPB on 01/02/19.
//  Copyright © 2019 IFPB. All rights reserved.
//

import UIKit

class FormViewController: UIViewController {

    @IBOutlet weak var tfDescricao: UITextField!
    @IBOutlet weak var swRealizado: UISwitch!
 
    @IBAction func salvar(_ sender: Any) {
        let descricao = self.tfDescricao.text!
        let realizado = self.swRealizado.isOn
        
        let desejo = Desejo(descricao: descricao, realizado: realizado)
        
        let delegate = UIApplication.shared.delegate as! AppDelegate
        delegate.cadastro.add(desejo: desejo)
        
        print(delegate.cadastro.get())
        
        self.navigationController?.popViewController(animated: true)
    }
}
