package br.fib.tentaasorte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_venda.*

class VendaActivity : AppCompatActivity() {

    var timeselecionado = ""

    var listadetimes = arrayOf("Flamengo","Santos","Palmeiras","Grêmio","Athletico-PR","São Paulo","Internacional","Corinthians",
        "Fortaleza","Goiás","Bahia","Vasco","Atlético-MG","Fluminense","Botafogo","Ceará","Cruzeiro",
        "CSA","Chapecoense","Avaí")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venda)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listadetimes)
        lsttimes.adapter = adapter

        lsttimes.setOnItemClickListener { _, _, position, _ ->
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
                Sorteio.registrarVenda( txtNomeCliente.text.toString() , timeselecionado )
                Toast.makeText( this, "Venda registrada para o cliente " + txtNomeCliente.text.toString() + ", time escolhido foi " + timeselecionado, Toast.LENGTH_LONG ).show()

                finish()
            }
        }

    }
}
