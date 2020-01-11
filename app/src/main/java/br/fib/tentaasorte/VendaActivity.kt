package br.fib.tentaasorte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_venda.*

class VendaActivity : AppCompatActivity() {

    var timeselecionado = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venda)

        var listadetimes = arrayOf("Flamengo","Santos","Palmeiras","Grêmio","Athletico-PR","São Paulo","Internacional","Corinthians",
                                   "Fortaleza","Goiás","Bahia","Vasco","Atlético-MG","Fluminense","Botafogo","Ceará","Cruzeiro",
                                   "CSA","Chapecoense","Avaí")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listadetimes)
        lsttimes.adapter = adapter

        lsttimes.setOnItemClickListener { parent, view, position, id ->
            timeselecionado = listadetimes.get(position)
        }

        btnregistrar.setOnClickListener{

            if (txtNomeCliente.text.toString() == ""){
                Toast.makeText(this,  "Informe o nome do cliente", Toast.LENGTH_LONG).show()
            }
            else if (timeselecionado == ""){
                Toast.makeText(this,  "Selecione um time", Toast.LENGTH_LONG).show()
            }
            else
            {
                Sorteio.getInstance().registrarVenda( txtNomeCliente.text.toString() , timeselecionado )
                Toast.makeText( this, "Venda registrar para o cliente " + txtNomeCliente.text.toString() + ", time escolhido foi " + timeselecionado, Toast.LENGTH_LONG ).show()

            }
        }

    }
}
