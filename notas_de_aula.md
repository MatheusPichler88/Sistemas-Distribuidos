# Notas de aula - Sistemas Distribuidos

Obrigacoes e avaliacoes:
  - github pessoal com um repositorio da disciplina
  - codigo dos desafios e trabalhos
  - notas_de_aula.md (20% da nota)
  - participacao efetiva (20% da nota)
  - todos os codigos orientados a objeto
  - todos os codigos tem q seguir a ideia da arquitetura MVC
  - todo codigo tem que ter comentario, se nao o professor vai devolver o codigo


## Aula 01 27/07/2026

Arquiteturas de sistemas:

  1) Cliente-Servidor -> Modelo TCP/IP -> pratico X teorico OSI = 7 camadas

  TCP/IP
    - aplicacao
    - transporte
    - internet
    - rede

  2) Peer to peer (ponto a ponto)
    - modelo TCP/IP

Vamos usar escrita e leitura

Thread -> mini processo
  - declarar e envelopar
  - iniciar
  - pausar
  - reiniciar
  - finalizar ou matar

Uma thread tem:
  - nome
  - memoria + cpu
  - tempo
  - pai


## Aula 02 31/07/2026

Thread sem compartilhar memoria
  - cada thread mexe so nos dados dela
  - nao tem problema de concorrencia
  - exemplo: dividir uma lista em partes e cada thread soma a sua

Thread com compartilhar memoria
  - varias threads mexendo na mesma variavel
  - Seção critica = trecho do codigo que mexe no recurso compartilhado
  - precisa de *bloqueio*
  - ferramentas: synchronized, semaforo
  - problema: deadlock (uma thread espera a outra e as duas ficam travadas pra sempre)

Race condition (condição de corrida)
  - contador++ NÃO é atômico: ler, somar, escrever
  - duas threads leem o mesmo valor e uma sobrescreve a outra
  - o resultado final fica menor do que o esperado (Exemplo3: esperava 200000 e deu menos)
  - com synchronized na seção crítica o resultado fica certo (Exemplo4)

join()
  - a thread principal espera a outra terminar
  - sem o join a principal pode imprimir o resultado antes das threads acabarem


## Aula 03 03/08/2026

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
  - sem compartilhamento: cada thread tem seus dados, nao precisa de bloqueio, mais simples e rapido
  - com compartilhamento: todas mexem no mesmo dado, precisa de seção crítica e sincronismo pra nao dar erro

Como fazer comunicação não bloqueante?
  - a thread nao fica parada esperando a resposta, ela segue trabalhando
  - usar uma thread separada pra esperar (ex: a thread de notificação roda enquanto o usuario navega)

Comunicação
  - bloqueante
    - Seção critica

Compartilhamento memoria
  - Seção critica

Memoria compartilhada
  - Sincronismo
      - Tempo
      - bloqueio

Formas de criar Threads

1) Objeto Thread (extends Thread)
  - Vantagem é se é pouco codigo
  - Desvantagem não pode herdar outras classes em Java

2) new Thread com Runnable (implements Runnable)
  - reutilização de codigo
  - separação de responsabilidades

Multitarefas (Threads)


## Aula 04 07/08/2026

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
  - Evitar conflitos
  - Manter consistencia de dados

Sincronização é complexa:
  - Simples x Complexo
  - quanto mais nós, mais dificil de coordenar (cada nó tem seu proprio relogio e a rede tem atraso)


## Aula 05 10/08/2026

Deadlock e semaforo
  - Deadlock: Thread A segura o recurso 1 e quer o 2, Thread B segura o 2 e quer o 1. Ninguem sai
  - Como evitar: sempre pegar os recursos na mesma ordem
  - Semaforo: contador que controla quantas threads entram ao mesmo tempo na seção crítica
    - semaforo com valor 1 funciona igual um bloqueio (mutex)

Exemplo do banco
  - varios caixas eletronicos (threads) mexendo na mesma conta
  - sem sincronizar o saldo fica errado
  - com synchronized no saque/deposito o saldo fica certo


## Aula 06 14/08/2026

Servidor com varias threads
  - servidor com sockets recebe um cliente de cada vez no accept()
  - se atender na propria thread, o segundo cliente fica esperando
  - solução: uma thread pra cada cliente

Problema: criar uma thread nova pra cada pedido é caro, se chegarem 10000 pedidos o servidor cai
  - solução: pool de threads (ver a pesquisa mais embaixo)

Exemplos feitos: Servidor de Eco e Servidor de Pedidos (pool com ExecutorService)


## Aula 07 17/08/2026

