package com.example.ifpb.ifpb

import java.io.Serializable

class Campus: Serializable{
    var id: Int
    var nome: String
    var url: String

    constructor(nome: String, url: String){
        this.id = -1
        this.nome = nome
        this.url = url
    }

    override fun toString(): String {
        return this.nome
    }
}