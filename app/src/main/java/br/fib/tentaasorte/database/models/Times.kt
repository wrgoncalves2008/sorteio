package br.fib.tentaasorte.database.models

import java.io.Serializable

data class Times (
    var id: Long = 0,
    var nome: String) : Serializable {

    override fun toString() : String {
        return  nome.toString()
    }
}