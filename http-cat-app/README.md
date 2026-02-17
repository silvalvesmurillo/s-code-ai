# HTTP Cat Android Application

Uma aplicação **Android** em Kotlin que busca e exibe imagens de códigos de status HTTP do serviço [http.cat](https://http.cat) em uma interface moderna com **Jetpack Compose**.

## Descrição

Esta aplicação Android faz requisições HTTP para o serviço http.cat e exibe uma listagem formatada com imagens e códigos HTTP em uma **LazyColumn**. A aplicação foi desenvolvida seguindo boas práticas de desenvolvimento Android, incluindo:

- Código limpo e bem estruturado
- Jetpack Compose para UI moderna e declarativa
- Testes unitários abrangentes usando Fakes (sem mocks)
- Separação de responsabilidades (Service, UI, Model)
- Uso de coroutines do Kotlin para operações assíncronas
- Material Design 3

## Tecnologias Utilizadas

- **Kotlin 2.3.10**: Linguagem principal
- **Android SDK 35**: Plataforma Android
- **Gradle 8.7.3**: Plugin Android e gerenciador de build
- **Jetpack Compose**: UI toolkit moderna
- **Material 3**: Design system
- **Ktor Client**: Cliente HTTP para fazer requisições
- **Coil**: Carregamento de imagens assíncrono
- **Kotlin Coroutines**: Para programação assíncrona
- **JUnit 4**: Framework de testes

## Estrutura do Projeto

```
http-cat-app/
├── src/
│   ├── main/
│   │   ├── kotlin/com/scode/ai/httpcat/
│   │   │   ├── HttpCatStatus.kt           # Modelo de dados
│   │   │   ├── HttpCatService.kt          # Interface do serviço
│   │   │   ├── HttpCatServiceImpl.kt      # Implementação real
│   │   │   └── MainActivity.kt            # Activity principal com Compose
│   │   ├── res/
│   │   │   ├── values/
│   │   │   │   ├── strings.xml           # Strings do app
│   │   │   │   └── themes.xml            # Temas Material
│   │   │   └── mipmap-*/                 # Ícones do launcher
│   │   └── AndroidManifest.xml           # Manifest Android
│   └── test/kotlin/com/scode/ai/httpcat/
│       ├── FakeHttpCatService.kt              # Fake para testes
│       ├── FakeHttpCatServiceTest.kt          # Testes do Fake
│       └── HttpCatStatusTest.kt               # Testes do Model
├── build.gradle.kts                    # Configuração do Gradle Android
├── proguard-rules.pro                  # Regras ProGuard
└── README.md                           # Documentação
```

## Como Executar

### Pré-requisitos

- Android Studio Ladybug ou superior
- JDK 17 ou superior
- Android SDK 35
- Dispositivo Android ou emulador (API 24+)
- Conexão com a internet (para acessar https://http.cat)

### Executar a Aplicação

#### No Android Studio:
1. Abra o projeto `http-cat-app` no Android Studio
2. Aguarde o Gradle sync completar
3. Conecte um dispositivo Android ou inicie um emulador
4. Clique em "Run" (▶️) ou pressione Shift+F10

#### Via Linha de Comando:
```bash
cd http-cat-app

# Compilar o APK
./gradlew assembleDebug

# Instalar no dispositivo conectado
./gradlew installDebug

# Ou build e instalar
./gradlew build
adb install -r build/outputs/apk/debug/http-cat-app-debug.apk
```

### Executar os Testes

```bash
cd http-cat-app
./gradlew test
```

## Arquitetura Android

### Componentes Principais

1. **HttpCatStatus**: Classe de dados que representa um código de status HTTP com sua URL de imagem
2. **HttpCatService**: Interface que define o contrato para buscar status HTTP
3. **HttpCatServiceImpl**: Implementação real que faz requisições HTTP usando Ktor com engine OkHttp
4. **MainActivity**: Activity principal que configura o Compose e gerencia o ciclo de vida
5. **HttpCatScreen**: Composable principal que gerencia estados (loading, error, success)
6. **HttpCatList**: LazyColumn que exibe a lista de status HTTP
7. **HttpCatItem**: Card individual que exibe cada status HTTP com sua imagem
8. **FakeHttpCatService**: Implementação fake para testes (sem uso de mocks)

### UI com Jetpack Compose

A interface usa Jetpack Compose com os seguintes componentes:

- **Scaffold**: Estrutura da tela com TopAppBar
- **LazyColumn**: Lista rolável eficiente para exibir os status HTTP
- **Card**: Container para cada item da lista
- **AsyncImage**: Carregamento assíncrono de imagens com Coil
- **Material 3**: Design system moderno

### Estratégia de Testes

Os testes foram implementados seguindo o princípio de usar **Fakes** ao invés de mocks:

- **Fakes**: Implementações simplificadas mas funcionais das interfaces
- **Sem Mocks**: Não utilizamos frameworks de mocking como Mockito
- **Testes Reais**: Os fakes comportam-se como implementações reais, apenas sem efeitos colaterais

### Exemplo de Tela

A aplicação exibe:

```
┌─────────────────────────────────────────┐
│ HTTP Cat                     [TopBar]   │
├─────────────────────────────────────────┤
│                                         │
│  ┌───────────────────────────────────┐  │
│  │ HTTP 200                          │  │
│  │                                   │  │
│  │  [Imagem do gato HTTP 200]       │  │
│  │                                   │  │
│  │ https://http.cat/200             │  │
│  └───────────────────────────────────┘  │
│                                         │
│  ┌───────────────────────────────────┐  │
│  │ HTTP 404                          │  │
│  │                                   │  │
│  │  [Imagem do gato HTTP 404]       │  │
│  │                                   │  │
│  │ https://http.cat/404             │  │
│  └───────────────────────────────────┘  │
│                                         │
│  ... (rolagem com mais itens)          │
│                                         │
└─────────────────────────────────────────┘
```

## Permissões Android

A aplicação requer as seguintes permissões:
- `INTERNET`: Para fazer requisições HTTP
- `ACCESS_NETWORK_STATE`: Para verificar conectividade

## Códigos HTTP Suportados

A aplicação exibe os seguintes códigos HTTP comuns:

- **1xx**: 100, 101, 102
- **2xx**: 200, 201, 202, 203, 204, 206, 207
- **3xx**: 300, 301, 302, 303, 304, 305, 307, 308
- **4xx**: 400-426, 429, 431, 444, 450, 451, 497-499
- **5xx**: 500-511, 521-525, 599

## Build Variants

- **debug**: Build de desenvolvimento com logs habilitados
- **release**: Build de produção com ProGuard/R8 otimizado

## Licença

Este projeto foi desenvolvido para fins educacionais.
