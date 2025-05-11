# ☕ Cafeteria Fidelidade - API REST em Spring Boot

Este projeto é uma API RESTful desenvolvida em **Spring Boot**, com o objetivo de simular um sistema de **pontos de fidelidade** para clientes de uma cafeteria. A ideia é permitir que clientes acumulem pontos com base em suas compras, subam de nível e acompanhem sua carteira de fidelidade.

---

## 📌 Funcionalidades

A API oferece recursos para:

- ✅ Criar clientes
- ✅ Criar e associar carteiras de pontos a clientes
- ✅ Consultar carteira de fidelidade de um cliente
- ✅ Adicionar ou remover pontos da carteira
- ✅ Calcular automaticamente o nível de fidelidade com base nos pontos
- 🔜 (TODO) Autenticação e autorização com JWT
- 🔜 (TODO) Documentação Swagger/OpenAPI
- 🔜 (TODO) GlobalExceptionHandler com respostas JSON amigáveis

---

## 🧠 Lógica de fidelidade

Os níveis de fidelidade são definidos com base nos pontos acumulados:

| Pontos             | Nível     |
|--------------------|-----------|
| 0 - 99             | BRONZE    |
| 100 - 499          | PRATA     |
| 500 - 999          | OURO      |
| 1000+              | DIAMANTE  |

---

## 📦 Endpoints principais

### 🔹 Criar um novo cliente

`POST /clientes`

```json
{
  "nome": "Psytch",
  "email": "psytch@email.com"
}
```

### 🔹Criar carteira de fidelidade para um cliente
`POST /carteiras/{clienteId}`
- Exemplo:
  `POST http://localhost:8080/carteiras/1`

### 🔹Buscar carteira de um cliente
`GET /carteiras/{clienteId}`
- Exemplo:
```json
{
  "id": 1,
  "pontos": 120,
  "nivelFidelidade": "PRATA"
}
```
### 🔹Realizar transações na carteira (ganho ou uso de pontos)
POST /transacoes
- Exemplo:
  json
  {
  "clienteId": 1,
  "pontos": 50,
  "tipoTransacao": "GANHO",
  "descricao": "Café expresso duplo"
  }


## 🚀 Como usar esta API

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/cafeteria-fidelidade.git
cd cafeteria-fidelidade
```

### 2. Configure o banco de dados

No arquivo application.properties ou application.yml, defina as configurações de banco de dados (padrão: H2 ou PostgreSQL).  
Exemplo usando `PostgreSQL:`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cafeteria
spring.datasource.username=postgres
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
``` 
### 3. Rode o projeto localmente

```bash
./mvnw spring-boot:run
```

A aplicação ficará disponível em:
👉 http://localhost:8080

### 4. Teste os endpoints com o Postman
Você pode importar os endpoints manualmente ou usar ferramentas como Insomnia, Thunder Client ou cURL.

## 💡 Tecnologias utilizadas
- Java 17

- Spring Boot

- Spring Data JPA

- PostgreSQL (ou H2 para testes locais)

- Maven

- Lombok (opcional)

## 📋 TODOs

- [x] Implementar controle de pontos
- [x] Subida automática de nível
- [ ] Adicionar autenticação JWT
- [ ] Documentação Swagger
- [ ] Tratamento global de exceções com JSON amigável
- [ ] Deploy com Railway  

