package com.example.ifpb.amiguinhos

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AmigoAdapter(var context: Context): BaseAdapter(){
    private lateinit var dao: AmigoDAO
    private lateinit var lista: ArrayList<Amigo>

    init {
        this.dao = AmigoDAO(context)
        this.lista = this.dao.read()
    }

    override fun getCount(): Int {
        return this.lista.size
    }

    override fun getItem(position: Int): Any {
        return this.lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val amigo = this.lista[position]
        val layout: View

        if (convertView == null){
            layout = View.inflate(context, R.layout.amigo_layout, null)
        }else{
            layout = convertView
        }

        if (position % 2 == 0){
            layout.setBackgroundColor(Color.rgb(0,191,255))
        }else{
            layout.setBackgroundColor(Color.WHITE)
        }

        val tvNome = layout.findViewById<TextView>(R.id.tvAmigoNome)
        val tvData = layout.findViewById<TextView>(R.id.tvAmigoData)

        tvNome.text = amigo.nome
        tvData.text = amigo.tempoStr()

        return layout
    }
}