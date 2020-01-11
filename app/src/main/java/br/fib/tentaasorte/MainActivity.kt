package br.fib.tentaasorte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, Sorteio.getInstance().ListarClientes())

        lstclientes.adapter = adapter

        lstclientes.setOnItemClickListener { parent, view, position, id ->
            txttimeselecionado.setText( "Time selecionado: " + Sorteio.getInstance().getCliente(position).getTime() )
        }

        btnvender.setOnClickListener{
            val intent = Intent(this@MainActivity, VendaActivity::class.java)
            startActivity(intent)
        }
    }
}
