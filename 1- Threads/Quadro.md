Obrigacoes e avaliacoes:
  - github pessoal com um repositorio da disciplina
  - codigo dos desafios e trabalhos
  - notas_de_aula.md (20% da nota)
  - participacao efetiva(20% da nota)
  - todos os codigos orientados a objeto
  - todos os codigos tem q seguir a ideia da arquitetura MVC
  - todo codigo tem que ter comentario, se nao o professor vai devolver o codigo 

Arquiteruras de sistemas:
  1) Cliente-Servidor-> Modelo TCP/IP -> pratico X teorico OSI = 7 camadas
TCP/IP
aplicacao
transporte
internet 
rede

  2)Peer to peer (ponto a ponto)
  -modelo TCP/IP


vamos usar escrita e leitura

Thread -> mini processo -----> -declarar e envelopar          -iniciar          -pausar       -reiniciar        -finalizar ou matar
          *             -nome     
          *memoria+cpu
          *tempo
          *pai
Thread sem compartilhar memoria
Seção critica
Thread com compartilhar memoria  *bloqueio
                                 ->manter, semaforo, deadlock






Aula 02 31/07/2026





Aula 03 03/08/2026

Sistemas disribuidos o objetivo é compartilhar recursos pra que uma tarefa seja executada por N(s)
  - Ele é Heterogeneo
  - Fracamente acoplado
  - É um grid computacional 

Quais os principais recursos que se compartilham? 
  - Disco, Placas gráficas, mémorias.

Como um computador compartilha recurso com outro computador?
  - comunicação de dados (troca de dados)
    - protocolo

    Qual a diferenca de Thread com compartilhamento de memoria e sem compartilhamento de memoria?

    como fazer comunicação não bloqueante?



comunicação 
  -bloqueante
    - Seção critica

Compartilhamento memoria 
  - Seção critica

Memoria compartilhada
  - Sincronismo
      - Tempo 
      - bloqueio

Formas de criar Threads 

1) Objeto Thread (nome)
  - Vantagem é se é pouco codigo
  - Desvantagem não pode herdar outras classes em Java

2) new Thread 
  - reutilização de codigo
  - separação de responsabilidades

Multitarefas (Threads)


Aula 07//08

Diferenças de arquiteturas 


Cliente Servidor 
  - é um modelo centralizado, atua como servidore(s), fornecendo serviços
  - a função é atender as requisições dos clientes
  - a comunicação é unidirecional na requisição
Caracteristicas: Centralização e Dependência, se um servidor ficar indisponivel os clientes perdem o acesso

Arquitetura Ponto a Ponto:
  - Modelo descentralizado, todos os nós podem atuar tanto como clientes quanto como servidores.
  - Cada nó pode solicitar e fornecer recursos diretamente para outros nos, sem precisar de um servidor central
  - É mais dificil a manutenção já que se lança uma atualização, ele so muda em um, ai teria que mandar um a um todas atualizações.


TCP-IP registra (chat por texto é um exemplo, a mensagem chega sem se perder).
UDP - se perde no ar (chat por voz, se falou e não escutou, se perdeu a mensagem).


Sincronismo - Em Sistemas distribuidos os nós precisam coordenar ações para 
 - Evitar conflitor
 - Manter constancia de dados
 
 Sincronização é complexa:
  - Simples x Complexo
  - 



 