//
//  Cadastro.swift
//  iChoco
//
//  Created by IFPB on 31/01/19.
//  Copyright © 2019 IFPB. All rights reserved.
//

import Foundation

class Cadastro: NSObject {
    var lista: Array<Chocolate>!
    
    override init() {
        self.lista = Array<Chocolate>()
    }
    
    func add(chocolate: Chocolate) {
        self.lista.append(chocolate)
    }
    
    func get() -> Array<Chocolate> {
        return self.lista
    }
    
    func get(index: Int) -> Chocolate {
        return self.lista[index]
    }
    
    func size() -> Int {
        return self.lista.count
    }
    
    func del(index: Int) {
        self.lista.remove(at: index)
    }
}
