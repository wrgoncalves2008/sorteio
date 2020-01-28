package br.fib.tentaasorte.database.bd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import br.fib.tentaasorte.database.bd.Constantes.TABLE_TIMES
import br.fib.tentaasorte.database.bd.Constantes.TABLE_VENDAS
import br.fib.tentaasorte.database.bd.Constantes.DB_NAME
import org.jetbrains.anko.db.*

class BancoDadosHelper(context: Context) :
    ManagedSQLiteOpenHelper(ctx = context , name = DB_NAME,  version = 1) {

    private val listadetimes = arrayOf("INSERT INTO $TABLE_TIMES VALUES(1,'Flamengo')",
                                       "INSERT INTO $TABLE_TIMES VALUES(2,'Santos')",
                                       "INSERT INTO $TABLE_TIMES VALUES(3,'Palmeiras')",
                                       "INSERT INTO $TABLE_TIMES VALUES(4,'Grêmio')",
                                       "INSERT INTO $TABLE_TIMES VALUES(5,'Athletico-PR')",
                                       "INSERT INTO $TABLE_TIMES VALUES(6,'São Paulo')",
                                       "INSERT INTO $TABLE_TIMES VALUES(7,'Internacional')",
                                       "INSERT INTO $TABLE_TIMES VALUES(8,'Corinthians')",
                                       "INSERT INTO $TABLE_TIMES VALUES(9,'Fortaleza')",
                                       "INSERT INTO $TABLE_TIMES VALUES(10,'Goiás')",
                                       "INSERT INTO $TABLE_TIMES VALUES(11,'Bahia')",
                                       "INSERT INTO $TABLE_TIMES VALUES(12,'Vasco')",
                                       "INSERT INTO $TABLE_TIMES VALUES(13,'Atlético-MG')",
                                       "INSERT INTO $TABLE_TIMES VALUES(14,'Fluminense')",
                                       "INSERT INTO $TABLE_TIMES VALUES(15,'Botafogo')",
                                       "INSERT INTO $TABLE_TIMES VALUES(16,'Ceará')",
                                       "INSERT INTO $TABLE_TIMES VALUES(17,'Cruzeiro')",
                                       "INSERT INTO $TABLE_TIMES VALUES(18,'CSA')",
                                       "INSERT INTO $TABLE_TIMES VALUES(19,'Chapecoense')",
                                       "INSERT INTO $TABLE_TIMES VALUES(20,'Avaí')")

    companion object {
        private var instance : BancoDadosHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): BancoDadosHelper {

            if (instance == null) {
                instance =
                    BancoDadosHelper(ctx.getApplicationContext())
            }

            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable( TABLE_TIMES , true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "nome" to TEXT)

        db.createTable( TABLE_VENDAS , true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "time" to TEXT,
            "cliente" to TEXT)


        listadetimes.forEach { sql ->
            db.execSQL(sql)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(TABLE_TIMES, true)
        db.dropTable(TABLE_VENDAS, true)
        onCreate(db)
    }

}

val Context.database: BancoDadosHelper
    get() = BancoDadosHelper.getInstance(
        getApplicationContext()
    )
