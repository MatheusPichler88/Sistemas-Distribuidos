# 04 - RMI

Regras da disciplina: código orientado a objetos, em MVC e comentado.

## Projetos desta pasta

| Pasta | O que é |
|---|---|
| [`telefonia`](telefonia) | Exercício: consulta de sessão de telefonia por número de celular, via RMI |

---

## Exercício: Telefonia, cliente-servidor ✅
Projeto: [`telefonia`](telefonia)

A partir do sistema local desenvolvido em *Pesquisa e Ordenação*, refatorar para arquitetura cliente-servidor. O servidor abre a base de sessões de telefonia e fornece ao cliente os dados da sua sessão, a partir do número de celular informado.

Cabe ao programador decidir a abordagem cliente-servidor (RMI, RPC...).

**O servidor deve**
- Abrir a base de sessões (`telephony_sessions.txt`).
- Adicionar as sessões em um `HashMap`.
- Retornar os dados da sessão de um celular informado pelo cliente.

**O cliente pode**
- Conectar ao servidor (via RMI, por exemplo).
- Consultar os dados de sessão de um número de celular.

**Classes do professor** (usadas sem alteração): `Sessao` (`numeroCelular`, `dadosSessao`, com `equals`/`hashCode` pelo número) e `TabelaHash` (um `HashMap<String, Sessao>`).

**Como ficou:** interface remota `IConsultaSessao` (`consultarSessao`), objeto remoto `ConsultaSessao`, `Servidor` com registry RMI, e telas `JFrameServidor` / `JFrameCliente`. Como rodar: `LEIAME.txt` do projeto.
