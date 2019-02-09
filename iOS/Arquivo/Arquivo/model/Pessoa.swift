//
//  Pessoa.swift
//  Arquivo
//
//  Created by Valéria Cavalcanti on 09/02/2019.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import Foundation

class Pessoa: NSObject, NSCoding {
    var id: Int
    var nome: String
    var idade: Int
    
    override var description: String{
        return "\(self.id) - \(self.nome) - \(self.idade)"
    }
    
    init(nome: String, idade: Int) {
        self.id = -1
        self.nome = nome
        self.idade = idade
    }
    
    init(id: Int, nome: String, idade: Int) {
        self.id = id
        self.nome = nome
        self.idade = idade
    }
    
    required init?(coder aDecoder: NSCoder) {
        self.id = aDecoder.decodeInteger(forKey: "id")
        self.nome = aDecoder.decodeObject(forKey: "nome") as! String
        self.idade = aDecoder.decodeInteger(forKey: "idade"     )
    }
    
    func encode(with aCoder: NSCoder) {
        aCoder.encode(self.id, forKey: "id")
        aCoder.encode(self.nome, forKey: "nome")
        aCoder.encode(self.idade, forKey: "idade")
    }
}
