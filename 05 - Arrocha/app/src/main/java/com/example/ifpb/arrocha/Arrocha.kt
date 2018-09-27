package com.example.ifpb.arrocha

import android.util.Log
import java.util.*


class Arrocha{
    private var menor: Int
    private var maior: Int
    private var segredo: Int
    private var status: Status

    constructor(){
        this.menor = 1
        this.maior = 100
        this.segredo = Random().nextInt(100) + 1
        this.status = Status.EM_CURSO

        Log.i("APP_ARROCHA", this.segredo.toString())
        //println(this.segredo.toString())
    }

    private fun validar(num: Int): Boolean{
        return ((num > this.menor) and (num < this.maior))
    }

    private fun arrochado():Boolean{
        return (menor + 1) == (maior - 1)
    }

    private fun atualiza(chute: Int){
        if (chute < this.segredo){
            this.menor = chute
        }else{
            this.maior = chute
        }
    }

    private fun verificaSeGanhou(chute: Int): Boolean{
        return chute == this.segredo
    }

    public fun getStatus(): Status{
        return this.status
    }

    public fun getMenor():Int{
        return this.menor
    }

    public fun getMaior(): Int{
        return this.maior
    }

    public fun jogar(chute: Int){
        if (!this.validar(chute)) this.status = Status.PERDEU_INTERVALO
        else{
            if (this.verificaSeGanhou(chute)) this.status = Status.GANHOU
            else{
                this.atualiza(chute)
                if (this.arrochado()) this.status = Status.PERDEU_ARROCHOU
            }
        }
    }
}

fun main(args: Array<String>) {
    val jogo = Arrocha()

    while (jogo.getStatus() == Status.EM_CURSO){
        println("${jogo.getMenor()} - ${jogo.getMaior()}")
        var num = readLine()!!.toInt()
        jogo.jogar(num)
    }

    println(jogo.getStatus())
}