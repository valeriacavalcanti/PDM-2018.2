package com.example.ifpb.arrocha

import android.util.Log
import java.util.*


val EM_CURSO = 0
val GANHOU = 1
val PERDEU_INTERVALO = 2
val PERDEU_ARROCHOU = 3

class Arrocha{

    //public val PERDEU_LIMITE = 4

    private var menor: Int
    private var maior: Int
    private var segredo: Int
    private var status: Int

    constructor(){
        this.menor = 1
        this.maior = 100
        this.segredo = Random().nextInt(100) + 1
        this.status = EM_CURSO

        //Log.i("APP_ARROCHA", this.segredo.toString())
        println(this.segredo.toString())
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

    public fun getStatus(): Int{
        return this.status
    }

    public fun getMenor():Int{
        return this.menor
    }

    public fun getMaior(): Int{
        return this.maior
    }

    public fun jogar(chute: Int){
        if (!this.validar(chute)) this.status = PERDEU_INTERVALO
        else{
            if (this.verificaSeGanhou(chute)) this.status = GANHOU
            else{
                this.atualiza(chute)
                if (this.arrochado()) this.status = PERDEU_ARROCHOU
            }
        }
    }
}

fun main(args: Array<String>) {
    val jogo = Arrocha()

    while (jogo.getStatus() == EM_CURSO){
        println("${jogo.getMenor()} - ${jogo.getMaior()}")
        var num = readLine()!!.toInt()
        jogo.jogar(num)
    }

    println(jogo.getStatus())
}