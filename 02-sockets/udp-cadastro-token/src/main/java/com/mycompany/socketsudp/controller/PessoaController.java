package com.mycompany.socketsudp.controller;
import com.mycompany.socketsudp.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PessoaController {

    private final List<Pessoa> listaPessoas = new ArrayList<>();

    // Cadastra a pessoa. Retorna false se o e-mail já estiver cadastrado
    public synchronized boolean cadastrar(Pessoa pessoa) {
        if (listaPessoas.contains(pessoa)) {
            return false;
        }
        listaPessoas.add(pessoa);
        return true;
    }

    // Procura a pessoa pelo e-mail
    public synchronized Pessoa buscarPorEmail(String email) {
        for (Pessoa p : listaPessoas) {
            if (p.getEmail().equals(email)) {
                return p;
            }
        }
        return null;
    }

    // Se o token tem menos de 60 segundos, devolve o mesmo.
    // Se passou de 60 segundos ou não existe, gera um novo.
    public synchronized String gerarToken(Pessoa pessoa) {
        long agora = System.currentTimeMillis();
        
        if (agora - pessoa.getHoraToken() >= 60000) {
            String novoToken = UUID.randomUUID().toString();
            pessoa.setToken(novoToken);
            pessoa.setHoraToken(agora);
        }
        return pessoa.getToken();
    }

    public synchronized List<Pessoa> getListaPessoas() {
        return new ArrayList<>(listaPessoas);
    }
}