Sistemas distribuidos precisam trocar dados pela rede, entao precisamos de uma forma de comunicação

Formas de comunicação
  - Sockets (baixo nivel, a gente que monta a mensagem)
  - RPC / RMI (alto nivel, chamar um metodo que roda em outra maquina como se fosse local)

Socket = ponto de comunicação, é o IP + a porta
  - Servidor: abre a porta e espera
  - Cliente: sabe o IP e a porta do servidor e conecta


## Aula 08 21/08/2026

Revisão para a prova
  - threads (com e sem memoria compartilhada)
  - seção crítica, synchronized, deadlock
  - arquiteturas cliente-servidor e ponto a ponto
  - TCP x UDP
  - sincronismo


## aula 24/08/2026 (Aula 09)

Prova dia 28 até aula 5 do quadro branco
- Atividades:
    - pesquisar, compilar e disponibilizar nos githubs pessoais sobre Relógios Físicos e Lógicos. Exclusão Mútua e Eleição
    - pesquisar e compilar sobre a teoria de poll de threads
    - refazer o codigo ao inves de lista de Threads, usar pool.


 Exercicio: Codigo está em pesquisa e ordenação
 (RMI ou RPC)

Servidor
carregar os dados
colocar num hashmap

Cliente
Buscar o seu numero de celular no servidor

Não usamos arquivos o servidor vai carregar a base de dados


## Aula 10 28/08/2026

Prova


## Aula 11 31/08/2026

Sockets TCP
  - TCP é orientado a conexão: antes de mandar dado o cliente conecta no servidor
  - garante a entrega e a ordem das mensagens

Servidor
  - ServerSocket(porta) abre a porta
  - accept() fica bloqueado esperando um cliente conectar
  - quando conecta devolve um Socket pra falar com aquele cliente

Cliente
  - new Socket(ip, porta) conecta no servidor


## Aula 12 04/09/2026

Troca de dados no TCP
  - escrita e leitura nos streams do socket (entrada e saida)
  - quem escreve de um lado tem que ler do outro
  - o read tambem bloqueia ate chegar dado

Exercicio: Gerador de email com socket
  - cliente manda nome e data de nascimento
  - servidor gera o email no formato primeiro.ultimo.ano@ufn.edu.br e devolve


## Aula 13 11/09/2026

Gerador de email com socket (continuação)
  - se a pessoa ja foi cadastrada o servidor devolve o email que ja existe (nao duplica)

Em MVC
  - model: Pessoa (implements Serializable pra poder passar pela rede)
  - controller: PessoaController (regra do email e a lista de pessoas)
  - view: ClienteView e ServidorView (telas Swing)

O controller usa synchronized porque varios clientes podem cadastrar ao mesmo tempo (memoria compartilhada!)


## Aula 14 14/09/2026

Sockets UDP
  - sem conexão, o cliente so manda o pacote
  - não garante entrega nem ordem (se perdeu, perdeu)
  - mais rapido e mais leve que o TCP
  - bom pra voz, video, jogos online

Classes do Java
  - DatagramSocket = o socket UDP
  - DatagramPacket = o pacote, leva os dados + IP + porta de destino
  - send() manda e receive() recebe (o receive bloqueia esperando pacote)


## Aula 15 18/09/2026

Diferenca UDP x TCP
  - no TCP o servidor tem um socket pra cada cliente
  - no UDP é um socket so e cada pacote diz de onde veio

Exercicio: Cliente/Servidor via UDP (cadastro com token)
  - separamos as classes que enviam e recebem (EnviadorUDP, RecebedorUDP, ComunicadorUDP)
  - mensagens: CADASTRAR;nome;email (resposta OK ou DUPLICADO) e TOKEN;email (resposta é o token ou NAO_CADASTRADO)
  - depois de cadastrado o cliente pede o token sozinho a cada 10 segundos
  - o servidor mantem o mesmo token por 60 segundos e depois gera um novo


## Aula 16 21/09/2026

Revisão de sockets
  - TCP: conexão, confiavel, mais pesado
  - UDP: sem conexão, pode perder, mais leve
  - nos dois a gente monta a mensagem e cuida de ler e escrever (baixo nivel)
  - isso da trabalho, por isso existem RPC e RMI (proximos assuntos)


## Aula 17 25/09/2026

Entrega das atividades da aula de 24/08 (pesquisas la embaixo)
  - pool de threads
  - relógios físicos e lógicos
  - exclusão mútua
  - eleição


## Aula 18 02/10/2026

