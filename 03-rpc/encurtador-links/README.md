# Encurtador de Links (RPC com Pyro5)

Encurtador de URLs com chamada remota de procedimentos (RPC) usando **Pyro5**.
O cliente (interface web em Streamlit) faz login, encurta links e gera o QR Code do link curto.

## Arquitetura

```
Encurtador/
├── servidor/
│   ├── servidor.py               # ponto de entrada: Daemon + registro no Name Server
│   ├── controller/encurtador.py  # objeto remoto exposto (login, encurtar_link, gerar_qrcode)
│   └── model/armazenamento.py    # dados em memória (links, usuários, tokens)
├── cliente/
│   └── app.py                    # interface Streamlit
└── requirements.txt
```

O cliente só se comunica com o servidor pelo proxy Pyro5 (`PYRONAME:encurtador`).

## Como rodar

Requer Python 3.10 ou superior.

### 1. Instalar as dependências

```bash
python3 -m venv venv
source venv/bin/activate        
pip install -r requirements.txt
```

### 2. Subir os 3 processos (um terminal para cada, com o venv ativo)

**Terminal 1: servidor de nomes**
```bash
python -m Pyro5.nameserver
```

**Terminal 2: servidor da aplicação**
```bash
cd servidor
python servidor.py
```

**Terminal 3: cliente (interface web)**
```bash
cd cliente
streamlit run app.py
```

A interface abre em http://localhost:8501.

### 3. Usar

Login de teste: usuário `matheus`, senha `123`.

1. Entre com o usuário e a senha.
2. Cole um link e clique em **Encurtar**.
3. O link curto aparece junto com o QR Code, que pode ser baixado.

## Funcionamento

- **Login:** o servidor compara o hash SHA-256 da senha e devolve um token aleatório.
- **Encurtar:** exige token válido. O código é formado pelos 8 primeiros caracteres do SHA-256 da URL, no formato `https://ufn/<codigo>`.
- **QR Code:** gerado no servidor, aponta para o link curto e é devolvido em base64.

Os usuários ficam fixos em `servidor/model/armazenamento.py`. Os dados ficam só em memória e são perdidos ao reiniciar o servidor.
