package br.fib.tentaasorte.database.repository

import android.content.Context
import br.fib.tentaasorte.database.bd.database
import br.fib.tentaasorte.database.models.Times
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.*
import br.fib.tentaasorte.database.bd.Constantes.TABLE_TIMES

class TimesRepository(val context: Context) {


    fun findAll() : ArrayList<Times> = context.database.use {
        val Times = ArrayList<Times>()

        select(TABLE_TIMES, "id", "nome")
            .parseList(object: MapRowParser<List<Times>> {
                override fun parseRow(columns: Map<String, Any?>): List<Times> {

                    val time = Times(
                        id = columns.getValue("id").toString()?.toLong(),
                        nome = columns.getValue("nome") as String)

                    Times.add(time)
                    return Times
                }
            })

        Times
    }

    fun listarTimesDisponiveis() : ArrayList<Times> = context.database.use {
        val Times = ArrayList<Times>()


        select(TABLE_TIMES, "id", "nome")
            .whereArgs("nome NOT IN (SELECT TIME FROM vendas)")
            .parseList(object: MapRowParser<List<Times>> {
                override fun parseRow(columns: Map<String, Any?>): List<Times> {

                    val time = Times(
                        id = columns.getValue("id").toString()?.toLong(),
                        nome = columns.getValue("nome") as String)

                    Times.add(time)
                    return Times
                }
            })

        Times
    }

    fun qtdeTimes(): Int = context.database.use {

        query(TABLE_TIMES, arrayOf("id"), null, null, null, null, null,null).count.toInt()
    }

    fun listarTimesVendidos(): ArrayList<Times> = context.database.use {
        val Times = ArrayList<Times>()

        select(TABLE_TIMES, "id", "nome")
            .whereArgs("nome IN (SELECT TIME FROM vendas)")
            .parseList(object: MapRowParser<List<Times>> {
                override fun parseRow(columns: Map<String, Any?>): List<Times> {

                    val time = Times(
                        id = columns.getValue("id").toString()?.toLong(),
                        nome = columns.getValue("nome") as String)

                    Times.add(time)
                    return Times
                }
            })

        Times
    }

    fun create(time: Times) = context.database.use {
        insert(TABLE_TIMES,
               "nome" to time.nome)
    }

    fun delete(id: Long) = context.database.use {
//       delete(TABLE_TIMES, "id = {timeId}" , *arrayOf("timeId" to id))
    }
}