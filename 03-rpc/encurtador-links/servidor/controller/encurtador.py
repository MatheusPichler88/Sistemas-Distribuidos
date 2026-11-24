import Pyro5.api
import hashlib
import secrets
import qrcode
import io
import base64

DOMINIO = "https://ufn"


@Pyro5.api.expose
class Encurtador:

    def __init__(self, armazenamento):
        self.armazenamento = armazenamento

    def ping(self, nome):
        print(f"Ping recebido de {nome}")
        return f"Olá, {nome}! O servidor está ativo."

    def login(self, usuario, senha):
        senha_hash = hashlib.sha256(senha.encode()).hexdigest()
        if self.armazenamento.buscar_senha(usuario) != senha_hash:
            print(f"Login recusado: {usuario}")
            return None
        token = secrets.token_hex(16)
        self.armazenamento.salvar_token(token, usuario)
        print(f"Login OK: {usuario}")
        return token

    def encurtar_link(self, token, url):
        if not self.armazenamento.token_valido(token):
            print("Tentativa de encurtar sem login válido")
            return None
        codigo = hashlib.sha256(url.encode()).hexdigest()[:8]
        self.armazenamento.salvar(codigo, url)
        print(f"Encurtado: {codigo} -> {url}")
        return f"{DOMINIO}/{codigo}"

    def gerar_qrcode(self, token, url):
        if not self.armazenamento.token_valido(token):
            return None
        imagem = qrcode.make(url)
        buffer = io.BytesIO()
        imagem.save(buffer, format="PNG")
        print(f"QR Code gerado para {url}")
        return base64.b64encode(buffer.getvalue()).decode()
