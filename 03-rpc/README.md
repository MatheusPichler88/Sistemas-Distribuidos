# 03 - RPC

Regras da disciplina: código orientado a objetos, em MVC e comentado.

## Projetos desta pasta

| Pasta | O que é |
|---|---|
| [`encurtador-links`](encurtador-links) | **Trabalho avaliativo**: encurtador de links com RPC (enunciado abaixo) |

---

## Trabalho do Encurtador RPC ✅
Projeto: [`encurtador-links`](encurtador-links)

Usando a linguagem de preferência e a biblioteca RPC equivalente, construir um sistema cliente-servidor para encurtar links ou URLs enviados pelo cliente ao servidor.

**Fluxo do cliente**
- Login (se necessário).
- Informar a URL ou link a ser encurtado.
- Receber o link encurtado e/ou o QR Code gerado.

**Fluxo do servidor**
- Autenticar o login (se necessário).
- Receber o link ou URL a ser encurtado.
- Gerar o hash do link ou URL.
- Armazenar em um HashMap: chave = hash gerado, conteúdo = link ou URL informado.
- Devolver o link encurtado no padrão `https://<dominio>/hash_gerado`.
- **Opcional:** um QR Code do link ou URL informado.

**Observações**
- A interface do cliente deve ser gráfica.
- **Entrega: 27/11**, por email ao professor, com o link do GitHub do trabalho.

**Como ficou:** servidor em Python com Pyro5 (login por token, hash SHA-256 da URL, armazenamento em memória e QR Code) e cliente web com Streamlit. Veja o README do projeto.