RPC - Remote Procedure Call (chamada de procedimento remoto)
  - chamar uma função que roda em outra maquina como se fosse local
  - quem usa nao precisa saber de socket, porta, bytes
  - por baixo dos panos continua usando socket
  - o RPC é um modelo (uma ideia), nao é de uma linguagem, qualquer linguagem pode ter
  - esconde a rede: se chama transparencia de acesso/localização

Por que existe
  - no socket a gente monta a mensagem e cuida de ler e escrever (da trabalho e da erro)
  - no RPC a gente so chama a função


## Aula 19 05/10/2026

Como funciona o RPC (passo a passo)
  1) Cliente chama a função no stub do cliente (proxy), que parece a função de verdade
  2) o stub empacota os parametros (marshalling) e monta a mensagem
  3) a mensagem vai pela rede ate o servidor (por baixo é socket TCP ou UDP)
  4) o stub do servidor desempacota (unmarshalling) e chama a função de verdade
  5) a função executa e devolve o resultado
  6) o resultado faz o caminho de volta (empacota, rede, desempacota)
  7) o cliente recebe o retorno como se fosse uma chamada normal

  - o cliente fica bloqueado esperando a resposta (chamada sincrona)

Problemas
  - a rede pode falhar, entao a chamada pode dar erro mesmo o codigo estando certo
  - o servidor pode cair no meio da chamada
  - os dois lados precisam combinar os tipos de dados (a interface)
  - nao dá pra passar ponteiro/endereço de memoria, porque a memoria é de outra maquina (passa uma copia)

Semantica de chamada (quantas vezes a função executa se der problema)
  - talvez (maybe): nao tem garantia nenhuma
  - pelo menos uma vez (at-least-once): o cliente tenta de novo ate responder, pode executar mais de uma vez
  - no maximo uma vez (at-most-once): nunca repete, mas pode nao executar
  - exatamente uma vez: o ideal, mas é muito dificil de garantir


## Aula 20 09/10/2026

Componentes de um RPC
  - Interface: define quais funções o servidor oferece e os tipos dos parametros e do retorno
  - Stub do cliente (proxy): representa o servidor no lado do cliente
  - Stub do servidor: recebe a mensagem e chama a função de verdade
  - Servidor de nomes: o cliente procura pelo nome (ex: "encurtador") e nao precisa saber o IP e a porta
  - Serialização: transforma os dados em bytes pra mandar pela rede (e o contrario na volta)

Fluxo geral
  - o servidor cria o objeto/serviço, registra no servidor de nomes e fica esperando chamadas
  - o cliente procura o nome, recebe o proxy e chama a função normalmente
  - só marca o que pode ser chamado de fora (o resto continua privado do servidor)


## Aula 21 16/10/2026

Exercicio: Encurtador de links (RPC)
  - servidor: login (devolve um token), encurtar_link e gerar_qrcode
  - MVC: model guarda os dados em memoria, controller é o objeto remoto
  - cliente: interface web que chama o servidor pelo proxy


## Aula 22 19/10/2026

Encurtador de links (continuação)
  - a senha vai com hash (sha256) e a cada login gera um token
  - sem token valido o servidor recusa
  - o codigo curto vem do hash da url


## Aula 23 23/10/2026

RMI - Remote Method Invocation
  - é o RPC do Java, mas trabalhando com objetos
  - so funciona entre programas Java
  - em vez de chamar uma função, chama o metodo de um objeto que esta em outra maquina

Como funciona o RMI
  - Cliente chama o metodo no stub (proxy do objeto remoto)
  - o stub serializa os parametros e manda pela rede
  - no servidor o objeto remoto executa e devolve o resultado
  - o registry (servidor de nomes do RMI) guarda o nome de cada objeto remoto

Passagem de parametros
  - objeto Serializable: vai uma COPIA (por valor)
  - objeto Remote: vai a referencia (o stub), o metodo continua rodando no servidor

RPC x RMI
  - RPC: chama funções, qualquer linguagem
  - RMI: chama metodos de objetos, so Java, usa interface Remote e serialização do Java

Outros modelos de comunicação
  - CORBA: igual o RMI mas entre linguagens diferentes, usa uma IDL (linguagem de definição de interface) e um ORB (intermediario)
  - gRPC: RPC moderno, usa HTTP/2 e Protocol Buffers (dados em binario, leve), varias linguagens
  - Web Services SOAP: chamada remota com mensagem em XML por cima do HTTP (pesado)
  - REST: nao chama função, acessa recursos por URL com HTTP (GET, POST, PUT, DELETE), dados normalmente em JSON
  - Mensageria (fila / publish-subscribe): nao é chamada direta, quem manda coloca a mensagem num broker e quem recebe pega depois (assincrono, nao precisa estar online ao mesmo tempo)

