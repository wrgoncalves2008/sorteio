package br.fib.tentaasorte

class Cliente {

    private var nome: String = ""
    private var time: String = ""


    constructor(nome: String, time: String) {
        this.nome = nome
        this.time = time
    }

    override fun toString(): String {
        return nome
    }

    fun getTime() : String {
        return this.time
    }

    fun getNome(): String {
        return this.nome
    }

}