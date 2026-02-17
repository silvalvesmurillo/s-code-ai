# HTTP Cat Application

Uma aplicação Kotlin que busca e exibe imagens de códigos de status HTTP do serviço [http.cat](https://http.cat).

## Descrição

Esta aplicação faz requisições HTTP para o serviço http.cat e retorna uma listagem formatada com imagens e códigos HTTP. A aplicação foi desenvolvida seguindo boas práticas de desenvolvimento, incluindo:

- Código limpo e bem estruturado
- Testes unitários abrangentes usando Fakes (sem mocks)
- Separação de responsabilidades (Service, Display, Model)
- Uso de coroutines do Kotlin para operações assíncronas

## Tecnologias Utilizadas

- **Kotlin 2.3.10**: Linguagem principal
- **Gradle 9.3.1**: Gerenciador de build
- **Ktor Client**: Cliente HTTP para fazer requisições
- **Kotlin Coroutines**: Para programação assíncrona
- **JUnit 5**: Framework de testes

## Estrutura do Projeto

```
http-cat-app/
├── src/
│   ├── main/kotlin/com/scode/ai/httpcat/
│   │   ├── HttpCatStatus.kt           # Modelo de dados
│   │   ├── HttpCatService.kt          # Interface do serviço
│   │   ├── HttpCatServiceImpl.kt      # Implementação real
│   │   ├── HttpCatDisplayService.kt   # Serviço de exibição
│   │   └── Main.kt                    # Ponto de entrada
│   └── test/kotlin/com/scode/ai/httpcat/
│       ├── FakeHttpCatService.kt              # Fake para testes
│       ├── FakeHttpCatServiceTest.kt          # Testes do Fake
│       ├── HttpCatDisplayServiceTest.kt       # Testes do Display
│       └── HttpCatStatusTest.kt               # Testes do Model
├── build.gradle.kts                    # Configuração do Gradle
└── settings.gradle.kts                 # Configurações do projeto
```

## Como Executar

### Pré-requisitos

- Java 17 ou superior
- Gradle 9.3.1 (ou use o wrapper incluído)
- Conexão com a internet (para acessar https://http.cat)

### Executar a Aplicação

```bash
cd http-cat-app
gradle run
```

ou usando o Gradle wrapper:

```bash
cd http-cat-app
./gradlew run
```

### Executar os Testes

```bash
cd http-cat-app
gradle test
```

ou:

```bash
cd http-cat-app
./gradlew test
```

## Arquitetura

### Componentes Principais

1. **HttpCatStatus**: Classe de dados que representa um código de status HTTP com sua URL de imagem
2. **HttpCatService**: Interface que define o contrato para buscar status HTTP
3. **HttpCatServiceImpl**: Implementação real que faz requisições HTTP para http.cat
4. **HttpCatDisplayService**: Serviço responsável por formatar e exibir os resultados
5. **FakeHttpCatService**: Implementação fake para testes (sem uso de mocks)

### Estratégia de Testes

Os testes foram implementados seguindo o princípio de usar **Fakes** ao invés de mocks:

- **Fakes**: Implementações simplificadas mas funcionais das interfaces
- **Sem Mocks**: Não utilizamos frameworks de mocking como Mockito
- **Testes Reais**: Os fakes comportam-se como implementações reais, apenas sem efeitos colaterais

### Exemplo de Saída

```
Fetching HTTP cat images from https://http.cat...

HTTP Cat Status Codes
==================================================

┌────────────────────────────────────────────────┐
│ Image: https://http.cat/200                    │
│ Code:  HTTP 200                                │
└────────────────────────────────────────────────┘

┌────────────────────────────────────────────────┐
│ Image: https://http.cat/201                    │
│ Code:  HTTP 201                                │
└────────────────────────────────────────────────┘

...

Total: XX status codes found
```

## Códigos HTTP Suportados

A aplicação verifica a disponibilidade dos seguintes códigos HTTP comuns:

- **1xx**: 100, 101, 102
- **2xx**: 200, 201, 202, 203, 204, 206, 207
- **3xx**: 300, 301, 302, 303, 304, 305, 307, 308
- **4xx**: 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 420, 421, 422, 423, 424, 425, 426, 429, 431, 444, 450, 451, 497, 498, 499
- **5xx**: 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 521, 522, 523, 524, 525, 599

## Licença

Este projeto foi desenvolvido para fins educacionais.
