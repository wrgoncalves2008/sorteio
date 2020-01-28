package br.fib.tentaasorte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import br.fib.tentaasorte.database.models.Times
import br.fib.tentaasorte.database.models.Vendas
import br.fib.tentaasorte.database.repository.TimesRepository
import br.fib.tentaasorte.database.repository.VendasRepository
import kotlinx.android.synthetic.main.activity_venda.*

class VendaActivity : AppCompatActivity() {

    var timeselecionado: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venda)

        val timesDisponiveis = TimesRepository(this).listarTimesDisponiveis()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, timesDisponiveis)
        lsttimes.adapter = adapter

        txtTimesDisponiveis.setText("Times restantes: " + timesDisponiveis.size.toString())
        txtTimeSelecionado.setText("Time Selecionado: Nenhum")

        lsttimes.setOnItemClickListener { _, _, position, _ ->
            timeselecionado = timesDisponiveis.get(position).nome
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
                val venda = Vendas( time =  timeselecionado,
                                    cliente = txtNomeCliente.text.toString() )

                VendasRepository(this).create( venda )

                Toast.makeText( this, "Venda registrada para o cliente " + txtNomeCliente.text.toString() + ", time escolhido foi " + timeselecionado, Toast.LENGTH_SHORT ).show()
                finish()
            }
        }

        btncancelar.setOnClickListener{
            finish()
        }

    }
}