Comparando
  - Socket: baixo nivel, a gente monta tudo
  - RPC/RMI/gRPC: chamada direta, sincrona, esconde a rede
  - REST/SOAP: padrao da web, simples de integrar com qualquer sistema
  - Mensageria: desacopla quem manda de quem recebe


## Aula 24 26/10/2026

Como fazer RMI
  - interface remota (extends Remote), cada metodo declara throws RemoteException
  - classe que implementa a interface (o objeto remoto)
  - Servidor registra o objeto no registry (LocateRegistry.createRegistry na porta 1099 e Naming.bind)
  - Cliente procura o objeto pelo nome (Naming.lookup) e chama o metodo

Diferença RMI x Socket
  - no socket a gente monta a mensagem e le o stream
  - no RMI chama o metodo e o Java cuida do resto


## Aula 25 30/10/2026

Exercicio: Desafio da Telefonia (RMI)
  - Servidor: carrega a base de sessoes e coloca num HashMap (chave = numero do celular)
  - Cliente: digita o numero do celular, conecta e pesquisa
  - interface remota IConsultaSessao com o metodo consultarSessao(numeroCelular)


## Aula 26 06/11/2026

Telefonia (continuação)
  - o servidor nao le o arquivo a cada consulta, carrega uma vez na memoria

MVC
  - model: Sessao e TabelaHash (do professor)
  - controller: IConsultaSessao, ConsultaSessao (objeto remoto) e Servidor
  - view: JFrameServidor e JFrameCliente

Por que HashMap?
  - a busca é direta pela chave, nao precisa percorrer a lista toda (pesquisa rapida)


# Resumo da estrutura (quadro)

Estrutura Cliente Servidor
  - Heterogêneos
  - TCP/IP: ip, domínio, porta, socket, udp, tcp
  - Objetos:
    - Socket e ServerSocket
    - Escritor e leitor de socket
    - Serialização
  - Manual: Socket + leitor + escritor + serialização
  - RPC
    - RPC (qualquer linguagem)
    - RMI Java: Interface -> Classe + Servidor + Cliente

Estrutura Ponto a Ponto
  - MultiCast: Grupo: IP de classe (faixa de IPs reservada pra grupo)


# Pesquisas (atividades da aula 24/08)

## Pool de Threads

O que é
  - um grupo de threads criadas antes e que ficam esperando tarefa
  - as tarefas entram numa fila, quando uma thread fica livre ela pega a proxima
  - a thread nao morre no fim da tarefa, volta pro pool e é reaproveitada

Por que usar
  - criar e destruir thread é caro
  - limita a quantidade de threads rodando (nao derruba o servidor com muitos pedidos)
  - o codigo fica mais organizado, so manda a tarefa e o pool cuida do resto

Em Java
  - ExecutorService pool = Executors.newFixedThreadPool(4);
  - pool.execute(tarefa) manda a tarefa pro pool
  - pool.shutdown() avisa que nao vai receber mais tarefas e termina quando acabar as que estao na fila

Tipos
  - FixedThreadPool: quantidade fixa de threads
  - CachedThreadPool: cria conforme precisa e reaproveita as paradas
  - SingleThreadExecutor: so uma thread, as tarefas rodam uma de cada vez em ordem

Lista de Threads x Pool
  - lista de threads: a gente cria, da start e join em cada uma
  - pool: so entrega a tarefa (Runnable) e o pool decide qual thread executa

Exemplo no servidor de pedidos: o servidor faz accept() e joga o atendimento pro pool de 4 threads (a cozinha atende no maximo 4 pedidos ao mesmo tempo, o resto espera na fila)


## Relógios Físicos

Problema
  - cada computador tem seu relogio e eles nao andam na mesma velocidade (clock drift)
  - a diferença entre dois relogios num mesmo momento é o clock skew
  - em sistema distribuido isso atrapalha (logs fora de ordem, arquivo salvo "antes" de ser criado)

Algoritmo de Cristian
  - o cliente pergunta a hora pra um servidor de tempo (que tem relogio confiavel)
  - hora certa = hora que o servidor mandou + (RTT / 2)
  - RTT = tempo de ida e volta da mensagem
  - problema: se o servidor cair ou ficar errado todo mundo erra junto

Algoritmo de Berkeley
  - nao tem relogio confiavel, usa a media
  - um coordenador pergunta a hora de todos, calcula a media e manda cada um ajustar (manda a diferença, nao a hora)
  - bom pra rede onde nao tem acesso a um relogio externo

