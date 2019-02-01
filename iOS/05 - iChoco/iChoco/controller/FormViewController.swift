//
//  ViewController.swift
//  iChoco
//
//  Created by IFPB on 31/01/19.
//  Copyright © 2019 IFPB. All rights reserved.
//

import UIKit

class FormViewController: UIViewController {
    @IBOutlet weak var tfDescricao: UITextField!
    @IBOutlet weak var tfValor: UITextField!
    
    @IBAction func salvar(_ sender: Any) {
        let descricao = self.tfDescricao.text!
        let valor = Float(self.tfValor.text!)
        
        let chocolate = Chocolate(descricao: descricao, valor: valor!)
        
        let delegate = UIApplication.shared.delegate as! AppDelegate
        delegate.cadastro.add(chocolate: chocolate)
        
        print(delegate.cadastro.get())
    }
}

