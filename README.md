# Sistemas Distribuídos

Códigos, exercícios e trabalhos da disciplina de Sistemas Distribuídos (6º semestre, Ciência da Computação).

Regras da disciplina: código orientado a objetos, em **MVC**.

## Organização

O repositório é dividido por tópico da disciplina, na ordem em que foram vistos. Cada pasta tem um `README.md` com os enunciados, os requisitos e a situação de cada exercício/trabalho.

| Pasta | Tópico | Projetos |
|---|---|---|
| [`01-threads`](01-threads) | Threads, memória compartilhada, pool, mensageria | `exemplos-aula`, `banco-caixas-eletronicos`, `servidor-pedidos`, `sistema-notificacao`, `caixas-saldo-compartilhado` (trabalho), `relatorio-vendas-filiais` (trabalho) |
| [`02-sockets`](02-sockets) | Sockets TCP e UDP | `tcp-gerador-email`, `udp-cadastro-token` (trabalho) |
| [`03-rpc`](03-rpc) | RPC | `encurtador-links` (trabalho) |
| [`04-rmi`](04-rmi) | RMI | `telefonia` |
| [`notas_de_aula.md`](notas_de_aula.md) | Notas de aula e pesquisas (relógios, exclusão mútua, eleição, pool de threads) | |

Cada projeto é independente e fica dentro da pasta do seu tópico. Exemplos, exercícios e trabalhos avaliativos aparecem juntos no tópico, e o `README.md` da pasta diz qual é qual.

## Como rodar

| Tipo de projeto | Como rodar |
|---|---|
| Java com `pom.xml` (Maven) | Dentro da pasta do projeto: `mvn compile` e execute a classe `Principal`/`Main`, ou abra na IDE |
| `caixas-saldo-compartilhado` | Projeto de IntelliJ sem Maven: abra na IDE e execute `View/Principal` |
| `telefonia` | Projeto NetBeans/Ant: abra no NetBeans e siga o `LEIAME.txt` |
| `encurtador-links` | Python: crie a venv e instale o `requirements.txt` (ver o README do projeto) |

## O que não é versionado

O `.gitignore` da raiz ignora arquivos gerados e de ambiente: pastas de build (`target/`, `build/`, `dist/`, `out/`, `*.class`), configurações de IDE (`.idea/`, `*.iml`, `nbproject/private/`, `.vscode/`) e ambientes Python (`venv/`, `__pycache__/`).
