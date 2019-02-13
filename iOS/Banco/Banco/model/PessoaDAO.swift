//
//  PessoaDAO.swift
//  Banco
//
//  Created by Valéria Cavalcanti on 12/02/2019.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import Foundation
import CoreData
import UIKit

class PessoaDAO {
    var delegate: AppDelegate
    
    init() {
        self.delegate = UIApplication.shared.delegate as! AppDelegate
    }
    
    func add(nome: String, idade: Int) {
        let p = NSEntityDescription.insertNewObject(forEntityName: "Pessoa", into: self.delegate.persistentContainer.viewContext)
        p.setValue(nome, forKey: "nome")
        p.setValue(idade, forKey: "idade")
        
        self.delegate.saveContext()
    }

    func get() -> Array<Pessoa> {
        
        let requisicao = NSFetchRequest<NSFetchRequestResult>(entityName: "Pessoa")
        requisicao.predicate = NSPredicate(format: "idade = max(idade)")
        
        do{
            let pessoas = try self.delegate.persistentContainer.viewContext.fetch(requisicao)
            if (pessoas.count > 0){
                return (pessoas as! [NSManagedObject]) as! Array<Pessoa>
            }
        }catch{}
        return Array<Pessoa>()
    }

    func del(p: Pessoa) {
        self.delegate.persistentContainer.viewContext.delete(p)
    }
    
    func count() -> Int {
        let requisicao = NSFetchRequest<NSFetchRequestResult>(entityName: "Pessoa")
        do{
           return try self.delegate.persistentContainer.viewContext.fetch(requisicao).count
        }catch{
            return -1
        }
    }
}
