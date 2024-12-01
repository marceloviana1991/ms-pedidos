# Microsserviço de Pedidos

API Rest responsável pelo gerenciamento do microsserviço de pedidos da aplicação Sergipe-Food


## Informações Gerais

- Registra pedido e cria fila ("pedido.registrado") que será escutada pelo microsserviço pagamentos
- Edita Status do pedido escutando fila criada pelo microsserviço de pagamentos ("pagamento.concluido")


## Produtos

Recurso utilizado para registrar o nome e o valor unitário do produto


### URL base para chamadas

```
http://localhost:8082/pedidos-ms/produtos
```


### Endpoints

| Método | Nome do endpoint | Descrição |
|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| POST | saveProduto | Cria um novo produto a ser processado |
| GET | getPageProdutos | Pesquisa por todos os produtos realizados | 
| GET | getProduto | Consulta todas as informações de um produto através de um ```id``` .| 


### Body Content

```
Resquest
{
    "nome": String,
    "preco": Long
}
```

```
Response
{
    "id": Long
    "nome": String,
    "preco": Double
}
```


## Pedidos

Recurso utilizado para registrar os itens de um pedido contendo a quantidade de cada produto em cada item, a data do pedido e o status de confirmação do pagamento


### URL base para chamadas

```
http://localhost:8082/pedidos-ms/pedidos
```

| Método | Nome do endpoint | Descrição |
|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| POST | savePedido | Cria um novo pedido a ser processado |
| GET | getPagePedidos | Pesquisa por todos os pedido realizados | 
| GET | getPedido | Consulta todas as informações de um pedido através de um ```id``` .|
| PUT | aprovaPagamento | Atualiza o status do pedido para confirmado | 


### Body Content

```
Resquest
{
    "itens":
        [
            {
                "quantidade": Integer,
                "produtoId": Long
            }
        ]
}


```

```
Response
{
    "id": Long,
    "dataHora": LocalDateTime,
    "status": ["CONFIRMADO", "CRIADO"],
    "itens":
        [
            {
                "quantidade": Integer,
                "produtoId": Long
            }
        ]
}
```
