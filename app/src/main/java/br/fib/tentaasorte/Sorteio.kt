package br.fib.tentaasorte

import java.lang.reflect.Array

object Sorteio {

    val clientes: ArrayList<Cliente>

    init {
        clientes = ArrayList<Cliente>()

//            this.clientes.add( new Cliente("Will", "São Paulo"));
//            this.clientes.add( new Cliente("Rosana", "Palmeiras"));
//            this.clientes.add( new Cliente("Zé", "Santos"));

    }

    fun ListarClientes(): ArrayList<Cliente>? {
        return clientes
    }

    fun NumerosVendidos(): Int {
        return clientes.size
    }

    fun getCliente(id: Int): Cliente? {
        return this.clientes.get(id)
    }

    fun registrarVenda(nome: String?, time: String?) {
        clientes.add(Cliente(nome, time))
    }

    fun timesEscolhidos(): ArrayList<String> {

        val arr = ArrayList<String>()

        for (i in this.clientes.indices){
            arr.add( clientes.get(i).nome )
        }

        return arr
    }

    @override
    fun
}