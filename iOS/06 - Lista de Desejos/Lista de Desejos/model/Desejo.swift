//
//  Desejo.swift
//  Lista de Desejos
//
//  Created by IFPB on 01/02/19.
//  Copyright © 2019 IFPB. All rights reserved.
//

import Foundation

class Desejo: NSObject {
    var descricao: String!
    var realizado: Bool!
    
    override var description: String{
        return "\(descricao!) - \(realizado!)"
    }
    
    init(descricao: String, realizado: Bool){
        self.descricao = descricao
        self.realizado = realizado
    }
}
