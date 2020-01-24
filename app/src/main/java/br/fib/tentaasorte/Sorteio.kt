package br.fib.tentaasorte

object Sorteio {

    private var listadetimes = arrayOf("Flamengo","Santos","Palmeiras","Grêmio","Athletico-PR","São Paulo","Internacional","Corinthians",
        "Fortaleza","Goiás","Bahia","Vasco","Atlético-MG","Fluminense","Botafogo","Ceará","Cruzeiro",
        "CSA","Chapecoense","Avaí")

    private val clientes: ArrayList<Cliente>

    init {
        this.clientes = ArrayList<Cliente>()
    }

    fun getQtdeDeTime(): Int {
        return listadetimes.size
    }

    fun verificarTimesDisponiveis(): ArrayList<String> {

        var times = ArrayList<String>()

        for (time in listadetimes){
            if ( !timeJaSelecionado( time ) )
            {
                times.add(time)
            }
        }

        return times
    }

    fun ListarClientes(): ArrayList<Cliente> {
        return this.clientes
    }

    fun NumerosVendidos(): Int {
        return this.clientes.size
    }

    fun getCliente(id: Int): Cliente? {
        return this.clientes.get(id)
    }

    fun registrarVenda(nome: String, time: String) {
        this.clientes.add( Cliente( nome, time ))
    }

    fun timeJaSelecionado( time: String ): Boolean {

        var arr = timesEscolhidos()

        return arr.contains(time)
    }

    fun timesEscolhidos(): ArrayList<String> {

        val arr = ArrayList<String>()

        for (i in this.clientes.indices){
            arr.add( this.clientes.get(i).getTime() )
        }

        return arr
    }

    fun limparListaDeTimeVendidos(){
        this.clientes.clear()
    }

    fun getNomeTime( id : Int ) : String {
        return listadetimes.get(id)
    }
}