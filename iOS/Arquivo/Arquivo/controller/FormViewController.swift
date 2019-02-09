//
//  ViewController.swift
//  Arquivo
//
//  Created by Valéria Cavalcanti on 09/02/2019.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class FormViewController: UIViewController {

    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tfIdade: UITextField!
    
    var cadastro: Cadastro!
    var p: Pessoa!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let delegate = UIApplication.shared.delegate as! AppDelegate
        self.cadastro = delegate.cadastro
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        if (self.p != nil){
            self.tfNome.text = p.nome
            self.tfIdade.text = String(p.idade)
        }
        self.tfNome.becomeFirstResponder()
    }
    
    @IBAction func salvar(_ sender: Any) {
        if (self.tfNome.text != "") && (self.tfIdade.text != ""){
            let idade = Int(self.tfIdade.text!)
            let nome = self.tfNome.text
            
            if (self.p == nil){
                self.p = Pessoa(nome: nome!, idade: idade!)
                self.cadastro.add(p: p)
                print("Pessoa cadastrada. Quantidade: \(self.cadastro.count())")
            }else{
                self.p.nome = nome!
                self.p.idade = idade!
                self.cadastro.update(p: p)
                print("Pessoa atualizada. Quantiadde: \(self.cadastro.count())")
            }
            print(self.cadastro.get())
        }
        self.navigationController?.popViewController(animated: true)
    }
}

