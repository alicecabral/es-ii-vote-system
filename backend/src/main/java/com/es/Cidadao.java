package com.es;

public class Cidadao{
    private String  cpf;
    private Sexo sexo;
    private int idade;

    public Cidadao(String cpf, Sexo sexo, int idade) {
        this.cpf = cpf;
        this.sexo = sexo;
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}