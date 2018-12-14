package com.example.ifpb.ifpb

class Cadastro{
    private var lista: ArrayList<Campus>

    constructor(){
        this.lista = ArrayList()
    }

    fun add(campus: Campus){
        this.lista.add(campus)
    }

    fun get(index: Int): Campus{
        return this.lista.get(index)
    }

    fun get(): ArrayList<Campus>{
        return this.lista
    }

    fun update(campus: Campus){

    }

    fun size(): Int{
        return this.lista.size
    }
}