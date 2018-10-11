package com.example.ifpb.ifpb

class Ifpb{
    var lista: ArrayList<Campus>

    constructor(){
        this.lista = ArrayList()
    }

    fun add(campus: Campus){
        this.lista.add(campus)
    }

    fun get(index: Int): Campus{
        return this.lista.get(index)
    }
}