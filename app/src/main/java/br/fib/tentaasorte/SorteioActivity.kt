package br.fib.tentaasorte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sorteio.*
import kotlin.random.Random

class SorteioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorteio)

        btnVoltarMainActivity.setOnClickListener{
            finish()
        }

        txtNumerosVendidos.setText( Sorteio.NumerosVendidos().toString() )

        btnSortear.setOnClickListener{
            var index = Random.nextInt(0 , Sorteio.NumerosVendidos())

            val cliente = Sorteio.getCliente( index )

            txtTimeSorteado.setText( cliente?.getTime() )
            txtNomeDoGanhador.setText(cliente?.getNome())
        }

        btnLimparLista.setOnClickListener{

            Sorteio.limparListaDeTimeVendidos()

            Toast.makeText(this, "Todos os registros de vendas foram apagados", Toast.LENGTH_LONG).show()
            txtTimeSorteado.setText( "" )
            txtNomeDoGanhador.setText("")
            txtNumerosVendidos.setText( "0000" )
        }
    }
}
