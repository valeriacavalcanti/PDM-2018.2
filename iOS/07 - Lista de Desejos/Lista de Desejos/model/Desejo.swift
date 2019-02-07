//
//  Desejo.swift
//  Lista de Desejos
//
//  Created by IFPB on 01/02/19.
//  Copyright © 2019 IFPB. All rights reserved.
//

import Foundation

class Desejo: NSObject, NSCoding {
    var descricao: String
    var realizado: Bool
    
    override var description: String{
        return "\(descricao) - \(realizado)"
    }
    
    // construtor: Memória
    init(descricao: String, realizado: Bool){
        self.descricao = descricao
        self.realizado = realizado
    }
    
    // construtor: Arquivo
    // arquivo -> memória
    required init?(coder aDecoder: NSCoder) {
        self.descricao = aDecoder.decodeObject(forKey: "descricao") as! String
        self.realizado = aDecoder.decodeObject(forKey: "realizado") as! Bool
    }
    
    // memória -> arquivo
    func encode(with aCoder: NSCoder) {
        aCoder.encode(self.descricao, forKey: "descricao")
        aCoder.encode(self.realizado, forKey: "realizado")
    }
}
