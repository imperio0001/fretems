# fretems

Microserviço de cálculo de frete desenvolvido com Java e Spring Boot.

## ✅ Requisitos
- Java 17
- Maven 3.8 ou superior

## 🚀 Como executar a aplicação

Clone o repositório:
```bash
git clone https://github.com/imperio0001/fretems.git
cd fretems
```

Execute o serviço localmente:
```bash
mvn spring-boot:run
```

A aplicação estará disponível em:
```
http://localhost:8080
```

## 📬 Endpoint principal

### Calcular Frete
**POST** `/api/frete/calcular`

Recebe os seguintes dados via corpo da requisição:
- `peso` (em kg)
- `distancia` (em km)
- `tipoTransporte` ("Normal" ou "Expresso")

#### Regras de cálculo:
##### Transporte "Normal":
- Valor base: R$ 5,00
- + R$ 0,50 por km
- + R$ 2,00 por kg

##### Transporte "Expresso":
- Valor base: R$ 10,00
- + R$ 1,00 por km
- + R$ 5,00 por kg

Se peso ou distância forem negativos, será retornado erro com mensagem apropriada.

#### Exemplo de Requisição:
```json
{
  "peso": 10.0,
  "distancia": 100.0,
  "tipoTransporte": "Normal"
}
```

#### Exemplo de Resposta:
```json
{
  "valorFrete": 255.0
}
```

## 🧪 Como rodar os testes unitários
```bash
mvn test
```

## 📘 Documentação da API com Swagger
Após iniciar a aplicação, acesse:
```
http://localhost:8080/swagger-ui.html
```

Você poderá visualizar e testar todos os endpoints da API diretamente pelo navegador.

## 🗄️ Banco de dados H2 (em memória)
A aplicação usa H2 para testes e simulações. Console disponível em:
```
http://localhost:8080/h2-console
```

**Configuração padrão:**
- JDBC URL: `jdbc:h2:mem:fretemsdb`
- Usuário: `sa`
- Senha: *(em branco)*

## 🛠️ Tecnologias utilizadas
- Java 17
- Spring Boot 3.2.0
- Maven
- JUnit 5
- Swagger (springdoc-openapi)
- H2 Database
- Lombok

## 📁 Estrutura do projeto
```
fretems
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.fretems
│   │   │       ├── controller
│   │   │       ├── model
│   │   │       └── service
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com.fretems.service
├── pom.xml
└── README.md
```

---

Desenvolvido por Marcos Imperio – Desafio técnico para vaga backend
