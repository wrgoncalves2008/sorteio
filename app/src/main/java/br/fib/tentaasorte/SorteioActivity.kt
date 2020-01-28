package br.fib.tentaasorte

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.fib.tentaasorte.database.models.Times
import br.fib.tentaasorte.database.models.Vendas
import br.fib.tentaasorte.database.repository.TimesRepository
import br.fib.tentaasorte.database.repository.VendasRepository
import kotlinx.android.synthetic.main.activity_sorteio.*
import kotlin.random.Random

class SorteioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorteio)

        btnVoltarMainActivity.setOnClickListener{
            finish()
        }

        var qtdeTimeVendidos = intent.getIntExtra("qtdevendas" , 0 )

        txtNumerosVendidos.setText( qtdeTimeVendidos.toString() )

        btnSortear.setOnClickListener{

            if (!qtdeTimeVendidos.equals(0)) {

                val listatimes: ArrayList<Times> = TimesRepository(this).findAll()

                var index = Random.nextInt(0, listatimes.size)

                if ((index + 1) > qtdeTimeVendidos)
                {

                    txtTimeSorteado.setText( listatimes.get(index).nome )
                    txtNomeDoGanhador.setText("Não houve ganhador!")
                    txtNomeDoGanhador.setTextColor( Color.RED )
                }
                else {
                    var venda: ArrayList<Vendas> = VendasRepository(this).findVenda( listatimes.get(index).nome )

                    txtTimeSorteado.setText(venda.get(0).time)
                    txtNomeDoGanhador.setText(venda.get(0).cliente)
                    txtNomeDoGanhador.setTextColor( Color.BLUE )
                }
            }
        }

        btnLimparLista.setOnClickListener{

            VendasRepository(this).limparTabela()

            Toast.makeText(this, "Todos os registros de vendas foram apagados", Toast.LENGTH_LONG).show()
            txtTimeSorteado.setText( "" )
            txtNomeDoGanhador.setText("")
            txtNumerosVendidos.setText( "0000" )
        }
    }
}
