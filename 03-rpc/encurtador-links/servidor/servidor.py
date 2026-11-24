import Pyro5.api
from model.armazenamento import Armazenamento
from controller.encurtador import Encurtador

armazenamento = Armazenamento()  # Cria o hashmap (model)
encurtador = Encurtador(armazenamento)  # Cria o objeto remoto passando o armazenamento (controller)

daemon = Pyro5.api.Daemon()  # Cria um atendente que fica escutando na rede e repassa as chamadas para o objeto remoto
ns = Pyro5.api.locate_ns()  # Localiza o servidor de nomes

uri = daemon.register(encurtador)  # Registra o objeto já criado (com o armazenamento) no atendente e obtém a URI
ns.register("encurtador", uri)  # Registra o objeto remoto no servidor de nomes

print("Servidor pronto, aguardando clientes...")
print("URI:", uri)
daemon.requestLoop()