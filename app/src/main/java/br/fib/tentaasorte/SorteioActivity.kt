package br.fib.tentaasorte

import android.graphics.Color
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

            if (Sorteio.NumerosVendidos() > 0) {

                var index = Random.nextInt(0, Sorteio.getQtdeDeTime())


                if ((index + 1) > Sorteio.NumerosVendidos())
                {
                    txtTimeSorteado.setText( Sorteio.getNomeTime(index) )
                    txtNomeDoGanhador.setText("Não houve Ganhador")
                    txtNomeDoGanhador.setTextColor( Color.RED )
                }
                else {
                    val cliente = Sorteio.getCliente(index)

                    txtTimeSorteado.setText(cliente?.getTime())
                    txtNomeDoGanhador.setText(cliente?.getNome())
                    txtNomeDoGanhador.setTextColor( Color.BLUE )
                }
            }
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
