package br.fib.tentaasorte;

import java.util.ArrayList;

public class Sorteio {

        private static Sorteio instance;
        private ArrayList<Cliente> clientes;

        private Sorteio() {
            this.clientes = new ArrayList<Cliente>();

            this.clientes.add( new Cliente("Will", "São Paulo"));
            this.clientes.add( new Cliente("Rosana", "Palmeiras"));
            this.clientes.add( new Cliente("Zé", "Santos"));
        }

        public static Sorteio getInstance() {
            if (instance == null) {
                instance = new Sorteio();
            }
            return instance;
        }

        public ArrayList<Cliente> ListarClientes() {
            return clientes;
        }

        public int NumerosVendidos(){
            return clientes.size();
        }

        public Cliente getCliente(int id ) {
            return clientes.get(id);
        }

        public void registrarVenda( String nome, String time ){
            this.clientes.add( new Cliente( nome, time) );
        }
    }

