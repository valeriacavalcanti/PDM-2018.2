//
//  Chocolate.swift
//  iChoco
//
//  Created by IFPB on 31/01/19.
//  Copyright © 2019 IFPB. All rights reserved.
//

import Foundation

class Chocolate: NSObject {
    var descricao: String!
    var valor: Float!
    
    override var description: String{
        return "\(descricao!) - \(valor!)"
    }
    
    init(descricao: String, valor: Float){
        self.descricao = descricao
        self.valor = valor
    }
}
