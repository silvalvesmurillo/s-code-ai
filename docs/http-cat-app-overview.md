# HTTP Cat Application - Documentação do Projeto

## Visão Geral

Este documento descreve o aplicativo HTTP Cat desenvolvido em Kotlin, localizado no diretório `http-cat-app/`.

## Objetivo

Criar uma aplicação Kotlin que faz requisições HTTP para o serviço https://http.cat e retorna uma listagem formatada com imagens e códigos HTTP.

## Requisitos Atendidos

✅ Aplicativo em Kotlin  
✅ Testes unitários sem mocks, apenas Fakes  
✅ Requisições HTTP para https://http.cat  
✅ Listagem com imagem e código HTTP  
✅ Commits seguindo padrão git semântico  
✅ Branch feature criada (`copilot/feathttp-cat-image-list`)  
✅ PR preparado para merge na main  

## Estrutura do Projeto

```
http-cat-app/
├── src/
│   ├── main/kotlin/com/scode/ai/httpcat/
│   │   ├── HttpCatStatus.kt           # Modelo de dados
│   │   ├── HttpCatService.kt          # Interface do serviço
│   │   ├── HttpCatServiceImpl.kt      # Implementação real com HTTP client
│   │   ├── HttpCatDisplayService.kt   # Serviço de formatação
│   │   └── Main.kt                    # Ponto de entrada da aplicação
│   └── test/kotlin/com/scode/ai/httpcat/
│       ├── FakeHttpCatService.kt              # Fake para testes
│       ├── FakeHttpCatServiceTest.kt          # Testes do Fake
│       ├── HttpCatDisplayServiceTest.kt       # Testes do serviço de display
│       └── HttpCatStatusTest.kt               # Testes do modelo
├── build.gradle.kts                    # Configuração Gradle
├── settings.gradle.kts                 # Settings do projeto
├── gradlew / gradlew.bat              # Gradle wrapper
└── README.md                          # Documentação detalhada
```

## Tecnologias Utilizadas

- **Kotlin 2.3.10**: Linguagem de programação
- **Java 17**: Runtime
- **Gradle 9.3.1**: Build tool
- **Ktor Client 3.0.3**: Cliente HTTP assíncrono
- **Kotlin Coroutines 1.10.1**: Programação assíncrona
- **JUnit 5**: Framework de testes

## Arquitetura

### Padrão de Design

O projeto utiliza os seguintes padrões:

1. **Dependency Injection Manual**: Injeção de dependências via construtor
2. **Interface Segregation**: Interface `HttpCatService` com implementações separadas
3. **Single Responsibility**: Cada classe tem uma responsabilidade única
4. **Test Doubles (Fakes)**: Uso de Fakes ao invés de mocks para testes

### Componentes

#### 1. HttpCatStatus (Model)
```kotlin
data class HttpCatStatus(
    val code: Int,
    val imageUrl: String
)
```
- Representa um código de status HTTP com sua URL de imagem
- Imutável (data class)
- Método `getDisplayText()` para formatação

#### 2. HttpCatService (Interface)
```kotlin
interface HttpCatService {
    suspend fun fetchAllStatuses(): List<HttpCatStatus>
    suspend fun imageExists(code: Int): Boolean
}
```
- Define o contrato para buscar status HTTP
- Métodos suspensos para operações assíncronas

#### 3. HttpCatServiceImpl (Implementação Real)
- Faz requisições HTTP reais para https://http.cat
- Usa Ktor Client com engine CIO
- Verifica disponibilidade de imagens com HEAD requests
- Testa códigos HTTP comuns (1xx, 2xx, 3xx, 4xx, 5xx)

#### 4. FakeHttpCatService (Fake para Testes)
- Implementação fake que não faz requisições reais
- Simula o comportamento do serviço real
- Configurável com conjunto de códigos disponíveis
- **Não usa mocks** - é uma implementação real simplificada

#### 5. HttpCatDisplayService
- Responsável por formatar a saída
- Recebe `HttpCatService` via injeção de dependência
- Cria listagem formatada com box drawing characters

## Estratégia de Testes

### Filosofia: Fakes, não Mocks

O projeto utiliza **Fakes** ao invés de mocks:

- **Fake**: Implementação simplificada mas funcional de uma interface
- **Não requer frameworks** como Mockito ou Mockk
- **Mais próximo do comportamento real**
- **Facilita refatoração** pois testa comportamento, não implementação

### Cobertura de Testes

✅ **HttpCatStatusTest**: Testa modelo de dados  
✅ **FakeHttpCatServiceTest**: Valida comportamento do Fake  
✅ **HttpCatDisplayServiceTest**: Testa formatação usando Fake  

### Exemplo de Teste com Fake

```kotlin
@Test
fun `fetchAllStatuses returns sorted list`() = runTest {
    // Given
    val availableCodes = setOf(500, 200, 404)
    val service = FakeHttpCatService(availableCodes)
    
    // When
    val result = service.fetchAllStatuses()
    
    // Then
    assertEquals(3, result.size)
    assertEquals(200, result[0].code)
}
```

## Como Executar

### Com Gradle Wrapper (Recomendado)

```bash
cd http-cat-app

# Executar aplicação
./gradlew run

# Executar testes
./gradlew test

# Gerar relatório de testes
./gradlew test --tests --info
```

### Com Gradle do Sistema

```bash
cd http-cat-app

gradle run    # Executar
gradle test   # Testar
```

## Requisitos de Ambiente

- Java 17 ou superior
- Conexão com internet (para acessar https://http.cat)
- Sistema operacional: Linux, macOS ou Windows

## Commits Semânticos

O projeto segue a convenção de commits semânticos:

```
feat: add HTTP cat Kotlin application with unit tests
chore: add Gradle wrapper and update README
```

### Tipos de Commit Usados

- `feat`: Nova funcionalidade
- `chore`: Tarefas de manutenção (build, dependencies)
- `test`: Adição ou modificação de testes
- `docs`: Documentação

## Branch e PR

- **Branch**: `copilot/feathttp-cat-image-list`
- **Base**: `main`
- **Status**: Pronto para merge

## Códigos HTTP Suportados

A aplicação verifica os seguintes códigos HTTP comuns:

- **Informacionais (1xx)**: 100, 101, 102
- **Sucesso (2xx)**: 200, 201, 202, 203, 204, 206, 207
- **Redirecionamento (3xx)**: 300, 301, 302, 303, 304, 305, 307, 308
- **Erro do Cliente (4xx)**: 400-426, 429, 431, 444, 450, 451, 497-499
- **Erro do Servidor (5xx)**: 500-511, 521-525, 599

## Exemplo de Saída

```
Fetching HTTP cat images from https://http.cat...

HTTP Cat Status Codes
==================================================

┌────────────────────────────────────────────────┐
│ Image: https://http.cat/200                    │
│ Code:  HTTP 200                                │
└────────────────────────────────────────────────┘

┌────────────────────────────────────────────────┐
│ Image: https://http.cat/404                    │
│ Code:  HTTP 404                                │
└────────────────────────────────────────────────┘

Total: XX status codes found
```

## Próximos Passos

Possíveis melhorias futuras:

1. ✨ Adicionar cache de imagens
2. ✨ Interface gráfica (GUI com Compose Desktop)
3. ✨ Filtro por categoria de status (2xx, 4xx, etc)
4. ✨ Export para HTML ou PDF
5. ✨ Paralelização das requisições HTTP
6. ✨ Tratamento de rate limiting

## Contato

Desenvolvido como parte do repositório `s-code-ai`.

---

**Data de Criação**: Fevereiro 2026  
**Versão**: 1.0.0
