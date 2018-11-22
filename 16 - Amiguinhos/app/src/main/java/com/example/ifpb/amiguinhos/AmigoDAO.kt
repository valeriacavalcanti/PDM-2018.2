package com.example.ifpb.amiguinhos

import android.content.ContentValues
import android.content.Context

class AmigoDAO{
    private lateinit var banco: BancoHelper
    private val TABLE = "amigo"

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    // inserir
    fun add(amigo: Amigo){
        val cv = ContentValues()
        cv.put("nome", amigo.nome)
        cv.put("tempo", amigo.tempo.timeInMillis)
        this.banco.writableDatabase.insert(TABLE, null, cv)
    }

    // select
    fun read(): ArrayList<Amigo>{
        val colunas = arrayOf("id", "nome", "tempo")
        val lista = ArrayList<Amigo>()

        val cursor = this.banco.readableDatabase.query(TABLE, colunas, null, null, null, null, null)

        if (cursor.count > 0){
            cursor.moveToFirst()
            do{
                var amigo = Amigo()
                amigo.id = cursor.getInt(cursor.getColumnIndex("id"))
                amigo.nome = cursor.getString(cursor.getColumnIndex("nome"))
                amigo.tempo.timeInMillis = cursor.getLong(cursor.getColumnIndex("tempo"))
                lista.add(amigo)
            }while(cursor.moveToNext())
        }

        return lista
    }

    // select com where
    fun read(id: Int): Amigo?{
        val colunas = arrayOf("id", "nome", "tempo")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        val cursor = this.banco.readableDatabase.query(TABLE, colunas, where, pWhere, null, null, null)

        if (cursor.count > 0){
            cursor.moveToFirst()
            var amigo = Amigo()
            amigo.id = cursor.getInt(cursor.getColumnIndex("id"))
            amigo.nome = cursor.getString(cursor.getColumnIndex("nome"))
            amigo.tempo.timeInMillis = cursor.getLong(cursor.getColumnIndex("tempo"))
            return amigo
        }

        return null
    }

    // atualização
    fun update(amigo: Amigo){
        val where = "id = ?"
        val pWhere = arrayOf(amigo.id.toString())
        val cv = ContentValues()
        cv.put("nome", amigo.nome)
        this.banco.writableDatabase.update(TABLE, cv, where, pWhere)
    }

    // remoção
    fun delete(id: Int){
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete(TABLE, where, pWhere)
    }
}