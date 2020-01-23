package br.fib.tentaasorte

object Sorteio {

    val clientes: ArrayList<Cliente>

    init {
        clientes = ArrayList<Cliente>()
    }

    fun ListarClientes(): ArrayList<Cliente> {
        return clientes
    }

    fun NumerosVendidos(): Int {
        return clientes.size
    }

    fun getCliente(id: Int): Cliente? {
        return this.clientes.get(id)
    }

    fun registrarVenda(nome: String, time: String) {
        clientes.add( Cliente( nome, time ))
    }

    fun timeJaSelecionado( time: String ): Boolean {

        var arr = timesEscolhidos()

        return arr.contains(time)
    }

    fun timesEscolhidos(): ArrayList<String> {

        val arr = ArrayList<String>()

        for (i in this.clientes.indices){
            arr.add( clientes.get(i).getTime() )
        }

        return arr
    }
}