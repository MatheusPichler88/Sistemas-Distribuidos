package com.mycompany.socketsudp.model;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private String email;
    private String token;
    private long horaToken; 

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.token = "";
        this.horaToken = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getHoraToken() {
        return horaToken;
    }

    public void setHoraToken(long horaToken) {
        this.horaToken = horaToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(email, pessoa.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return nome + " | " + email + " | " + token;
    }
}