NTP (Network Time Protocol)
  - protocolo da internet pra sincronizar relogio
  - organizado em camadas (stratum): stratum 0 = relogio atomico/GPS, stratum 1 conecta nele, e assim por diante
  - usa UDP na porta 123


## Relógios Lógicos

Ideia
  - o que importa muitas vezes nao é a hora exata e sim a ORDEM dos eventos
  - relação "aconteceu antes" (happened-before, simbolo →):
    - se A e B estao no mesmo processo e A veio antes, A → B
    - se A é o envio de uma mensagem e B o recebimento dela, A → B
    - se A → B e B → C então A → C
  - se nenhum aconteceu antes do outro eles são concorrentes

Relógio de Lamport
  - cada processo tem um contador
  - antes de cada evento: contador = contador + 1
  - ao enviar mensagem, manda o contador junto
  - ao receber: contador = max(contador local, contador da mensagem) + 1
  - se A → B então L(A) < L(B)
  - mas o contrario NAO vale: L(A) < L(B) nao quer dizer que A aconteceu antes de B

Relógio Vetorial
  - cada processo guarda um vetor com um contador pra cada processo do sistema
  - evento: incrementa a propria posição
  - envio: manda o vetor inteiro
  - recebimento: pega o maior de cada posição e depois incrementa a propria
  - resolve o problema do Lamport: dá pra saber se dois eventos são concorrentes
    - V(A) < V(B) se todas as posições de A são <= as de B e pelo menos uma é menor
    - se nao for nem A < B nem B < A, são concorrentes


## Exclusão Mútua

Problema
  - varios processos (em maquinas diferentes) querem usar o mesmo recurso ao mesmo tempo
  - so um pode estar na seção crítica por vez
  - aqui nao tem memoria compartilhada, entao não dá pra usar synchronized, tem que ser com troca de mensagens

O que o algoritmo tem que garantir
  - Segurança: no maximo um processo na seção crítica
  - Vivacidade: quem pediu uma hora consegue entrar (sem deadlock nem starvation)
  - Justiça: entra na ordem do pedido

1) Centralizado
  - um processo é o coordenador
  - quem quer entrar manda REQUEST, o coordenador responde GRANT se estiver livre (senao coloca na fila)
  - ao sair manda RELEASE e o coordenador libera o proximo da fila
  - 3 mensagens por entrada, simples
  - desvantagem: se o coordenador cai, trava tudo (ponto unico de falha)

2) Distribuído (Ricart e Agrawala)
  - nao tem coordenador
  - quem quer entrar manda pedido com o timestamp (relogio de Lamport) pra TODOS
  - os outros respondem OK se nao querem entrar, ou se o pedido do outro tem timestamp menor
  - senao guardam a resposta e mandam depois que sairem
  - entra quando recebeu OK de todos
  - 2 x (N - 1) mensagens por entrada
  - desvantagem: se um processo cai, ninguem mais consegue o OK dele

3) Token Ring (anel com ficha)
  - os processos formam um anel logico
  - uma ficha (token) fica circulando, so quem esta com o token pode entrar na seção crítica
  - se nao quer entrar, passa o token pro proximo
  - desvantagem: se o token se perde precisa gerar outro, e fica circulando mesmo sem ninguem querer entrar


## Eleição

Problema
  - muitos algoritmos precisam de um processo coordenador (como o da exclusão mútua centralizada)
  - se o coordenador cair, os outros precisam escolher outro
  - a eleição escolhe um novo coordenador e todo mundo tem que concordar nele
  - criterio comum: o processo com o MAIOR ID ativo

Algoritmo do Valentão (Bully)
  - quem percebe que o coordenador caiu manda ELECTION pra todos com ID maior que o dele
  - se ninguem responde, ele ganha e avisa todo mundo (COORDINATOR)
  - se alguem responde OK, ele sai da disputa e o que respondeu começa uma eleição nova
  - no fim o maior ID ativo ganha (por isso "valentão")
  - se um processo maior volta, ele toma o lugar chamando uma nova eleição

Algoritmo em Anel (Ring)
  - processos em um anel logico, cada um conhece o proximo
  - quem percebe a falha manda uma mensagem ELECTION com o seu ID pro proximo
  - cada processo que recebe adiciona o seu ID na lista e passa pra frente (pulando quem caiu)
  - quando a mensagem volta pra quem começou, ele pega o maior ID da lista e manda uma mensagem COORDINATOR avisando todos

Comparando
  - Bully: mais mensagens (no pior caso o de menor ID inicia), mas é mais rapido de resolver
  - Anel: menos mensagens por processo, mas a mensagem precisa dar a volta toda
