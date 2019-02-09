//
//  Cadastro.swift
//  Arquivo
//
//  Created by Valéria Cavalcanti on 09/02/2019.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import Foundation

class Cadastro: NSObject, NSCoding {
    var lista: Array<Pessoa>
    
    override init() {
        self.lista = Array<Pessoa>()
    }
    
    required init?(coder aDecoder: NSCoder) {
        self.lista = aDecoder.decodeObject(forKey: "lista") as! Array<Pessoa>
    }
    
    func encode(with aCoder: NSCoder) {
        aCoder.encode(self.lista, forKey: "lista")
    }
    
    func add(p: Pessoa) {
        if (p.id == -1){
            var maior = 0
            for e in self.lista{
                if (e.id > maior){
                    maior = e.id
                }
            }
            p.id = maior + 1
        }
        self.lista.append(p)
        print("Cadastrou: \(p)")
    }
    
    func get(index: Int) -> Pessoa {
        return self.lista[index]
    }
    
    func get() -> Array<Pessoa> {
        return self.lista
    }
    
    func count() -> Int {
        return self.lista.count
    }
    
    func del(index: Int) {
        self.lista.remove(at: index)
    }
    
    func update(p: Pessoa) {
        for e in self.lista{
            if (p.id == e.id){
                e.nome = p.nome
                e.idade = p.idade
            }
        }
    }
    
    func swap(origem: Int, destino: Int) {
        let aux = self.lista[origem]
        self.lista[origem] = self.lista[destino]
        self.lista[destino] = aux
    }
}
