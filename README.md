# Pagamento-simplificado-api

Este projeto é uma API construída usando **Java, Spring, PostgreSQL.** 

## API Endpoints
A API contém os seguintes endpoints:

**GET USERS**
```markdown
GET /users - busca todos os usuários
```
```json
[
  {
    "id": 1,
    "firstName": "Jorge",
    "lastName": "Reis Lima",
    "identity": "24644312954",
    "email": "jorgereis@gmail.com",
    "password": "45642465",
    "balance": 1133.70,
    "userType": "COMUM"
  },
  {
    "id": 2,
    "firstName": "Carlos",
    "lastName": "dos Santos",
    "identity": "45713454678",
    "email": "carlossantos@gmail.com",
    "password": "5034504545",
    "balance": 2441.60,
    "userType": "COMUM"
  }
]
```

**POST USERS**
```markdown
POST /users - Cadastra um novo usuário
```
```json
{
	"firstName":"Jorge",
	"lastName":"Reis Lima",
	"identity":"24644312954",
	"email":"jorgereis@gmail.com",
	"password":"45642465",
	"userType":"COMUM",
	"balance":1268.0  
}
```

**POST TRANSACTIONS**
```markdown
POST /transactions -Cadastra uma nova Transação entre usuários (COMUM para COMUM ou COMUM para LOGISTA)
```

```json

{
  "value": 134.30,
  "payer": 1,
  "payee": 2
}
```

## Database
O projeto usa PostgreSQL como banco de dados.

## Desafio proposto: PicPay Simplificado
Temos 2 tipos de usuários, os comuns e lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles. Vamos nos atentar somente ao fluxo de transferência entre dois usuários.

Requisitos:

Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.

Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.

Lojistas só recebem transferências, não enviam dinheiro para ninguém.

Validar se o usuário tem saldo antes da transferência.

Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock para simular (https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc).

A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia.

No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock para simular o envio (https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6).

Este serviço deve ser RESTFul.

Payload
Faça uma proposta ❤️ de payload, se preferir, temos uma exemplo aqui:

POST /transaction

{
    "value": 100.0,
    "payer": 4,
    "payee": 15
}
