package utilidades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import model.Sessao;

public class Util {

    public static String carregarArquivoEmHashMap(String nomeArquivo, HashMap<String, Sessao> sessoes, StringBuilder dadosSessoes) {
        try {
            for (String linha : Files.readAllLines(Paths.get(nomeArquivo))) {
                dadosSessoes.append(linha).append("\n");
                String[] dadosLinha = linha.split(";");

                if (dadosLinha.length >= 2) {
                    sessoes.put(dadosLinha[0], new Sessao(dadosLinha[0], dadosLinha[1]));
                }
            }
            return "";
        } catch (IOException e) {
            return "Erro ao processar o arquivo: " + e.getMessage();
        }
    }
}