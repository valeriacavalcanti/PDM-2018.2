//
//  Cadastro.swift
//  Lista de Desejos
//
//  Created by IFPB on 01/02/19.
//  Copyright © 2019 IFPB. All rights reserved.
//

import Foundation

class Cadastro: NSObject {
    var lista: Array<Desejo>!
    
    override init() {
        self.lista = Array<Desejo>()
    }
    
    func add(desejo: Desejo) {
        self.lista.append(desejo)
    }
    
    func get(index: Int) -> Desejo {
        return self.lista[index]
    }
    
    func get() -> Array<Desejo> {
        return self.lista
    }
    
    func del(index: Int) {
        self.lista.remove(at: index)
    }
    
    func size() -> Int {
        return self.lista.count
    }
    
    func swap(origem: Int, destino: Int) {
        let antes = self.lista[origem]
        self.lista[origem] = self.lista[destino]
        self.lista[destino] = antes
    }
}
