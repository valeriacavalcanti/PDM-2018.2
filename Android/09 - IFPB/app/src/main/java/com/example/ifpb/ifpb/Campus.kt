package com.example.ifpb.ifpb

class Campus{
    var nome: String
    var url: String

    constructor(nome: String, url: String){
        this.nome = nome
        this.url = url
    }

    override fun toString(): String {
        return this.nome
    }
}