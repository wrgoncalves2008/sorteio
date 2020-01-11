package br.fib.tentaasorte;

import androidx.annotation.NonNull;

public class Cliente {

    private String nome;
    private String time;

    public String getTime(){
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome, String time) {

        this.nome = nome;
        this.time = time;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
