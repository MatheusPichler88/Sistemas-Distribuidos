# 01 - Threads

Regras da disciplina: código orientado a objetos, em MVC e comentado. Os programas são apresentados oralmente ao professor.

Legenda: ✅ feito · 🟡 parcial · ⬜ não feito

## Projetos desta pasta

| Pasta | O que é |
|---|---|
| [`exemplos-aula`](exemplos-aula) | Exemplos de aula: Thread, Runnable, race condition, `synchronized`, lista compartilhada com pool e servidor de eco |
| [`banco-caixas-eletronicos`](banco-caixas-eletronicos) | Vários caixas usando a mesma conta |
| [`servidor-pedidos`](servidor-pedidos) | Servidor com `ServerSocket` e pool de 4 threads |
| [`sistema-notificacao`](sistema-notificacao) | Thread de notificação junto da thread principal |
| [`caixas-saldo-compartilhado`](caixas-saldo-compartilhado) | **Trabalho avaliativo**, Módulo 1 |
| [`relatorio-vendas-filiais`](relatorio-vendas-filiais) | **Trabalho avaliativo**, Módulo 2 |

Anotações da disciplina: [`Quadro.md`](Quadro.md) (rascunho) e [`../notas_de_aula.md`](../notas_de_aula.md).

---

## Trabalhos avaliativos

Entrega: disponibilizar os códigos no GitHub pessoal para avaliação posterior.

### Módulo 1, Exercício 1: Sistema de Caixa Centralizado de Evento (média) ✅
Projeto: [`caixas-saldo-compartilhado`](caixas-saldo-compartilhado)

Foco: sincronização, condições de corrida e exclusão mútua (com compartilhamento de memória).

**Contexto:** um grande festival de música possui 5 caixas físicos vendendo fichas de alimentação simultaneamente. Todos os caixas atualizam o mesmo saldo bancário centralizado do evento.

**Requisitos:**
- Criar uma variável global/compartilhada chamada `saldo_central`.
- Instanciar 5 threads (os caixas).
- Cada thread simula a venda de 1.000 fichas (cada ficha custa R$ 10,00), somando o valor ao `saldo_central`.
- O saldo final esperado deve ser exatamente **R$ 50.000,00**.

**O que avalia:** mecanismos de sincronização (`synchronized` / `ReentrantLock` em Java, `threading.Lock` em Python) para garantir a consistência do saldo.

### Módulo 2, Exercício 2: Relatório de Vendas por Filial (fácil) ✅
Projeto: [`relatorio-vendas-filiais`](relatorio-vendas-filiais)

Foco: divisão de tarefas, junção de resultados e isolamento (sem compartilhamento de memória).

**Contexto:** uma franquia precisa calcular o faturamento total anual somando os dados independentes de suas 4 filiais.

**Requisitos:**
- Criar 4 listas independentes de números, cada uma simulando as vendas de uma filial (ex.: 10.000 registros por lista).
- Disparar 4 threads. Cada thread recebe apenas a lista da sua filial e calcula a soma localmente.
- As threads não podem acessar variáveis globais durante a execução.
- A thread principal aguarda o fim de todas e soma os 4 resultados finais.

**O que avalia:** conceito de fork-join e isolamento. Em Java, o uso de `join()` com classes que estendem `Thread` / implementam `Runnable` (guardando o resultado em um atributo do objeto) ou `Future` / `Callable`. Em Python, `threading.Thread` com retorno planejado ou `concurrent.futures`.

---

## Exercícios de fixação

### 1. Divisão e Conquista: Soma de Sublistas ⬜
- **Contexto:** processamento de grandes volumes de dados numéricos.
- **Problema:** dada uma lista com 10.000 números inteiros aleatórios, dividir em 4 partes iguais.
- **Ação:** criar 4 threads. Cada uma recebe apenas uma parte como parâmetro, calcula a soma da sua sublista e retorna o valor.
- **Encerramento:** a thread principal aguarda as 4 threads, coleta as 4 somas parciais e calcula a soma total.
- Sem compartilhamento de memória (sem usar `Runnable`), orientado a objetos e em MVC.

### 2. Filtro de Dados Independente (Map) ⬜
- **Contexto:** limpeza e saneamento de bases de dados.
- **Problema:** lista com 5.000 strings de nomes de usuários gravados em um arquivo `.txt`.
- **Ação:** dividir a lista em 2 blocos. A Thread A recebe a primeira metade e a Thread B a segunda. Cada uma processa sua sublista isolada: remove espaços no início/fim e converte tudo para maiúsculas.
- **Encerramento:** cada thread retorna uma nova lista limpa e a thread principal junta as duas.
- Sem compartilhamento de memória (sem usar `Runnable`), orientado a objetos e em MVC.

### 3. Pool de threads: pesquisa e exemplos com listas 🟡
- Pesquisar e compilar a teoria de pool de threads e criar exemplos usando listas.
- Pesquisa: seção *Pool de Threads* em [`notas_de_aula.md`](../notas_de_aula.md).
- Exemplo com lista e `ExecutorService`: `exemplos-aula/.../ListaCompartilhada.java`.
- Falta refazer os exercícios 1 e 2 usando pool em vez de lista de threads.

### 4. Pesquisa: Relógios Físicos e Lógicos, Exclusão Mútua e Eleição ✅
- Pesquisar, compilar e disponibilizar no GitHub pessoal.
- Conteúdo em [`notas_de_aula.md`](../notas_de_aula.md).

### 5. Analisador de Logs Distribuído (MapReduce local) ⬜
- Processar arquivos de log gigantescos ([`erro.log`](https://raw.githubusercontent.com/alexandrezamberlan/sistemasDistribuidos/refs/heads/master/00-exercicios_trabalhos/erro.log)).
- **Cenário:** um processo coordenador lê o arquivo grande e divide em pedaços menores.
- **Regra do pool:** o coordenador envia cada pedaço para um pool de trabalhadores usando filas de mensagens (mensageria).
- **Sem memória compartilhada:** os trabalhadores não alteram variáveis globais. Cada um processa seu pedaço isolado e devolve um resumo parcial (ex.: contagem de erros).
- **Resultado:** o coordenador junta todos os resumos e mostra o resultado final.

### 6. Simulador de Chat por Mensageria ⬜
- Mini chat em que o estado não é compartilhado entre as threads.
- **Cenário:** vários clientes se conectam ao servidor.
- **Regra do pool:** o servidor usa um pool de trabalhadores (estilo modelo de atores). Cada trabalhador cuida de um grupo de usuários ou de salas.
- **Sem memória compartilhada:** as threads não acessam uma lista global de usuários conectados. Para enviar uma mensagem a outro usuário, a thread remetente envia uma mensagem (formato de rede ou canal) para a thread destino.
- **Resultado:** o chat funciona em tempo real apenas com envio de mensagens entre os componentes isolados.
