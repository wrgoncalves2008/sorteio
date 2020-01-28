package br.fib.tentaasorte.database.repository

import android.content.Context
import br.fib.tentaasorte.database.bd.Constantes.TABLE_VENDAS
import br.fib.tentaasorte.database.bd.database
import br.fib.tentaasorte.database.models.Vendas
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class VendasRepository(val context: Context) {

    fun findAll() : ArrayList<Vendas> = context.database.use {
        val vendas = ArrayList<Vendas>()

        select(TABLE_VENDAS, "id", "cliente", "time")
            .parseList(object: MapRowParser<List<Vendas>> {
                override fun parseRow(columns: Map<String, Any?>): List<Vendas> {

                    val venda = Vendas(
                        id = columns.getValue("id").toString().toLong(),
                        cliente = columns.getValue("cliente") as String,
                        time = columns.getValue("time") as String)

                    vendas.add(venda)
                    return vendas
                }
            })

        vendas
    }

    fun findVenda(timeFiltro: String) : ArrayList<Vendas> = context.database.use {
        val vendas = ArrayList<Vendas>()

        select(TABLE_VENDAS, "id", "cliente", "time")
            .whereArgs("time = {time}", "time" to timeFiltro)
            .parseList(object: MapRowParser<List<Vendas>> {
                override fun parseRow(columns: Map<String, Any?>): List<Vendas> {

                    val venda = Vendas(
                        id = columns.getValue("id").toString().toLong(),
                        cliente = columns.getValue("cliente") as String,
                        time = columns.getValue("time") as String)

                    vendas.add(venda)
                    return vendas
                }
            })

        vendas
    }

    fun create(venda: Vendas) = context.database.use {
        insert(TABLE_VENDAS,
            "cliente" to venda.cliente,
                    "time" to venda.time)
    }

    fun limparTabela() = context.database.use {
        delete(TABLE_VENDAS, null, null)
    }

//    fun delete(id: Long) = context.database.use {
//        delete(TABLE_VENDAS, "id = {vendaId}", *arrayOf("vendaId" to id))
//    }
}