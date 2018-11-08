package com.example.ifpb.carregador

class Status{
    var id: Int
    var mensagem: String

    constructor(mensagem: String){
        this.id = -1
        this.mensagem = mensagem
    }

    override fun toString(): String {
        return "${this.id} - ${this.mensagem}"
    }
}