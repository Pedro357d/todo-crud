# To-Do CRUD

API REST para gerenciamento de tarefas, desenvolvida utilizando Java, Spring Boot e PostgreSQL.

## Banco de dados

O projeto utiliza PostgreSQL.

O script para criação da tabela está disponível em:

`database/script.sql`

Crie um banco chamado:

`todo_db`

Depois configure a senha do PostgreSQL através da variável de ambiente:

`DB_PASSWORD`

## Executando o projeto

No terminal, dentro da pasta do projeto:

```bash
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

A aplicação será executada em:

`http://localhost:8080`

## Endpoints

| Método | Endpoint | Função |
|---|---|---|
| POST | `/tarefas` | Criar uma tarefa |
| GET | `/tarefas` | Listar todas as tarefas |
| GET | `/tarefas/{id}` | Buscar tarefa por ID |
| PUT | `/tarefas/{id}` | Atualizar uma tarefa |
| DELETE | `/tarefas/{id}` | Excluir uma tarefa |

Exemplos de requisições também estão disponíveis no arquivo `api.http`.

## Testes

O projeto possui testes unitários e de integração.

Para executar os testes no Windows:

```powershell
.\mvnw.cmd test
```

## Autor

Pedro Silva

Faculdade de Tecnologia de Franca – Dr. Thomaz Novelino