# 02 - Sockets

Regras da disciplina: código orientado a objetos, em MVC e comentado.

## Projetos desta pasta

| Pasta | O que é |
|---|---|
| [`tcp-gerador-email`](tcp-gerador-email) | Exercício de aula: cliente/servidor TCP (Swing) que gera o e-mail institucional `primeiro.ultimo.ano@ufn.edu.br` e não duplica cadastros |
| [`udp-cadastro-token`](udp-cadastro-token) | **Trabalho avaliativo**: cliente/servidor UDP com cadastro e token (enunciado abaixo) |

---

## Trabalho Prático: Cliente-Servidor via UDP ✅
Projeto: [`udp-cadastro-token`](udp-cadastro-token)

**Objetivo:** desenvolver uma aplicação cliente-servidor com comunicação UDP por meio da classe `Comunicador` e uma interface gráfica.

**Requisitos gerais**
- **Interface gráfica:** o cliente deve ter interface em Java Swing (ou outro ambiente gráfico/linguagem).
- **Comunicação:** todo envio e recebimento de dados via protocolo UDP.

**1. Cadastro do cliente**
- O cliente inicia o contato enviando nome completo e e-mail.
- O servidor registra o usuário em uma lista interna usando a classe `Pessoa` (conforme visto em aula).
- O servidor controla e impede cadastros duplicados.

**2. Autenticação por chave temporária (token)**
- O cliente solicita periodicamente ao servidor uma chave token, gerada de forma aleatória.
- Cada token tem validade estrita de 60 segundos.
- Se o cliente pedir um novo token dentro dos 60 segundos, o servidor mantém o mesmo. Se o tempo expirou, gera e retorna uma nova chave.

**Como ficou:** `ComunicadorUDP`, `RecebedorUDP` (servidor) e `EnviadorUDP` (cliente); `PessoaController` gera o token com `UUID` e controla os 60 s; telas Swing. Mensagens: `CADASTRAR;nome;email` e `TOKEN;email`. Detalhes no `LEIAME.txt` do projeto.
