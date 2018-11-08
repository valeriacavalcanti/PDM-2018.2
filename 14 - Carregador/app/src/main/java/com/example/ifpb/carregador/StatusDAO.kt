package com.example.ifpb.carregador

class StatusDAO{
    private var lista: ArrayList<Status>

    constructor(){
        this.lista = ArrayList()
    }

    fun add(status: Status){
        status.id = this.lista.size + 1
        this.lista.add(status)
    }

    fun read(): ArrayList<Status>{
        return this.lista
    }

    fun read(id: Int): Status{
        for (status in this.lista)
            if (status.id == id) return status
        throw RuntimeException("Eita! Tem não.")
    }

    fun update(status: Status){

    }

    fun delete(status: Status){

    }
}