# Granja de Patos API

##  Descrição do Desafio

Este desafio consiste em uma **API REST desenvolvida em Java com Spring Boot** para gerenciar uma granja de patos, suas funcionalidades são:

- Cadastro de Patos, Clientes e Vendedores
- Registro de Vendas, aplicando descontos para clientes elegíveis
- Listagem de Patos vendidos
- Geração de relatórios em Excel
- Ranking de Vendedores por número de vendas ou valor total vendido

O sistema utiliza **SQL Server** como banco de dados, **Docker** para containerização e **Apache POI** para relatórios.

---

##  Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA / Hibernate**
- **SQL Server**
- **Apache POI** (relatórios Excel)
- **Docker
- **DBeaver** (modelagem e gerenciamento do banco)
- **Git / GitHub** (versionamento)

---

## 🗓 Cronograma

| Etapa | Descrição | Estimativa de Horas |
|-------|-----------|-------------------|
| 1 | Modelagem do Banco de Dados | 3h |
| 2 | Criação do Projeto Spring Boot + Configuração Docker/DB | 2h |
| 3 | Implementar entidades e repositórios (JPA) | 4h |
| 4 | Implementar services e regras de negócio | 5h |
| 5 | Criar endpoints REST (controllers) | 4h |
| 6 | Testes e validações | 3h |
| 7 | Geração de relatórios (Apache POI) | 3h |
| 8 | Dockerização da aplicação e documentação final | 2h |

---

##  Modelagem do Banco de Dados

### Entidades Principais

- **PATO**: armazena informações de cada pato, incluindo referência à mãe (auto-relacionamento)
- **CLIENTE**: informações dos clientes e elegibilidade para desconto
- **VENDEDORES**: cadastro de vendedores
- **VENDA**: registro de vendas de patos

### Diagrama ER:

docs/diagramaer.png

### Script:

```sql

-- Tabela Patos
CREATE TABLE PATO (
ID INT IDENTITY(1,1),
NOME VARCHAR(100),
VALOR DECIMAL(10,2),
ID_MAE INT NULL,
CONSTRAINT PK_PATO_ID PRIMARY KEY (ID),
CONSTRAINT FK_MAE FOREIGN KEY (ID_MAE) REFERENCES PATO(ID)
);

-- Tabela Clientes
CREATE TABLE CLIENTE (
ID INT IDENTITY(1,1),
NOME VARCHAR(100) NOT NULL,
DESCONTO BIT NOT NULL,
CONSTRAINT PK_CLIENTE_ID PRIMARY KEY (ID)
);

-- Tabela Vendedores
CREATE TABLE VENDEDORES (
ID INT IDENTITY(1,1),
NOME VARCHAR(100) NOT NULL,
MATRICULA INT NOT NULL UNIQUE,
CPF VARCHAR(14) NOT NULL UNIQUE,
CONSTRAINT PK_VENDEDOR_ID PRIMARY KEY (ID)
);

-- Tabela de Vendas
CREATE TABLE VENDA (
ID INT IDENTITY(1,1),
ID_CLIENTE INT NOT NULL,
ID_VENDEDOR INT NOT NULL,
TOTAL_VENDA DECIMAL(10,2),
DESCONTO BIT DEFAULT 0,
DATA_VENDA DATETIME NOT NULL DEFAULT GETDATE()  
CONSTRAINT PK_VENDA_ID PRIMARY KEY (ID),
CONSTRAINT FK_VENDA_CLIENTE FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE(ID),
CONSTRAINT FK_VENDA_VENDEDOR FOREIGN KEY (ID_VENDEDOR) REFERENCES VENDEDORES(ID)
);


--Tabela Relação N-N da venda de patos

CREATE TABLE PATO_VENDA (
ID_VENDA INT NOT NULL,
ID_PATO INT NOT NULL UNIQUE,

CONSTRAINT PK_VENDA_PATOS_ID PRIMARY KEY (ID_PATO, ID_VENDA),
CONSTRAINT FK_PATO_VENDA_PATO FOREIGN KEY (ID_PATO) REFERENCES PATO(ID),
CONSTRAINT FK_PATO_VENDA_VENDA FOREIGN KEY (ID_VENDA) REFERENCES VENDA(ID)

)

