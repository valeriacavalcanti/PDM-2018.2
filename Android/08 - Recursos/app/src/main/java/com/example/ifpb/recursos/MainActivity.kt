package com.example.ifpb.recursos

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout

val FOTO = 1

class MainActivity : AppCompatActivity() {
    private lateinit var btHtml : Button
    private lateinit var btDiscar : Button
    private lateinit var btLigar : Button
    private lateinit var btEmail : Button
    private lateinit var btSMS : Button
    private lateinit var btCompartilhar : Button
    private lateinit var btPonto : Button
    private lateinit var btRota : Button
    private lateinit var btYoutube : Button
    private lateinit var btFoto : Button
    private lateinit var llBotoes: LinearLayout

    private lateinit var llVoltar: LinearLayout
    private lateinit var btVoltar: Button
    private lateinit var ivFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btHtml = findViewById(R.id.btHtml)
        this.btDiscar = findViewById(R.id.btDiscar)
        this.btLigar = findViewById(R.id.btLigar)
        this.btEmail = findViewById(R.id.btEmail)
        this.btSMS = findViewById(R.id.btSMS)
        this.btCompartilhar = findViewById(R.id.btCompartilhar)
        this.btPonto = findViewById(R.id.btPonto)
        this.btRota = findViewById(R.id.btRota)
        this.btYoutube = findViewById(R.id.btYoutube)
        this.btFoto = findViewById(R.id.btFoto)
        this.llBotoes = findViewById(R.id.llBotoes)

        this.llVoltar = findViewById(R.id.llVoltar)
        this.btVoltar = findViewById(R.id.btVoltar)
        this.ivFoto = findViewById(R.id.ivFoto)


        // definindo os listeners

        this.btHtml.setOnClickListener({ html(it) })
        this.btDiscar.setOnClickListener({ discar(it) })
        this.btLigar.setOnClickListener({ ligar(it) })
        this.btEmail.setOnClickListener({ email(it) })
        this.btSMS.setOnClickListener({ sms(it) })
        this.btCompartilhar.setOnClickListener({ compartilhar(it) })
        this.btPonto.setOnClickListener({ ponto(it) })
        this.btRota.setOnClickListener({ rota(it) })
        this.btYoutube.setOnClickListener({ youtube(it) })
        this.btFoto.setOnClickListener({ foto(it) })

        this.btVoltar.setOnClickListener({ voltar(it) })
    }

    fun html(view: View){
        val uri = Uri.parse("http://pdm.valeriacavalcanti.com.br")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    fun discar(view: View){
        val uri = Uri.parse("tel:36121392")
        val it = Intent(Intent.ACTION_DIAL, uri)

        startActivity(it)
    }

    fun ligar(view: View){
        val uri = Uri.parse("tel:36121392")
        val it = Intent(Intent.ACTION_CALL, uri)
        val call = Manifest.permission.CALL_PHONE
        val granted = PackageManager.PERMISSION_GRANTED
        if (ContextCompat.checkSelfPermission(this, call) == granted){
            startActivity(it)
        }
    }

    fun email(view: View){
        val uri = Uri.parse("mailto:valeria.cavalcanti@ifpb.edu.br")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra(Intent.EXTRA_SUBJECT, "Assunto")
        it.putExtra(Intent.EXTRA_TEXT, "Texto")

        startActivity(it)
    }

    fun sms(view: View){
        val uri = Uri.parse("sms:36121392")
        val it = Intent(Intent.ACTION_SENDTO, uri)

        it.putExtra("sms_body", "Mensagem")

        startActivity(it)
    }

    fun compartilhar(view: View){
        val it = Intent(Intent.ACTION_SEND)

        it.setType("text/plain")
        it.putExtra(Intent.EXTRA_TEXT, "Texto para compartilhar")
        startActivity(Intent.createChooser(it, "Compartilhar"))
    }

    fun ponto(view: View){
        val uri = Uri.parse("geo:-7.1356496,-34.8760932")
        val it = Intent(Intent.ACTION_VIEW, uri)

        startActivity(it)
    }

    fun rota(view: View){
        val origem = "-7.1356496,-34.8760932"
        val destino = "-7.1181836,-34.8730402"
        val url = "http://maps.google.com/maps"
        val uri = Uri.parse("${url}?f=&saddr=${origem}+&daddr=${destino}")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun youtube(view: View){
        val uri = Uri.parse("vnd.youtube://H0Z7ewOXCKw")
        val it = Intent(Intent.ACTION_VIEW, uri)

        startActivity(it)
    }

    fun foto(view: View){
        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        startActivityForResult(it, FOTO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == FOTO){
                this.ivFoto.setImageBitmap(data!!.extras.get("data") as Bitmap)
                this.llBotoes.visibility = View.INVISIBLE
                this.llVoltar.visibility = View.VISIBLE
            }
        }
    }

    fun voltar(view: View){
        this.llBotoes.visibility = View.VISIBLE
        this.llVoltar.visibility = View.INVISIBLE
    }
}
