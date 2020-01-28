package br.fib.tentaasorte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import br.fib.tentaasorte.database.models.Vendas
import br.fib.tentaasorte.database.repository.VendasRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var qtdeVendas: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnActivityVendas.setOnClickListener{
            val intent = Intent(this@MainActivity, VendaActivity::class.java)
            startActivity(intent)
        }

        btnActivitySorteio.setOnClickListener{
            val intent = Intent(this@MainActivity, SorteioActivity::class.java)
            intent.putExtra("qtdevendas", qtdeVendas)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        carregarListadeVendas()
    }

    fun carregarListadeVendas(){
        val vendas = VendasRepository(this).findAll()
        qtdeVendas = vendas.size

        val adapter : ArrayAdapter<Vendas> = ArrayAdapter(this, android.R.layout.simple_list_item_1, vendas)

        lstclientes.adapter = adapter
        adapter.notifyDataSetChanged()

        txtQtdeVendida.setText("Qtde vendida: " + qtdeVendas.toString() )
    }
}
