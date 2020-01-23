package br.fib.tentaasorte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_venda.*

class VendaActivity : AppCompatActivity() {

    var timeselecionado: String = ""
    var timesDisponiveis = ArrayList<String>()

    var listadetimes = arrayOf("Flamengo","Santos","Palmeiras","Grêmio","Athletico-PR","São Paulo","Internacional","Corinthians",
        "Fortaleza","Goiás","Bahia","Vasco","Atlético-MG","Fluminense","Botafogo","Ceará","Cruzeiro",
        "CSA","Chapecoense","Avaí")

    fun verificarTimesDisponiveis() {

        for (time in listadetimes){
            if ( !Sorteio.timeJaSelecionado( time ) )
            {
                timesDisponiveis.add(time)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venda)

        verificarTimesDisponiveis()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, timesDisponiveis)
        lsttimes.adapter = adapter

        txtTimesDisponiveis.setText("Times restantes: " + timesDisponiveis.size.toString())
        txtTimeSelecionado.setText("Time Selecionado: Nenhum")

        lsttimes.setOnItemClickListener { _, _, position, _ ->
            timeselecionado = timesDisponiveis.get(position)
            txtTimeSelecionado.setText("Time Selecionado: " + timeselecionado)
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
                Toast.makeText( this, "Venda registrada para o cliente " + txtNomeCliente.text.toString() + ", time escolhido foi " + timeselecionado, Toast.LENGTH_SHORT ).show()

                finish()
            }
        }

        btncancelar.setOnClickListener{
            finish()
        }

    }
}
