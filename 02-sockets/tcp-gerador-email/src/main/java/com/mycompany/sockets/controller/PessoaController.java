package com.mycompany.sockets.controller;
import com.mycompany.sockets.model.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaController {

    private final List<Pessoa> listaPessoas = new ArrayList<>();

    // método para evitar duplicatas
    public synchronized Pessoa processarCadastro(Pessoa pessoa) {
        if (listaPessoas.contains(pessoa)) {
            int index = listaPessoas.indexOf(pessoa);
            return listaPessoas.get(index);
        }
        // Gerar o email
        String emailGerado = gerarEmail(pessoa.getNome(), pessoa.getDataNascimento());
        pessoa.setEmail(emailGerado);
        listaPessoas.add(pessoa);
        return pessoa;
    }

    public synchronized List<Pessoa> getListaPessoas() {
        return new ArrayList<>(listaPessoas);
    }

    // Regra de formatação do e-mail: primeiro.ultimo.ano@ufn.edu.br
    public String gerarEmail(String nomeCompleto, String dataNascimentoStr) {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            return "invalido@ufn.edu.br";
        }

        String nomeLimpo = nomeCompleto.trim();
        String[] partesNome = nomeLimpo.split("\\s+");
        
        String primeiroNome = partesNome[0];
        String ultimoSobrenome = (partesNome.length > 1) ? partesNome[partesNome.length - 1] : "";

        String ano = "0000";
        if (dataNascimentoStr != null && dataNascimentoStr.contains("/")) {
            String[] partesData = dataNascimentoStr.trim().split("/");
            if (partesData.length == 3) {
                ano = partesData[2].trim();
            }
        }

        String email;
        if (ultimoSobrenome.isEmpty()) {
            email = primeiroNome + "." + ano + "@ufn.edu.br";
        } else {
            email = primeiroNome + "." + ultimoSobrenome + "." + ano + "@ufn.edu.br";
        }

        return email.toLowerCase();
    }
}
