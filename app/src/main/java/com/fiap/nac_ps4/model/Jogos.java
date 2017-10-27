package com.fiap.nac_ps4.model;

/**
 * Created by User on 27/10/2017.
 */

public class Jogos {


    private int id;
    private String nome;

    public Jogos(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
