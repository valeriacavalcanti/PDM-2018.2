package com.example.ifpb.amiguinhos

import java.io.Serializable
import java.util.*

class Amigo: Serializable{
    var id: Int
    var nome: String
    var tempo: Calendar

    constructor(){
        this.id = -1
        this.nome = ""
        this.tempo = Calendar.getInstance()
    }

    constructor(nome: String){
        this.id = -1
        this.nome = nome
        this.tempo = Calendar.getInstance()
    }

    fun tempoStr(): String{
        val dia = this.tempo.get(Calendar.DAY_OF_MONTH)
        val mes = this.tempo.get(Calendar.MONTH) + 1
        val ano = this.tempo.get(Calendar.YEAR)
        val hora = this.tempo.get(Calendar.HOUR_OF_DAY)
        val minuto = this.tempo.get(Calendar.MINUTE)
        val segundo = this.tempo.get(Calendar.SECOND)
        return "${dia}/${mes}/${ano} - ${hora}:${minuto}:${segundo} h"
    }

    override fun toString(): String {
        return "${this.id} - ${this.nome} (${this.tempoStr()})"
    }
}