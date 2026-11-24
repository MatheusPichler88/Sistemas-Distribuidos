import hashlib

class Armazenamento:

    def __init__(self):
        self.links = {}  
        self.usuarios = {  
            "matheus": hashlib.sha256("123".encode()).hexdigest(),
        }
        self.tokens = {} 

    #links
    def salvar(self, codigo, url):
        self.links[codigo] = url

    def buscar(self, codigo):
        return self.links.get(codigo)

    #usuários
    def buscar_senha(self, usuario):
        return self.usuarios.get(usuario)  
    def salvar_token(self, token, usuario):
        self.tokens[token] = usuario

    def token_valido(self, token):
        return token in self.tokens