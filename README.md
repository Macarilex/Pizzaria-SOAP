# 🍕 Web Service SOAP - Pizzaria

Este projeto implementa um Web Service SOAP simples para gerenciamento de pedidos de uma pizzaria.

## 📋 Funcionalidades

- Cadastro de clientes
- Criação de pedidos (com sabores e borda)
- Consulta e listagem de pedidos
- Atualização automática do status do pedido a cada 1 minuto
- CRUD de sabores de pizza e bordas

## 🚀 Tecnologias

- Java 8+
- JAX-WS (Java API for XML Web Services)

## 🛠️ Como Executar

1. Clone o repositório ou copie o código para um projeto Java no IntelliJ IDEA.
2. Execute a classe `PizzariaService.java`.
3. O serviço ficará disponível em:

```
http://localhost:8080/PizzariaService?wsdl
```

## 📦 Estrutura do Projeto

- `PizzariaService` – Web Service principal.
- `Cliente` – Classe que representa o cliente.
- `Pedido` – Classe que representa um pedido.
- `StatusPedido` – Enum com os status do pedido.

## 🔁 Atualização Automática de Status

Os pedidos passam automaticamente pelos seguintes status, a cada 1 minuto:

1. Recebido
2. Em Preparo
3. Pronto para Retirada
4. Saiu para Entrega
5. Entregue

## 📬 Endpoints (via SOAP)

- `cadastrarCliente(nome, telefone)` → Retorna `id` do cliente
- `criarPedido(clienteId, List<Integer> sabores, bordaId)` → Retorna `id` do pedido
- `consultarPedido(pedidoId)` → Retorna dados do pedido
- `listarPedidos()` → Lista todos os pedidos
- `adicionarSaborPizza(nome)` → Adiciona novo sabor
- `adicionarBorda(nome)` → Adiciona nova borda

## 📌 Observações

- O serviço SOAP é stateless e todos os dados estão em memória (não persistidos).
- Não há controle de autenticação, qualquer um pode acessar os métodos do serviço.
- Esse projeto é ideal para estudos e testes com Web Services SOAP.

---

Desenvolvido para fins acadêmicos. 🍕
