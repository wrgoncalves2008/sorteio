package br.fib.tentaasorte.database.models

import java.io.Serializable

data class Vendas (

    var id: Long = 0,
    var time: String? = null,
    var cliente: String? = null) : Serializable {

    override fun toString(): String {
        return cliente.toString() + " -> " + time.toString()
    }
}